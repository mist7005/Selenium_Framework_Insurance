package com.santum.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class contains objects of insert nominee page
 * @author abhishek
 *
 */
public class InsertNomineePage {
	@FindBy(xpath = "//div[@id='page-wrapper']/div/div/h1") private WebElement insertNomineeTxt;
	@FindBy(xpath = "//div[@id='page-wrapper']/div/div") private WebElement insertNomineeConfirmationPage;
	
	public InsertNomineePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getInsertNomineeTxt()
	{
		return insertNomineeTxt;
	}
	
	/**
	 * This method is used to get the confirmation message which is displayed after adding the nominee
	 * @return
	 */
	public String getInsertNomineeConfirmationMsg()
	{
		return insertNomineeConfirmationPage.getText();
	}
}
