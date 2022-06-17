package com.ada;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HotelBook {
	static WebDriver driver;

	public static Object[][] getExcelData(){
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		driver.get("http://adactinhotelapp.com/");
		File file = new File("D:\\JavaClassProjectsEclipse\\AdactinAccessWithExcel\\Excel\\vijay.xlsx");
		FileInputStream st1 = null;
		try {
			st1 = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Workbook workbook = null;
		try {
			workbook = new XSSFWorkbook(st1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Sheet sheet = workbook.getSheet("Sheet0");
		int lastRowNum = sheet.getLastRowNum();
		short lastCellNum = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[lastRowNum][lastCellNum];
		for (int i = 1; i <= lastRowNum; i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < lastCellNum; j++) {
				Cell cell = row.getCell(j);
				DataFormatter dft = new DataFormatter();
				String value = dft.formatCellValue(cell);
				data[i-1][j]= value;
			}
		}
		// File file1 = new
		// File("D:\\JavaClassProjectsEclipse\\AdactinAccessWithExcel\\Excel\\xssf.xlsx");
		// FileInputStream st = new FileInputStream(file1);
		// Workbook workbook1 = new XSSFWorkbook(st);
		// Sheet sheet1 = workbook.getSheet("Sheet1");
		// Row row1 = sheet1.createRow(2);
		// Cell ncell = row1.createCell(3);
		// ncell.setCellValue("vijaymani");
		// FileOutputStream out= new FileOutputStream(file1);
		// workbook1.write(out);
		// System.out.println(cell);
		// FileOutputStream stream = new FileOutputStream(file);
		// workbook.write(stream);
		try {
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
}
