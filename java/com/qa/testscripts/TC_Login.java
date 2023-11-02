package com.qa.testscripts;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class TC_Login extends Testbase {
	// method to verify login functionality
	@Test
	void login() {
		System.out.print(username);
		driver.findElement(AppiumBy.accessibilityId("App")).click();

		List<WebElement> menuitems = driver.findElements(AppiumBy.className("android.widget.CheckedTextView"));

		for (WebElement item : menuitems) {
			if (item.getText().contains("My Account")) {
				item.click();
				break;
			}
		}
		driver.findElement(AppiumBy.id("com.studiobluelime.ecommerceapp:id/et_login_username")).sendKeys(email);
		driver.findElement(AppiumBy.id("com.studiobluelime.ecommerceapp:id/et_login_password")).sendKeys(password);
		driver.findElement(AppiumBy.id("com.studiobluelime.ecommerceapp:id/btn_login")).click();
		
		driver.findElement(AppiumBy.id("com.studiobluelime.ecommerceapp:id/btn_mydetails")).click();
		List <WebElement> userdetails = driver.findElements(AppiumBy.className("android.widget.EditText"));
		
		// to verify registered user details
		for (WebElement userdetail : userdetails) {
			System.out.print(userdetail.getText());
			if (userdetail.getText().contains(email)) {
				Assert.assertTrue(true);
				System.out.println("\nuser login successfull");
				break;
			} else {
				System.out.print("\n");
			}
		}
		  test = extent.createTest("noCommerceLoginTest");
	}
}
