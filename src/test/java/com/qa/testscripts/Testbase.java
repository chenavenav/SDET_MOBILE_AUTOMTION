package com.qa.testscripts;

import io.appium.java_client.AppiumBy;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.pages.ecommerceapplicationPages;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Testbase {

	AndroidDriver driver;
	WebDriver driver2;
	String username;
	String mobile_number;
	String email;;
	String password;
	Properties props;
	ecommerceapplicationPages ecommercepageObjects;
	// Initializing Extent reports
	public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest test;
	// path to store Screenshots
	SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
	String file_name = df.format(new Date()) + ".png";
	String path = "C:\\Users\\chena\\eclipse-workspace\\SDET_Capstone_MT\\Reports\\Screenshot";

	@SuppressWarnings("deprecation")
	@Parameters({ "devicename" })
	@BeforeMethod
	void BaseConfig(String devicename) throws InterruptedException, IOException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", devicename);
		capabilities.setCapability("automationName", "UiAutomator2");
		capabilities.setCapability("app",System.getProperty("user.dir")+ "/Resources/E-Commerce App_1.8_Apkpure.apk");

		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/com/qa/testdata/userdata.properties");
		props = new Properties();
		props.load(file);
		username = props.getProperty("Username");
		mobile_number = props.getProperty("Mobile");
		email = props.getProperty("Email");
		password = props.getProperty("Password");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), capabilities);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		ecommercepageObjects = new ecommerceapplicationPages(driver);

		driver.findElement(AppiumBy.id("com.studiobluelime.ecommerceapp:id/btn_skip")).click();
		Thread.sleep(3000);
		menubtn = driver.findElement(AppiumBy.accessibilityId("App"));

	}

	WebElement menubtn;

	

	//Method to take screenshot 
	public static String getScreenshot(AndroidDriver driver, String screenshotName) throws IOException {
		  String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		  TakesScreenshot ts = (TakesScreenshot) driver;
		  File source = ts.getScreenshotAs(OutputType.FILE);
		  
		  // after execution, you could see a folder "FailedTestsScreenshots" under src folder
		  String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
		  File finalDestination = new File(destination);
		  FileUtils.copyFile(source, finalDestination);
		  return destination;
		 }
	//Method to scroll and click
	public void ScrollandClick(String text) {
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"+text+\").instance(0))"))
				.click();

	}
	

	public void scrollIntoView(WebElement ele) {
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
	}
	
	//configuration of extent report
	 @BeforeSuite
	    public void setUp()
	    {
	        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/TestReport.html");
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	         
	        extent.setSystemInfo("OS", "Windows");
	        extent.setSystemInfo("Host Name", "Local Host-Virtusa");
	        extent.setSystemInfo("Environment", "QA");
	        extent.setSystemInfo("User Name", "Vamshi");
	         
	    
	        htmlReporter.config().setDocumentTitle("MobileTesting.in Report");
	        htmlReporter.config().setReportName("Ecommerce App Test Report");
	       
	        htmlReporter.config().setTheme(Theme.DARK);
	    }
	

	 @AfterMethod
	    public void getResult(ITestResult result) throws IOException
	    {
	        if(result.getStatus() == ITestResult.FAILURE)
	        {
	            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case FAILED due to below issues:", ExtentColor.RED));
	            test.fail(result.getThrowable());
	            String screenshotPath = getScreenshot(driver, result.getName());
	            test.addScreenCaptureFromPath(screenshotPath);
	        }
	        else if(result.getStatus() == ITestResult.SUCCESS)
	        {
	            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
	            String screenshotPath = getScreenshot(driver, result.getName());
	            test.addScreenCaptureFromPath(screenshotPath);
	        }
	        else
	        {
	            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test Case SKIPPED", ExtentColor.ORANGE));
	            test.skip(result.getThrowable());
	        }
	        driver.quit();
	    }

	@AfterSuite
	public void endReport() {
		extent.flush();
		WebDriverManager.edgedriver().setup();

		driver2 = new EdgeDriver();

		
	}
}
