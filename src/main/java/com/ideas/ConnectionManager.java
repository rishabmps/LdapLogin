package com.ideas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	public Connection connect() {
		
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeForms", "root", "root");

		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		} catch (SQLException e) {
	
			e.printStackTrace();
		}

		return connection;
	}

}
