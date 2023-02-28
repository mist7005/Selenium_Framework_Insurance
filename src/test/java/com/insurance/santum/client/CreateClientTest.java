package com.insurance.santum.client;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.santum.genericUtility.BaseClass;
import com.santum.genericUtility.IConstantPath;
import com.santum.genericUtility.SheetName;
import com.santum.genericUtility.TestCaseName;
import com.santum.objectRepository.AddClientsPage;
import com.santum.objectRepository.ClientsPage;

public class CreateClientTest extends BaseClass {

	@Test
	public void createClientTest() {
		//fetch data from excel file
		String clientPassword = wu.getExcelData(SheetName.CLIENTS.convertToString() ,TestCaseName.CREATECLIENTTEST.convertToString() ,"ClientPassword" );
		String clientName = wu.getExcelData(SheetName.CLIENTS.convertToString() ,TestCaseName.CREATECLIENTTEST.convertToString() ,"ClientName" )+ranNum;
		String clientSex = 	wu.getExcelData(SheetName.CLIENTS.convertToString() ,TestCaseName.CREATECLIENTTEST.convertToString() ,"Sex" );
		String clientBirthDate = wu.getExcelData(SheetName.CLIENTS.convertToString(),TestCaseName.CREATECLIENTTEST.convertToString(),"BirthDate" );
		String clientMaritalStatus = wu.getExcelData(SheetName.CLIENTS.convertToString(),TestCaseName.CREATECLIENTTEST.convertToString(),"MaritalStatus" );
		String clientNid = wu.getExcelData(SheetName.CLIENTS.convertToString() ,TestCaseName.CREATECLIENTTEST.convertToString(),"Address" );
		String clientAddress = wu.getExcelData(SheetName.CLIENTS.convertToString() ,TestCaseName.CREATECLIENTTEST.convertToString(),"Nid" );
		String clientPhoneNo = wu.getExcelData(SheetName.CLIENTS.convertToString(),TestCaseName.CREATECLIENTTEST.convertToString(),"Phone" );
		String policyId = wu.getExcelData(SheetName.CLIENTS.convertToString() ,TestCaseName.CREATECLIENTTEST.convertToString(),"PolicyId" );

		String nomineeName = wu.getExcelData(SheetName.CLIENTS.convertToString(),TestCaseName.CREATECLIENTTEST.convertToString(),"NomineeName" )+ranNum;
		String nomineeSex = wu.getExcelData(SheetName.CLIENTS.convertToString(),TestCaseName.CREATECLIENTTEST.convertToString(),"NomineeSex" );
		String nomineeBirthDate = wu.getExcelData(SheetName.CLIENTS.convertToString(),TestCaseName.CREATECLIENTTEST.convertToString(),"NomineeBirthDate" );
		String nomineeNid = wu.getExcelData(SheetName.CLIENTS.convertToString(),TestCaseName.CREATECLIENTTEST.convertToString() ,"NomineeNid" );
		String nomineeRelationship = wu.getExcelData(SheetName.CLIENTS.convertToString(),TestCaseName.CREATECLIENTTEST.convertToString(),"NomineeRelationship" );
		String priority = wu.getExcelData(SheetName.CLIENTS.convertToString(),TestCaseName.CREATECLIENTTEST.convertToString(),"Priority" );
		String nomineePhoneNo = wu.getExcelData(SheetName.CLIENTS.convertToString() ,TestCaseName.CREATECLIENTTEST.convertToString(),"NomineePhone" );

		//navigate to client module and click on add client button
		commomPage.clickOnClients();
		ClientsPage clietPage=new ClientsPage(driver);
		clietPage.clickOnAddClientBtn();

		//get the unique client id
		AddClientsPage addClientsPage=new AddClientsPage(driver);
		String clientId=addClientsPage.getClientId();
		System.out.println(clientId);

		//enter all the client details
		addClientsPage.enterClientPassword(clientPassword);
		addClientsPage.enterClientName(clientName);

		//handle file upload pop up
		addClientsPage.uploadPhoto(wdu, IConstantPath.PHOTO_PATH);

		addClientsPage.enterClientSex(clientSex);
		addClientsPage.enterClientBirthDate(clientBirthDate);
		addClientsPage.enterClientMaritalStatus(clientMaritalStatus);
		addClientsPage.enterClientNid(clientNid);
		addClientsPage.enterClientPhoneNo(clientPhoneNo);
		addClientsPage.enterClientAddress(clientAddress);
		addClientsPage.enterPolicyId(policyId);

		//enter all the nominee details
		addClientsPage.enterNomineeName(nomineeName);
		addClientsPage.enterNomineeSex(nomineeSex);
		addClientsPage.enterNomineeBirthDate(nomineeBirthDate);
		addClientsPage.enterNomineeNid(nomineeNid);
		addClientsPage.enterNomineeRelationship(nomineeRelationship);
		addClientsPage.enterPriority(priority);
		addClientsPage.enterNomineePhone(nomineePhoneNo);
		addClientsPage.clickOnSubmitBtn();

		//post submitting the details, navigate again to client module to check whether the client created or not using the unique id
		commomPage.clickOnClients();	

		//check if client is created
		clietPage.checkIfClientIsCreated(clientId);
//		boolean result=wdu.compareDataAgainstAlistOfElements(clientId,clietPage.getClientIds());
		
		
		
//		if(result)
//		{
//			System.out.println("Pass"+"------>"+ "client created successfully: "+clientId);
//		}
//		else
//		{
//			System.out.println("Fail"+"------>"+ "client not created");
//			Assert.fail();
//		}
	}

}

