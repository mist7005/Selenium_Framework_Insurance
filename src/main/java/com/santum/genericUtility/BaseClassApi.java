package com.santum.genericUtility;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;

public class BaseClassApi {
	protected JavaUtility ju=new JavaUtility();
	protected RestAssuredLibrary raLib=new RestAssuredLibrary();
	protected DataBaseUtility db;
	
	@BeforeSuite
	public void bsConfig()
	{
		db=new DataBaseUtility();
		db.openDatabase(Iconstants.dbUrl,Iconstants.dbUn,Iconstants.dbPw);
		baseURI=Iconstants.appUrl;
		port=Iconstants.port;
		
		
	}
	@AfterSuite
	public void closeConfig()
	{
		
		db.closeDatabase();
	}
}
