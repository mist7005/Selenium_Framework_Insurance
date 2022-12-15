package com.insurance.prac;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchExcelData {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/data/testscript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		try
		{
//			String clientPassword = wb.getSheet("Clients").getRow(2).getCell(1).getStringCellValue();
//			String clientName = wb.getSheet("Clients").getRow(2).getCell(2).getStringCellValue();
//			String clientSex = wb.getSheet("Clients").getRow(2).getCell(3).getStringCellValue();
//			String clientBirthDate = wb.getSheet("Clients").getRow(2).getCell(4).getStringCellValue();
//			String clientMaritalStatus = wb.getSheet("Clients").getRow(2).getCell(5).getStringCellValue();
//			String clientNid = wb.getSheet("Clients").getRow(2).getCell(6).getStringCellValue();
//			String clientAddress = wb.getSheet("Clients").getRow(2).getCell(7).toString();
//			String clientPhoneNo = wb.getSheet("Clients").getRow(2).getCell(8).getStringCellValue();
//			String policyId = wb.getSheet("Clients").getRow(2).getCell(9).toString();
			
			String nomineeName = wb.getSheet("Clients").getRow(2).getCell(10).getStringCellValue();
			String nomineeSex = wb.getSheet("Clients").getRow(2).getCell(11).getStringCellValue();
			String nomineeBirthDate = wb.getSheet("Clients").getRow(2).getCell(12).getStringCellValue();
			String nomineeNid = wb.getSheet("Clients").getRow(2).getCell(13).getStringCellValue();
			String nomineeRelationship = wb.getSheet("Clients").getRow(2).getCell(14).getStringCellValue();
			String priority = wb.getSheet("Clients").getRow(2).getCell(15).toString();
			String nomineePhoneNo = wb.getSheet("Clients").getRow(2).getCell(16).toString();
//			System.out.println(clientPassword);
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
