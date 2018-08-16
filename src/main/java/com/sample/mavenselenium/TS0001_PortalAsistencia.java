package com.sample.mavenselenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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
	private static int numIterations;
	private static ProcessFile pf = new ProcessFile();
	
	public static WebDriver driver;
	
	/*
	 * Método de carga de los parametros para
	 * la prueba
	 **/
	public static void loadParametersFile() {
		//Read file properties
		strURL = pf.readFileProperties("URL");
		strBrowserDriver = pf.readFileProperties("browserDriver");
		strPathDriver = pf.readFileProperties("pathDriver");
		String rows = pf.readFileProperties("iteraciones");
		numIterations = Integer.valueOf(rows);
				
	}
	
	/*
	 * Método para cargar los parametros de test
	 * desde un archivo excel especificado
	 */
	public void loadParametersExcel(int numRow) {
		//Read Excel file
		strUser =  pf.readExcelFile(TS0001_PortalAsistencia.class.getSimpleName().toString(), numRow, "Usuario");
		strMasterKey = pf.readExcelFile(TS0001_PortalAsistencia.class.getSimpleName().toString(), numRow, "LlaveMaestra");
		
		//Localización de Driver
		System.setProperty(strBrowserDriver, strPathDriver);
		
		//Create Driver object for firefox Browser
		driver = new FirefoxDriver();
		
		//get: Obtener una pagina
		driver.get(strURL);
	}
	
	/*
	 * Método Main
	 */
    public static void main( String[] args )
    {
        TS0001_PortalAsistencia ts001 = new TS0001_PortalAsistencia();
                
        loadParametersFile();
        
        ts001.loadParametersExcel(0);
        
        RTS_LoginAsistenciaPage loginAsistencia = new RTS_LoginAsistenciaPage(strURL, strBrowserDriver, strPathDriver, strUser, strMasterKey);
        loginAsistencia.startTestLoginAsistencia(driver);
        
        MetodoGlobal mg = new MetodoGlobal();
        
        mg.pleaseWaiting(driver, ConstantTest.WAIT_FIVE_SECONDS);
        driver.close();
        
    }
}
