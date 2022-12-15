package com.insurance.prac;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchExcelDataWithKey {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		FetchExcelDataWithKey fd=new FetchExcelDataWithKey();
//		String password=fd.fetchExcelData("Clients", "CreateClientTest", "ClientPassword");
//		String clientPassword = fd.fetchExcelData("Clients", "CreateClientTest", "ClientPassword");
//		String clientName = fd.fetchExcelData("Clients", "CreateClientTest", "ClientName");
//		String clientSex = 	fd.fetchExcelData("Clients", "CreateClientTest", "Sex");
//		String clientBirthDate = fd.fetchExcelData("Clients", "CreateClientTest", "BirthDate");
//		String clientMaritalStatus = fd.fetchExcelData("Clients", "CreateClientTest", "MaritalStatus");
//		String clientNid = fd.fetchExcelData("Clients", "CreateClientTest", "Address");
//		String clientAddress = fd.fetchExcelData("Clients", "CreateClientTest", "Nid");
//		String clientPhoneNo = fd.fetchExcelData("Clients", "CreateClientTest", "Phone");
//		String policyId = fd.fetchExcelData("Clients", "CreateClientTest", "PolicyId");
//		System.out.println(password);
//		System.out.println(clientMaritalStatus);
//		
//		fd.writeToExcel("Clients",1,18,"pass");
		
		String paymentMonth = fd.fetchExcelData("Clients","CreateClientTest","PaymentMonth");
		String paymentAmount = fd.fetchExcelData("Clients","CreateClientTest","PaymentAmount");
		String paymentDue = fd.fetchExcelData("Clients","CreateClientTest","PaymentDue");
		String paymentFine = fd.fetchExcelData("Clients","CreateClientTest","PaymentFine");
		String nomineeNAme = fd.fetchExcelData("Clients","CreateClientTest","NomineeName");
		System.out.println(nomineeNAme);

	}

	public String fetchExcelData(String sheetName,String testcaseName,String columnName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/data/testscript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data="";
		DataFormatter df=new DataFormatter();
		try
		{
			Sheet sheet = wb.getSheet(sheetName);
			int rowLength=sheet.getLastRowNum();
			int cellLength=sheet.getRow(0).getLastCellNum();
			String expectedTestCaseName = testcaseName;
			String expectedColumnName= columnName;

			for (int i = 0; i <= rowLength; i++) {
				String actualTestCaseName = sheet.getRow(i).getCell(0).toString();
				if(expectedTestCaseName.equals(actualTestCaseName))
				{
					for (int j = 1; j < cellLength; j++) {
						String actualColumnName=sheet.getRow(i).getCell(j).toString();
						if(expectedColumnName.equals(actualColumnName))
						{
							data=df.formatCellValue(sheet.getRow(i+1).getCell(j));
							break;
						}
					}
					break;
				}
			}		

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			wb.close();
			fis.close();
		}
		return data;


	}

	public void writeToExcel(String sheetName,int row,int cell,String value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/data/testscript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		try
		{
		wb.getSheet(sheetName).getRow(row).createCell(cell).setCellValue(value);
		
		FileOutputStream fos=new FileOutputStream("./src/test/resources/data/testscript.xlsx");
		wb.write(fos);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			wb.close();
			fis.close();
		}

	}
}
