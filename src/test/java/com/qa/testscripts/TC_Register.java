package com.qa.testscripts;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.testscripts.Testbase;

import io.appium.java_client.AppiumBy;



public class TC_Register extends Testbase {
	
	//Generic method for registration
	@Test(priority=1)
	void register() throws IOException
	{
		
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		List<WebElement> menuitems= ecommercepageObjects.getMenuItems();
		
		for(WebElement item:menuitems)
		{
			if(item.getText().contains("My Account"))
			{
				item.click();
				break;
			}
		}
		//To click on Register Button 
		ecommercepageObjects.getRegisterButton().click();
		//To enter user name in user name field
		ecommercepageObjects.getUserNameTxtBox().sendKeys(username);
		//To Enter Mobile number in mobile number field
		ecommercepageObjects.getMobileNumber().sendKeys(mobile_number);
		
		//To Enter Email in email text field
		ecommercepageObjects.getEmailtxtbox().sendKeys(email);
		//To Enter Password in password text field
		ecommercepageObjects.getRegisterPasswordTxtBox().sendKeys(password);
		//To click on register button after entering the required fields
		ecommercepageObjects.getBtn_register().click();
		
		
		//To click on my details button to verify registered user 
		ecommercepageObjects.getMydetalsBtn().click();
		List <WebElement> userdetails = ecommercepageObjects.getUserDetails();
		// to verify registered user details
		for(WebElement userdetail:userdetails)
		{
			System.out.print(userdetail.getText());
			if(userdetail.getText().contains(email))
			{
				Assert.assertTrue(true);
				System.out.println("user_Registered:\n"+username+"\t mobile:"+mobile_number+"\t email:"+email+"\t password:"+password);
				System.out.print("user register successfull");
				break;
			}
			else
			{
				System.out.print("\n");
			}
		}
		test = extent.createTest("TC_Register");
	
}
}
