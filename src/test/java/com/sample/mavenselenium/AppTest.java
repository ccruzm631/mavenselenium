package com.sample.mavenselenium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxOptions;
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

   
    public static void test0() {
    	System.out.println("==>Start Test WebDriver");
    	System.setProperty("webdriver.gecko.driver", "C:\\tools\\geckodriver.exe");
    	
    	FirefoxOptions options = new FirefoxOptions()
    			.addPreference("browser.startup.page", 1)
    			.addPreference("browser.startup.homepage", "http://10.53.29.252:8080/Asistencia/");
    		
    	options.setCapability("marionette", true);
    	
    	try {
			WebDriver driver = new RemoteWebDriver(new URL("http://localhost:8089/wd/hub"), options);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebElement objUserField = driver.findElement(By.id("numempleado"));
			objUserField.click();	

			objUserField.sendKeys("163796");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			WebElement objMasterKeyField = driver.findElement(By.id("llaveMaestra"));
			objMasterKeyField.click();
			objMasterKeyField.sendKeys("Cgruposalinas13");
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebElement objIngresarButton = driver.findElement(By.cssSelector("input.submit:nth-child(2)"));
			
			objIngresarButton.submit();
			
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.close();
			
		} catch (MalformedURLException e) {
			System.out.println("Error Test: "+e.getLocalizedMessage());
		}
    }
 }
