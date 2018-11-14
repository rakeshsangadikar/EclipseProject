package com.cg.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.bean.Employee;
import com.cg.exception.EmployeeException;
import com.cg.service.EmployeeService;
import com.cg.service.EmployeeServiceImpl;

/**
 * Servlet implementation class EmployeeController
 */
@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	EmployeeService service  = new EmployeeServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String qStr = request.getParameter("action");
		HttpSession session = request.getSession(true);
		if("add".equals(qStr)){
			RequestDispatcher dispatch = request.getRequestDispatcher("addEmp.jsp");
			dispatch.forward(request, response);
		}
		
		if("home".equals(qStr)){
			RequestDispatcher dispatch = request.getRequestDispatcher("index.jsp");
			dispatch.forward(request, response);
		}
		
		if("showAll".equals(qStr)){
			try {
				ArrayList<Employee> list = service.getAllEmployees();
				
				if(list.size()!=0){
					session.setAttribute("empList", list);
					RequestDispatcher dispatch = request.getRequestDispatcher("emp.jsp");
					dispatch.forward(request, response);
				}
			} catch (EmployeeException e) {
				
				RequestDispatcher dispatch = request.getRequestDispatcher("error.jsp");
				session.setAttribute("errorMsg", e.getMessage());
				dispatch.forward(request, response);
			}
		
		}
		
		if("showEmpById".equals(qStr)){
			RequestDispatcher dispatch = request.getRequestDispatcher("searchById.jsp");
			dispatch.forward(request, response);
		
		}
		
		if("delEmp".equals(qStr)){
			String empId = request.getParameter("empId");
			try {
				ArrayList<Employee> list = service.deleteEmployee(empId);
				
				if(list.size()!=0){
					session.setAttribute("empList", list);
					RequestDispatcher dispatch = request.getRequestDispatcher("emp.jsp");
					dispatch.forward(request, response);
				}
			} catch (EmployeeException e) {
				
				RequestDispatcher dispatch = request.getRequestDispatcher("error.jsp");
				session.setAttribute("errorMsg", e.getMessage());
				dispatch.forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		String qStr = request.getParameter("action");
		if("addEmp".equals(qStr)){
			String id = request.getParameter("empId");
			String name = request.getParameter("empName");
			String sal = request.getParameter("empSal");
			Employee bean = new Employee();
			bean.setEmpId(Integer.parseInt(id));
			bean.setEmpName(name);
			bean.setEmpSal(Integer.parseInt(sal));
			
			try {
				Employee ref = service.addEmployee(bean);
				if(ref!=null){
					RequestDispatcher dispatch = request.getRequestDispatcher("addEmp.jsp");
					session.setAttribute("newObj", ref);
					dispatch.forward(request, response);
				}
			} catch (EmployeeException e) {
				
				RequestDispatcher dispatch = request.getRequestDispatcher("error.jsp");
				session.setAttribute("errorMsg", e.getMessage());
				dispatch.forward(request, response);
			}
		}
		
		if("searchEmpId".equals(qStr)){
			String empId = request.getParameter("empId");
			try {
				Employee bean = service.getEmployeeById(Integer.parseInt(empId));
				if(bean!=null){
					session.setAttribute("exeObj", bean);
					RequestDispatcher dispatch = request.getRequestDispatcher("searchById.jsp");
					dispatch.forward(request, response);
				}
				else{
					PrintWriter out = response.getWriter();
					out.println("Employee not available with EmpId:" + empId);
				}
					
				}
			catch (EmployeeException e) {
				
				RequestDispatcher dispatch = request.getRequestDispatcher("error.jsp");
				session.setAttribute("errorMsg", e.getMessage());
				dispatch.forward(request, response);
			}
		}
	}

}
