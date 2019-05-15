package com.example.demogradle;

public class Employee
{
private int employeeId;
private String employeeName;
private float employeeSal;
public Employee()
{
	employeeId=0;
	employeeName="";
	employeeSal=0.0f;
}
public Employee(int employeeId, String employeeName, float employeeSal) {

	this.employeeId = employeeId;
	this.employeeName = employeeName;
	this.employeeSal = employeeSal;
}
public int getEmployeeId() {
	return employeeId;
}
public void setEmployeeId(int employeeId) {
	this.employeeId = employeeId;
}
public String getEmployeeName() {
	return employeeName;
}
public void setEmployeeName(String employeeName) {
	this.employeeName = employeeName;
}
public float getEmployeeSal() {
	return employeeSal;
}
public void setEmployeeSal(float employeeSal) {
	this.employeeSal = employeeSal;
}

}
