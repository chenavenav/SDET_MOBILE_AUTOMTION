package com.qa.testscripts;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class TC_MenuItems extends Testbase{
	@Test
	void getMenuitems() throws IOException
	{
	menubtn.click();
	List<WebElement> menuitems = ecommercepageObjects.getMenuItems();
	System.out.println("menu items are:");
	for(WebElement item:menuitems)
	{
		System.out.println(item.getText());
	}
	
	test = extent.createTest("TC_MenuItems");
}
	
}
	
