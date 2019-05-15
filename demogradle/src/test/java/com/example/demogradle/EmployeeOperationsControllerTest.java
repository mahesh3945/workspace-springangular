package com.example.demogradle;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeOperationsControllerTest 
{
	
	
	@InjectMocks
	private EmployeeOperationsController employeeopertationscontroller;
	
	@Test
	public void list()	
	{
		List<Employee> elist = new ArrayList<Employee>();
		
		elist.add(new Employee(1,"ramesh",10000));
		elist.add(new Employee(2,"rajesh",20000));		
		
		List<Employee> actual=employeeopertationscontroller.retriveEmployee();
		//System.out.println("*************************************"+actual.size()+"\t"+elist.size());
		assertEquals(elist.size(), actual.size());
	}	
	
	@Test
	public void addEmployeeTest()
	{
		Employee emp = new Employee(10,"sushma",500);
		String expected ="record added successfully";
		String actual=employeeopertationscontroller.addEmployee(emp);
		assertEquals(expected, actual);
	}
	
	@Test
	public void addEmployeeTest_withNullObject()
	{
		Employee emp = null;
		String expected ="invalid employee object";
		String actual=employeeopertationscontroller.addEmployee(emp);
		assertEquals(expected, actual);
	}		
	
	@Test
	public void updateValuesTest()
	{
		Employee emp = new Employee();
		emp.setEmployeeId(1);
		emp.setEmployeeName("rr");
		emp.setEmployeeSal(5000);
		
		String expected ="successfully updated";
		String actual=employeeopertationscontroller.updateValues(emp);
		assertEquals(expected, actual);
	}
	@Test
	public void updateValuesTest_withNullObject()
	{
		Employee emp = new Employee();
		emp.setEmployeeId(100);
		emp.setEmployeeName("rr");
		emp.setEmployeeSal(5000);
		String expected ="no record found";
		String actual=employeeopertationscontroller.updateValues(emp);
		assertEquals(expected, actual);
	}		
}
