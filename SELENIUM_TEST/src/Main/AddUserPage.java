package Main;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddUserPage {
	
	@FindBy(xpath = "//input[@name='username']")
	private WebElement userName;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement password;
	
	@FindBy(xpath = "//input[@value='save']")
	private WebElement submit;
	
	@FindBy(xpath = "//a[@href='login.php']")
	private WebElement page_Login;

	public void input_Username(String uName){
		userName.sendKeys(uName);
	}
	
	public void input_Password(String pass){
		password.sendKeys(pass);
	}
	
	public void submit_User(){
		submit.click();
	}
	
	public void navigate_Login(){
		page_Login.click();
	}
	
}
