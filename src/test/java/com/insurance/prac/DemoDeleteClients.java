package com.insurance.prac;

import org.openqa.selenium.WebDriver;

import com.santum.genericUtility.FileUtility;
import com.santum.genericUtility.IConstantPath;
import com.santum.genericUtility.JavaUtility;
import com.santum.genericUtility.PropertyFileKeys;
import com.santum.genericUtility.WebDriverUtility;

public class DemoDeleteClients {

	public static void main(String[] args) {
		WebDriverUtility wdu=new WebDriverUtility();
		FileUtility fu=new FileUtility();
		JavaUtility ju=new JavaUtility();
		
		fu.openPropertyFile(IConstantPath.PROPERTY_FILE_PATH);
		
		String browser = fu.getDataFromPropertyFille(PropertyFileKeys.BROWSER.convertToString());
		String url = fu.getDataFromPropertyFille(PropertyFileKeys.URL.convertToString());
		String timeout=fu.getDataFromPropertyFille(PropertyFileKeys.TIMEOUT.convertToString());
		 Long t =(Long) ju.convertToAnyDataType(timeout, "long");
		  WebDriver driver = wdu.setApplication(browser,t,url);
		  
	}

}
