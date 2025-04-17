package LetShop.Scripts;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import BaseClass.BaseTest;
import LetsShop.Pages.CartPage;
import LetsShop.Pages.CheckOutPage;
import LetsShop.Pages.ConfirmationPage;
import LetsShop.Pages.LoginPage;
import LetsShop.Pages.OrderSummaryPage;
import LetsShop.Pages.OrdersPage;
import LetsShop.Pages.ProductCatalouguePage;
import junit.framework.Assert;

public class Product_Order_Cancel extends BaseTest{


	
	@BeforeMethod
	public void launchDriver() {
		setup();
	}

	 
	@Test(dataProvider= "getData")
	public void TC001_Product_Order(HashMap<String,String> input) {
		try {
		LoginPage loginPage = new LoginPage();  
		ProductCatalouguePage productCatalouguePage = new ProductCatalouguePage();
		CartPage cartPage = new CartPage();
		CheckOutPage checkOutPage = new CheckOutPage();
		ConfirmationPage confirmationPage = new ConfirmationPage();
		
		loginPage.goTo();
		loginPage.enterEmail(input.get("email"));
		loginPage.enterPassword(input.get("password"));
		loginPage.clickLoginBtn();
		productCatalouguePage.addProductToCart(input.get("productName"));
		productCatalouguePage.clickOnCart();
		cartPage.clickCheckOutBTn();
		checkOutPage.enterCVVCode(input.get("CVVCode"));
		checkOutPage.enterNameOnCard(input.get("nameOnCard"));
		checkOutPage.enterCountry(input.get("enterCountry"));
		checkOutPage.slctCountry(input.get("selectCountry"));
		checkOutPage.clickOnOrderBtn();
		confirmationPage.clickOnHomeBtn();
		productCatalouguePage.signOut();
		
	}catch (Exception e) {
		updateTestReporter(getClass().getSimpleName(), "Run script", Status.FAIL, "Test Failed due to: " + e);
	}
  }
	
	@Test(dependsOnMethods= {"TC001_Product_Order"},dataProvider="getData")
	public void TC002_Cancel_Order(HashMap<String,String> input) {
		try {
			LoginPage loginPage = new LoginPage();  
			ProductCatalouguePage productCatalouguePage = new ProductCatalouguePage();
			OrdersPage ordersPage = new OrdersPage();
			
			loginPage.goTo();
			loginPage.enterEmail(input.get("email"));
			loginPage.enterPassword(input.get("password"));
			loginPage.clickLoginBtn();
			productCatalouguePage.clickOnOrdersBtn();
			ordersPage.clickDeleteBtn();
			productCatalouguePage.signOut();
			
		}catch (Exception e) {
			updateTestReporter(getClass().getSimpleName(), "Run script", Status.FAIL, "Test Failed due to: " + e);
		}
	}
	
	  @Test(dataProvider= "getData")
	  public void TC003_Validate_OrderId(HashMap<String,String> input) {
		  try {
				LoginPage loginPage = new LoginPage();  
				ProductCatalouguePage productCatalouguePage = new ProductCatalouguePage();
				OrdersPage ordersPage = new OrdersPage();
				CartPage cartPage = new CartPage();
				CheckOutPage checkOutPage = new CheckOutPage();
				ConfirmationPage confirmationPage = new ConfirmationPage();
				OrderSummaryPage orderSummaryPage = new OrderSummaryPage();
				
				loginPage.goTo();
				loginPage.enterEmail(input.get("email"));
				loginPage.enterPassword(input.get("password"));
				loginPage.clickLoginBtn();
				productCatalouguePage.addProductToCart(input.get("productName"));
				productCatalouguePage.clickOnCart();
				cartPage.clickCheckOutBTn();
				checkOutPage.enterCVVCode(input.get("CVVCode"));
				checkOutPage.enterNameOnCard(input.get("nameOnCard"));
				checkOutPage.enterCountry(input.get("enterCountry"));
				checkOutPage.slctCountry(input.get("selectCountry"));
				checkOutPage.clickOnOrderBtn();
				String Id = confirmationPage.getOrderId();
				confirmationPage.clickOrderHistoryPage();
				ordersPage.clickViewButton();
				String orderId = orderSummaryPage.getOrderID();
				Assert.assertEquals(Id, orderId);
				productCatalouguePage.signOut();
				
			}catch (Exception e) {
				updateTestReporter(getClass().getSimpleName(), "Run script", Status.FAIL, "Test Failed due to: " + e);
			}
	  }
	   @DataProvider
	   public Object[][] getData(Method method) throws IOException {
		
		String testCaseName = method.getName(); 
		   
		HashMap<String, HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\LetsShop\\TestData\\Data.json");
		return new Object[][] {{data.get(testCaseName)}};	
	   }
	
	@AfterMethod
	public void quitDriver() {
		closeDriver();
	}

}
