package com.santum.objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class contains the objects of clients status page
 * @author abhishek
 *
 */
public class ClientsStatusPage {

	
	@FindBy(linkText = "Edit Client") private WebElement editLink;
	@FindBy(linkText = "Add Nominee") private WebElement addNomineeLink;
	@FindBy(linkText = "Add Payment") private WebElement addPaymentLink;
	@FindBy(linkText = "Delete Client") private WebElement deleteClientLink;
	@FindBy(xpath = "//div[@id='page-wrapper']/div/div") private WebElement deleteClientConfirmationMsg;
	@FindBy(xpath = "//b[text()='Nominee']/following-sibling::table[@class='table']/tbody/tr/td[1]") private List<WebElement> nomineeNames;
	@FindBy(xpath = "//b[text()='Nominee']/following-sibling::table[@class='table']/tbody/tr/td[7]/a") private List<WebElement> nomineeEditLinks;
	
	public ClientsStatusPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method is used to get the confirmation message after deleting the record
	 * @return
	 */
	public String getDeleteConfirmationMsg()
	{
		return deleteClientConfirmationMsg.getText();
	}
	
	/**
	 * This method is used to click on edit link
	 */
	public void clickOnEditLink()
	{
		editLink.click();
	}
	
	/**
	 * This method is used to click on add nominee link
	 */
	public void clickOnAddNomineeLink()
	{
		addNomineeLink.click();
	}
	
	/**
	 * This method is used to click on payments link
	 */
	public void clickOnPaymentLink()
	{
		addPaymentLink.click();
	}
	
	/**
	 * This method is used to click on delete client link
	 */
	public void clickOnDeleteClientLink()
	{
		deleteClientLink.click();
	}
	
	/**
	 * This method is used to get the list of nominee names
	 * @return
	 */
	public List<WebElement> getNomineeNames()
	{
		return nomineeNames;
	}
	
	/**
	 * This method is used to get the list of nominee edit links
	 * @return
	 */
	public List<WebElement> getNomineeEditLinks()
	{
		return nomineeEditLinks;
	}

}
