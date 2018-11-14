<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Welcome To Employee Management</h2>

	<br>
	<input type="button" value="Add Employee" onclick="location.href='EmployeeController?action=add'"/>
	<!-- <a href="EmployeeController?action=add">Add Employee</a> -->
	&nbsp;&nbsp;&nbsp;
	<input type="button" value="Show All" onclick="location.href='EmployeeController?action=showAll'"/>
	<!-- <a href="EmployeeController?action=showAll">Show All Employee</a> -->
	&nbsp;&nbsp;&nbsp;
	<input type="button" value="Search By Id" onclick="location.href='EmployeeController?action=showEmpById'"/>
	<!-- <a href="EmployeeController?action=showEmpById">Search Employee By Id</a> -->
</body>
</html>