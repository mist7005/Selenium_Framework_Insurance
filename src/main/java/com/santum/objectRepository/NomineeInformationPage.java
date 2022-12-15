package com.santum.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class contains the object of nominee information page
 * @author abhishek
 *
 */
public class NomineeInformationPage {
@FindBy(name = "priority") private WebElement nomineePriorityTxtBx;
@FindBy(xpath = "//input[@type='submit']") private WebElement submitBtn;
public NomineeInformationPage(WebDriver driver)
{
PageFactory.initElements(driver, this);	
}

/**
 * This method is used to clear the current priority and enter a new priority value
 * @param priority
 */
public void enterNomineePriority(String priority)
{
nomineePriorityTxtBx.clear();
nomineePriorityTxtBx.sendKeys(priority);
}

/**
 * This method is used to click on submit button
 */
public void clickOnSubmitBtn()
{
submitBtn.click();	
}
}
