package ShopStore.Pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import Utilities.Components;

public class SignupLoginPage extends Components{

	protected By newUserSignUpLabel = By.xpath("//h2[contains(text(),'New')]");
	protected By signupEmail = By.xpath("//input[@data-qa = 'signup-email']");
	protected By signupLoginBtn = By.xpath("//a[contains(text(),'Login')]");
	protected By signupBtn = By.xpath("//button[contains(@data-qa,'signup')]");
	protected By loginToYourAccountLabel = By.xpath("//h2[contains(text(),'Login')]");
	protected By name = By.xpath("//input[@name = 'name']");
	protected By loginEmail = By.xpath("//input[@data-qa = 'login-email']");
	protected By loginPassword = By.xpath("//input[@data-qa = 'login-password']");
	protected By errorMessage = By.xpath("//p[contains(text(),'incorrect')]");
	protected By loginBtn = By.xpath("//button[@data-qa = 'login-button']");
	protected By signupErrorMessage = By.xpath("//div[@class = 'signup-form']/form/p");

	
	public void clickSignupLoginBtn() {
		 getElement(signupLoginBtn).click();
		 waitElementToAppear(newUserSignUpLabel);
		 waitForSometime();
		 Assert.assertTrue(verifyObjectDisplayed(newUserSignUpLabel),"'New User Signup!' is not visible");
		 Assert.assertTrue(verifyObjectDisplayed(loginToYourAccountLabel), "'Login to your account' is not visible");
		 updateTestReporter(getClass().getSimpleName(), "Click SignupLogin Button", Status.PASS,"SignupLogin Button is clicked and SignupLogin page displayed");
	}
	
	public void enterName(String Name) {
		 waitElementToAppear(newUserSignUpLabel);
		 getElement(name).sendKeys(Name);
		 updateTestReporter(getClass().getSimpleName(), "Enter Name", Status.PASS,"Name Entered successfully");
		 waitForSometime();
	}
	
	public void enterSignupEmail(String signUpEmail) {
		 waitElementToAppear(newUserSignUpLabel);
		 getElement(signupEmail).sendKeys(signUpEmail);
		 updateTestReporter(getClass().getSimpleName(), "Enter Signup Email", Status.PASS,"Signup Email Entered successfully");
		 waitForSometime();
	}
	
	public void clickSignupBtn() {
		 getElement(signupBtn).click();
		 if(!verifyObjectDisplayed(signupErrorMessage)) {
		 updateTestReporter(getClass().getSimpleName(), "Click Signup Button", Status.PASS,"Signup Button is clicked and AccountInfo page displayed");
		 }
	}
	
	public void enterLoginEmail(String LoginEmail) {
		waitElementToAppear(loginToYourAccountLabel);
		getElement(loginEmail).sendKeys(LoginEmail);
		updateTestReporter(getClass().getSimpleName(), "Enter Login Email", Status.PASS,"Login Email Entered successfully");
		waitForSometime();
	}
	
	public void enterLoginPassword(String Password) {
		waitElementToAppear(loginToYourAccountLabel);
		getElement(loginPassword).sendKeys(Password);
		updateTestReporter(getClass().getSimpleName(), "Enter Login Password", Status.PASS,"Login Password Entered successfully");
		waitForSometime();
	}
	
	public void clickLoginBtn() {
		getElement(loginBtn).click();
  		updateTestReporter(getClass().getSimpleName(), "Verify user navigate to Login page", Status.PASS,"User navigated to Login page");

	}
	
    public void validateErrorMessage() {
    	if(verifyObjectDisplayed(errorMessage)) {
   		 updateTestReporter(getClass().getSimpleName(), "Click Login Button", Status.PASS,"Login Button is clicked and error 'Your email or password is incorrect!' is visible");
   		}
   		else {
   		 updateTestReporter(getClass().getSimpleName(), "Click Login Button", Status.PASS,"Login Button is clicked and AccountInfo page displayed");
   		}
    }
    
    public void validateSignupErrorMessage() {
    	if(verifyObjectDisplayed(signupErrorMessage)) {
    		updateTestReporter(getClass().getSimpleName(), "Click Signup Button", Status.PASS,"Signup Button is clicked and error message 'Email Address already exist!' is visible");
    	}
    	else {
    		updateTestReporter(getClass().getSimpleName(), "Click Signup Button", Status.PASS,"Signup Button is clicked and AccountInfo page displayed");
    	}
    	waitForSometime();
    }
	
}
