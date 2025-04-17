package ShopStore.Pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import Utilities.Components;

public class RegistrationConfirmationPage extends Components{

	protected By AccCreatedLabel = By.xpath("//h2[@data-qa='account-created']/b");
	protected By continueBtn = By.xpath("//a[@data-qa='continue-button']");
	
	public void clickContinueBtn() {
		waitElementToAppear(AccCreatedLabel);
		Assert.assertTrue(verifyObjectDisplayed(AccCreatedLabel),"Account not Created"); 
		updateTestReporter(getClass().getSimpleName(), "Verify 'ACCOUNT CREATED!' is visible", Status.PASS,"Account Created Successfully and  'ACCOUNT CREATED!' is visible");
		getElement(continueBtn).click();
		updateTestReporter(getClass().getSimpleName(), "Click Continue Button", Status.PASS,"Navigated to Login Page Successfully");
	}
	
}
