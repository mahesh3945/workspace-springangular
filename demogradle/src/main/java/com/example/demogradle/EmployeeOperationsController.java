package com.example.demogradle;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeOperationsController
{
	private  List<Employee> employeeList = new ArrayList<Employee>();
	
	public EmployeeOperationsController() {
	employeeList.add(new Employee(1,"ramesh",10000));
	employeeList.add(new Employee(2,"mahesh",2000));
	}
	@RequestMapping(value="/employee/add",method=RequestMethod.POST,consumes="application/json",produces="text/plain")
	public String addEmployee(@RequestBody Employee employeeData) {		
		if(employeeData!=null) {
		employeeList.add(employeeData);
		return "record added successfully";	
		}
		else
		{
			return "invalid employee object";
		}
	}
	
	@RequestMapping(value="/employee/list",method=RequestMethod.GET,produces="application/json")
	public List<Employee> retriveEmployee()
	{
		return employeeList;
		
	}
	@RequestMapping(value="/employee/update", method=RequestMethod.PUT,produces="application/json")
	public String updateValues(@RequestBody Employee employeeData)	
	{
		boolean status=false;
			for (Employee employee : employeeList) {
				if(employee.getEmployeeId()==employeeData.getEmployeeId())
				{
				employee.setEmployeeName(employeeData.getEmployeeName());
				employee.setEmployeeSal(employeeData.getEmployeeSal());
				status=true;
				break;
				}
			}						
			if(status) {
				return "successfully updated";
			}
			else {
				return "no record found";
			}
	}
	@RequestMapping(value="/employee/delete/{id}", method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") int eid)	
	{
		boolean status=false;
			for (Employee employee : employeeList) {
				if(employee.getEmployeeId()==eid)
				{
				employeeList.remove(employee);
				status=true;
				break;
				}
			}
						
			if(status) {
				return "successfully deleted";
			}
			else {
				return "no record found";
			}
	}
	@RequestMapping(value="/employee/get/{id}", method=RequestMethod.GET,produces="application/json")
	public Employee retriveData(@PathVariable("id") int eid )	
	{
		
			for (Employee employee : employeeList) {
				if(employee.getEmployeeId()==eid)
				{
					return employee;
					//System.out.println("Git Practice");
				}
			}			
			return null;
			
	}
}
