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


public class LoginServlet1 extends HttpServlet {
	

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		Student st = new Student();
		st.setEmail(email);
		st.setPassword(password);
		
		StudentServiceInterface si = StduentServiceFactory.createobject();
		int i = si.loginStudent(st);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		if(i>0) {
			
			ServletContext sc=getServletContext(); //calling servlet container
			sc.setAttribute("userid",email);       //sharing value of email with servlet container
			
			HttpSession ss=request.getSession(true); //creating session to share information bydefault session will be valid for 30 minutes
			ss.setAttribute("userid",email);
			
			
//  		ServletContext sc = getServletContext();
//			HttpSession ss = request.getSession(true);//calling servlet container
//			ss.setAttribute("userid", email);//sharing value of email with other servlets
		   
		   out.println("<br> Welcome " + email);
		 
		   out.println("<br><a href=ViewprofileServlet>view Profile</a>");
		   out.println("<br><a href=EditProfileServlet>Edit Profile</a>");
		   out.println("<br><a href=DeleteProfileServlet>Delet Profile</a>");
		   out.println("<br><a href=searchprofile.html>Search Profile</a>");
		   out.println("<br><a href=ViewAllServlet>ViewAll Profile</a>");
		   out.println("<br><a href=TimeLineServlet>TimeLine</a>");
		   out.println("<br><a href=logoutServlet>Logout</a>");
		}
		else {
			  out.println("<br><a href=loginpage.html>Try Again</a>");
		}
		out.println("</body></html>");
	}
	}


