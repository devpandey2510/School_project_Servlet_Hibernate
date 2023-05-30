package com.SchoolWeb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.SchoolWeb.entity.Student;
import com.SchoolWeb.service.StduentServiceFactory;
import com.SchoolWeb.service.StudentServiceInterface;


public class ViewprofileServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		ServletContext sc = getServletContext();
//		Object oo = sc.getAttribute("userid");
//		String email = oo.toString();
		
		HttpSession ss = request.getSession(true);
		Object oo = ss.getAttribute("userid");
		String email = oo.toString();
		
		Student st = new Student();
		st.setEmail(email);
		
		StudentServiceInterface si = StduentServiceFactory.createobject();
		Student st1 = si.ViewPofileStudent(st);
		

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		if(st1!=null) {
		   out.println("<br> Your name is " + st1.getName());
		   out.println("<br> Your email is " + st1.getEmail());
		   out.println("<br> Your password is " + st1.getPassword());
		   out.println("<br> Your reentered password is " + st1.getRpassword());
		   out.println("<br> Your admission no. is " + st1.getAdmission());
		   out.println("<br> Your address is " + st1.getAddress());
		   out.println("Want to login");
		   out.println("<br><a href=loginpage.html>Continue...</a>");
		}
		else {
			out.println("something went wrong");
		}
		out.println("</body></html>");
	}

}
