package com.ideas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbManager {
	Connection connection;

	public ResultSet findAll(String query) throws ClassNotFoundException, SQLException {
		ConnectionManager manager = new ConnectionManager();
		ResultSet result = null;
		try {
			connection = manager.connect();
			
			Statement statement = connection.createStatement();
			result = statement.executeQuery(query);
			return result;

		} catch (SQLException e) {
			
			throw new SQLException();
		} catch (ClassNotFoundException e) {
			
			throw new ClassNotFoundException();
		}

		

	}

	public void Update(String query) throws SQLException {
		ConnectionManager manager = new ConnectionManager();
		

		try {
			connection = manager.connect();
			Statement statement = connection.createStatement();
			statement.executeUpdate(query);

		} catch (SQLException e) {
			throw new SQLException();
		} catch (ClassNotFoundException e) {
			throw new SQLException();
		}

	}

	public void closeConnection() throws SQLException {
		try {
			connection.close();
		} catch (SQLException e) {
			throw new SQLException();
		}

	}
}
