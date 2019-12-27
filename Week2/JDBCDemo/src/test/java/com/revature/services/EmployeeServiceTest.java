package com.revature.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.revature.repositories.EmployeeDAOImpl;

public class EmployeeServiceTest {
	
	private EmployeeService es;
	
	@Mock
	private EmployeeDAOImpl mockedDao;

	@Before
	public void setUp() throws Exception {
		es = new EmployeeService(mockedDao);
	}

	@Test
	public void testFindAll() {
		es.findAll();
		verify(mockedDao, times(1)).findAll();
	}

	@Test
	public void testLoginCorrect() {
		assertTrue(es.login("correctUsername", "correctPassword"));
	}
	
	@Test
	public void testLoginWrongUsername() {
		assertFalse(es.login("wrongUsername", "correctPassword"));
	}
	
	@Test
	public void testLoginWrongPassword() {
		assertFalse(es.login("correctUsername", "wrongPassword"));
	}
}
