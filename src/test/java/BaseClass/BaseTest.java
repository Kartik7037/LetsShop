package BaseClass;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
   public static WebDriver driver;
   public static String emailableReportPath;
	static String reportName;
	static String emailableReportName;

	protected String reportpath;
	public static String resultDirectory;
	public static ExtentReports report;
	public static ExtentHtmlReporter htmlreport = null;
	public int counter = 001;
	public static ExtentTest extentlogger = null;
	public static String CurrentDate;	
	
	public WebDriver setup() throws MalformedURLException, URISyntaxException {
		ChromeOptions options = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		options.addArguments("--headless");
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setBrowserName("chrome");
		driver = new RemoteWebDriver(new URI("http://192.168.0.107:4444").toURL(), caps);
		
		//driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1440,900));
		driver.manage().window().maximize();
		createReport();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		return driver;
	}
	
   public void goTo() {
	   driver.get("https://rahulshettyacademy.com/client/auth/login");
   }
	
   public HashMap<String, HashMap<String, String>> getJsonDataToMap(String Filepath) throws IOException {
		
		String JsonContent = FileUtils.readFileToString(new File(Filepath), StandardCharsets.UTF_8);
		
		ObjectMapper obj = new ObjectMapper();
		HashMap<String, HashMap<String, String>> data = obj.readValue(JsonContent,new TypeReference<HashMap<String, HashMap<String, String>>>(){});
		   return data;
   }
   
   public void createReport() {
 		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
 		Date date = new Date();
 		CurrentDate = formatter.format(date).replace("/", "_").replace(":", "_").replace(" ", "_");

 		reportpath = System.getProperty("user.dir") + "\\RunResults\\" + CurrentDate + "\\ResultReport.html";

 		System.out.println("Report::" + reportpath);
 		if (report == null) {

 			htmlreport = new ExtentHtmlReporter(reportpath);
 			htmlreport.config().setTheme(Theme.DARK);
 			report = new ExtentReports();
 			report.attachReporter(htmlreport);
 			htmlreport.start();
 			report.flush();
 			System.out.println(report);
 			extentlogger = report.createTest("Lets Shop Test Report");
 			
 		}
  
     }
   
   
   public String getScreenshot() {
		String destination = "";
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			Random rand = new Random();
			int randomInteger = rand.nextInt(100);
			File source = ts.getScreenshotAs(OutputType.FILE);
			destination = System.getProperty("user.dir") + "/RunResults/" + CurrentDate + "/ScreenShots/"
					+ randomInteger + counter + "_" + CurrentDate + ".png";
			counter++;
			File finalDestination = new File(destination);
			FileUtils.copyFile(source, finalDestination);
		} catch (Exception e) {
			System.out.println(e);

		}

		return destination;
	}
   
   public void updateTestReporter(String pageName, String functionName, Status Status, String StepMessage) {
		try {
			String screenshotPath = getScreenshot();
			screenshotPath = screenshotPath.substring(screenshotPath.indexOf("ScreenShots"));
			MediaEntityModelProvider screenshot = MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath)
					.build();
			if (Status.equals(Status.PASS)) {
				extentlogger.log(Status.PASS, pageName + " : " + functionName + " : " + StepMessage, screenshot);

			} else if (Status.equals(Status.INFO)) {
				extentlogger.log(Status.INFO, pageName + " : " + functionName + " : " + StepMessage, screenshot);

			} else if (Status.equals(Status.FAIL)) {
				extentlogger.log(Status.FAIL, pageName + " : " + functionName + " : " + StepMessage, screenshot);
				report.flush();
				Assert.assertTrue(false);

			}
			report.flush();

		} catch (Exception e) {
			System.out.println("Error in getting screenshot");
		}
	}

	public void closeDriver() {
		driver.quit();
	}
}
