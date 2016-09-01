package com.ideas.test;

import org.junit.Assert;
import org.junit.Test;

import com.ideas.Employee;

public class EmployeeTest {

	@Test
	public void sameEmployeeTest() {
		Employee employee = new Employee("1", "Rishabh", "rishab@ideas", "0-2140", "Contract", null, null);
		Assert.assertEquals(employee, new Employee(employee.getEmployeeID(), employee.getName(), employee.getEmailId(), employee.getTelephone(), employee.getEmployeeType(), employee.getDepartment(), employee.getDesignation()));

	}
	
	@Test
	public void differentEmployeeTest() {
		Employee employee = new Employee("1", "Rishabh", "rishab@ideas", "0-2140", "Contract", null, null);
		Assert.assertNotEquals(employee, new Employee("2", employee.getName(), employee.getEmailId(), employee.getTelephone(), employee.getEmployeeType(), employee.getDepartment(), employee.getDesignation()));

	}

}
