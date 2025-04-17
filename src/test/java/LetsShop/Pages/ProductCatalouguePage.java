package LetsShop.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import Utilities.Components;

public class ProductCatalouguePage extends Components{

	protected By listProducts = By.xpath("//div[@class='container'] //div[@class='row']/div");
	protected By addToCartBtn = By.xpath("//button[@class='btn w-10 rounded']");
	protected By prdName = By.xpath("//h5/b");
	protected By toast = By.xpath("//div[@id='toast-container']");
	protected By spinner = By.cssSelector(".ng-animating");
	protected By cartBtn = By.xpath("//button[@class='btn btn-custom' and contains(text(),'Cart')]");
	protected By cartPage = By.xpath("//div[@class='heading cf']/h1");
	protected By orderBtn = By.xpath("//button[@class='btn btn-custom' and contains(text(),'ORDERS')]");
	protected By ordersPage = By.xpath("//h1[text()='Your Orders']");
	protected By signOutBtn = By.xpath("//button[contains(text(),'Sign Out')]");
	
	public void addProductToCart(String productName) {
		List<WebElement> list = getElements(listProducts);
		for(int i=0;i<list.size();i++) {
		    if(productName.equalsIgnoreCase((getElements(prdName).get(i).getText()))){
		    	getElements(addToCartBtn).get(i).click();
		    }
		}
		waitElementToAppear(spinner);
		waitElementToDisappear(spinner);
		waitElementToAppear(toast);
		Assert.assertTrue(verifyObjectDisplayed(toast), "Product not added to cart");
		waitElementToDisappear(toast);
		updateTestReporter(getClass().getSimpleName(), "Add Product to cart", Status.PASS, "Product is added to cart");
	}
	
	public void clickOnCart() {
		getElement(cartBtn).click();
		Assert.assertTrue(verifyObjectDisplayed(cartPage),"Cart page is not displayed");
		updateTestReporter(getClass().getSimpleName(), "Click On Cart", Status.PASS, "Cart Button is clicked and user is navigated to Cart page");
	}
	
	public void clickOnOrdersBtn() {
		getElement(orderBtn).click();
		waitElementToAppear(ordersPage);
		updateTestReporter(getClass().getSimpleName(), "Click On Orders", Status.PASS, "Orders Button is clicked and user is navigated to Orders page");
	}
	
	public void signOut() {
		waitElementToAppear(signOutBtn);
		getElement(signOutBtn).click();
		updateTestReporter(getClass().getSimpleName(), "Click SignOut button", Status.PASS, "User logout from the application successfully");
	}
}
