<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%><%@page import="org.afroz.practice.ejb.Student"%>
<%@page import="java.util.List"%>
<%@page import="org.afroz.practice.ejb.remotes.StudentRemote"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Remove Student</title>
</head>
<body>
<%
StudentRemote studentRemote  = (StudentRemote) request.getSession().getAttribute("studentRemote");
List<Student> studentList = studentRemote.listStudent();
 %>
 <h1>List of Students</h1>
 <ul>
 <%
 for(Student s: studentList){
 	out.print("<li>Name: "+s.getsName()+" id: <a href=\\EJBBookClient\\RemoveStudentServ?id="+s.getId()+">"+s.getId()+"</a></li>");
 }
  %>
<div>got business? want to add more students?<br>
click <a href="/EJBBookClient/addStudent.html"> add </a> student.  
  </div></ul>
</body>
</html>