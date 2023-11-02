package com.qa.testscripts;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class TC_Sales extends Testbase {
	@Test
	void getSales() throws IOException, InterruptedException
	{
		menubtn.click();
		List<WebElement> menuitems=ecommercepageObjects.getMenuItems();
		for(WebElement item:menuitems)
		{
			if(item.getText().contains("Sale"))
			{
				item.click();
				break;
			}
		}
		Thread.sleep(1000);
		test = extent.createTest("TC_Sales");
		
	}
	}




