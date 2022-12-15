package com.santum.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class contains objects of common page
 * @author abhishek
 *
 */
public class CommonPage {
	@FindBy(linkText = "Aegon Life") private WebElement aegonLifeTextLink;
	@FindBy(linkText = "CLIENTS") private WebElement clientsTextLink;
	@FindBy(linkText = "AGENTS") private WebElement agentsTextLink;
	@FindBy(linkText = "POLICY") private WebElement policyTextLink;
	@FindBy(linkText = "NOMINEE") private WebElement nomineeTextLink;
	@FindBy(linkText = "PAYMENTS") private WebElement paymentsTextLink;
	@FindBy(xpath = "//a[@title='Logout']") private WebElement logOutBtn;

	public CommonPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	/**
	 * This method is used to click on aegon life link
	 */
	public void clickOnAegonLife()
	{
		aegonLifeTextLink.click();
	}
	
	/**
	 * This method is used to click on clients module
	 */
	public void clickOnClients()
	{
		clientsTextLink.click();
	}
	
	/**
	 * This method is used to click on agents module
	 */
	public void clickOnAgents()
	{
		agentsTextLink.click();
	}
	
	/**
	 * This method is used to click on policy module
	 */
	public void clickOnPolicy()
	{
		policyTextLink.click();
	}
	
	/**
	 * This method is used to click on nominee module
	 */
	public void clickOnNominee()
	{
		nomineeTextLink.click();
	}
	
	/**
	 * This method is used to click on payments module
	 */
	public void clickOnPayments()
	{
		paymentsTextLink.click();
	}
	
	/**
	 * This method is used to click on logout
	 */
	public void clickOnLogOut()
	{
		logOutBtn.click();
	}

}
