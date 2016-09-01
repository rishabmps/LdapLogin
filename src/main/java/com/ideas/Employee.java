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

	public String getTelephone() {
		return telephone;
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

	@Override
	public boolean equals(Object arg0) {
		Employee employee = (Employee) arg0;
		if (this.employeeID == employee.getEmployeeID() && this.department == employee.getDepartment()
				&& this.designation == employee.getDesignation() && this.emailId == employee.getEmailId()
				&& this.employeeType == employee.getEmployeeType() && this.mobile == employee.getMobile()
				&& this.name == employee.getName() && this.authorized == this.getAuthorized()
				&& this.telephone == employee.getTelephone() && this.username == employee.getUsername()) {

			return true;
		} else {

			return false;
		}

	}
}