package com.SchoolWeb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.SchoolWeb.entity.Student;
import com.SchoolWeb.service.StduentServiceFactory;
import com.SchoolWeb.service.StudentServiceInterface;


public class SearchProfileServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("searchname");
		Student st = new Student();
		st.setName(name);
		
		StudentServiceInterface si = StduentServiceFactory.createobject();
		ArrayList<Student> st1 = si.SearchPofileStudent(st);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		//out.println("<br>Numbers of profile with this name are" + st1.size());
		for(Student st2: st1) {
			
		   out.println("<br>Name is " + st2.getName());
		   out.println("<br>Email is " + st2.getEmail());
		   //out.println("<br>password is " + st2.getPassword());
		   //out.println("<br>reentered password is " + st2.getRpassword());
		   out.println("<br>Admission no. is " + st2.getAdmission());
		   out.println("<br>Address is " + st2.getAddress());
		  
		}
		
		out.println("</body></html>");
		
	}

}
