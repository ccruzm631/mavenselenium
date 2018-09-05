package com.sample.mavenselenium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ImmutableCapabilities;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
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
     * 
     */
    public void testMTT() {
    	System.out.println("==>Start Test MTT");
    	System.setProperty("webdriver.firefox.marionette", "C:\\tools\\geckodriver.exe");
    	
    	FirefoxOptions options = new FirefoxOptions();
    	options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
    	options.setCapability("marionette", true);
    	options.addPreference("browser.startup.homepage", "http://10.53.29.252:8080/Asistencia/");
    	
    	WebDriver driver = new FirefoxDriver(options);
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	WebElement objUserField = driver.findElement(By.id("numempleado"));
		objUserField.click();	

		objUserField.sendKeys("163796");
    	
    	driver.quit();
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
    	
    	driver.quit();
    }
    
    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	System.out.println("==>Start Test App");
    	
//    	System.setProperty("webdriver.firefox.marionette", "C:\\tools\\geckodriver.exe");

    	System.setProperty("webdriver.gecko.driver", "C:\\tools\\geckodriver.exe"); 
//    	System.setProperty("webdriver.firefox.marionette", "C:\\tools\\geckodriver.exe");

    	
    	FirefoxProfile profile = new FirefoxProfile();
    	profile.setAcceptUntrustedCertificates(true);
    	profile.setAssumeUntrustedCertificateIssuer(true);

    	FirefoxOptions options = new FirefoxOptions(new ImmutableCapabilities("marionette", false, 
    			CapabilityType.PAGE_LOAD_STRATEGY, PageLoadStrategy.EAGER,
    			CapabilityType.ACCEPT_INSECURE_CERTS, true))
    	
//    			.addPreference("browser.startup.page", 1)
    			.addPreference("browser.startup.homepage", "http://10.53.29.252:8080/Asistencia/")
    			.setProfile(profile);
//    			.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
    			
//    			.setLegacy(true);
//    	options.setLogLevel(FirefoxDriverLogLevel.TRACE);
//    	options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//    	options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
//    	options.setCapability("marionette", false);
    			
//		FirefoxDriver driver = new FirefoxDriver(options);	
		try {
			RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:8089/wd/hub"), options);
//			WebDriver driver = new FirefoxDriver(options);
//			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("http://10.53.29.252:8080/Asistencia/");
			
			//WebDriver augmentedDriver = new Augmenter().augment(driver);
//			driver.get("http://10.53.29.252:8080/Asistencia/");
//			ffd.navigate().to("http://10.53.29.252:8080/Asistencia/");
			
//			driver.navigate().to("http://10.53.29.252:8080/Asistencia/");
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//			
			WebElement objUserField = driver.findElement(By.id("numempleado"));
			objUserField.click();	

			objUserField.sendKeys("163796");
//			
			driver.close();
			driver.quit();
		} catch (Exception e) {
			System.out.println("Error Test: "+e.getLocalizedMessage());
		}
    	
        assertTrue( true );
    }
    
    public static void test0() {
    	System.out.println("==>Start Test 0");
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
			driver.close();
			driver.quit();
			
		} catch (MalformedURLException e) {
			System.out.println("Error Test: "+e.getLocalizedMessage());
		}
    }
    
    public static void test() {
    	System.out.println("==>Start Test");
    	System.setProperty("webdriver.gecko.driver", "C:\\tools\\geckodriver.exe"); 
    	
    	FirefoxProfile profile = new FirefoxProfile();
    	profile.setAcceptUntrustedCertificates(true);
    	profile.setAssumeUntrustedCertificateIssuer(true);
    	
    	FirefoxOptions ffoptions = new FirefoxOptions();
    	ffoptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
    	ffoptions.setCapability(CapabilityType.HAS_NATIVE_EVENTS, true);
    	ffoptions.setCapability("marionette", true);
    	ffoptions.setCapability("acceptSslCerts", true);
    	ffoptions.setProfile(profile);
    	
    	WebDriver driver = new FirefoxDriver(ffoptions);
    	driver.get("http://10.53.29.252:8080/Asistencia/");
    	WebElement objUserField = driver.findElement(By.id("numempleado"));
		objUserField.click();	

		objUserField.sendKeys("163796");
		driver.close();
		driver.quit();

    }
    
//    public static void testMario() {
//    	System.out.println("==>Start TestMario");
//    	System.setProperty("\"webdriver.firefox.marionette", "C:\\tools\\geckodriver.exe"); 
//    	
//    	FirefoxProfile profile = new FirefoxProfile();
//    	profile.setAcceptUntrustedCertificates(true);
//    	profile.setAssumeUntrustedCertificateIssuer(true);
//    	
//    	FirefoxOptions ffoptions = new FirefoxOptions();
//    	ffoptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//    	ffoptions.setCapability(CapabilityType.HAS_NATIVE_EVENTS, true);
//    	ffoptions.setCapability("acceptSslCerts", true);
//    	ffoptions.setCapability("marionette", true);
//    	ffoptions.setProfile(profile);
//    	
//    	WebDriver driver = new FirefoxDriver(ffoptions);
//    	driver.get("http://10.53.29.252:8080/Asistencia/");
//    	WebElement objUserField = driver.findElement(By.id("numempleado"));
//		objUserField.click();	
//
//		objUserField.sendKeys("163796");
//		driver.close();
//		driver.quit();
//
//    }
}
