package com.cg.service;

import java.util.ArrayList;

import com.cg.bean.Employee;
import com.cg.dao.EmployeeDao;
import com.cg.dao.EmployeeDaoImpl;
import com.cg.exception.EmployeeException;

public class EmployeeServiceImpl implements EmployeeService {
	
	EmployeeDao dao = new EmployeeDaoImpl();

	@Override
	public Employee addEmployee(Employee bean) throws EmployeeException {
		// TODO Auto-generated method stub
		return dao.addEmployee(bean);
	}

	@Override
	public ArrayList<Employee> getAllEmployees() throws EmployeeException {
		// TODO Auto-generated method stub
		return dao.getAllEmployees();
	}

	@Override
	public Employee getEmployeeById(int id) throws EmployeeException {
		// TODO Auto-generated method stub
		return dao.getEmployeeById(id);
	}

	@Override
	public ArrayList<Employee> deleteEmployee(String empId)
			throws EmployeeException {
		// TODO Auto-generated method stub
		return dao.deleteEmployee(empId);
	}

}
