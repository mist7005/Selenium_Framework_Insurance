package com.santum.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;


/**
 * This class contains reusable database methods
 * @author abhishek
 *
 */
public class DataBaseUtility {
	
	private Connection connection=null;
	/**
	 * This method is used to open the database and establish the connection
	 * @param dbUrl
	 * @param dbUsername
	 * @param dbPassword
	 */
	public void openDatabase(String dbUrl,String dbUsername,String dbPassword)
	{
		Driver dbDriver=null;
		try {
			dbDriver = new Driver();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			DriverManager.registerDriver(dbDriver);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//establish connection
		try {
			 connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method is used to get data from the database in the form of a List
	 * @param url
	 * @param username
	 * @param password
	 * @param query
	 * @param columnLabel
	 * @return
	 * @throws SQLException
	 */
	public List<String> getDatabaseData(String url,String username,String password,String query,String columnLabel)
	{
		
		Statement statement=null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ResultSet result=null;
		try {
			result = statement.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		List<String> ls=new ArrayList<String>();
		
		try {
			while(result.next())
			{
				ls.add(result.getString(columnLabel));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ls;
	}
	
	/**
	 * This method is used to close the browser
	 */
	public void closeDatabase()
	{
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
