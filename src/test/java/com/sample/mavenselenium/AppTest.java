package com.sample.mavenselenium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	System.out.println("==>Start Test App");
    	System.setProperty("webdriver.gecko.driver", "C:\\tools\\geckodriver.exe");
		
//    	FirefoxDriver driver = new FirefoxDriver();
//
//		driver.get("http://10.53.29.252:8080/Asistencia/");
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.close();

    	FirefoxOptions options = new FirefoxOptions()
    			.addPreference("browser.startup.page", 1)
    			.addPreference("browser.startup.homepage", "http://10.53.29.252:8080/Asistencia/");
    	options.setCapability("marionette", false);
    	
		try {
			WebDriver driver = new RemoteWebDriver(new URL("http://localhost:8089/wd/hub"), options);
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.close();
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
//    	
        assertTrue( true );
    }
}
