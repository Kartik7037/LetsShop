package ShopStore.Pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import Utilities.Components;

public class AccountInfoPage extends Components{

	protected By TitleMr = By.xpath("//input[@id='id_gender1']");
	protected By TitleMrs = By.xpath("//input[@id='id_gender2']");
	protected By enterAccInfoLabel = By.xpath("//h2/b[contains(text(),'Enter')]");
	protected By password = By.xpath("//input[@id='password']");
	protected By newsletterCheckbox = By.xpath("//input[@name='newsletter']");
	protected By specialOffers = By.xpath("//input[@name='optin']");
	protected By firstName = By.xpath("//input[@id='first_name']");
	protected By lastName = By.xpath("//input[@id='last_name']");
	protected By company = By.xpath("//input[@id='company']");
	protected By address1 = By.xpath("//input[@id='address1']");
	protected By address2 = By.xpath("//input[@id='address2']");
	protected By state = By.xpath("//input[@id='state']");
	protected By city = By.xpath("//input[@id='city']");
	protected By zipcode = By.xpath("//input[@id='zipcode']");
	protected By mobileNumber = By.xpath("//input[@id='mobile_number']");
	protected By day = By.xpath("//select[@id='days']");
	protected By month = By.xpath("//select[@id='months']");
	protected By year = By.xpath("//select[@id='years']");
	protected By country = By.xpath("//select[@id='country']");
	protected By createAccBtn = By.xpath("//button[contains(@data-qa,'create')]");
	
	public void enterPassword(String Password) {
		 scrollToElement(password);
		 getElement(password).sendKeys(Password);
		 updateTestReporter(getClass().getSimpleName(), "Enter Password", Status.PASS,"Password Entered successfully");
	}
	
	public void selectTitle(String title) {
		waitElementToAppear(enterAccInfoLabel);
		 Assert.assertTrue(verifyObjectDisplayed(enterAccInfoLabel),"'ENTER ACCOUNT INFORMATION' is not visible"); 
		if(title.equals("Male")) {
			getElement(TitleMr).click();
		}
		else {
		   getElement(TitleMrs).click();	
		}
		 updateTestReporter(getClass().getSimpleName(), "Select Title", Status.PASS,"'ENTER ACCOUNT INFORMATION' is visible and Title selected successfully");

	}
	
	public void enterFirstName(String FName) {
		 scrollToElement(firstName);
		 getElement(firstName).sendKeys(FName);
		 updateTestReporter(getClass().getSimpleName(), "Enter First Name", Status.PASS,"First Name Entered successfully");
	}
	
	public void enterLastName(String LName) {
		 scrollToElement(lastName);
		 getElement(lastName).sendKeys(LName);
		 updateTestReporter(getClass().getSimpleName(), "Enter Last Name", Status.PASS,"Last Name Entered successfully");
	}
	
	public void enterCompany(String Company) {
		 scrollToElement(company);
		 getElement(company).sendKeys(Company);
		 updateTestReporter(getClass().getSimpleName(), "Enter Company", Status.PASS,"Company Entered successfully");
	}
	
	public void enterAddress(String address) {
		 scrollToElement(address1);
		 getElement(address1).sendKeys(address);
		 updateTestReporter(getClass().getSimpleName(), "Enter Address", Status.PASS,"Address Entered successfully");
	}
	
	public void enterAddress2(String Address2) {
		 scrollToElement(address2);
		 getElement(address2).sendKeys(Address2);
		 updateTestReporter(getClass().getSimpleName(), "Enter Address2", Status.PASS,"Address2 Entered successfully");
	}
	
	public void enterState(String State) {
		 scrollToElement(state);
		 getElement(state).sendKeys(State);
		 updateTestReporter(getClass().getSimpleName(), "Enter State", Status.PASS,"State Entered successfully");
	}
	
	public void enterCity(String City) {
		 scrollToElement(city);
		 getElement(city).sendKeys(City);
		 updateTestReporter(getClass().getSimpleName(), "Enter City", Status.PASS,"City Entered successfully");
	}
	
	public void enterZipcode(String Zipcode) {
		 scrollToElement(zipcode);
		 getElement(zipcode).sendKeys(Zipcode);
		 updateTestReporter(getClass().getSimpleName(), "Enter Zipcode", Status.PASS,"Zipcode Entered successfully");
	}
	
	public void enterMobileNumber(String MobileNumber) {
		 scrollToElement(mobileNumber);
		 getElement(mobileNumber).sendKeys(MobileNumber);
		 updateTestReporter(getClass().getSimpleName(), "Enter MobileNumber", Status.PASS,"MobileNumber Entered successfully");
	}
	
	public void selectDay(String Day) {
		scrollToElement(day);
		selectByVisibleText(day,Day);
		updateTestReporter(getClass().getSimpleName(), "Select Day", Status.PASS,"Day Selected successfully");
	}
	
	public void selectMonth(String Month) {
		scrollToElement(month);
		selectByVisibleText(month,Month);
		updateTestReporter(getClass().getSimpleName(), "Select Month", Status.PASS,"Month Selected successfully");
	}
	
	public void selectYear(String Year) {
		scrollToElement(year);
		selectByVisibleText(year,Year);
		updateTestReporter(getClass().getSimpleName(), "Select Year", Status.PASS,"Year Selected successfully");
	}
	
	public void selectCountry(String Country) {
		scrollToElement(country);
		selectByVisibleText(country,Country);
		updateTestReporter(getClass().getSimpleName(), "Select Country", Status.PASS,"Country Selected successfully");
	}
	
	public void clickCreateAccBtn() {
		scrollToElement(createAccBtn);
		getElement(createAccBtn).click();
		updateTestReporter(getClass().getSimpleName(), "Click Create Account Button", Status.PASS,"Create Account button is clicked");		
	}
	
	public void clickNewsletterCheckbox() {
		scrollToElement(newsletterCheckbox);
		getElement(newsletterCheckbox).click();
		updateTestReporter(getClass().getSimpleName(), "Select NewsLetter Checkbox", Status.PASS,"NewsLetter Checkbox Selected successfully");
	}
	
	public void clickSpecialOffersCheckbox() {
		scrollToElement(specialOffers);
		getElement(specialOffers).click();	
		updateTestReporter(getClass().getSimpleName(), "Select Special Offers Checkbox", Status.PASS,"Special Offers Checkbox selected successfully");
	}
}
