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

import junit.framework.TestCase;

public class TS_LoginAsistenciastartTest extends TestCase {
	private static String strUser;
	private static String strMasterKey;
	private static String ipLocal;
	
	public static WebDriver driver;
	public static FirefoxOptions options; 
	
	public TS_LoginAsistenciastartTest(String name) {
		super(name);
	}

	public void testStartTestLoginAsistencia() {
		System.out.println("Start Test : " + TS_LoginAsistenciastartTest.class.getSimpleName().toString());

		//Read excel parameters
		ProcessFile pf = new ProcessFile();
		strUser =  		pf.readExcelFile("TS0001_PortalAsistencia", 1, "Usuario");
		strMasterKey = 	pf.readExcelFile("TS0001_PortalAsistencia", 1, "LlaveMaestra");
		ipLocal = 		pf.readExcelFile("TS0001_PortalAsistencia", 1, "IPLocal");

		System.out.println("IP: "+ipLocal);
		System.setProperty("webdriver.gecko.driver", "Z:\\PruebasQA\\Driver\\geckodriver.exe");
		
		options = new FirefoxOptions()
				.addPreference("browser.startup.page", 1)
				.addPreference("browser.startup.homepage", "http://10.53.29.252:8080/Asistencia/");
		options.setCapability("marionette", true);
		
		//Create Driver object for firefox Browser
		try {
			driver = new RemoteWebDriver(new URL("http://"+ ipLocal +":8089/wd/hub"), options);
		} catch (MalformedURLException e) {
			throw new RuntimeException("Error en creación de driver: " + e.getMessage());
		}	
        
        RTS_LoginAsistenciaPage loginAsistencia = new RTS_LoginAsistenciaPage(strUser, strMasterKey);
        loginAsistencia.startTestLoginAsistencia(driver);
        
        MetodoGlobal mg = new MetodoGlobal();
        
        mg.pleaseWaiting(driver, ConstantTest.WAIT_THIRTEEN_SECONDS);
        driver.close();
		
        assertTrue(true);

	}

//	public void testStartTestLoginAsistencia() {
//		System.out.println("reading");
//		
//		try {
//			BufferedReader read = new BufferedReader(new FileReader("\\\\10.51.145.100\\\\xfer\\\\PruebasQA\\\\FileTest\\\\ipLocal.txt"));
//			String st;
//			while((st = read.readLine()) != null)
//				System.out.println(st);
//			read.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		assertTrue(true);
//	}
}
