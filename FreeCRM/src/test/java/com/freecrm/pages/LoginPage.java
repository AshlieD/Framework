package com.freecrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver) {
		this.driver = ldriver;
		
	}
	
	//@FindBy(xpath="//a[normalize-space()='Login']")
	//WebElement linkLogin;
	
	//@FindBy(name="email") 
	@FindBy(id="txtUsername") 
	WebElement txtusername;
	
	//@FindBy(name="password") 
	@FindBy(id="divPassword") 
	WebElement txtpassword;
	
	//@FindBy(xpath= "//div[text()='Login']") 
	@FindBy(id= "btnLogin") 
	WebElement btnlogin;
	
	
	public void loginToCRM(String username, String password) throws InterruptedException {
		//linkLogin.click();
		txtusername.sendKeys(username);
		/*WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(
		ExpectedConditions.elementToBeClickable(By.id("divPassword")));
		//Thread.sleep(3000);*/
		//txtpassword.sendKeys(password);
		btnlogin.click();
	}
	
	
	
}
