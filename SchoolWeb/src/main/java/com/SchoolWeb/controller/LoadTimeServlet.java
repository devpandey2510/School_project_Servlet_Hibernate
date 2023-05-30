package com.SchoolWeb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.SchoolWeb.entity.Country;


public class LoadTimeServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str="";
		Thread t =null;
		//t.start();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		while(true) {
			Date d = new Date();
			str = d.toString();
			
			try {
				t.sleep(1000);
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			out.println("<html><body>");
		
			out.println(str);
			out.println("</body></html>");
		}
	}

}
