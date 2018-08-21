package com.sample.mavenselenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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
    	System.setProperty("webdriver.gecko.driver", "C:\\tools\\geckodriver.exe");
		
    	WebDriver driver = new FirefoxDriver();
		
		driver.get("http://10.53.29.252:8080/Asistencia/");
		driver.close();
        assertTrue( true );
    }
}
