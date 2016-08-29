package com.ideas;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FormService {

	public Integer getCount(String query) {
		
		DbManager manager = new DbManager();
		Integer count = 0;

		ResultSet executeQuery = manager.findAll(query);
		try {
			while (executeQuery.next()) {
				count = executeQuery.getInt("count");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		manager.closeConnection();

		return count;

	}

	public void saveForm(String name,String empNo,String amount, String form) {
	
		DbManager manager = new DbManager();
		manager.Update("INSERT INTO "+ form+" (employee_name,employee_No,amount) " + "VALUES('"
				+ name + "','" + empNo + "','" + amount+"');");
		manager.closeConnection();

	}

	public double getTotalAmount(String form,String name) {
		DbManager manager = new DbManager();
		double amount = 0;
		ResultSet executeQuery = manager.findAll("select amount From "+form+" where employee_name='"+name+"'");
		try {
			while (executeQuery.next()) {
				String tempAmount = executeQuery.getString("amount");
				amount += Double.valueOf(tempAmount);
			}
			return amount;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		manager.closeConnection();
		return -1;

	}

//	public Account getByPan(String query) {
//		
//		DbManager manager = new DbManager();
//		ResultSet executeQuery = manager.findAll(query);
//
//		String birthDate;
//		Account account = null;
//		try {
//			String name = executeQuery.getString("account_name");
//			birthDate = executeQuery.getString("birthdate");
//			String type = executeQuery.getString("account_type");
//			String mobile = executeQuery.getString("mobile_no");
//			String pan_no = executeQuery.getString("pan_card");
//			account = new Account(name, birthDate, type, mobile, pan_no);
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//		}
//		manager.closeConnection();
//		return account;
//
//	}

	

//	public void updateAccount(String name, String birtDate, String type, String mobile, String pan_no) {
//	
//		DbManager manager = new DbManager();
//		String s = "UPDATE account SET account_name='" + name + "',birthdate='" + birtDate + "',account_type='" + type
//				+ "',mobile_no='" + mobile + "' where pan_card='" + pan_no + "'; ";
//		manager.Update(s);
//		manager.closeConnection();
//	}

}
