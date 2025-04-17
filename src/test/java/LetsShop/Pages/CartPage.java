package LetsShop.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import Utilities.Components;

public class CartPage extends Components{
	
	protected By checkOutBtn = By.xpath("//button[text()='Checkout']");
	protected By checkOutPage = By.xpath("//div[@class='payment__title' and text()=' Payment Method ']");
	
	
	public void clickCheckOutBTn() {
		getElement(checkOutBtn).click();
		waitElementToAppear(checkOutPage);
		Assert.assertTrue(verifyObjectDisplayed(checkOutPage),"Checkout page not displayed");
		updateTestReporter(getClass().getSimpleName(), "Click Checkout button", Status.PASS, "Checkout button is clicked and user is navigated to CheckOut Page");
	}

	
}
