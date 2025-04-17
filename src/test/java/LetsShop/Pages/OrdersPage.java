package LetsShop.Pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import Utilities.Components;

public class OrdersPage extends Components{

	protected By deleteBtn = By.xpath("//tbody/tr[1] //button[text()='Delete']");
	protected By orderCancelTxt = By.xpath("//div[@aria-label='Orders Deleted Successfully']");
	protected By viewBtn = By.xpath("//tbody/tr[1] //button[text()='View']");
	protected By orderSummary = By.xpath("//div[@class='email-preheader']/p");
	
	public void clickDeleteBtn() {
		getElement(deleteBtn).click();
		waitElementToAppear(orderCancelTxt);
		Assert.assertTrue(verifyObjectDisplayed(orderCancelTxt), "Order not Cancelled");
		updateTestReporter(getClass().getSimpleName(), "Click On Delete", Status.PASS, "Order Cancelled");
	}
	
	public void clickViewButton() {
		getElement(viewBtn).click();
		waitElementToAppear(orderSummary);
		Assert.assertTrue(verifyObjectDisplayed(orderSummary), "Order Summary not displayed");
		updateTestReporter(getClass().getSimpleName(), "Click On View Button", Status.PASS, "View button is clicked and user is navigated to Order Summary page");
	}
}
