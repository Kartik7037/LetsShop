package LetsShop.Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import Utilities.Components;




public class LoginPage extends Components{

	protected By Email = By.id("userEmail");
	protected By Password = By.id("userPassword");
	protected By loginBtn = By.id("login");
	protected By HomePage = By.xpath("//div[@class='left mt-1']/p");
    String ApplicationName = "LetsShop";
 
	public void goTo() {
	 launchApplication(ApplicationName);
	 waitElementToAppear(Email);
	 updateTestReporter(getClass().getSimpleName(), "LaunchURL", Status.PASS, "URL launched successfully");
	}
	
	public void enterEmail(String email) {
		getElement(Email).sendKeys(email);
		updateTestReporter(getClass().getSimpleName(), "Enter Email", Status.PASS, "Email entered successfully");
	}
	
	public void enterPassword(String password) {
		getElement(Password).sendKeys(password);
		updateTestReporter(getClass().getSimpleName(), "Enter Password", Status.PASS, "Password entered successfully");
	}
	
	public void clickLoginBtn() {
	    getElement(loginBtn).click();	
	    waitElementToAppear(HomePage);
	    Assert.assertTrue(verifyObjectDisplayed(HomePage), "Login Failed");
	    updateTestReporter(getClass().getSimpleName(), "Click Login button", Status.PASS, "Login button clicked and user is navigated to HomePage");
	}
}
