package com.cg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;

import com.cg.bean.Employee;
import com.cg.exception.EmployeeException;
import com.cg.util.DBUtil;

public class EmployeeDaoImpl implements EmployeeDao {
	
	Connection conn;
	
	public EmployeeDaoImpl(){
		conn = DBUtil.getConnect();
		
	}

	@Override
	public Employee addEmployee(Employee bean) throws EmployeeException {
		
		//String sql = "INSERT INTO emp_detail VALUES(?, ?, ?)";
		String sql = "INSERT INTO emp_detail VALUES("+bean.getEmpId()+", '"+bean.getEmpName()+"', "+bean.getEmpSal()+")";
		
		try {
			/*PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, bean.getEmpId());
			stmt.setString(2, bean.getEmpName());
			stmt.setInt(3, bean.getEmpSal());
			stmt.executeUpdate();*/
			Statement st = conn.createStatement();
			int result = st.executeUpdate(sql);
			return bean;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Employee> getAllEmployees() throws EmployeeException {
		
		String sql = "SELECT * FROM emp_detail";
		ArrayList<Employee> list  = new ArrayList<Employee>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				Employee bean =  new Employee();
				bean.setEmpId(rs.getInt(1));
				bean.setEmpName(rs.getString(2));
				bean.setEmpSal(rs.getInt(3));
				list.add(bean);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public ArrayList<Employee> deleteEmployee(String empId)
			throws EmployeeException {
		
		
		String sql = "SELECT * FROM emp_detail";
		String sql1 = "DELETE FROM emp_detail WHERE empId="+empId;
		ArrayList<Employee> list  = new ArrayList<Employee>();
		try {
			Statement stmt = conn.createStatement();
			stmt.executeQuery(sql1);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				Employee bean =  new Employee();
				bean.setEmpId(rs.getInt(1));
				bean.setEmpName(rs.getString(2));
				bean.setEmpSal(rs.getInt(3));
				list.add(bean);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Employee getEmployeeById(int id) throws EmployeeException {
		
		String sql = "SELECT * FROM emp_detail WHERE empId="+id;
		Employee bean=null;
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				bean = new Employee();
				bean.setEmpId(rs.getInt(1));
				bean.setEmpName(rs.getString(2));
				bean.setEmpSal(rs.getInt(3));
			}
			return bean;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
