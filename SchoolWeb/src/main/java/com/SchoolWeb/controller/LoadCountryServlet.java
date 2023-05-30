package com.SchoolWeb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.SchoolWeb.entity.Country;
import com.SchoolWeb.entity.Student;
import com.SchoolWeb.service.StduentServiceFactory;
import com.SchoolWeb.service.StudentServiceInterface;


public class LoadCountryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		StudentServiceInterface si = StduentServiceFactory.createobject();
		List<Country> i= si.LoadCountryService();
		

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		out.println("<select>");
		for(Country cc:i) {
		   out.println("<option>"+cc.getCountryName()+"</option>");
		}
		
		out.println("</select>");
		out.println("</body></html>");
	}
	}


