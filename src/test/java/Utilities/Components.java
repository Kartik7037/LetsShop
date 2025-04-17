package Utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import BaseClass.BaseTest;

public class Components extends BaseTest{

	public void launchApplication(String Application) {
		if(Application.equals("LetsShop")) {
		driver.get("https://rahulshettyacademy.com/client");
		}
		else {
			driver.get("https://www.automationexercise.com/");	
		}
	}
	
	public WebElement getElement(By by) {
		return driver.findElement(by);
	}
	
	public List<WebElement> getElements(By by){
		return driver.findElements(by);
	}
	
	public void waitElementToAppear(By element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.visibilityOf(getElement(element)));	
	}
	
	public void waitElementToDisappear(By element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.invisibilityOf(getElement(element)));	
	}
	
    public boolean verifyObjectDisplayed(By by) {
    	return getElement(by).isDisplayed();
    }
    
    public String trimOrderId(By element) {
    	return getElement(element).getText().trim().split(" ")[1];
    }
    
    public void scrollToElement(By by) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", getElement(by));
		js.executeScript("window.scrollBy(0,-450)", "");
	}
    
    public void selectByVisibleText(By by,String text) {
    	Select sel = new Select(getElement(by));
    	sel.selectByVisibleText(text);
    }

    public String getElementText(By by) {
    	return getElement(by).getText();
    }
    
    public void waitForSometime() {
    	try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
} 