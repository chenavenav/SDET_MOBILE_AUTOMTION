package com.qa.testscripts;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class TC_NewArrivals extends Testbase {
	@Test
	void getnewarrivals() throws IOException
	{
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		List<WebElement> menuitems=driver.findElements(AppiumBy.className("android.widget.CheckedTextView"));
		
		for(WebElement item:menuitems)
		{
			if(item.getText().contains("New Arrivals"))
			{
				item.click();
				break;
			}
		}
		
		captureScreenShot();
	}

}
