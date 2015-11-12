package org.afroz.practice.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.afroz.practice.ejb.Student;
import org.afroz.practice.ejb.remotes.StudentRemote;

/**
 * Servlet implementation class StudentClient
 */
public class StudentClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		try{
/*			Context contex = new InitialContext();
			StudentRemote studentRemote = (StudentRemote) contex.lookup("Student/remote");*/
			StudentRemote studentRemote  = (StudentRemote) request.getSession().getAttribute("studentRemote");
			List<Student> students =studentRemote.listStudent();
			out.println("<h1>List of Students</h1><ul>");
			for(Student s : students){
				out.println("<li>"+s+"</li>");
			}
			out.print("</ul>");
			out.println("Remove students <a href=\\EJBBookClient\\RemoveStudent.jsp> here </a>");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
