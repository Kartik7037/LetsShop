package ShopStore.Pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import Utilities.Components;

public class TestCasesPage extends Components{

	protected By testCasesLabel = By.xpath("//h2/b");
	
	public void validateTestCasesPage() {
		waitElementToAppear(testCasesLabel);
		 Assert.assertTrue(verifyObjectDisplayed(testCasesLabel),"Test Cases Page is not visible");
		 updateTestReporter(getClass().getSimpleName(), "Verify user is navigated to test cases page successfully", Status.PASS, "User is navigated to test cases page successfully");
	}
	
}
