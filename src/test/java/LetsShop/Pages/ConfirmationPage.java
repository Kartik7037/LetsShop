package LetsShop.Pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import Utilities.Components;

public class ConfirmationPage extends Components{

	protected By homeBtn = By.xpath("//button[@class='btn btn-custom' and contains(text(),'HOME')]");
	protected By HomePage = By.xpath("//div[@class='left mt-1']/p");
	protected By orderId = By.xpath("//label[@class='ng-star-inserted']");
	protected By orderHistoryPage = By.xpath("//label[text()=' Orders History Page ']");
	protected By ordersPage = By.xpath("//h1[text()='Your Orders']");
	
	public void clickOnHomeBtn() {
		updateTestReporter(getClass().getSimpleName(), "Confirmation Page", Status.PASS, "User navigated to Confirmation page");
		getElement(homeBtn).click();
		waitElementToAppear(HomePage);
	    Assert.assertTrue(verifyObjectDisplayed(HomePage), "HomePage not displayed");
	    updateTestReporter(getClass().getSimpleName(), "Click On HomePage button", Status.PASS, "User navigated to Home page");
	    
	}
	
	public String getOrderId() {
		String Id = trimOrderId(orderId);
		return Id;
	}
	
	public void clickOrderHistoryPage() {
		getElement(orderHistoryPage).click();
		waitElementToAppear(ordersPage);
		updateTestReporter(getClass().getSimpleName(), "Click On Order History Page", Status.PASS, "User is navigated to Orders page");
	}
	
	
}
