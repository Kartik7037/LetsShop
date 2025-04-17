package ShopStore.Scripts;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import BaseClass.BaseTest;
import ShopStore.Pages.AccountInfoPage;
import ShopStore.Pages.HomePage;
import ShopStore.Pages.RegistrationConfirmationPage;
import ShopStore.Pages.SignupLoginPage;
import ShopStore.Pages.TestCasesPage;


public class Resgistration_Login extends BaseTest{

	@BeforeMethod
	public void launchDriver() {
		setup();
	}
	
	//Registration
	@Test(dataProvider= "getData")
	public void TC001_Registration(HashMap<String,String> input) {
		try {
		HomePage homePage = new HomePage();
		SignupLoginPage signupLoginPage = new SignupLoginPage();
		AccountInfoPage accountInfoPage = new AccountInfoPage();
		RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage();
		
		homePage.goTo();
		signupLoginPage.clickSignupLoginBtn();
		signupLoginPage.enterName(input.get("name"));
		signupLoginPage.enterSignupEmail(input.get("email"));
		signupLoginPage.clickSignupBtn();
		accountInfoPage.selectTitle(input.get("Title"));
		accountInfoPage.enterPassword(input.get("password"));
		accountInfoPage.selectDay(input.get("Day"));
		accountInfoPage.selectMonth(input.get("Month"));
		accountInfoPage.selectYear(input.get("Year"));
		accountInfoPage.clickNewsletterCheckbox();
		accountInfoPage.clickSpecialOffersCheckbox();
		accountInfoPage.enterFirstName(input.get("First Name"));
		accountInfoPage.enterLastName(input.get("Last Name"));
		accountInfoPage.enterCompany(input.get("Company"));
		accountInfoPage.enterAddress(input.get("Address"));
		accountInfoPage.enterAddress2(input.get("Address2"));
		accountInfoPage.selectCountry(input.get("Country"));
		accountInfoPage.enterState(input.get("State"));
		accountInfoPage.enterCity(input.get("City"));
		accountInfoPage.enterZipcode(input.get("Zipcode"));
		accountInfoPage.enterMobileNumber(input.get("Mobile Number"));
		accountInfoPage.clickCreateAccBtn();
		registrationConfirmationPage.clickContinueBtn();
		homePage.clickDeleteButton();
		homePage.clickContinueBtn();
		
	}catch (Exception e) {
		updateTestReporter(getClass().getSimpleName(), "Run script", Status.FAIL, "Test Failed due to: " + e);
	}
  }
	
	
	//Login with incorrect Credentials
	@Test(dataProvider="getData")
	public void TC002_LoginWithIncorrectCredentials(HashMap<String,String> input) {
		try {
			HomePage homePage = new HomePage();
			SignupLoginPage signupLoginPage = new SignupLoginPage();
			
			homePage.goTo();
			signupLoginPage.clickSignupLoginBtn();
			signupLoginPage.enterLoginEmail(input.get("email"));
			signupLoginPage.enterLoginPassword(input.get("password"));
			signupLoginPage.clickLoginBtn();
			signupLoginPage.validateErrorMessage();
			
		}catch (Exception e) {
			updateTestReporter(getClass().getSimpleName(), "Run script", Status.FAIL, "Test Failed due to: " + e);
		}
	}
	
	@Test(dataProvider= "getData")
	public void TC003_VerifyTestCasesPage(HashMap<String,String> input) {
		try {
			HomePage homePage = new HomePage();
			TestCasesPage testCasesPage = new TestCasesPage();
			
			homePage.goTo();
			homePage.clickTestCasesLink();
			testCasesPage.validateTestCasesPage();
			
		}catch (Exception e) {
			updateTestReporter(getClass().getSimpleName(), "Run script", Status.FAIL, "Test Failed due to: " + e);
		}
	}
	
	@Test(dataProvider= "getData")
	public void TC004_LogoutUser(HashMap<String,String> input) {
		try {
			HomePage homePage = new HomePage();
			SignupLoginPage signupLoginPage = new SignupLoginPage();
			
			homePage.goTo();
			signupLoginPage.clickSignupLoginBtn();
			signupLoginPage.enterLoginEmail(input.get("email"));
			signupLoginPage.enterLoginPassword(input.get("password"));
			signupLoginPage.clickLoginBtn();
			homePage.validateLoggedInUsername();
			homePage.clickLogoutBtn();
			
			
		}catch (Exception e) {
			updateTestReporter(getClass().getSimpleName(), "Run script", Status.FAIL, "Test Failed due to: " + e);
		}
	}
	
	
	  @DataProvider
	   public Object[][] getData(Method method) throws IOException {
		
		String testCaseName = method.getName(); 
		  
		HashMap<String, HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\ShopStore\\TestData\\Data.json");
		return new Object[][] {{data.get(testCaseName)}};	
	   }
	
	@AfterMethod
	public void quitDriver() {
		closeDriver();
	}
}
