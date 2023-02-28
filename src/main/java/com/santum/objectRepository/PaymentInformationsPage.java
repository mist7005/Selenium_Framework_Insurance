package com.santum.objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.santum.genericUtility.ThreadSafe;

public class PaymentInformationsPage {
@FindBy(linkText = "Add Payment")
private WebElement addPaymentBtn;

@FindBy(xpath = "//table/tbody/tr/td[1]") private List<WebElement> receiptNo;

String receiptNoXpath="//table/tbody/tr/td[contains(text(),'%s')]";

public PaymentInformationsPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public void clickOnPaymentEditLink(String replaceData)
{
	ThreadSafe.getwebdriverUtility().convertStringToWebElement(receiptNoXpath, replaceData).click();

}

public void checkIfPaymentIsCreated(String receiptNum)
{
	String rp = receiptNum.split("_")[0];
	String actualData=ThreadSafe.getwebdriverUtility().convertStringToWebElement(receiptNoXpath, rp).getText();
	String ac = actualData.split("_")[0];
//	System.out.println("actual receipt ====>"+ac);
//	String rp = replaceData.split("_")[0];
	System.out.println("actual receipt1 ====>"+rp);
	if(ac.equals(rp))
	{
		System.out.println("Payment added success");
	}
	else
	{
		System.out.println("payment not added");
		Assert.fail();
	}
}

public void clickOnAddPaymentBtn()
{
addPaymentBtn.click();	
}

public List<WebElement> getReceiptNo()
{
	return receiptNo;
}

}
