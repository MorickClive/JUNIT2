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

public class JTEST extends Common{
	
	private WebDriver webDriver;
	
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
		
		// Navigate to add user
		string = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]";
		webDriver.findElement(By.xpath(string)).click();
		Sleep(500); // wait for webpage to load (0.5 second)
		// Add user
		string = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input";
		webDriver.findElement(By.xpath(string)).sendKeys("user"); // username
		
		string = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input";
		webDriver.findElement(By.xpath(string)).sendKeys("user"); // password
		
		string = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input";
		webDriver.findElement(By.xpath(string)).click();
		
		// find login page
		string = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]";
		webDriver.findElement(By.xpath(string)).click();
		Sleep(500); // wait for webpage to load (0.5 second)
		
		// Begin log in
		string = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input";		
		webDriver.findElement(By.xpath(string)).sendKeys("user"); // username
		string = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input";
		webDriver.findElement(By.xpath(string)).sendKeys("user"); // password
		
		string = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input";
		webDriver.findElement(By.xpath(string)).click();
		
		////
		// find out if success
		////
		
		// check string displayed
		string = "/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b";
		output = webDriver.findElement(By.xpath(string)).getText();
		
		// verify output of element
		System.out.println(	"\tValue: " + output +
							"\n\tSuccess: " +  (output.equals("**Successful Login**") ? "true" : "false"));
		// test assert
		assertEquals(output, "**Successful Login**");
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
