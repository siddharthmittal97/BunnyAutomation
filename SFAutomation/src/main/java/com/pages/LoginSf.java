package com.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class LoginSf 
{
	//WebDriver driver;	
	//public LoginSf(WebDriver driver)
	//{
	//		this.driver=driver;
	//}
@FindBy(id="username") WebElement User;
@FindBy(id="password") WebElement Pass;
@FindBy(id="Login") WebElement Login;

public void LoginParameter(String username,String password)
 {
	User.sendKeys(username);
	Pass.sendKeys(password);
	Login.click();
 } 
}
