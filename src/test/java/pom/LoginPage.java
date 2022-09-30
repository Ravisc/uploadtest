package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import generic.BasePage;

public class LoginPage extends BasePage {
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	public WebDriver driver;
	
	@FindBy(id="username")
	private WebElement username;
	@FindBy(xpath="//input[@name='pwd']")
	private WebElement password;
	@FindBy(xpath="//div[.='Login ']")
	private WebElement loginbtn;
	
	
	
	public void setusername(String un){
		username.sendKeys(un);
	}
	public void setPassword(String pw){
		password.sendKeys(pw);
	}
	public void clickLogin(){
		loginbtn.click();
	}

}
