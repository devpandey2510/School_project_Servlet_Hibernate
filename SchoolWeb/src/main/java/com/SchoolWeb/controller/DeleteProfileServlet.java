package com.SchoolWeb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.SchoolWeb.entity.Student;
import com.SchoolWeb.service.StduentServiceFactory;
import com.SchoolWeb.service.StudentServiceInterface;


public class DeleteProfileServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ss = request.getSession(true);
		Object oo = ss.getAttribute("userid");
		String email = oo.toString();
		
		Student st = new Student();
		st.setEmail(email);
		
		StudentServiceInterface si = StduentServiceFactory.createobject();
		int i = si.DeletePofileStudent(st);
		

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		  if(i>0) {
		    	out.println("profile deleted");
		    }
		    else {
		    	out.println("profile could not be deleted");
		    }
	}

}
