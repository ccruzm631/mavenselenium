package com.sample.mavenselenium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.sample.config.ConstantTest;
import com.sample.globalmethods.MetodoGlobal;
import com.sample.mavenselenium.testscript.RTS_LoginAsistenciaPage;

import junit.framework.TestCase;

public class TS_LoginAsistenciastartTest extends TestCase {
	public static WebDriver driver;
	public static FirefoxOptions options; 
	
	public TS_LoginAsistenciastartTest(String name) {
		super(name);
	}

	public void testStartTestLoginAsistencia() {
		System.out.println("Start: " + TS_LoginAsistenciastartTest.class.getSimpleName().toString());
  
		System.setProperty("webdriver.gecko.driver", "Z:\\\\PruebasQA\\\\Driver\\\\geckodriver.exe");
		
		options = new FirefoxOptions()
				.addPreference("browser.startup.page", 1)
				.addPreference("browser.startup.homepage", "http://10.53.29.252:8080/Asistencia/");
		options.setCapability("marionette", true);
		
		//Create Driver object for firefox Browser
		try {
			driver = new RemoteWebDriver(new URL("http://10.51.145.164:8089/wd/hub"), options);
		} catch (MalformedURLException e) {
			throw new RuntimeException("Error en creación de driver: " + e.getMessage());
		}	
        
        RTS_LoginAsistenciaPage loginAsistencia = new RTS_LoginAsistenciaPage("163796", "Cgruposalinas13");
        loginAsistencia.startTestLoginAsistencia(driver);
        
        MetodoGlobal mg = new MetodoGlobal();
        
        mg.pleaseWaiting(driver, ConstantTest.WAIT_FIVE_SECONDS);
        driver.close();
		
        assertTrue(true);

	}

}
