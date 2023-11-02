package com.qa.testscripts;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_MyAccount extends Testbase{
	@Test
	void getmyaccount() throws IOException {
		
		//to click on menu button
		menubtn.click();

		List<WebElement> menuitems=ecommercepageObjects.getMenuItems();
		//To click My Account option in menu items
		for (WebElement item : menuitems) {
			if (item.getText().contains("My Account")) {
				item.click();
				break;
			}
		}
		//To enter email address in email text box
		ecommercepageObjects.getEmailTxtBox().sendKeys(email);
		
		// to enter password in password text box
		ecommercepageObjects.getPasswordTxtBox().sendKeys(password);
		
		// To click on login button 
		ecommercepageObjects.getLoginBtn().click();
		
		//to click on my details button
		ecommercepageObjects.getMydetalsBtn().click();
		
		//To get user details
		List <WebElement> userdetails = ecommercepageObjects.getUserDetails();		
		// To verify registered user details
		for (WebElement userdetail : userdetails) {
			System.out.print(userdetail.getText());
			if (userdetail.getText().contains(email)) {
				Assert.assertTrue(true);
				System.out.println("\nuser userverified successfull");
				break;
			} else {
				System.out.print("\n");
			}
		}
		 
		 test = extent.createTest("TC_LOGIN");
	}

}
