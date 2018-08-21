/**
 * 
 */
package com.sample.mavenselenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import junit.framework.TestCase;

/**
 * @author ccruzm
 *
 */
public class WebTest extends TestCase {

	/**
	 * @param name
	 */
	public WebTest(String name) {
		super(name);
	}

	public void testWb() {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		
		assertTrue( true );
	}
}
