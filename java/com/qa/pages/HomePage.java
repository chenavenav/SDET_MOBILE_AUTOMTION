package com.qa.pages;

import java.util.List;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class HomePage {
	public AndroidDriver driver;

List<WebElement> categories= driver.findElements(AppiumBy.className("android.widget.TextView"));	
public List<WebElement> getCategories()
{
	return categories;
}

//method to find Skip Element

//WebElement skip=driver.findElement(AppiumBy.id("com.studiobluelime.ecommerceapp:id/btn_skip"));
@FindBy(id="com.studiobluelime.ecommerceapp:id/btn_skip")
WebElement skip;
public WebElement skip()
{
	return skip;
}
public HomePage(AndroidDriver rDriver) {
    this.driver = rDriver;
    PageFactory.initElements(rDriver,this);
}

}
