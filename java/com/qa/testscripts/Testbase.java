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

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.appium.java_client.screenrecording.CanRecordScreen;

public class Testbase {

	AndroidDriver driver;
	String username;
	String mobile_number;
	String email;;
	String password;
	Properties props;
	
	//Intialize Extent reports
	public WebDriver driver;
	 public ExtentHtmlReporter htmlReporter;
	 public ExtentReports extent;
	 public ExtentTest test;

	@SuppressWarnings("deprecation")
	@Parameters({ "devicename" })
	@BeforeTest
	void BaseConfig(String devicename) throws InterruptedException, IOException {
		
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", devicename);
		capabilities.setCapability("automationName", "UiAutomator2");
		capabilities.setCapability("app",
				"C:\\Users\\chena\\eclipse-workspace\\SDET_CAPSTONE_MOBILEAUTOMATION\\Resources\\E-Commerce App_1.8_Apkpure.apk");
		
		FileInputStream file = new FileInputStream("C:\\Users\\chena\\eclipse-workspace\\SDET_CAPSTONE_MOBILEAUTOMATION\\src\\test\\java\\com\\qa\\testdata\\userdata.properties");
		props = new Properties();
		props.load(file);
		username = props.getProperty("Username");
		mobile_number = props.getProperty("Mobile");
		email = props.getProperty("Email");
		password = props.getProperty("Password");
		
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), capabilities);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		driver.findElement(AppiumBy.id("com.studiobluelime.ecommerceapp:id/btn_skip")).click();
		Thread.sleep(3000);
		
		 public void setExtent() {
			  // specify location of the report
			  htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/myReport.html");

			  htmlReporter.config().setDocumentTitle("Automation Report"); // Tile of report
			  htmlReporter.config().setReportName("Mobile Testing"); // Name of the report
			  htmlReporter.config().setTheme(Theme.DARK);
			  
			  extent = new ExtentReports();
			  extent.attachReporter(htmlReporter);
			  
			  // Passing General information
			  extent.setSystemInfo("Host name", "localhost");
			  extent.setSystemInfo("Environemnt", "QA");
			  extent.setSystemInfo("user", "Vamshi");
			 }
		
	}



	public void captureScreenShot(String name) throws IOException {
		String path = "C:\\Users\\chena\\eclipse-workspace\\SDET_CAPSTONE_MOBILEAUTOMATION\\Reports\\Screenshot";
		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		

		FileUtils.copyFile(f, new File(path + "/" +name+".png"));
	}
	 @AfterMethod
	 public void tearDown(ITestResult result) throws IOException {
	  if (result.getStatus() == ITestResult.FAILURE) {
	   test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report
	   test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in extent report
	   String screenshotPath = NopCommerceTest.getScreenshot(driver, result.getName());
	   test.addScreenCaptureFromPath(screenshotPath);// adding screen shot
	  } else if (result.getStatus() == ITestResult.SKIP) {
	   test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
	  }
	  else if (result.getStatus() == ITestResult.SUCCESS) {
	   test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
	  }
	  driver.quit();
	 }
	@AfterTest
	void teardown() throws IOException {
		 extent.flush();
	}

}
