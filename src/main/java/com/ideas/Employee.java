package com.ideas;

public class Employee {
	private String username;
	private String employeeID;
	private String name;
	private String emailId;
	private String mobile = null;
	private String telephone = null;
	private String employeeType;
	private String authorized;
	private String department;
	private String designation;
	// public Employee(String employeeID, String name, String email) {
	// this.employeeID = employeeID;
	// this.name = name;
	// this.emailId = email;
	// }
	//

	public Employee(String employeeID, String name, String emailId, String telephone, String employeeType,
			String department, String designation) {
		this.employeeID = employeeID;
		this.name = name;
		this.emailId = emailId;
		this.telephone = telephone;
		this.employeeType = employeeType;
		this.authorized = "Not Authorized";
		this.department = department;
		this.designation = designation;
	}

	public String getDepartment() {
		return department;
	}

	public String getDesignation() {
		return designation;
	}

	public String getEmployeeType() {
		return employeeType;
	}

	public String getAuthorized() {
		return authorized;
	}

	public void setAuthorized(String authorized) {
		this.authorized = authorized;
	}

	public String getUsername() {
		return username;
	}

	@Override
	public String toString() {
		return "Employee [username=" + username + ", employeeID=" + employeeID + ", name=" + name + ", emailId="
				+ emailId + ", mobile=" + mobile + ", telephone=" + telephone + ", employeeType=" + employeeType
				+ ", authorized=" + authorized + ", department=" + department + ", designation=" + designation + "]";
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public String getName() {
		return name;
	}

	public String getEmailId() {
		return emailId;
	}

	public String getMobile() {
		return mobile;
	}

	public String getAddress() {
		return telephone;
	}

}