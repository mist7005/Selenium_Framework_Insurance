package com.santum.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class contains objects of Add payment page
 * @author abhishek
 *
 */
public class AddPaymentPage {
	@FindBy(name = "month") private WebElement paymentMonthTxtBx;
	@FindBy(name = "amount") private WebElement paymentAmountTxtBx;
	@FindBy(name = "due") private WebElement paymentDueTxtBx;
	@FindBy(name = "fine") private WebElement paymentFineTxtBx;
	@FindBy(xpath = "//input[@type='submit']") private WebElement submitBtn;

	public AddPaymentPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);	
	}
	
	/**
	 * This method is used to enter payment month
	 * @param month
	 */
	public void enterPaymentMonth(String month)
	{
		paymentMonthTxtBx.sendKeys(month);	
	}
	
	/**
	 * This method is used to enter payment amount
	 * @param amount
	 */
	public void enterPaymentAmount(String amount)
	{
		paymentAmountTxtBx.sendKeys(amount);	
	}
	
	/**
	 * This method is used to enter payment due
	 * @param due
	 */
	public void enterPaymentDue(String due)
	{
		paymentDueTxtBx.sendKeys(due);	
	}
	
	/**
	 * This method is used to enter payment fine
	 * @param fine
	 */
	public void enterPaymentFine(String fine)
	{
		paymentFineTxtBx.sendKeys(fine);	
	}
	
	/**
	 * This method is used to click on submit button
	 */
	public void clickOnSubmitBtn()
	{
		submitBtn.click();	
	}
}
