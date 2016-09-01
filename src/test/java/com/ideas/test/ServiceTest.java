package com.ideas.test;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ideas.ConnectionManager;
import com.ideas.FormService;





public class ServiceTest {
	
	FormService service;
	@Before
	public void setup(){
	 service = new FormService();
	}
	@Test
	public void checkConnection() throws ClassNotFoundException, SQLException{
		ConnectionManager manager  = new ConnectionManager();
		Assert.assertNotNull(manager.connect());
	}

	@Test
	public void shouldInsertData() throws ClassNotFoundException, SQLException{
		Integer preCount = service.getCount("select count(*) as count from healthcare");
		service.saveForm("Rishabh", "125", "124", "healthCare","2013-05-05");
		Integer postCount = service.getCount("select count(*) as count from healthcare");
		Assert.assertEquals(preCount+ 1,postCount,0);
	}

	@Test
	public void SumOfAmmount() throws ClassNotFoundException, SQLException{
		double preAmount = service.getTotalAmount("healthcare", "Rishabh");
		service.saveForm("Rishabh", "125", "124", "healthCare","2013-05-05");
		double postCount = service.getTotalAmount("healthcare", "Rishabh");
		Assert.assertEquals(preAmount+124, postCount,0);
	}
	
	@Test
	public void sqlExceptionTest() throws ClassNotFoundException, SQLException{
		service.getTotalAmount("healthcare", "Rishabh");
		
		
	}

}
