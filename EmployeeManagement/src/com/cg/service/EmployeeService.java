package com.cg.service;

import java.util.ArrayList;

import com.cg.bean.Employee;
import com.cg.exception.EmployeeException;

public interface EmployeeService {
	
	public Employee addEmployee(Employee bean) throws EmployeeException;
	public ArrayList<Employee> getAllEmployees() throws EmployeeException;
	public Employee getEmployeeById(int id)throws EmployeeException;
	public ArrayList<Employee> deleteEmployee(String empId) throws EmployeeException;
	
}
