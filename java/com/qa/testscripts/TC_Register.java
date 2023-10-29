package com.qa.testscripts;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.pages.Register;
import com.qa.testscripts.Testbase;

import io.appium.java_client.AppiumBy;



public class TC_Register extends Testbase {
	
	//Generic method for registration
	@Test(priority=1)
	void register()
	{
		
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		List<WebElement> menuitems=driver.findElements(AppiumBy.className("android.widget.CheckedTextView"));
		
		for(WebElement item:menuitems)
		{
			if(item.getText().contains("My Account"))
			{
				item.click();
				break;
			}
		}
		driver.findElement(AppiumBy.id("com.studiobluelime.ecommerceapp:id/tv_register")).click();
		driver.findElement(AppiumBy.id("com.studiobluelime.ecommerceapp:id/et_register_username")).sendKeys(username);
		driver.findElement(AppiumBy.id("com.studiobluelime.ecommerceapp:id/et_register_mno")).sendKeys(mobile_number);
		driver.findElement(AppiumBy.id("com.studiobluelime.ecommerceapp:id/et_register_email")).sendKeys(email);
		driver.findElement(AppiumBy.id("com.studiobluelime.ecommerceapp:id/et_register_password")).sendKeys(password);
		driver.findElement(AppiumBy.id("com.studiobluelime.ecommerceapp:id/btn_register")).click();
		System.out.println("user_Registered:\n"+username+"\t mobile:"+mobile_number+"\t email:"+email+"\t password:"+password);
		
		driver.findElement(AppiumBy.id("com.studiobluelime.ecommerceapp:id/btn_mydetails")).click();
		List <WebElement> userdetails = driver.findElements(AppiumBy.className("android.widget.EditText"));
		
		// to verify registered user details
		for(WebElement userdetail:userdetails)
		{
			System.out.print(userdetail.getText());
			if(userdetail.getText().contains(email))
			{
				Assert.assertTrue(true);
				System.out.print("user register successfull");
				break;
			}
			else
			{
				System.out.print("\n");
			}
		}
	}
}
