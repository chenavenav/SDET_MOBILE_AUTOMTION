package com.qa.testscripts;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class TC_AddtoCart extends Testbase {
	@Test
	void additemtocart()
	{
	
	 driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Electronics\").instance(0))")).click();
	 driver.findElement(AppiumBy.xpath("//*[@text='Mobiles']")).click();
	 driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Xiaomi\").instance(0))")).click();
	//to select product
	 driver.findElement(AppiumBy.id("com.studiobluelime.ecommerceapp:id/npr_imgview")).click();
	 //to select color of product
	 driver.findElement(AppiumBy.xpath("hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.ImageView")).click();
	 
	 //to select size of product
	 driver.findElement(AppiumBy.xpath("//*[@text='128gb']")).click();
	 //to select quantity
	 driver.findElement(AppiumBy.id("com.studiobluelime.ecommerceapp:id/pv_txt_quantity")).sendKeys("1");
	 //to click on add_to_cart
	 driver.findElement(AppiumBy.id("com.studiobluelime.ecommerceapp:id/pv_fab_addtocart")).click();
	 
	 
	 //to verify item is added to into cart
	 driver.findElement(AppiumBy.accessibilityId("Cart")).click();
	 String productname=driver.findElement(AppiumBy.id("com.studiobluelime.ecommerceapp:id/shopingcart_productname")).getText();
	 
	 System.out.println(productname+"Successfully added into Cart");
    }
}
