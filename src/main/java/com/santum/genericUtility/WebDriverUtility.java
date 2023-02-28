package com.santum.genericUtility;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.text.Element;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class contains reusable methods to work with webdriver 
 * @author abhishek
 *
 */
public class WebDriverUtility {
	private WebDriver driver;
	private WebDriverWait wait;
	private Actions a;
	JavascriptExecutor js;


	/**
	 * This method is used to maximize the browser
	 * @param driver
	 */
	public void maximizeTheBrowser(WebDriver driver)
	{
		driver.manage().window().maximize();
	}

	/**
	 * This method is used to set the implicit wait
	 * @param driver
	 * @param timeout
	 */
	public void setImplicitWait(WebDriver driver, Long timeout)
	{
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);

	}
	/**
	 * This method is used to open the application
	 * based on the browser provided
	 * enter the url
	 * @param browser
	 * @param timeout
	 * @param url
	 * @return
	 */
	public WebDriver setApplication(String browser,Long timeout,String url)
	{
		if(browser.equals(browser))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equals(browser))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browser.equals(browser))
		{
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		else
		{
			System.out.println("enter valid browser");
		}

		//		driver.manage().window().maximize();
		maximizeTheBrowser(driver);
		setImplicitWait(driver, timeout);
		//		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		driver.get(url);
		return driver;
	}

	/**
	 * This method is used to check if the given data is present in a list of elements
	 * returns true if it is present else returns false 
	 * @param data
	 * @param list
	 * @return 
	 */
	public boolean compareDataAgainstAlistOfElements(String data,List<WebElement> list)
	{
		for (int i=list.size()-1;i>=0; i--) {
			String id=list.get(i).getText();
			if(data.equals(id))
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * This method is used to compare a given data in a list and click on that particular link
	 * @param value
	 * @param list
	 * @param links
	 */
	public void compareDataAndClickOnLink(String value,List<WebElement> list,List<WebElement> links)
	{
		for (int i = list.size()-1; i >= 0; i--) {
			String id = list.get(i).getText();
			if(id.equals(value))
			{
				links.get(i).click();
				break;
			}
		}
	}

	/**
	 * This method is used to initialise explicit wait
	 * @param time
	 */
	public void initialiseExplicitWait(long time)
	{
		wait=new WebDriverWait(driver,time);
	}

	/**
	 * This method is used to waitTillVisibility Of elements
	 * @param waitCondition
	 */
	public void waitTillVisibilityOf(WebElement waitCondition)
	{
		wait.until(ExpectedConditions.visibilityOf(waitCondition));
	}

	/**
	 * This method is used to waitTillInVisibility Of elements 
	 * @param waitCondition
	 */
	public void waitTillInVisibilityOf(WebElement waitCondition)
	{
		wait.until(ExpectedConditions.invisibilityOf(waitCondition));
	}

	/**
	 * This method is used to close the browser
	 */
	public void closeBrowser()
	{
		driver.quit();
	}

	/**
	 * This method is used to close the web page
	 */
	public void closeWindow()
	{
		driver.close();
	}


	/**
	 * This method is used to switch the window based on title or url
	 * with respect to the strategy provided
	 * strategy can be-- title or url
	 * @param titleOrUrl
	 * @param strategy
	 */
	public void switchWindow(String titleOrUrl,String strategy)
	{
		Set<String> windows = driver.getWindowHandles();
		for (String w : windows) {
			driver.switchTo().window(w);
			if(strategy.equals("title"))
			{
				String actualTitle = driver.getTitle();
				if(titleOrUrl.equals(actualTitle))
				{
					break;
				}
			}
			else if(strategy.equals("url"))
			{
				String actualUrl = driver.getCurrentUrl();
				if(actualUrl.contains(titleOrUrl))
				{
					break;
				}
			}
			else
			{
				System.out.println("not a valid strategy");
				break;
			}

		}
	}


	/**
	 * This method is used to handle listbox based on index
	 * @param element
	 * @param index
	 */
	public void handleSelect(WebElement element,int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}

	/**
	 * This method is used to handle listbox based on attribute-value
	 * @param element
	 * @param value
	 */
	public void handleSelect(WebElement element,String value)
	{
		Select s=new Select(element);
		s.selectByValue(value);
	}

	/**
	 * This method is used to handle listbox based on visible text
	 * @param element
	 * @param visibleText
	 */
	public void handleSelectVisibleText(WebElement element,String visibleText)
	{
		Select s=new Select(element);
		s.selectByVisibleText(visibleText);
	}

	/**
	 * This method is used to take screenshot
	 * @param descFilePath
	 * @throws IOException
	 */
	public void takeScreenShot(String descFilePath)
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File desc=new File(descFilePath);
		try {
			FileUtils.copyFile(src, desc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to switch to a particular frame using index
	 * @param index
	 */
	public void switchToFrame(int index)
	{
		driver.switchTo().frame(index);
	}

	/**
	 * This method is used to switch to a particular frame using attribute name
	 * @param name
	 */
	public void switchToFrame(String name)
	{
		driver.switchTo().frame(name);
	}

	/**
	 * This method is used to switch to a particular frame using webelement
	 * @param frameElement
	 */
	public void switchToFrame(WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
	}

	public void switchBackToParentFrame()
	{
		driver.switchTo().parentFrame();
	}

	public void switchBackToDefaultFrame()
	{
		driver.switchTo().defaultContent();
	}
	/**
	 * This method is used to create an instance of Actions class
	 */
	public void initialiseActions()
	{
		a=new Actions(driver);

	}


	/**
	 * This method is used to perform right click
	 */
	public void rightClick()
	{
		a.contextClick().perform();;
	}

	/**
	 * This method is used to perform right click on a particular element
	 * @param target
	 */
	public void rightClick(WebElement target)
	{
		a.contextClick(target).perform();;
	}

	/**
	 * This method is used to move the mouse cursor to a particular element
	 * @param target
	 */
	public void moveToElement(WebElement target)
	{
		a.moveToElement(target).perform();
	}

	/**
	 * This method is used to double click
	 */
	public void doubleClick()
	{
		a.doubleClick();
	}

	/**
	 * This method is used to double click on a particular element
	 * @param target
	 */
	public void doubleClick(WebElement target)
	{
		a.doubleClick(target).perform();
	}

	/**
	 * This method is used to handle drag and drop functionality
	 * @param source
	 * @param destination
	 */
	public void dragAndDrop(WebElement source,WebElement destination)
	{
		a.dragAndDrop(source, destination).perform();
	}



	/**
	 * This method is used to handle file upload pop up
	 * @param element
	 * @param filePath
	 */
	public void handleFileUploadPopUp(WebElement element,String filePath)
	{
		File f=new File(filePath);
		String absolutePath = f.getAbsolutePath();
		element.sendKeys(absolutePath);
	}

	/**
	 * This method is used to handle accept and dismiss functionality in alert popup
	 * strategy can be--accept or dismiss
	 * @param strategy
	 */
	public void handleAlertPopUp(String strategy)
	{
		Alert alert = driver.switchTo().alert();
		if(strategy.equals("accept"))
		{
			alert.accept();
		}
		else if(strategy.equals("dismiss"))
		{
			alert.dismiss();
		}
	}

	/**
	 * This method is used to get the text from alert popup
	 * @return
	 */
	public String handleAlertPopUp()
	{
		Alert alert=driver.switchTo().alert();
		String alertMsg = alert.getText();
		return alertMsg;
	}

	/**
	 * This method is used to send values to alert popup
	 * @param strategy
	 * @param valueToSend
	 */
	public void AlertPopUpSendValue(String valueToSend)
	{
		Alert alert=driver.switchTo().alert();
		alert.sendKeys(valueToSend);
	}

	/**
	 * This method is used wait for a particular period of time and click on the webelemnt
	 * @param element
	 * @param waitTime
	 * @param pollingTime
	 */
	public void waitAndClick(WebElement element,int waitTime,long pollingTime)
	{
		int i=0;
		while(i<waitTime)
		{
			try
			{
				element.click();
				break;
			}
			catch (Exception e) {
				try {
					Thread.sleep(pollingTime);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	/**
	 * This method is used to scroll the scrollbar to the element provided
	 * @param element
	 */
	public void scrollIntoView(WebElement element)
	{
		js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}


	/**
	 * This method is used to convert String to By type
	 * @param xpath
	 * @return
	 */
	public By convertStringToBy(String xpath)
	{
		return By.xpath(xpath);
	}

	/**
	 * This method is used to convert String to WebElement
	 * @param s
	 * @param replaceData
	 * @return
	 */
	public WebElement convertStringToWebElement(String s,String replaceData)
	{
		String xpath=String.format(s, replaceData);
		return driver.findElement(By.xpath(xpath));
	}

	/**
	 * This method is used to convert String to WebElement
	 * @param s
	 * @param replaceData1
	 * @param replaceData2
	 * @return
	 */
	public WebElement convertStringToWebElement(String s,String replaceData1,String replaceData2)
	{
		String xpath=String.format(s, replaceData1,replaceData2);
		return driver.findElement(By.xpath(xpath));
	}

	/**
	 * This method is used to take screenshot
	 * @param desFilePath
	 */
	public String takeScreenshot(String testName)
	{
		System.out.println("webdriverutility"+Thread.currentThread().getId());
		String time = new JavaUtility().getCurrentDate();
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File("./screenshot/"+testName+"_"+time+".png");
		try {
			Files.copy(src, des);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return des.getAbsolutePath();
	}

	public String takeScreenshot()
	{
		//		System.out.println("webdriverutility"+Thread.currentThread().getId());
		//		String time = new JavaUtility().getCurrentDate();
		TakesScreenshot ts=(TakesScreenshot) driver;
		String src = ts.getScreenshotAs(OutputType.BASE64);

		return src;
	}

	public void customWait(int waitTime,WebElement element)
	{ 
		int i=0;
		while(i<waitTime)
		{
			try 
			{
				element.click();
				break;
			} 
			catch (Exception e) 
			{
				try 
				{
					Thread.sleep(500);
				} 
				catch (InterruptedException e1) 
				{
					e1.printStackTrace();
				}
			}
		}
	}

	public void uploadFile(String relativeFPath,WebElement element)
	{
		File file=new File(relativeFPath);
		String aFilePath = file.getAbsolutePath();
		element.sendKeys(aFilePath);
	}
}
