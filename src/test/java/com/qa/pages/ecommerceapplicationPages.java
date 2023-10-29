package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import io.appium.java_client.android.AndroidDriver;


public class ecommerceapplicationPages {
	AndroidDriver driver;

	/************************Menu Items***************/
	//method to locate menu bar items 
	@FindAll(@FindBy(className="android.widget.CheckedTextView"))
	List<WebElement> menuitems;
	public List<WebElement> getMenuItems()
	{
		return menuitems;
	}
	/****************************REGISTER*********************************************/
	
	/***************************NEW ARRIVALS*************************************/
	
	/**************************SALES*******************************/
	
	
	
	/********************LOGIN******************************************/
	
	
	// method to locate email text box
	@FindBy(id="com.studiobluelime.ecommerceapp:id/et_login_username")
	WebElement emailtxtBox;

	public WebElement getEmailTxtBox()
	{
		return emailtxtBox;
	}
	
	
	// method to loacte password text box
	@FindBy(id="com.studiobluelime.ecommerceapp:id/et_login_password")
	WebElement password;
	public WebElement getPasswordTxtBox()
	{
		return password;
	}
	
	
	//method to locate login button
	@FindBy(id="com.studiobluelime.ecommerceapp:id/btn_login")
	WebElement loginbtn;
	public WebElement getLoginBtn()
	{
		return loginbtn;
	}
	
	
	/***********************MY ACCOUNT******************************************/
	
	// To locate My Details Button
	@FindBy(id="com.studiobluelime.ecommerceapp:id/btn_mydetails")
	WebElement mydetails;
	public WebElement getMydetalsBtn()
	{
		return mydetails;
	}
	
	//to locate user details
	@FindBy(className="android.widget.EditText")
	List<WebElement> userdetails;
	public List<WebElement> getUserDetails()
	{
		return userdetails;
		
	}

	
	/***************************ADD TO CART **********************************************/
	
	
	
	
	public ecommerceapplicationPages(AndroidDriver rDriver) {
		 this.driver = rDriver;
		    PageFactory.initElements(rDriver,this);
		}
	}
	