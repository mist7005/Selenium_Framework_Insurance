package com.santum.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class contains the object of Add nominee page
 * @author abhishek
 *
 */
public class AddNomineePage {
@FindBy(xpath="//input[@name='name']") private WebElement nomineeNameTxtBx;
@FindBy(xpath="//input[@name='sex']") private WebElement nomineeSexTxtBx;
@FindBy(xpath = "//input[@name='birth_date']") private WebElement nomineeBirthDateTxtBx;
@FindBy(xpath = "//input[@name='nid']") private WebElement nomineeNidTxtBx;
@FindBy(xpath = "//input[@name='relationship']") private WebElement nomineeRelationshipTxtBx;
@FindBy(xpath = "//input[@name='priority']") private WebElement nomineePriorityTxtBx;
@FindBy(xpath = "//input[@name='phone']") private WebElement nomineePhoneTxtBx;
@FindBy(xpath = "//input[@type='submit']") private WebElement submitBtn;

public AddNomineePage(WebDriver driver)
{
PageFactory.initElements(driver, this);	
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
 * This method is used to enter nominee sex
 * @param nomineeSex
 */
public void enterNomineeSex(String nomineeSex)
{
nomineeSexTxtBx.sendKeys(nomineeSex);
}

/**
 * This method is used to enter nominee birth date
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
 * This method is used to enter priority
 * @param priority
 */
public void enterPriority(String priority)
{
nomineePriorityTxtBx.sendKeys(priority);
}

/**
 * Thismethod is used to enter nominee phone number
 * @param nomineePhoneNo
 */
public void enterNomineePhone(String nomineePhoneNo)
{
nomineePhoneTxtBx.sendKeys(nomineePhoneNo);
}

/**
 * This method is used to click on the submit button
 */
public void clickOnSubmitBtn()
{
	submitBtn.click();
}
}
