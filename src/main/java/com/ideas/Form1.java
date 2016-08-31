package com.ideas;

public class Form1 {
	Employee employee;
	String hospital;
	String description;
	String date;
	String amount;
	public Form1(Employee employee, String hospital, String description, String date, String amount) {
		this.employee = employee;
		this.hospital = hospital;
		this.description = description;
		this.date = date;
		this.amount = amount;
	}
	public Employee getEmployee() {
		return employee;
	}
	public String getHospital() {
		return hospital;
	}
	public String getDescription() {
		return description;
	}
	public String getDate() {
		return date;
	}
	public String getAmount() {
		return amount;
	}
	
}
