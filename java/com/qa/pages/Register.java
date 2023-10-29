package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class Register {
	 static AndroidDriver driver;
	
	
	
	//static WebElement menubutton=driver.findElement(AppiumBy.accessibilityId("App"));
	 @AndroidFindBy(id="App")
	 WebElement menubutton;
	//method to get menubutton element
	public WebElement getMenu()
	{
		return menubutton;
	}
	
	@FindAll(@FindBy(className="android.widget.CheckedTextView"))
	List<WebElement> menuitems;
	public List<WebElement> getMenuItems()
	{
		return menuitems;
	}
	
	
	@AndroidFindBy(id="com.studiobluelime.ecommerceapp:id/tv_register")
	WebElement register;
	public WebElement getregisterBtn()
	{
		return register;
	}
	
	@AndroidFindBy(id="com.studiobluelime.ecommerceapp:id/et_register_username")
	WebElement name;
	public WebElement getnametxtbox()
	{
		return name;
	
	}
	
	@AndroidFindBy(id="com.studiobluelime.ecommerceapp:id/et_register_mno")
	WebElement mobilenumber;
	public WebElement getmobileNumbertxtbox()
	{
		return mobilenumber;
	}
	@AndroidFindBy(id="com.studiobluelime.ecommerceapp:id/et_register_email")
	WebElement email;
	public WebElement getEmailtxtbox()
	{
		return email;
	}
	
	@AndroidFindBy(id="com.studiobluelime.ecommerceapp:id/et_register_password")
	WebElement password;
	public WebElement getpaswordtxtbox()
	{
		return password;
	}
	@AndroidFindBy(id="com.studiobluelime.ecommerceapp:id/btn_register")
	WebElement registerbtn;
	public WebElement ClickRegister()
	{
		return registerbtn;
	}
	
	public Register(AndroidDriver rDriver) {
	    Register.driver = rDriver;
	    PageFactory.initElements(rDriver,this);
	}

	}


