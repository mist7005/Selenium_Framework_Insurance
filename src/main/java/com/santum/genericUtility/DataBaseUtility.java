package com.santum.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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

	private Connection connection;
	private Statement statement;
	private Driver dbDriver;
	/**
	 * This method is used to open the database and establish the connection
	 * @param dbUrl
	 * @param dbUsername
	 * @param dbPassword
	 */
	public void openDatabase(String dbUrl,String dbUsername,String dbPassword)
	{

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
	public List<String> getDatabaseData(String query,String columnLabel)
	{


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

	public void modifyDataIntoDb(String query) throws SQLException
	{
		statement=connection.createStatement();

		int result=statement.executeUpdate(query);


	}
	
	public void showColumnNames(String query)
	{
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ResultSet result=null;
		try {
			result = statement.executeQuery(query);
			 ResultSetMetaData rsMetaData = result.getMetaData();
			int count=rsMetaData.getColumnCount();
			for (int i = 1; i <= count; i++) {
				System.out.println(rsMetaData.getColumnName(i));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public boolean getDatabaseDataAndValidate(String query,int columnLabel,String expData)
	{

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

		if(ls.contains(expData))
		{
			return true;
		}
		else
			return false;
	}
	
	public boolean getDatabaseDataAndValidate(String query,String columnLabel,String expData)
	{

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

		if(ls.contains(expData))
		{
			return true;
		}
		else
			return false;
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
