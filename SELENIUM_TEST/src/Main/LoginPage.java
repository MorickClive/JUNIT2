package Main;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	@FindBy(xpath = "//input[@name='username']")
	private WebElement userName;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement password;
	
	@FindBy(xpath = "//input[@value='Test Login']")
	private WebElement submit;
	
	@FindBy(xpath = "//blockquote/blockquote/font/center/b")
	private WebElement log_Validate;

	public void input_Username(String uName){
		userName.sendKeys(uName);
	}
	
	public void input_Password(String pass){
		password.sendKeys(pass);
	}
	
	public void Login(){
		submit.click();
	}
	
	// Returns whether the webpage succeeded
	public String validationCheck(){
		return log_Validate.getText();		
	}
	

}
