/**
 * 
 */
package com.sample.globalmethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * @author ccruzm
 *
 */
public class ProcessFile {
	public String rutaExcel;

	public String readExcelFile(String excelFile, int rowNumber, String strColumnName) {
		Workbook workbook = null;
		String cellValue = null; 
		
		rutaExcel = readFileProperties("excelPath");
		
		try {
			workbook = WorkbookFactory.create(new File(rutaExcel + excelFile + ".xlsx"));
			
			Sheet sheet = workbook.getSheetAt(0);
			
			DataFormatter dataFormatter = new DataFormatter();
			
			Row rowSheet = sheet.getRow(rowNumber);
			int numCells = rowSheet.getLastCellNum() - 1;

			int rowSearched = -1;
			
			for (int cols= 0; cols < rowSheet.getLastCellNum(); cols ++) {
				cellValue = dataFormatter.formatCellValue(sheet.getRow(0).getCell(cols));
				if (strColumnName.equalsIgnoreCase(cellValue)) {
					rowSearched = cols;
					break;
				}
			}
			
			if (rowSearched != -1)
				cellValue = dataFormatter.formatCellValue(sheet.getRow(rowNumber).getCell(rowSearched));
			
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cellValue;
	}
	
	public String readFileProperties(String atributo) {
		//Ruta del archivo properties
		String filePath = "src\\main\\java\\com\\sample\\config\\configuration.properties";
		Properties prop = new Properties();
		String atrrValue = null;
		
		try (InputStream inputStream = new FileInputStream(filePath)) {
			//Cargar las propiedades
			prop.load(inputStream);
			
			//tomando atributos
			atrrValue = prop.getProperty(atributo);
			
		} catch(IOException e) {
			throw new RuntimeException("Error al localizar el archivo: " + e.getMessage()); 
		}
		
		prop = null;
		return atrrValue;
	}
}
