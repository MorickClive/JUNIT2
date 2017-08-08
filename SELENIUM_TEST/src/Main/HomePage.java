package Main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	@FindBy(xpath = "//a[@href='addauser.php']")
	private WebElement page_AddUser;
	
	@FindBy(xpath = "//a[@href='login.php']")
	private WebElement page_Login;
	
	public void navigate_addUser(){
		page_AddUser.click();
	}
	
	public void navigate_Login(){
		page_Login.click();
	}

}
