package com.santum.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.santum.genericUtility.WebDriverUtility;

public class EditClientsPage {

	@FindBy(linkText = "Delete Client") private WebElement deleteClientLink;
	@FindBy(name="client_id") private WebElement clientIdTxtBx;
	@FindBy(name="client_password") private WebElement clientPasswordTxtBx;
	@FindBy(name="name") private WebElement clientNameTxtBx;
	@FindBy(name="fileToUpload") private WebElement fileToUploadBtn;
	@FindBy(name="sex") private WebElement sexTxtBx;
	@FindBy(name="birth_date") private WebElement birthDateTxtBx;
	@FindBy(xpath = "//input[@name='marital_status']") private WebElement maritalStatusTxtBx;
	@FindBy(name="nid") private WebElement nidTxtBX;
	@FindBy(name="phone") private WebElement phoneTxtBx;
	@FindBy(name="address") private WebElement addressTxtBx;
	@FindBy(name="policy_id") private WebElement policyIdTxtBx;
	@FindBy(name="agent_id") private WebElement agentIdTxtBx;
	@FindBy(xpath = "//input[@type='submit']") private WebElement updateBtn;
	public EditClientsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);	
	}

	public void editClientPassword(String clientPassword)
	{
		clientPasswordTxtBx.clear();
		clientPasswordTxtBx.sendKeys(clientPassword);
	}
	public void editClientName(String clientName)
	{
		clientNameTxtBx.clear();
		clientNameTxtBx.sendKeys(clientName);
	}

	public void edituploadPhoto(WebDriverUtility webDriverUtility,String photo)
	{
		webDriverUtility.handleFileUploadPopUp(fileToUploadBtn, photo);	
	}

	public void editClientSex(String clientSex)
	{
		sexTxtBx.clear();
		sexTxtBx.sendKeys(clientSex);
	}

	public void editClientBirthDate(String clientBirthDate)
	{
		birthDateTxtBx.clear();
		birthDateTxtBx.sendKeys(clientBirthDate);
	}
	public void editClientMaritalStatus(String clientMaritalStatus)
	{
		maritalStatusTxtBx.clear();
		
		maritalStatusTxtBx.sendKeys(clientMaritalStatus);
	}
	public void editClientId(String clientNid)
	{
		nidTxtBX.clear();
		nidTxtBX.sendKeys(clientNid);
	}
	public void editClientPhoneNo(String clientPhoneNo)
	{
		phoneTxtBx.clear();
		phoneTxtBx.sendKeys(clientPhoneNo);
	}
	public void editClientAddress(String clientAddress)
	{
		addressTxtBx.clear();
		addressTxtBx.sendKeys(clientAddress);
	}
	public void editPolicyId(String policyId)
	{
		policyIdTxtBx.clear();
		policyIdTxtBx.sendKeys(policyId);
	}
	public void clickonUpdateBtn()
	{
		updateBtn.click();
	}
	public void clickOndeletClientLink()
	{
		deleteClientLink.click();
	}
}
