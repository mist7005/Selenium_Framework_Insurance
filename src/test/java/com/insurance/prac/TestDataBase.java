package com.insurance.prac;

import java.sql.SQLException;
import java.util.List;

import com.santum.genericUtility.DataBaseUtility;
import com.santum.genericUtility.PropertyFileKeys;

public class TestDataBase {

	public static void main(String[] args) throws SQLException {
		String projectId="Ty1234";
		String projectName="pankaj432";
		String createdBy="pankaj";
		int teamSize=2;
		DataBaseUtility db=new DataBaseUtility();
		db.openDatabase("jdbc:mysql://localhost:3306/sdet44", "root","root");
		List<String> actualProjectId = db.getDatabaseData("select * from projects", "projectId");
		
		if(actualProjectId.contains(projectId))
		{
			System.out.println("duplicate available");
		}
		else
		{
		db.modifyDataIntoDb("insert into projects values('Ty12345','pro02','Pankaj','ongoing',5)");
		}
		actualProjectId.forEach(System.out::println);
		db.closeDatabase();
		System.out.println("data base closed");
		
		
		
	}

}
