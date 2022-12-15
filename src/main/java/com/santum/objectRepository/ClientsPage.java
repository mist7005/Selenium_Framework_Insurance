package com.santum.objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class contains the objects of clients page
 * @author abhishek
 *
 */
public class ClientsPage {

	@FindBy(xpath = "//div[@id='page-wrapper']/div/div/h1") private WebElement clientsInformationTxt;
	@FindBy(linkText = "Add Client") private WebElement addClientBtn;
	@FindBy(xpath = "//table/tbody/tr/td[1]") private List<WebElement> clientsIds;
	@FindBy(xpath = "//table/tbody/tr/td[7]/a") private List<WebElement> StatusClients;
	@FindBy(xpath = "//table/tbody/tr/td[8]/a") private List<WebElement> editLinks;
	
	
	public ClientsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method is used to click on edit link
	 * @param clientId
	 */
	public void clickOnEditLink(String clientId)
	{
		for (int i = 0; i < clientsIds.size(); i++) {
			String loopId=clientsIds.get(i).getText();
			if(clientId.equals(loopId))
			{
				editLinks.get(i).click();
			}
		}
	}
	
	/**
	 * This method is used to get the client information text
	 * @return
	 */
	public WebElement getclientinformationText()
	{
		return clientsInformationTxt;
	}
	
	/**
	 * This method is used to click on add clients button
	 */
	public void clickOnAddClientBtn()
	{
		addClientBtn.click();
	}
	
	/**
	 * This method is used to get the list of clients id
	 * @return
	 */
	public List<WebElement> getClientIds()
	{
		return clientsIds;
	}
	
	
	/**
	 * This method is used to get the clients status
	 * @return
	 */
	public List<WebElement> getClientsStatus()
	{
		return StatusClients;
	}
	
	/**
	 * This method is used to get the edit links
	 * @return
	 */
	public List<WebElement> getEditLinks()
	{
		return editLinks;
	}


}
