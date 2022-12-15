package com.insurance.prac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

public class AddDataWithoutDuplicates {

	public static void main(String[] args) throws SQLException {

		Driver dbdriver=new Driver();
		DriverManager.registerDriver(dbdriver);

		String model="note 11";
		String price="90000";
		String brand="MI";

		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet44", "root","root");

		Statement statement = connection.createStatement();

		List<String> ls=new ArrayList<String>();

		try
		{
			ResultSet result = statement.executeQuery("select * from mobile;");

			while(result.next())
			{
				ls.add(result.getString("model")+" || "+result.getString("price")+" || "+result.getString("brand"));
			}
			System.out.println(ls);

			if(ls.contains(model+" || "+price+" || "+brand))
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
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			connection.close();
		}
	}

}
