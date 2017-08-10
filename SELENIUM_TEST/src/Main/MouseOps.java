package Main;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import QADemo_WEBPAGE.QADEMO_PORTAL;

public class MouseOps extends Common {
	
	// Driver
	private WebDriver webDriver;
	private Actions builder;
	
	// Page templates
	private QADEMO_PORTAL website = new QADEMO_PORTAL();
	
	
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
		// Assign webdriver
		website = PageFactory.initElements(webDriver, QADEMO_PORTAL.class);
		builder= new Actions(webDriver);
  		
		}
	
	@Test
	public void T() {		
		System.out.println("Test.");
		
		String string, output; // used to control Xpath and CSS selectors, output for string values	
			
		// Find website
		webDriver.navigate().to(website.getURL());		
		// go to draggable, Interaction
		website.Nav_Interaction_Draggable();
				
		System.out.println(webDriver.findElement(By.xpath("//*[@id='draggable']/p")).isDisplayed());
		builder.moveToElement(webDriver.findElement(By.xpath("//*[@id='draggable']/p"))).clickAndHold().moveByOffset( 250, 250).click().perform();
		
		// Resizable
		website.Nav_Interaction_Resizable();
		WebElement target = webDriver.findElement(By.xpath("//*[@id='resizable']/div[3]"));
		builder.moveToElement(webDriver.findElement(By.xpath("//*[@id='resizable']/div[3]"))).clickAndHold().moveByOffset( 250, 250).click().perform();
		
		//
		
		website.Nav_Interaction_Droppable();
		target = webDriver.findElement(By.xpath("//*[@id='draggableview']"));
		builder.moveToElement(target).clickAndHold().moveToElement(webDriver.findElement(By.xpath("//*[@id='droppableview']"))).click().perform();
		
		// select each item in the list
		website.Nav_Interaction_Selectable();
		
		for(int x = 0; x < 8; x++){
			Sleep(250);
			builder.moveToElement(webDriver.findElement(By.xpath("//*[@id='selectable']/li[1]"))).moveByOffset( 0, 30 * x).click().perform();
		}
		
		// move grid label 1 between grid label 6-7
		website.Nav_Interaction_Sortable();
		
		builder.moveToElement(webDriver.findElement(By.xpath("//*[@id='ui-id-3']"))).moveByOffset( 5, 5).click().perform();
		builder.moveToElement(webDriver.findElement(By.xpath("//*[@id='sortable_grid']/li[1]"))).clickAndHold().moveByOffset( 110, 100).click().perform();

		website.Nav_Widget_Slider();
		builder.moveToElement(webDriver.findElement(By.xpath("//*[@id='slider-range-max']/span"))).moveByOffset( 65*6, 0).click().perform();
		Sleep(1000);
		
	}
	
	@After
	public void A(){
		System.out.println("After.");
		
		////
		// Close Chrome
		////
		System.out.print("\t- Closing chrome.");
		printDelayed("...", 150*3);
		System.out.println();
		webDriver.quit();

		}
	
//	@AfterClass
//	public static void AC(){		
//		System.out.println("After Class.");
//		//fail("Not implemented.");
//		}


}
