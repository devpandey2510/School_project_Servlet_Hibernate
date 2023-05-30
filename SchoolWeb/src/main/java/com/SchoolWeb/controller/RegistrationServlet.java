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


public class RegistrationServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String Rpassword=request.getParameter("password2");
		int admission= Integer.parseInt(request.getParameter("admission_no"));
		String address =request.getParameter("address1");
		
		Student st = new Student();
		st.setName(name);
		st.setEmail(email);
		st.setPassword(password);
        st.setRpassword(Rpassword);
        st.setAdmission(admission);
       st.setAddress(address);
		
		StudentServiceInterface si = StduentServiceFactory.createobject();
		int i = si.registerStudent(st);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		if(i>0) {
		   out.println("<br> Your name is " + name);
		   out.println("<br> Your email is " + email);
		   out.println("<br> Your password is " + password);
		   out.println("<br> Your reentered password is " + Rpassword);
		   out.println("<br> Your name is " + admission);
		   out.println("<br> Your name is " + address);
		   out.println("Want to login");
		   out.println("<br><a href=loginpage.html>Continue...</a>");
		}
		else {
			out.println("something went wrong");
		}
		out.println("</body></html>");
	}

}
