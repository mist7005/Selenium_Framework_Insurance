package com.insurance.prac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class PracFetchDbData {

	public static void main(String[] args) throws SQLException {
		Driver dbdriver=new Driver();
		DriverManager.registerDriver(dbdriver);
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet44", "root","root");
		
		Statement statement = connection.createStatement();
		try
		{
		ResultSet result = statement.executeQuery("select * from mobile;");
		
		while(result.next())
		{
			System.out.println(result.getString("brand"));
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			connection.close();
		}
	}

}
