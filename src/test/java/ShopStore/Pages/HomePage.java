package ShopStore.Pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import Utilities.Components;

public class HomePage extends Components{

	protected By homeBtn = By.xpath("//a[contains(text(),'Home')]"); 
	protected By signupLoginBtn = By.xpath("//a[contains(text(),'Login')]");
	protected By loggedInUser = By.xpath("//i[contains(@class,'user')]/parent::a");
	protected By loggedInUsername = By.xpath("//i[contains(@class,'user')]/parent::a/b");
	protected By deleteAccountBtn = By.xpath("//i[contains(@class,'trash')]");
	protected By username = By.xpath("//i[contains(@class,'user')]/parent::a/b");
	protected By accDeletedLabel = By.xpath("//h2[contains(@data-qa,'deleted')]/b");
	protected By continueBtn = By.xpath("//a[@data-qa='continue-button']");
	protected By testCasesLink = By.xpath("//ul[contains(@class,'navbar')]/li/a[contains(text(),'Cases')]");
	protected By logoutBtn = By.xpath("//i[contains(@class,'lock')]");
	String ApplicationName = "ShopStore";
	
	public void goTo() {
		 launchApplication(ApplicationName);
		 waitElementToAppear(homeBtn);
		 Assert.assertTrue(verifyObjectDisplayed(homeBtn),"HomePage not displayed");
		 updateTestReporter(getClass().getSimpleName(), "LaunchURL", Status.PASS, "URL launched successfully");
		}
	
	public void clickDeleteButton() {
		validateLoggedInUsername();
		waitElementToAppear(deleteAccountBtn);
		 getElement(deleteAccountBtn).click();
		 updateTestReporter(getClass().getSimpleName(), "Click Delete Account Button", Status.PASS, "");
		 validateAccountDeleted(accDeletedLabel);
	}
	
	public void validateLoggedInUsername() {
		 waitElementToAppear(loggedInUsername);
		 String username = getElement(loggedInUsername).getText();
		 Assert.assertTrue(verifyObjectDisplayed(loggedInUsername)," 'Logged in as username' is not visible");
		 updateTestReporter(getClass().getSimpleName(), "Verify that 'Logged in as "+username+"' is visible", Status.PASS, " 'Logged in as "+username+"' is visible");
		 
	}
	public void clickContinueBtn() {
		getElement(continueBtn).click();
		updateTestReporter(getClass().getSimpleName(), "Click Continue Button", Status.PASS,"Navigated to Home Page Successfully");
	}
	
	public void validateAccountDeleted(By by) {
		 waitElementToAppear(by);
		 Assert.assertTrue(verifyObjectDisplayed(by),"ACCOUNT DELETED!' is not visible");
		 updateTestReporter(getClass().getSimpleName(), "Verify that 'ACCOUNT DELETED!' is visible", Status.PASS, " ACCOUNT DELETED!' is visible");
	}
	
	public void clickTestCasesLink() {
		getElement(testCasesLink).click();
		updateTestReporter(getClass().getSimpleName(), "Click Test Cases link", Status.PASS,"Navigated to Test Cases Page Successfully");
	}
	
	public void clickLogoutBtn() {
		waitElementToAppear(logoutBtn);
		getElement(logoutBtn).click();
		updateTestReporter(getClass().getSimpleName(), "Click Logout Button", Status.PASS,"Logout Button is clicked and user is logged out");
		waitForSometime();
		updateTestReporter(getClass().getSimpleName(), "Verify user is navigated to login page", Status.PASS,"User is navigated to login page");
	}
}
