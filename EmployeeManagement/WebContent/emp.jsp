<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1" align="center">
	<tr>
		<th>EmpId</th>
		<th>EmpName</th>
		<th>EmpSal</th>
	</tr>
	<c:forEach var="emp" items="${empList }">
		<tr>
			<td>${emp.empId}</td>
			<td>${emp.empName}</td>
			<td>${emp.empSal}</td>
			<td><a href="EmployeeController?action=delEmp&empId=${emp.empId}">Delete</a></td>
		</tr>
	</c:forEach>
	</table>
	<br>
	<center><input type="button" value="HOME" onclick="location.href='EmployeeController?action=home'"/></center>
	<!-- <a href="EmployeeController?action=home">HOME</a> -->
</body>
</html>