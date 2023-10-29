package com.qa.testscripts;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.qa.pages.ecommerceapplicationPages;

import io.appium.java_client.screenrecording.CanRecordScreen;

public class Testbase {

	AndroidDriver driver;
	String username;
	String mobile_number;
	String email;;
	String password;
	Properties props;
	ecommerceapplicationPages ecommercepageObjects;
	
	

	@SuppressWarnings("deprecation")
	@Parameters({ "devicename" })
	@BeforeMethod
	void BaseConfig(String devicename) throws InterruptedException, IOException {
		
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", devicename);
		capabilities.setCapability("automationName", "UiAutomator2");
		capabilities.setCapability("app",
				"C:\\Users\\chena\\eclipse-workspace\\SDET_CAPSTONE_MOBILEAUTOMATION\\Resources\\E-Commerce App_1.8_Apkpure.apk");
		
		FileInputStream file = new FileInputStream("C:\\Users\\chena\\eclipse-workspace\\SDET_Capstone_MT\\src\\test\\java\\com\\qa\\testdata\\userdata.properties");
		props = new Properties();
		props.load(file);
		username = props.getProperty("Username");
		mobile_number = props.getProperty("Mobile");
		email = props.getProperty("Email");
		password = props.getProperty("Password");
		
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), capabilities);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		ecommercepageObjects=new ecommerceapplicationPages(driver);

		driver.findElement(AppiumBy.id("com.studiobluelime.ecommerceapp:id/btn_skip")).click();
		Thread.sleep(3000);
		menubtn=driver.findElement(AppiumBy.accessibilityId("App"));
		

	}
	WebElement menubtn;
	
	
	public void startRecording() {

		((CanRecordScreen) driver).startRecordingScreen();
	}

	public void captureScreenShot() throws IOException {
		String path = "C:\\Users\\chena\\eclipse-workspace\\SDET_CAPSTONE_MOBILEAUTOMATION\\Reports\\Screenshot";
		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");

		String file_name = df.format(new Date()) + ".png";

		FileUtils.copyFile(f, new File(path + "/" + file_name));
	}

	@AfterMethod
	void teardown() throws IOException {

		driver.quit();
	}

}
