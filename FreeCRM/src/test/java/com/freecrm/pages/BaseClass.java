package com.freecrm.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.freecrm.utility.BrowserFactory;
import com.freecrm.utility.ConfigReader;
import com.freecrm.utility.ExcelReader;
import com.freecrm.utility.Helper;

public class BaseClass {
	//create Global variable
	public WebDriver driver;
	public ExcelReader excel;
	public ConfigReader config;
	public ExtentReports report;
	public ExtentTest logger;
	//public Helper helper;
	
	//As soon as the test suite will start it will start/create the obj of the ExcelReader, after 
	// which we can use the reference obj excel in our test scripts as our tests extends BaseClass
	@BeforeSuite
	public void setupSuite() {
		
		Reporter.log("Setting up reports and Test is getting ready" , true);
		 excel = new ExcelReader();
		 config = new ConfigReader();
		 
		 ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir") + "/Reports/FreeCRM.html"));
		 report = new ExtentReports();
		 report.attachReporter(extent);
		 //helper = new Helper();
		 
		 Reporter.log("Setting done -  Test can be started" , true);
	} 
	
	//@BeforeClass annotation will setup all the driver initialization and browser set up and launching the website
	@BeforeClass()
	public void launch() {
		Reporter.log("Launching the browser and getting the application ready" , true);
		driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getqaURL());

		Reporter.log("Browser and Application is up and running" , true);
	}
	
	@AfterClass
	public void teardownT() {
		BrowserFactory.tearDown(driver);
	}
	
	@AfterMethod
	public void captureScreenshot(ITestResult result) throws IOException {
		if(result.getStatus() == ITestResult.FAILURE) {
			
			logger.fail("Test Failed ",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			
			logger.pass("Test Passed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		//will keep on adding the test, say we have 5 tests the report.flush()will keep on adding test into a single report
		report.flush();
		
		Reporter.log("Test completed >>>>>>> report generated." , true);
	} 
}
