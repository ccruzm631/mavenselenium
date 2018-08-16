/**
 * 
 */
package com.sample.globalmethods;

import org.openqa.selenium.WebDriver;

/**
 * @author ccruzm
 *
 */
public class MetodoGlobal {

	/*
	 * Método para esperar carga de controles
	 */
	public void pleaseWaiting(WebDriver wDriver, int segundos) {
		synchronized(wDriver) {
			try {
				wDriver.wait(segundos * 1000);
			} catch(InterruptedException ex){
				System.out.println(ex.getMessage());
			}
		}
	}
}
