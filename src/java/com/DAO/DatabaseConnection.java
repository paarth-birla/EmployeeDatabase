package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	/*
	 * protected static Connection initializeDatabase() throws SQLException,
	 * ClassNotFoundException { String dbDriver = "com.mysql.jdbc.Driver"; String
	 * url = "jdbc:mysql://localhost:3306/cloudcomputing"; String connect_username =
	 * "root"; String connect_password = "root";
	 * 
	 * Class.forName(dbDriver); Connection connection =
	 * DriverManager.getConnection(url, connect_username, connect_password);
	 * 
	 * return connection; }
	 */
	
	protected static Connection getDBConnection() throws SQLException, ClassNotFoundException
	{
		String dbDriver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/cloudcomputing";
		String connect_username = "root";
		String connect_password = "root";
		
		Class.forName(dbDriver);
		Connection connection = DriverManager.getConnection(url, connect_username, connect_password);
		
		return connection;
	}
}
