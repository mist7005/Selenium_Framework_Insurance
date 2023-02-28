package com.apitest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pojoClasses.Project;
import com.santum.genericUtility.BaseClassApi;
import com.santum.genericUtility.EndPointLibrary;
import com.santum.genericUtility.JavaUtility;
import com.santum.genericUtility.RestAssuredLibrary;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.sql.SQLException;

public class CreateProject extends BaseClassApi {
	private String projectId;
	@Test(priority = 1)
	public void createProjectTest() throws SQLException
	{
		String projectName="pankaj";
		String createdBy="pro01"+ju.generateRandomNumber(1000);
		String status="On going";
		int teamSize=4;
		
		Project p=new Project(projectName,createdBy,status,teamSize);
		
		Response resp = given()
		.body(p)
		.contentType(ContentType.JSON)
		
		.when()
		.post(EndPointLibrary.CREATEPROJECT);
		projectId=raLib.getJsonData(resp, "projectId");
		
//		db.modifyDataIntoDb("insert into projects values('"+projectId+"','"+projectName+"','"+createdBy+"','"+status+"',"+teamSize+")");
		String query="select * from project";
//		db.showColumnNames(query);
		boolean result = db.getDatabaseDataAndValidate(query, "project_id", projectId);
		
		Assert.assertTrue(result);
		System.out.println("verified");	
	}
	@Test(dependsOnMethods = "createProjectTest")
	public void deleteProject()
	{
		when()
		.delete(EndPointLibrary.DELETEPROJECT+projectId)
		
		.then()
		.assertThat()
		.statusCode(204);
		String query="select * from project";
		boolean result = db.getDatabaseDataAndValidate(query, "project_id", projectId);
		Assert.assertFalse(result);
		System.out.println("deleted");
	}
	
}
