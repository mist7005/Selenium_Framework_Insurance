package com.insurance.santum.client;


import org.testng.annotations.Test;

import com.santum.genericUtility.BaseClass;
import com.santum.genericUtility.IConstantPath;
import com.santum.genericUtility.SheetName;
import com.santum.genericUtility.TestCaseName;
import com.santum.objectRepository.AddClientsPage;
import com.santum.objectRepository.AddNomineePage;
import com.santum.objectRepository.ClientsPage;
import com.santum.objectRepository.ClientsStatusPage;
import com.santum.objectRepository.InsertNomineePage;


public class AddNewNomineeToClientTest extends BaseClass{

	@Test
	public void addNewNomineeToClientTest(){

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

		String expectedClientId = "";
		String expectedNomineeName = wu.getExcelData(SheetName.CLIENTS.convertToString(),TestCaseName.CREATECLIENTTEST.convertToString(),"NomineeName" )+ranNum;


		//navigate to client module and click on add client button
		commomPage.clickOnClients();
		ClientsPage clietPage=new ClientsPage(driver);
		clietPage.clickOnAddClientBtn();

		//get the unique client id
		AddClientsPage addClientsPage=new AddClientsPage(driver);
		expectedClientId=addClientsPage.getClientId();
		System.out.println(expectedClientId);

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
		boolean result=wdu.compareDataAgainstAlistOfElements(expectedClientId,clietPage.getClientIds() );
		if(result)
		{
			System.out.println("Pass"+"------>"+ "client created successfully: "+expectedClientId);
		}
		else
		{
			System.out.println("Fail"+"------>"+ "client not created");
		}


		//check for the given clientId in a list and click on that particular client status link
		wdu.compareDataAndClickOnLink(expectedClientId, clietPage.getClientIds(), clietPage.getClientsStatus());

		ClientsStatusPage clientsStatusPage=new ClientsStatusPage(driver);
		clientsStatusPage.clickOnAddNomineeLink();

		//add new nominee details
		AddNomineePage addNomineePage=new AddNomineePage(driver);
		addNomineePage.enterNomineeName(expectedNomineeName);
		addNomineePage.enterNomineeSex(nomineeSex);
		addNomineePage.enterNomineeBirthDate(nomineeBirthDate);
		addNomineePage.enterNomineeNid(nomineeNid);
		addNomineePage.enterNomineeRelationship(nomineeRelationship);
		addNomineePage.enterPriority(priority);
		addNomineePage.enterNomineePhone(nomineePhoneNo);		
		addNomineePage.clickOnSubmitBtn();

		//wait condition
		InsertNomineePage insertNomineePage=new InsertNomineePage(driver);
		wdu.waitTillVisibilityOf(insertNomineePage.getInsertNomineeTxt());


		// verify if the nominee is added
		ju.checkConfirmationMessage(insertNomineePage.getInsertNomineeConfirmationMsg(),"New Nominee ADDED");


	}

}
