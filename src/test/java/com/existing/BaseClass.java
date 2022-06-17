package com.existing;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
public class BaseClass {

	
		static WebDriver driver;
		static WebElement findElement;

		public static void getDriver() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}

		public void launchUrl(String url) {
			driver.get(url);
		}

		public static WebElement locators(String locatorType, String value) {
			if (locatorType.equals("id")) {
				findElement = driver.findElement(By.id(value));
				return findElement;
			} else if (locatorType.equals("name")) {
				findElement = driver.findElement(By.name(value));
				return findElement;
			} else if (locatorType.equals("xpath")) {
				findElement = driver.findElement(By.xpath(value));
				return findElement;
			} else if (locatorType.equals("tagName")) {
				findElement = driver.findElement(By.tagName(value));
				return findElement;
			} else if (locatorType.equals("linkText")) {
				findElement = driver.findElement(By.linkText(value));
				return findElement;
			} else if (locatorType.equals("partialLinkText")) {
				findElement = driver.findElement(By.partialLinkText(value));
				return findElement;
			} else
				System.out.println("No Locators");
			return null;
		}

		// Takes Screenshot
		private static void screenshot(String name) throws IOException {
			TakesScreenshot tk = (TakesScreenshot) driver;
			File sourceFile = tk.getScreenshotAs(OutputType.FILE);
			File destinationFile = new File("E:\\Java\\Screenshot\\" + name + ".png");
			FileUtils.copyFile(sourceFile, destinationFile);
		}

		public static void textSend(String text, WebElement findElement) {
			findElement.sendKeys(text);
		}

		public static void textSend2(String text) {
			findElement.sendKeys(text);
		}

		public static void buttonClick(WebElement findElement) {
			findElement.click();
		}

		public static void buttonClick2() {
			findElement.click();
		}

		// Actions
		public static void mouseOver(WebElement element) {
			Actions action = new Actions(driver);
			action.moveToElement(element).perform();
		}

		public static void contentClick(WebElement element) {
			Actions action = new Actions(driver);
			action.contextClick(element).perform();
		}

		public static void doubleClick(WebElement element) {
			Actions action = new Actions(driver);
			action.doubleClick(element).perform();
		}

		// Robot
		public static void btnEnter() throws AWTException {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
		}

		// javascriptExecutor
		public static void textJavaScript(String user, WebElement element) {
			JavascriptExecutor jk = (JavascriptExecutor) driver;
			jk.executeScript("arguments[0].setAttribute('value','" + user + "')", element);
		}

		public static void buttonJavaScript(WebElement refElement) {
			JavascriptExecutor jk = (JavascriptExecutor) driver;
			jk.executeScript("arguments[0].click()", refElement);
		}

		public static void scrollDown(WebElement refElement) {
			JavascriptExecutor jk = (JavascriptExecutor) driver;
			jk.executeScript("arguments[0].scrollIntoView(true)", refElement);
		}

		public static void scrollUp(WebElement refElement) {
			JavascriptExecutor jk = (JavascriptExecutor) driver;
			jk.executeScript("arguments[0].scrollIntoView(false)", refElement);
		}

		public static String excelRead(int rownum, int cellnum) throws IOException {
			Workbook w = new XSSFWorkbook(new FileInputStream(new File("D:\\Selenium\\Testing\\Adactin.xlsx")));
			Sheet sheet = w.getSheet("Sheet1");
			CellType type = sheet.getRow(rownum).getCell(cellnum).getCellType();
			String cellValue;
			switch (type) {
			case STRING:
				cellValue = sheet.getRow(rownum).getCell(cellnum).getStringCellValue();
				break;
			case NUMERIC:
				double value = sheet.getRow(rownum).getCell(cellnum).getNumericCellValue();
				long l = (long) value;
				cellValue = String.valueOf(l);
				break;
			default:
				double value2 = sheet.getRow(rownum).getCell(cellnum).getNumericCellValue();
				SimpleDateFormat date = new SimpleDateFormat("dd/mm/yyyy");
				cellValue = date.toString();
				break;
			}
			return cellValue;
		}

		public static void getProperties(String url2) throws IOException {
			File f = new File("C:\\Users\\pamoh\\.eclipse\\AdActIn\\src\\test\\resources\\Properties.properties");
			FileReader fileReader = new FileReader(f);
			Properties properties = new Properties();
			properties.load(fileReader);
			String url = properties.get("url").toString();
		}

		public static void getUrl(String url) throws IOException {
			getProperties(url);
		}
	}


