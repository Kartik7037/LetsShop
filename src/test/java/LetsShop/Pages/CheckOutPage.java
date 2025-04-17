package LetsShop.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import Utilities.Components;

public class CheckOutPage extends Components{

	protected By cVVCodeTxtBox = By.xpath("//div[@class='field small'] //input[@class='input txt']");
	protected By nameOnCard = By.xpath("//div[@class='field'] //input[@class='input txt']");
	protected By countryTxtBox = By.xpath("//input[@placeholder='Select Country']");
	protected By selectCountry = By.xpath("//button[@type='button']");
	protected By placeOrderBtn = By.xpath("//a[contains(text(),'Place')]");
	protected By confirmationPage = By.xpath("//h1[contains(text(),'Thank')]");
	
	public void enterCVVCode(String code) {
		getElement(cVVCodeTxtBox).sendKeys(code);
		updateTestReporter(getClass().getSimpleName(), "Enter CVV code", Status.PASS, "CVV code is entered");
	}
	
	public void enterNameOnCard(String Name) {
		getElement(nameOnCard).sendKeys(Name);
		updateTestReporter(getClass().getSimpleName(), "Enter Name On Card", Status.PASS, "Name On Card is entered");
	}
	
	public void enterCountry(String country) {
	    getElement(countryTxtBox).sendKeys(country);
	    updateTestReporter(getClass().getSimpleName(), "Enter 3 characters", Status.PASS, "Characters entered");
	}
	
	public void slctCountry(String cntry) {
		List<WebElement> list = getElements(selectCountry);
		for(int i=0;i<list.size();i++) {
			if(cntry.equalsIgnoreCase(getElements(selectCountry).get(i).getText())) {
				getElements(selectCountry).get(i).click();
				break;
			}
		}
		updateTestReporter(getClass().getSimpleName(), "Select Country", Status.PASS, "Country is Selected");
	}
	
	public void clickOnOrderBtn() {
		waitElementToAppear(placeOrderBtn);
		updateTestReporter(getClass().getSimpleName(), "Click Order button", Status.PASS, "Order button is clicked");
		getElement(placeOrderBtn).click();
		waitElementToAppear(confirmationPage);
		Assert.assertTrue(verifyObjectDisplayed(confirmationPage),"Confirmation page not displayed");
	
	}
}
