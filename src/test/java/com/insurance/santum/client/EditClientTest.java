package com.insurance.santum.client;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.santum.genericUtility.BaseClass;
import com.santum.genericUtility.IConstantPath;
import com.santum.genericUtility.SheetName;
import com.santum.genericUtility.TestCaseName;
import com.santum.objectRepository.AddClientsPage;
import com.santum.objectRepository.ClientsPage;
import com.santum.objectRepository.EditClientsPage;
import com.santum.objectRepository.UpdateClientsPage;


@Listeners(com.santum.genericUtility.ListnerImplementationClass.class)
public class EditClientTest extends BaseClass{

	@Test
	public void editClient(){
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

		String expectedMaritalStatus=wu.getExcelData(SheetName.CLIENTS.convertToString(),3, 5);

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
		clietPage.checkIfClientIsCreated(expectedClientId);
		
//		boolean result=wdu.compareDataAgainstAlistOfElements(expectedClientId,clietPage.getClientIds() );
//		if(result)
//		{
//			System.out.println("Pass"+"------>"+ "client created successfully: "+expectedClientId);
//		}
//		else
//		{
//			System.out.println("Fail"+"------>"+ "client not created");
//		}
		
		clietPage.clickOnEdit(expectedClientId);
		//click on the given client edit link
//		wdu.compareDataAndClickOnLink(expectedClientId, clietPage.getClientIds(), clietPage.getEditLinks());
		
		//edit the marital status
		EditClientsPage editClientsPage=new EditClientsPage(driver);
		editClientsPage.editClientMaritalStatus(expectedMaritalStatus);
		// click on submit button
		editClientsPage.clickonUpdateBtn();

		//explicit wait
		wdu.waitTillVisibilityOf(clietPage.getclientinformationText());

		//verify if the update is successfull
		UpdateClientsPage updateClientsPage=new UpdateClientsPage(driver);
		String confirmationMessage = updateClientsPage.getConfirmationMsgTxt();
		ju.checkConfirmationMessage(confirmationMessage,"Client record updated successfully");
	}

}
