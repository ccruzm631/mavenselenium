/**
 * 
 */
package com.sample.mavenselenium.testscript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author ccruzm
 *
 */
public class RTS_LoginAsistenciaPage {

	private String strUser;
	private String strMasterKey;
	
	private WebElement objUserField;
	private WebElement objMasterKeyField;
	private WebElement objIngresarButton;
	
	public RTS_LoginAsistenciaPage(String strUser, String strMasterKey) {
		this.strUser = strUser;
		this.strMasterKey = strMasterKey;
	}
	
	/*
	 * Método con los pasos de la prueba
	 */
	public void startTestLoginAsistencia(WebDriver driver) {
		//tagName[@attribute='value'] - spath sintaxis (existen otras)
		//tagName[attribute='value'] - CSS sintaxis (existen otras)
		//
		//Regular expression: tagName[contains(@attribute, 'value')] -xpath
		
		//findElements: Encuentra un conjunto de elementos web(por clase, XPATH)
		//findElement: Encuentra un elemento web (por id, nombre de la etiqueta, nombre, texto de enlace - total o parcial, CSS)
		objUserField = driver.findElement(By.id("numempleado"));
		
		//click: Equivale a un click del usuario sobre elemento
		objUserField.click();	
		
		//sendKeys: Simula la pulsación de teclas del usuario sobre elementos WebElement
		objUserField.sendKeys(strUser);
				
		objMasterKeyField = driver.findElement(By.id("llaveMaestra"));
		objMasterKeyField.click();
		objMasterKeyField.sendKeys(strMasterKey);
				
		//Nota: Valores de xpath que comienzan con: "/html/..." no son confiables
		objIngresarButton = driver.findElement(By.cssSelector("input.submit:nth-child(2)"));
		
		//submit: Envía los datos del formulario que contiene al elemento sobre el que invoca
		objIngresarButton.submit();
		//switchTo: Mueve a otra ventana, frame o incluse capturar diálogos
		
		//manage: Gestión de ventanas, log y cookies
		
		//quit: Cierra el driver
		
//		driver.close();
		
	}
}
