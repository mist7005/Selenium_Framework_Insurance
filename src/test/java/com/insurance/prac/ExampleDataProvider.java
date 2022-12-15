package com.insurance.prac;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.santum.genericUtility.BaseClass;
import com.santum.genericUtility.ThreadSafe;

public class ExampleDataProvider extends BaseClass{


	@Test(dataProvider = "getData")
	public void printCity(String cityName)
	{
		ThreadSafe.getExtentTest().info("data==> "+cityName);
//		System.out.println("city name =====>  "+cityName);
	}
	
	@DataProvider
	public Object[] getData()
	{
		Object[] ctName= {"Bangalore","Delhi","Mumbai","Kolkata"};
		return ctName;
	}
//	
//	@Test(dataProvider = "loginData")
//	public void loginA(String username,String password)
//	{
//		System.out.println(username+"------>"+password);
//	}
//	@DataProvider(name = "loginData")
//	public String[][] getLoginData() throws EncryptedDocumentException, IOException
//	{
//		DataFormatter df=new DataFormatter();
//		FileInputStream fis=new FileInputStream("./src/test/resources/data/testscriptLog.xlsx");
//		Workbook wb = WorkbookFactory.create(fis);
//		Sheet sheet = wb.getSheet("login");
//		int rowLength=sheet.getLastRowNum();
//		int cellLength=sheet.getRow(0).getLastCellNum();
//		String[][] arr=new String[rowLength][cellLength];
//		for (int i = 0; i < rowLength; i++) {
//			for (int j = 0; j < cellLength; j++) {
////				System.out.print(df.formatCellValue(sheet.getRow(i+1).getCell(j))+"   ");
//				arr[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
//			}
////			System.out.println();
//		}
//		wb.close();
//		fis.close();
//		return arr;
//	}
	

}
