package Main;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class JTEST extends Common{
	
	private WebDriver webDriver;
	private HomePage w_Home;
	private AddUserPage w_AddUserPage;
	private LoginPage w_LoginPage;
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
		System.out.println(	"\t- Chrome has " + 
							(webDriver.toString().contains("null") ? "NOT " : "") + 
							"started successfully.");
		assertFalse(webDriver.toString().contains("null"));
		}
	
	@Test
	public void T() throws InterruptedException{		
		System.out.println("Test.");
		
		String string, output; // used to control Xpath and CSS selectors, output for string values
		
		// Find website
		webDriver.navigate().to("http://thedemosite.co.uk/");
		Sleep(500); // wait for webpage to load (0.5 second)
		w_Home.navigate_addUser();
		// Navigate to add user//title[@lang='word']
		
		Sleep(500); // wait for webpage to load (0.5 second)
		// Add user
		w_AddUserPage.input_Username("user");
		w_AddUserPage.input_Password("user");
		w_AddUserPage.submit_User();
		
		// find login page
		w_AddUserPage.navigate_Login();
		Sleep(500); // wait for webpage to load (0.5 second)
		
		// Begin log in
		w_LoginPage.input_Username("user");
		w_LoginPage.input_Password("user");
		w_LoginPage.Login();
		
		////
		// find out if success
		////
		
		// check string displayed
		
		// verify output of element
		System.out.println(	"\tValue: " + w_LoginPage.validationCheck() +
							"\n\tSuccess: " +  (w_LoginPage.validationCheck().equals("**Successful Login**") ? "true" : "false"));
		// test assert
		assertEquals(w_LoginPage.validationCheck(), "**Successful Login**");
		}
	
	@After
	public void A(){
		System.out.println("After.");
		
		////
		// Close Chrome
		////
		System.out.print("\t- Closing Chrome");
		printDelayed("...", 500);
		System.out.println();
		webDriver.quit();
		
		// check if successfully closed
		System.out.println(	"\t- Chrome has " + 
				(webDriver.toString().contains("null") ? "" : "NOT ") + 
				"closed successfully.");
		assertTrue(webDriver.toString().contains("null")); // test before and after
		}
	
//	@AfterClass
//	public static void AC(){		
//		System.out.println("After Class.");
//		//fail("Not implemented.");
//		}

}
