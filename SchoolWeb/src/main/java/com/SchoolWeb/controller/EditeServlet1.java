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

/**
 * Servlet implementation class EditeServlet1
 */
public class EditeServlet1 extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ss = request.getSession(true);
		Object oo = ss.getAttribute("userid");
		String email = oo.toString();
		
		Student st = new Student();
		st.setEmail(email);
		
		String name=request.getParameter("nm");
		String password=request.getParameter("pw");
		String Rpassword=request.getParameter("rpw");
		int admission= Integer.parseInt(request.getParameter("adm"));
		String address =request.getParameter("adrs");
		
		st.setName(name);
		st.setPassword(password);
        st.setRpassword(Rpassword);
        st.setAdmission(admission);
        st.setAddress(address);
		
		StudentServiceInterface si = StduentServiceFactory.createobject();
		int i = si.EditProfileStudent(st);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html><body><center>");
		if(i>0) {
			out.println("Hello"+name);
		   out.println("<br>Your profile has been edited successfully");
//		   try {
//			   Thread.sleep(5000);
//		   }
//		   catch(Exception e) {
//			   e.printStackTrace();
//		   }
//		   response.sendRedirect("LoginServlet1");
		}
		else {
			out.println("something went wrong");
		}
		out.println("</center></body></html>");

	}

}
