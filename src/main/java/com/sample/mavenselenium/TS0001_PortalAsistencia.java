package com.sample.mavenselenium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.sample.config.ConstantTest;
import com.sample.globalmethods.MetodoGlobal;
import com.sample.globalmethods.ProcessFile;
import com.sample.mavenselenium.testscript.RTS_LoginAsistenciaPage;

/**
 * Hello world!
 *
 */
public class TS0001_PortalAsistencia 
{
	private static String strURL;
	private static String strBrowserDriver;
	private static String strPathDriver;
	private static String strUser;
	private static String strMasterKey;
	private static String ipLocal;
//	private static int numIterations;
	private static ProcessFile pf = new ProcessFile();
	
	public static WebDriver driver;
	public static FirefoxOptions options; 
	
	/*
	 * Método de carga de los parametros para
	 * la prueba
	 **/
	public static void loadParametersFile() {
		//Read file properties
		strURL = pf.readFileProperties("URL");
		strBrowserDriver = pf.readFileProperties("browserDriver");
		strPathDriver = pf.readFileProperties("pathDriver");
//		String rows = pf.readFileProperties("iteraciones");
//		numIterations = Integer.valueOf(rows);
				
	}
	
	/*
	 * Método para cargar los parametros de test
	 * desde un archivo excel especificado
	 */
	public void loadParametersExcel(int numRow) {
		//Read Excel file
		strUser =  pf.readExcelFile(TS0001_PortalAsistencia.class.getSimpleName().toString(), numRow, "Usuario");
		strMasterKey = pf.readExcelFile(TS0001_PortalAsistencia.class.getSimpleName().toString(), numRow, "LlaveMaestra");
		ipLocal = pf.readExcelFile(TS0001_PortalAsistencia.class.getSimpleName().toString(), numRow, "IPLocal");
				
		//Localización de Driver
		System.setProperty(strBrowserDriver, strPathDriver);
		
		options = new FirefoxOptions()
				.addPreference("browser.startup.page", 1)
				.addPreference("browser.startup.homepage", strURL);
		options.setCapability("marionette", true);
		
		//Create Driver object for firefox Browser
		try {
			driver = new RemoteWebDriver(new URL("http://"+ ipLocal +":8089/wd/hub"), options);
		} catch (MalformedURLException e) {
			throw new RuntimeException("Error en creación de driver: " + e.getMessage());
		}	
	}
	
	/*
	 * Método Main
	 */
    public static void main( String[] args )
    {
        TS0001_PortalAsistencia ts001 = new TS0001_PortalAsistencia();
                
        loadParametersFile();
        
        ts001.loadParametersExcel(1);
        
        RTS_LoginAsistenciaPage loginAsistencia = new RTS_LoginAsistenciaPage(strUser, strMasterKey);
        loginAsistencia.startTestLoginAsistencia(driver);
        
        MetodoGlobal mg = new MetodoGlobal();
        
        mg.pleaseWaiting(driver, ConstantTest.WAIT_FIVE_SECONDS);
        driver.close();
        
    }
}
