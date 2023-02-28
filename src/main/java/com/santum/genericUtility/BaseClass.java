package com.santum.genericUtility;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


import com.santum.objectRepository.CommonPage;
import com.santum.objectRepository.LoginPage;

public class BaseClass {
	protected FileUtility fu;
	protected WorkBookUtility wu;
	protected WebDriverUtility wdu;
	protected JavaUtility ju;
	protected WebDriver driver;
	public static WebDriver sDriver;
	protected String un;
	protected String pw;
	protected CommonPage commomPage;
	protected LoginPage loginPage;
	protected int ranNum;

	/**
	 * This method is used to create an instance of FileUtility class-->fu,
	 * WorkBookUtility class--> wu, WebdriverUtility class-->wdu,
	 * JavaUtility class-->ju, CommonPage class-->commomPage
	 * and open the broswer
	 */
	@BeforeClass(alwaysRun = true)
	public void openBrowser()
	{
		
		fu=new FileUtility();
		wu=new WorkBookUtility();
		wdu=new WebDriverUtility();
		ThreadSafe.setwebdriverUtility(wdu);
		ju=new JavaUtility();



		//open property file
		fu.openPropertyFile(IConstantPath.PROPERTY_FILE_PATH);

		//open excel workbook
		wu.openExcelWorkBook(IConstantPath.EXCEL_PATH);


		//limit to generate random number
		Integer limit = (Integer)ju.convertToAnyDataType(fu.getDataFromPropertyFille(PropertyFileKeys.LIMIT.convertToString()), "int");
		ranNum = ju.generateRandomNumber(limit);

		//fetch data from property file

		String url = fu.getDataFromPropertyFille(PropertyFileKeys.URL.convertToString());
		un = fu.getDataFromPropertyFille(PropertyFileKeys.USERNAME.convertToString());
		pw = fu.getDataFromPropertyFille(PropertyFileKeys.PASSWORD.convertToString());
		long time = (Long) ju.convertToAnyDataType(fu.getDataFromPropertyFille(PropertyFileKeys.TIMEOUT.convertToString()),"long");


		//open the browser
		String browser = fu.getDataFromPropertyFille(PropertyFileKeys.BROWSER.convertToString());
		driver = wdu.setApplication(browser, time, url);
		sDriver=driver;
		commomPage=new CommonPage(driver);

		//initialise explicit wait
		wdu.initialiseExplicitWait(time);
		System.out.println("BeforeClass"+Thread.currentThread().getId());
	}

	/**
	 * This method is used to login to the application
	 */
	@BeforeMethod(alwaysRun = true)
	public void loginToApp()
	{
		//login in to application
		loginPage=new LoginPage(driver);
		loginPage.loginAction(un, pw);
	}

	/**
	 * This method is used to logout from the browser,
	 * and close propertyFile, excelFile
	 */
	@AfterMethod(alwaysRun = true)
	public void logoutFromApp()
	{
		//sign out of the application 
		commomPage.clickOnLogOut();
		fu.closePropertyFile();
		wu.closeExcelFile();
	}

	/**
	 * This method is used close the Browser
	 */
	@AfterClass(alwaysRun = true)
	public void closeBrowser()
	{
		wdu.closeBrowser();
	}

}
