<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="EmployeeController?action=searchEmpId" method="post">
		Enter Employee Id: <input type="text" name="empId"/> &nbsp;
		<input type="submit" value="Search"/>&nbsp;&nbsp;
		<input type="button" value="HOME" onclick="location.href='EmployeeController?action=home'"/>
	</form><br><br>
	SEARCH RESULT:<br>
	Employee Id: ${exeObj.empId }<br>
	Employee Name: ${exeObj.empName }<br>
	Employee Salary: ${exeObj.empSal }<br>
	<br>
	<!-- <a href="EmployeeController?action=home">HOME</a> -->
</body>
</html>