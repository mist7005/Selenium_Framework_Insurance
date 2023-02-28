package com.santum.objectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.santum.genericUtility.ThreadSafe;

/**
 * This class contains the objects of clients page
 * @author abhishek
 *
 */
public class ClientsPage {

	private WebDriver driver;
	@FindBy(xpath = "//div[@id='page-wrapper']/div/div/h1") private WebElement clientsInformationTxt;
	@FindBy(linkText = "Add Client") private WebElement addClientBtn;
	@FindBy(xpath = "//table/tbody/tr/td[1]") private List<WebElement> clientsIds;
	@FindBy(xpath = "//table/tbody/tr/td[7]/a") private List<WebElement> StatusClients;
	@FindBy(xpath = "//table/tbody/tr/td[8]/a") private List<WebElement> editLinks;

	String clientIdXpath="//tbody/tr/td[text()='%s']";
	String editXpath="//tbody/tr/td[text()='%s']/..//a[text()='Edit']";
	String clientStatusXpath="//tbody/tr/td[text()='%s']/..//a[text()='Client Status']";

	public ClientsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	public void checkIfClientIsCreated(String clientId)
	{
		String actualData=ThreadSafe.getwebdriverUtility().convertStringToWebElement(clientIdXpath, clientId).getText();
		if(actualData.equals(clientId))
		{
			System.out.println("Client added success");
		}
		else
		{
			System.out.println("Client not added");
			Assert.fail();
		}
	}
	
	public WebElement stringToWebelement(String replaceData)
	{
		String updatedString = String.format(editXpath, replaceData);
		return driver.findElement(By.xpath(updatedString));
	}
	
	/**
	 * This method is used to click on editLink
	 * @param clientId
	 */
	public void clickOnEdit(String clientId)
	{
		ThreadSafe.getwebdriverUtility().convertStringToWebElement(editXpath, clientId).click();
		//		stringToWebelement(replaceData).click();

	}

	/**
	 * This method is used to click on client status link
	 * @param clientId
	 */
	public void clickOnClientStatus(String clientId)
	{
		ThreadSafe.getwebdriverUtility().convertStringToWebElement(clientStatusXpath, clientId).click();
		//		stringToWebelement(replaceData).click();

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
