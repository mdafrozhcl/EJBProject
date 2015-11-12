package org.afroz.practice.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.afroz.practice.ejb.Student;
import org.afroz.practice.ejb.remotes.StudentRemote;

/**
 * Servlet implementation class RegisterStudent
 */
public class RegisterStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterStudent() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		response.setContentType("text/html");
		StudentRemote studentRemote = null;
		PrintWriter out = response.getWriter();
		String name = request.getParameter("sname");
		int age = Integer.parseInt(request.getParameter("age"));
		try {
			Context contex = new InitialContext();
			if (request.getSession().getAttribute("studentRemote") == null) {
				studentRemote = (StudentRemote) contex.lookup("Student/remote");
				HttpSession session = request.getSession();
				session.setAttribute("studentRemote", studentRemote);
			}else{
				studentRemote = (StudentRemote) request.getSession().getAttribute("studentRemote");
			}
				Student s = new Student(name, age);
				studentRemote.addStudent(s);
				out.println("Added new Student" + "<ul><li>" + s + "</li></ul>");
				out.println("Click <a href='/EJBBookClient/StudentClient'>here</a> to see the list of students");
			
		} catch (Exception e) {

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
