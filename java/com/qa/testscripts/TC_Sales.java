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
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		List<WebElement> menuitems=driver.findElements(AppiumBy.className("android.widget.CheckedTextView"));
		
		for(WebElement item:menuitems)
		{
			if(item.getText().contains("Sale"))
			{
				item.click();
				break;
			}
		}
		Thread.sleep(1000);
		captureScreenShot("Sales");
	}



}
