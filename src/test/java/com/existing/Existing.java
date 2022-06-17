package com.existing;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Existing extends BaseClass {

	@Test
	public void tc01() throws IOException {
		getDriver();
		File f = new File("C:\\Users\\pamoh\\.eclipse\\AdActIn\\src\\test\\resources\\Properties.properties");
		FileReader fileReader = new FileReader(f);
		Properties properties = new Properties();
		properties.load(fileReader);
		String url = properties.get("url").toString();
		launchUrl(url);
		String username = properties.get("username").toString();
		String password = properties.get("password").toString();
		// Username
		PageObject p = new PageObject();
		WebElement txtuser = p.getUsername();
		txtuser.sendKeys(username);
		// Password
		WebElement txtPass = p.getPassword();
		txtPass.sendKeys(password);
		// Login Button
		locators("name", "login").click();
	}

	@Test
	private void tc02() throws IOException {
		PageObject p = new PageObject();
		String txtlocation = excelRead(1, 0);
		Select s = new Select(p.getLocation());
		s.selectByValue(txtlocation);
		String txthotel = excelRead(1, 1);
		Select s1 = new Select(p.getHotels());
		s1.selectByValue(txthotel);
		String txtroomtype = excelRead(1, 2);
		Select s2 = new Select(p.getRoomtype());
		s2.selectByValue(txtroomtype);
		String txtroomno = excelRead(1, 3);
		Select s3 = new Select(p.getRoomnos());
		s3.selectByValue(txtroomno);
		String txtCheckIn = excelRead(1, 4);
		p.getCheckInDate().clear();
		p.getCheckInDate().sendKeys(txtCheckIn);
		String txtCheckOut = excelRead(1, 5);
		p.getCheckOutDate().clear();
		p.getCheckOutDate().sendKeys(txtCheckOut);
		String txtAdult = excelRead(1, 6);
		Select s6 = new Select(p.getAdult());
		s6.selectByValue(txtAdult);
		String txtChild = excelRead(1, 7);
		Select s7 = new Select(p.getChild());
		s7.selectByValue(txtChild);
		locators("id", "Submit").click();
	}

	@Test
	private void tc03() {
		locators("id", "radiobutton_0").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		locators("id", "continue").click();
	}

	@Test
	private void tc04() throws IOException, InterruptedException {
		PageObject p = new PageObject();
		String firstname = excelRead(1, 8);
		p.getFirstname().sendKeys(firstname);
		String lastname = excelRead(1, 9);
		p.getLastname().sendKeys(lastname);
		String address = excelRead(1, 10);
		p.getAddress().sendKeys(address);
		String ccnum = excelRead(1, 11);
		p.getCcnum().sendKeys(ccnum);
		String cctype = excelRead(1, 12);
		Select s8 = new Select(p.getCctype());
		s8.selectByValue(cctype);
		String ccexpmonth = excelRead(1, 13);
		Select s9 = new Select(p.getCcmonth());
		s9.selectByValue(ccexpmonth);
		String ccexpyear = excelRead(1, 14);
		Select s10 = new Select(p.getCcyear());
		s10.selectByValue(ccexpyear);
		String cccvv = excelRead(1, 15);
		p.getCccvv().sendKeys(cccvv);
		locators("id", "book_now").click();
		Thread.sleep(8000);
		// Print Order Id
		// String attribute = p.getOrderno().getAttribute("value");
		// System.out.println(attribute);
	}
}
