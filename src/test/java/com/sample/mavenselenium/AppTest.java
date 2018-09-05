package com.sample.mavenselenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

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

    
    public void testGK() {
    	System.out.println("==>Start Test GK");
    	System.setProperty("webdriver.gecko.driver", "C:\\tools\\geckodriver.exe");
    	
    	FirefoxOptions options = new FirefoxOptions();
    	options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
    	options.setCapability("marionette", false);
    	
    	WebDriver driver = new FirefoxDriver();
    	driver.get("http://10.53.29.252:8080/Asistencia/");
    	
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	
    	WebElement objUserField = driver.findElement(By.id("numempleado"));
		objUserField.click();	

		objUserField.sendKeys("163796");
		
		WebElement objMasterKeyField = driver.findElement(By.id("llaveMaestra"));
		objMasterKeyField.click();
		objMasterKeyField.sendKeys("Cgruposalinas13");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement objIngresarButton = driver.findElement(By.cssSelector("input.submit:nth-child(2)"));
		
		//submit: Envía los datos del formulario que contiene al elemento sobre el que invoca
		objIngresarButton.submit();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	driver.quit();
    }
   
 }
