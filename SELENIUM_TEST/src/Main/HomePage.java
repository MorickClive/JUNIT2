package Main;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class HomePage {
	
	@FindBy(xpath = "//a[@href='addauser.php']")
	private WebElement page_AddUser;
	
	@FindBy(xpath = "//a[@href='login.php']")
	private WebElement page_Login;
	
	public void navigate_addUser(){
//		Wait<WebDriver> wait = new	 FluentWait<WebDriver>(driver)
//		.withTimeout(30, TimeUnit.SECONDS)
//		.pollingEvery(5, TimeUnit.SECONDS)
//		.ignoring(NoSuchElementException.class);
//
//		WebElement foo = wait.until(new Function<WebDriver, WebElement>() 
//			{ 
//				public WebElement apply(WebDriver driver) {
//				return driver.findElement((By) page_AddUser);
//				}
//			});
			    
		
		page_AddUser.click();
	}
	
	public void navigate_Login(){
		page_Login.click();
	}

}
