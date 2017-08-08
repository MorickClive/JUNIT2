package Main;

import static org.junit.Assert.fail;

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
	
	@BeforeClass
	public static void Bclass(){
		System.out.println("Before Class.");
		//fail("Not implemented.");
	}
	
	@Before
	public void B(){		
		System.out.println("Before.");
		
		webDriver = new ChromeDriver();
		Sleep(timer += 500);
		webDriver.manage().window().maximize(); // to full screen.
		}
	
	@Test
	public void T() throws InterruptedException{		
		System.out.println("Test.");
		
		String string; // used to control Xpath and CSS selectors
		
		// Find website
		webDriver.navigate().to("http://thedemosite.co.uk/");
		
		// Navigate 
		Sleep(500);
		string = "body > div > center > table > tbody > tr:nth-child(2) > td > div > center >"
				+ " table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(6)";
		webDriver.findElement(By.cssSelector(string)).click();
		
		// Add user
		string = "body > table > tbody > tr > td.auto-style1 > form > div > center > table "
				+ "> tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input";
		webDriver.findElement(By.cssSelector(string)).sendKeys("user");
		
		string = "body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div "
				+ "> center > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type='password']";
		webDriver.findElement(By.cssSelector(string)).sendKeys("user");
		
		string = "body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div "
				+ "> center > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type='button']";
		webDriver.findElement(By.cssSelector(string)).click();
		
		// find login page
		string = "body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table >"
				+ " tbody > tr > td:nth-child(2) > p > small > a:nth-child(7)";
		webDriver.findElement(By.cssSelector(string)).click();
		Sleep(500);		
		
		// Begin log in
		string = "body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) "
				+ "> table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input";		
		webDriver.findElement(By.cssSelector(string)).sendKeys("user");
		string = "body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) "
				+ "> table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type='password']";
		webDriver.findElement(By.cssSelector(string)).sendKeys("user");
		
		string = "body > table > tbody > tr > td.auto-style1 > form > div > "
				+ "center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type='button']";
		webDriver.findElement(By.cssSelector(string)).click();
		//fail("Not implemented.");
		}
	
	@After
	public void A(){
		System.out.println("After.");
		
		Sleep(500);
		webDriver.quit();
		//fail("Not implemented.");
		}
	
	@AfterClass
	public static void AC(){		
		System.out.println("After Class.");
		//fail("Not implemented.");
		}

}
