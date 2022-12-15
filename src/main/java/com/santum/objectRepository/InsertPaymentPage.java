package com.santum.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class contains the objects of insert payemnt page
 * @author abhishek
 *
 */
public class InsertPaymentPage {
@FindBy(xpath = "//div[@id='page-wrapper']/div/div") private WebElement insertPayemntConfirmationMsg;
public InsertPaymentPage(WebDriver driver)
{
PageFactory.initElements(driver, this);	
}

/**
 * This method is used to get the confirmation message after submitting the payment details
 * @return
 */
public String getInsertPayemntConfirmationMsg()
{
return insertPayemntConfirmationMsg.getText();	
}
}
