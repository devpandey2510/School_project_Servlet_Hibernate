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

public class EditProfileServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession ss = request.getSession(true);
		Object oo = ss.getAttribute("userid");
		String email = oo.toString();
		
		Student st = new Student();
		st.setEmail(email);
		
		StudentServiceInterface si = StduentServiceFactory.createobject();
		Student st1 = si.ViewPofileStudent(st);
		

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html><body><center>");
		
		   out.println("<br><h1> Edit page</h1> ");
		   out.println("<br> <form method=post action=EditeServlet1> ");
		   out.println("<br> Name:<input type=text name=nm value="+st1.getName()+">");
		   out.println("<br> Email:<input type=text name=pw value=" + st1.getEmail()+"disabled>");
		   out.println("<br> Password:<input type=text name=pw value=" + st1.getPassword()+">");
		   out.println("<br> Password:<input type=text name=rpw value=" + st1.getRpassword()+">");
		   out.println("<br>  Admission:<input type=text name=adm value="+ st1.getAdmission()+">");
		   out.println("<br>  Address:<input type=text name=adrs value=" + st1.getAddress()+">");
		   out.println("<br> <input type=submit name=btn value=update");
		   out.println("</form>");
		  
		out.println("</center></body></html>");
	}
}


