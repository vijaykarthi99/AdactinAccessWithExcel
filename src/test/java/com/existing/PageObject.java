package com.existing;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObject extends BaseClass {
	public PageObject() {
		PageFactory.initElements(driver, this);
		}
	
	
	@FindBy(id = "username")
	private WebElement username;

	public WebElement getUsername() {
		return username;
	}

	@FindBy(id = "password")
	private WebElement password;

	public WebElement getPassword() {
		return password;
	}

	@FindBy(name = "location")
	private WebElement location;

	public WebElement getLocation() {
		return location;
	}

	@FindBy(name = "hotels")
	private WebElement hotels;

	public WebElement getHotels() {
		return hotels;
	}

	@FindBy(name = "room_type")
	private WebElement roomtype;

	public WebElement getRoomtype() {
		return roomtype;
	}

	@FindBy(name = "room_nos")
	private WebElement roomnos;

	public WebElement getRoomnos() {
		return roomnos;
	}

	@FindBy(id = "datepick_in")
	private WebElement checkInDate;

	public WebElement getCheckInDate() {
		return checkInDate;
	}

	@FindBy(id = "datepick_out")
	private WebElement checkOutDate;

	public WebElement getCheckOutDate() {
		return checkOutDate;
	}

	@FindBy(name = "adult_room")
	private WebElement adult;

	public WebElement getAdult() {
		return adult;
	}

	@FindBy(name = "child_room")
	private WebElement child;

	public WebElement getChild() {
		return child;
	}

	@FindBy(id = "radiobutton_0")
	private WebElement selectContinueClick;

	public WebElement getSelectContinueClick() {
		return selectContinueClick;
	}

	@FindBy(name = "first_name")
	private WebElement firstname;

	public WebElement getFirstname() {
		return firstname;
	}

	@FindBy(name = "last_name")
	private WebElement lastname;

	public WebElement getLastname() {
		return lastname;
	}

	@FindBy(name = "address")
	private WebElement address;

	public WebElement getAddress() {
		return address;
	}

	@FindBy(name = "cc_num")
	private WebElement ccnum;

	public WebElement getCcnum() {
		return ccnum;
	}

	@FindBy(name = "cc_type")
	private WebElement cctype;

	public WebElement getCctype() {
		return cctype;
	}

	@FindBy(name = "cc_exp_month")
	private WebElement ccmonth;

	public WebElement getCcmonth() {
		return ccmonth;
	}

	@FindBy(name = "cc_exp_year")
	private WebElement ccyear;

	public WebElement getCcyear() {
		return ccyear;
	}

	@FindBy(id = "cc_cvv")
	private WebElement cccvv;

	public WebElement getCccvv() {
		return cccvv;
	}

	@FindBy(id = "order_no")
	private WebElement orderno;

	public WebElement getOrderno() {
		return orderno;
	}

}
