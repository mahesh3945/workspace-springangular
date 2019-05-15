package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringRestController
{
	@RequestMapping(method=RequestMethod.GET,value="/getName")
	public String readName()
	{
		return "Get Method Name";
	}
	@RequestMapping(method=RequestMethod.GET,value="/getxml",produces="text/xml")
	public String xmlformat()
	{
		return "<messagae>xml formatt</message>";
	}
	@RequestMapping(method=RequestMethod.GET,value="/empdetails", produces="application/json")
	public Employee getEmpdetails()
	{
		Employee employee = new Employee();
		employee.setEmpNo(11);
		employee.setEmpName("mahesh");
		employee.setEmpSal(50000);
		return employee;
	}
}
