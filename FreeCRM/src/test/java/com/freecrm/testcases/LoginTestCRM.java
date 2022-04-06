package com.freecrm.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.freecrm.pages.BaseClass;
import com.freecrm.pages.LoginPage;
import com.freecrm.utility.ExcelReader;

public class LoginTestCRM extends BaseClass {
	//WebDriver driver;

	//ExcelReader excel =  new ExcelReader();
	
	@Test
	public void loginApp() throws InterruptedException {
		//ExcelReader excel = new ExcelReader(); we can create the obj in here or else create in base class and directly use here by using the ref obj.
		
		logger= report.createTest("Login to CRM");
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		Thread.sleep(2000);
		logger.info("Starting Application");
		login.loginToCRM(excel.getStringData("Login", 2, 0), excel.getStringData("Login", 2, 0));
		logger.info("Get Title");
		System.out.println(driver.getTitle());
		logger.pass("Login Success");
		//helper.captureScreenshot(driver);

	}
	

}
