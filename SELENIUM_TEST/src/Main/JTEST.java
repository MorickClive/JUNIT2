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
		string = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]";
		webDriver.findElement(By.xpath(string)).click();
		
		// Add user
		string = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input";
		webDriver.findElement(By.xpath(string)).sendKeys("user");
		
		string = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input";
		webDriver.findElement(By.xpath(string)).sendKeys("user");
		
		string = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input";
		webDriver.findElement(By.xpath(string)).click();
		
		// find login page
		string = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]";
		webDriver.findElement(By.xpath(string)).click();
		Sleep(500);		
		
		// Begin log in
		string = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input";		
		webDriver.findElement(By.xpath(string)).sendKeys("user");
		string = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input";
		webDriver.findElement(By.xpath(string)).sendKeys("user");
		
		string = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input";
		webDriver.findElement(By.xpath(string)).click();
		//fail("Not implemented.");
		}
	
	@After
	public void A(){
		System.out.println("After.");
		
		Sleep(2500);
		webDriver.quit();
		//fail("Not implemented.");
		}
	
	@AfterClass
	public static void AC(){		
		System.out.println("After Class.");
		//fail("Not implemented.");
		}

}
