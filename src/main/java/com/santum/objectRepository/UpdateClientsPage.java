package com.santum.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class contains the objects of update clients page
 * @author abhishek
 *
 */
public class UpdateClientsPage {

	@FindBy(xpath = "//div[@id='page-wrapper']/div/div") private WebElement confirmationMessage;
	
	public UpdateClientsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method gets the confirmation message after updating the clients details
	 * @return
	 */
	public String getConfirmationMsgTxt()
	{
		return confirmationMessage.getText();
	}

}
