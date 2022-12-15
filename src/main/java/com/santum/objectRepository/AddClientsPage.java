package com.santum.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.santum.genericUtility.WebDriverUtility;

/**
 * This class contains objects of AddClientsPage
 * @author abhishek
 *
 */
public class AddClientsPage {
	@FindBy(name="client_id") private WebElement clientIdTxtBx;
	@FindBy(name="client_password") private WebElement clientPasswordTxtBx;
	@FindBy(name="name") private WebElement clientNameTxtBx;
	@FindBy(name="fileToUpload") private WebElement fileToUploadBtn;
	@FindBy(name="sex") private WebElement sexTxtBx;
	@FindBy(name="birth_date") private WebElement birthDateTxtBx;
	@FindBy(name="maritial_status") private WebElement maritalStatusTxtBx;
	@FindBy(name="nid") private WebElement nidTxtBX;
	@FindBy(name="phone") private WebElement phoneTxtBx;
	@FindBy(name="address") private WebElement addressTxtBx;
	@FindBy(name="policy_id") private WebElement policyIdTxtBx;
	@FindBy(name="agent_id") private WebElement agentIdTxtBx;
	@FindBy(name="nominee_id") private WebElement nomineeIdTxtBx;
	@FindBy(name="nominee_name") private WebElement nomineeNameTxtBx;
	@FindBy(name="nominee_sex") private WebElement nomineeSexTxtBx;
	@FindBy(name="nominee_birth_date") private WebElement nomineeBirthDateTxtBx;
	@FindBy(name="nominee_nid") private WebElement nomineeNidTxtBx;
	@FindBy(name="nominee_relationship") private WebElement nomineeRelationshipTxtBx;
	@FindBy(name="priority") private WebElement priorityTxtBx;
	@FindBy(name="nominee_phone") private WebElement nomineePhoneTxtBx;
	@FindBy(xpath ="//input[@type='submit']") private WebElement submitBtn;

	
	
	public AddClientsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);	
	}

	/**
	 * This method is used to get the unique client id
	 * @return
	 */
	public String getClientId()
	{
		return clientIdTxtBx.getAttribute("value");
	}
	
	/**
	 * This method is used enter client password
	 * @param clientPassword
	 */
	public void enterClientPassword(String clientPassword)
	{
		clientPasswordTxtBx.sendKeys(clientPassword);
	}
	
	/**
	 * This method is used to enter Client name
	 * @param clientName
	 */
	public void enterClientName(String clientName)
	{
	clientNameTxtBx.sendKeys(clientName);
	}

	/**
	 * This method is used to upload photo
	 * @param webDriverUtility
	 * @param photo
	 */
	public void uploadPhoto(WebDriverUtility webDriverUtility,String photo)
	{
	webDriverUtility.handleFileUploadPopUp(fileToUploadBtn, photo);	
	}
	
	/**
	 * This method is used to enter the client sex
	 * @param clientSex
	 */
	public void enterClientSex(String clientSex)
	{
	sexTxtBx.sendKeys(clientSex);
	}
	
	/**
	 * This method is used to enter the client birth date
	 * @param clientBirthDate
	 */
	public void enterClientBirthDate(String clientBirthDate)
	{
	birthDateTxtBx.sendKeys(clientBirthDate);
	}
	
	/**
	 * This method is used to enter client Marital status
	 * @param clientMaritalStatus
	 */
	public void enterClientMaritalStatus(String clientMaritalStatus)
	{
	maritalStatusTxtBx.sendKeys(clientMaritalStatus);
	}
	
	/**
	 * This method is used to enter the client Nid
	 * @param clientNid
	 */
	public void enterClientNid(String clientNid)
	{
	nidTxtBX.sendKeys(clientNid);
	}
	
	/**
	 * This method is used to enter the client Phone number
	 * @param clientPhoneNo
	 */
	public void enterClientPhoneNo(String clientPhoneNo)
	{
	phoneTxtBx.sendKeys(clientPhoneNo);
	}
	
	/**
	 * This method is used to enter client address
	 * @param clientAddress
	 */
	public void enterClientAddress(String clientAddress)
	{
	addressTxtBx.sendKeys(clientAddress);
	}
	
	/**
	 * This method is used to enter policy id
	 * @param policyId
	 */
	public void enterPolicyId(String policyId)
	{
	policyIdTxtBx.sendKeys(policyId);
	}
	
	/**
	 * This method is used to get the unique nominee id
	 * @return
	 */
	public String getNomineeId()
	{
		return nomineeIdTxtBx.getAttribute("value");
	}

	/**
	 * This method is used to enter nominee name
	 * @param nomineeName
	 */
	public void enterNomineeName(String nomineeName)
	{
	nomineeNameTxtBx.sendKeys(nomineeName);
	}
	
	/**
	 * This method is used to enter the nominee sex
	 * @param nomineeSex
	 */
	public void enterNomineeSex(String nomineeSex)
	{
	nomineeSexTxtBx.sendKeys(nomineeSex);
	}
	
	/**
	 * This method is used to enter the nominee birth date
	 * @param nomineeBirthDate
	 */
	public void enterNomineeBirthDate(String nomineeBirthDate)
	{
	nomineeBirthDateTxtBx.sendKeys(nomineeBirthDate);
	}
	
	/**
	 * This method is used to enter nominee Nid
	 * @param nomineeNid
	 */
	public void enterNomineeNid(String nomineeNid)
	{
	nomineeNidTxtBx.sendKeys(nomineeNid);
	}
	
	/**
	 * This method is used to enter nominee relationship
	 * @param nomineeRelationship
	 */
	public void enterNomineeRelationship(String nomineeRelationship)
	{
	nomineeRelationshipTxtBx.sendKeys(nomineeRelationship);
	}
	
	/**
	 * This method is used to enter the priority
	 * @param priority
	 */
	public void enterPriority(String priority)
	{
	priorityTxtBx.sendKeys(priority);
	}
	
	/**
	 * This method is used to enter nominee phone number
	 * @param nomineePhoneNo
	 */
	public void enterNomineePhone(String nomineePhoneNo)
	{
	nomineePhoneTxtBx.sendKeys(nomineePhoneNo);
	}
	
	/**
	 * This method is used to click on submit button
	 */
	public void clickOnSubmitBtn()
	{
	submitBtn.click();	
	}
}

