package com.santum.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class contains the objects of login page
 * @author abhisehk
 *
 */
public class LoginPage {
	@FindBy(name="username") private WebElement usernameTxtbx;
	@FindBy(name="password") private WebElement passwordTxtbx;
	@FindBy(xpath="//button[text()='login']") private WebElement loginBtn;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method is used to perform login
	 * @param username
	 * @param password
	 */
	public void loginAction(String username,String password)
	{
		usernameTxtbx.sendKeys(username);
		passwordTxtbx.sendKeys(password);
		loginBtn.click();
	}

}
