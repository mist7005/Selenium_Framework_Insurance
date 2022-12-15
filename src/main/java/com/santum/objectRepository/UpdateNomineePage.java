package com.santum.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This 
 * @author abhishek
 *
 */
public class UpdateNomineePage {
@FindBy(xpath = "//div[@id='page-wrapper']/div/div") private WebElement updateNomineeConfirmationMsg;
public UpdateNomineePage(WebDriver driver)
{
PageFactory.initElements(driver, this);	
}

/**
 * This method is used to get the confirmation message after updating the nominee details
 * @return
 */
public String getupdateNomineeConfirmationMsg()
{
	return updateNomineeConfirmationMsg.getText();
}

}
