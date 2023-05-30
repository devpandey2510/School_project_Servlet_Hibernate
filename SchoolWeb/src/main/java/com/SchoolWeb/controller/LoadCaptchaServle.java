package com.SchoolWeb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.SchoolWeb.entity.Country;


public class LoadCaptchaServle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         int rr=(int)((Math.random())*1000);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		out.println("<input type=text value="+rr+"id=c disabled>");
		out.println("<button type=button onclick=loadCaptcha()>Refresh</button>");
		out.println("<br>Enter the captcha value<input type=text id=cc1>");
		out.println("<button type=button onclick=ValidateCaptcha()>Validate</button>");
		out.println("</body></html>");
	}
	
}


