package com.ada;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProvoiderExcel {
	WebDriver driver;
	
	@Test(dataProvider = "login", dataProviderClass = DataUtils.class)

	public void tc01(String data[]) {
		System.out.println("username: " + data[0]);
		System.out.println("password: " + data[1]);
		System.out.println("Phone No : " + data[2]);
		System.out.println("User_Id: " + data[3]);
		System.out.println("e-mail: " + data[4]);
		System.out.println("Date: " + data[5]);
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://adactinhotelapp.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebElement txtName = driver.findElement(By.id("username"));
		txtName.sendKeys(data[0]);
		WebElement txtpass = driver.findElement(By.id("password"));
		txtpass.sendKeys(data[1]);
		WebElement btncreat = driver.findElement(By.id("login"));
		btncreat.click();
			}
/*	public void tc02() {
		b=new BaseClass();
		b.launchURL("http://adactinhotelapp.com/");
	}
	public void tc03() {
	b.findLocator("id", "username");
	b.enterText("username", data[0]);
	}*/

}
