package com.ideas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbManager {
	Connection connection;

	public ResultSet findAll(String query) {
		ConnectionManager manager = new ConnectionManager();
		connection = manager.connect();
		ResultSet result = null;
		try {
			Statement statement = connection.createStatement();
			result = statement.executeQuery(query);
			return result;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;

	}

	public void Update(String query) {
		ConnectionManager manager = new ConnectionManager();
		connection = manager.connect();

		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(query);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
