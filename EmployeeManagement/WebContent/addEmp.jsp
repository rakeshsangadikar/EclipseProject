<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="EmployeeController?action=addEmp" method="post">
	<table>
		<caption>Add Employees</caption>
		<tr>
		<td>Enter Employee Id:</td>
		<td><input type="text" name="empId"/><br></td>
		</tr>
		<tr>
		<td>Enter Employee Name:</td>
		<td><input type="text" name="empName"/><br></td>
		</tr>
		<tr>
		<td>Enter Employee Salary:</td>
		<td><input type="text" name="empSal"/><br></td>
		</tr>
		<tr>
		<td></td>
		<td><input type="submit" value="Add Employee" />
		&nbsp;&nbsp;
		<input type="button" value="HOME" onclick="location.href='EmployeeController?action=home'"/></td>
		</tr>
		</table>
		<br>
		Successfully inserted in database<br>
		Employee Id : ${newObj.empId}<br>
		Employee Name : ${newObj.empName}<br>
		Employee Salary : ${newObj.empSal}
	
	</form>
	<br>
	<!-- <a href="EmployeeController?action=home">HOME</a> -->
</body>
</html>