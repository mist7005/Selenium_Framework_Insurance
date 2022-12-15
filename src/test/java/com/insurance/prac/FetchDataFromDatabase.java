package com.insurance.prac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

import com.mysql.cj.jdbc.Driver;


public class FetchDataFromDatabase {

	public static void main(String[] args) throws SQLException {

		Driver dbdriver=new Driver();
		DriverManager.registerDriver(dbdriver);

		String model="note 11";
		String price="70000";
		String brand="MI";

		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet44", "root", "root");


		//create environment
		Statement statement = connection.createStatement();

		ResultSet result = statement.executeQuery("select * from mobile");
		HashSet<String> mod=new HashSet<String>();
		HashSet<String> prc=new HashSet<String>();
		HashSet<String> brd=new HashSet<String>();
		while(result.next())
		{
			mod.add(result.getString("model"));
			prc.add(result.getString("price"));
			brd.add(result.getString("brand"));
		}
		
		
		try {
			if(mod.contains(model) && prc.contains(price)&& brd.contains(brand) )
			{
				System.out.println("duplicate available");
			}
			else
			{
			int result1=statement.executeUpdate("insert into mobile values('"+model+"',"+Integer.parseInt(price)+",'"+brand+"')");
			if(result1>=1)
			{
				System.out.println("data updated successfully");
			}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			connection.close();
			System.out.println("connection closed successfully");
		}
		//		statement.executeUpdate("create table mobile1 as select * from mobile;");
		//		ResultSet result = statement.executeQuery("select Price from mobile1");
		//		
		//		while(result.next())
		//		{
		//			System.out.println(result.getString("Price"));
		//		}
	}

}
