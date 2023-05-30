package com.SchoolWeb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.SchoolWeb.entity.Student;
import com.SchoolWeb.service.StduentServiceFactory;
import com.SchoolWeb.service.StudentServiceInterface;

public class CheckEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("emailvalue");

		Student st = new Student();
		st.setEmail(email);
		
		StudentServiceInterface si = StduentServiceFactory.createobject();
		int i = si.checkEmailService(st);
		

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		if(i>0) {
		   out.println("<font color=red>This Email has already been taken </font>");
		}
		else {
			out.println("<font color=green>Valid Email</font>");
		}
		out.println("</body></html>");
	}

}
