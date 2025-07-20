package com.tekgrads;

import java.io.IOException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class ServletOne extends GenericServlet{
	int count=0;
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		//res.getWriter().print("ServetOne is running"+count++);
		
		res.getWriter().print("<h1>Hello "+ name +" welcome</h1>");
		
	}

}
