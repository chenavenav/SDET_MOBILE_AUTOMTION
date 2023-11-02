package com.qa.testscripts;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class TC_AddtoCart extends Testbase {
	@Test
	void additemtocart() throws IOException
	{
	//To scroll on to electronics and Click on it.
	 driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Electronics\").instance(0))")).click();
	 //To select category
	 ecommercepageObjects.getMobileCategory().click();
	driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Xiaomi\").instance(0))")).click();
	
	//to select product
	 ecommercepageObjects.getProduct().click();
	 //to select color of product
	ecommercepageObjects.SelectProductColor().click();
	 //to select size of product
	 ecommercepageObjects.SelectSize().click();
	 //to select quantity
	 ecommercepageObjects.SelectQuantity().sendKeys("1");
	 //to click on add_to_cart
	
	 driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"WRITE REVIEW\").instance(0))")).click();
		
	 ecommercepageObjects.getAddToCartBtn().click();
	 
	 
	 //to verify item is added to into cart
	 driver.findElement(AppiumBy.accessibilityId("Cart")).click();
	 String productname=ecommercepageObjects.getProductName().getText();
	 
	 System.out.println(productname+"Successfully added into Cart");
	 
	 test = extent.createTest("TC_AddtoCart");
	
    }
}