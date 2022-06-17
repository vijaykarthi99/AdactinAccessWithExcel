package com.existing;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotConcept {
	static WebDriver driver;
	Robot r;
	Date date;
	Actions actions;

	@BeforeClass
	public static void url() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();

	}

	@After
	public void date() throws IOException {
		date = new Date();
		System.out.println(date);
		
	}

	@Before
	public void screenshot() throws IOException {
		TakesScreenshot src = (TakesScreenshot) driver;
		File st = src.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(st, new File("D:\\JavaClassProjectsEclipse\\AdactinAccessWithExcel\\Flipkart\\1.png"));

	}

	@Test
	public void search() throws AWTException {
		driver.findElement(By.xpath("//button[text()='✕']")).click();

		driver.findElement(By.name("q")).sendKeys("laptops i5");
		r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		WebElement le = driver.findElement(By.xpath("(//div[@class='_4rR01T'])[1]"));
		le.click();
	}
	

//	@Test
//	public void selectlap() {
	
		// WebElement cl = driver.findElement(By.xpath("//div[contains(text(),'X413EA-EB531WS')]"));

//		JavascriptExecutor ex = (JavascriptExecutor) driver;
		// ex.executeScript("arguments[0].ScrollIntoView(true)",le);

//		ex.executeScript("arguments[0].click()", le);

//	}
	@Test
	public void switchWindow() {
		WebElement add = driver.findElement(By.xpath("//button[contains(text(),'ADD TO CART')]"));
		Set<String> handles = driver.getWindowHandles();
		List<String> li = new ArrayList(handles);
		driver.switchTo().window(li.get(0));
		add.click();
		
	}
	
}
