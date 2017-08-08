package Main;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class JTEST extends Common{
	
	// Driver
	private WebDriver webDriver;
	
	// Page templates
	private HomePage w_Home;
	private AddUserPage w_AddUserPage;
	private LoginPage w_LoginPage;
	
	// reports
    private ExtentReports report;
    private ExtentTest test;
    private String reportFilePath = "Report.html";
	
	
//	@BeforeClass
//	public static void Bclass(){
//		System.out.println("Before Class.");
//		//fail("Not implemented.");
//	}
	
	@Before
	public void B(){		
		System.out.println("Before.");
		
		// Create Chrome instance.
		webDriver = new ChromeDriver();
		webDriver.manage().window().maximize(); // to full screen.
		
		w_Home = PageFactory.initElements(webDriver, HomePage.class);
		w_AddUserPage =PageFactory.initElements(webDriver, AddUserPage.class);
		w_LoginPage = PageFactory.initElements(webDriver, LoginPage.class);
		
		// Assuming that webDriver does not describe as null, then success!
//		System.out.println(	"\t- Chrome has " + 
//							(webDriver.toString().contains("null") ? "NOT " : "") + 
//							"started successfully.");
	
		// Reports
        report = new ExtentReports();
        ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter(reportFilePath);
        extentHtmlReporter.config().setReportName("New User Login");
        extentHtmlReporter.config().setDocumentTitle("Report_UserInsert");
        
        report.attachReporter(extentHtmlReporter);
        test = report.createTest("Automated results");
		
		}
	
	@Test
	public void T() {		
		System.out.println("Test.");
		
		String string, output; // used to control Xpath and CSS selectors, output for string values
		
		// Find website
		webDriver.navigate().to("http://thedemosite.co.uk/");
		
		// Wait implementation
		
//		Wait<WebDriver> wait = new	 FluentWait<WebDriver>(webDriver)
//		.withTimeout(30, TimeUnit.SECONDS)
//		.pollingEvery(5, TimeUnit.SECONDS)
//		.ignoring(NoSuchElementException.class);
//
//		WebElement foo = wait.until(new Function<WebDriver, WebElement>() 
//			{ 
//				public WebElement apply(WebDriver driver) {
//				return driver.findElement(By.xpath( "//a[@href='addauser.php']"));
//				}
//			});
//		
		//Sleep(500); // wait for webpage to load (0.5 second)
		w_Home.navigate_addUser();
		// Navigate to add user//title[@lang='word']
		
		// Add user
		w_AddUserPage.input_Username("user");
		w_AddUserPage.input_Password("user");
		w_AddUserPage.submit_User();

		// find login page
		w_AddUserPage.navigate_Login();
		
		
		// Begin log in
		w_LoginPage.input_Username("user");
		w_LoginPage.input_Password("user");
		w_LoginPage.Login();
		
		////
		// find out if success
		////
		
		// verify output of element
		System.out.println(	"\tValue: " + w_LoginPage.validationCheck() +
							"\n\tSuccess: " +  (w_LoginPage.validationCheck().equals("**Successful Login**") ? "true" : "false"));
		// log for report
		if(w_LoginPage.validationCheck().equals("**Successful Login**")){ test.log(Status.PASS, w_LoginPage.validationCheck());}
		else{test.log(Status.FAIL, "Login Failed!!");}
		// test assert
		assertEquals(w_LoginPage.validationCheck(), "**Successful Login**");
		}
	
	@After
	public void A(){
		System.out.println("After.");
		
		////
		// Close Chrome
		////
		System.out.print("\t- Closing chrome.");
		printDelayed("...", 500);
		System.out.println();
		webDriver.quit();
		
		// check if successfully closed
		System.out.println(	"\t- Chrome has " + 
				(webDriver.toString().contains("null") ? "" : "NOT ") + 
				"closed successfully.");
		if(webDriver.toString().contains("null")){ test.log(Status.INFO, "Successfully closed Chrome.");}
		else{  test.log(Status.FAIL, "Chrome failed to close.");}
		
		////
		// Generate report
		///
		
		// allows generation of report
		report.flush();

		// produce results after test
		System.out.println("Producing report...");
		webDriver = new ChromeDriver();
		webDriver.navigate().to(System.getProperty("user.dir") + "\\Report.html");
		
		}
	
//	@AfterClass
//	public static void AC(){		
//		System.out.println("After Class.");
//		//fail("Not implemented.");
//		}

}
