package com.ideas.test;

import org.junit.Assert;
import org.junit.Test;

import com.ideas.Employee;

public class EmployeeTest {

	@Test
	public void createCorrectEmployee() {
		Employee employee = new Employee("1", "Rishabh", "rishab@ideas", "0-2140", "Contract", null, null);
		Assert.assertEquals("Rishabh", employee.getName());

	}

}
