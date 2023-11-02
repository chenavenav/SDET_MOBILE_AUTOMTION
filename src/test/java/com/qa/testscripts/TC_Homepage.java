package com.qa.testscripts;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class TC_Homepage extends Testbase {
	// Method to scroll to an element
	@Test
	public void scroll() throws IOException {
		 driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Electronics\").instance(0))")).click();
	
		 test = extent.createTest("TC_Homepage");
		 
	}

}
