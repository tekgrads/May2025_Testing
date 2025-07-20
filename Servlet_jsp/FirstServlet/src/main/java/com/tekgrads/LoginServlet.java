package com.tekgrads;

import java.io.IOException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class LoginServlet extends GenericServlet{	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		String userName = req.getParameter("username");
		String password = req.getParameter("password");
		//res.getWriter().print("ServetOne is running"+count++);
		
		res.getWriter().print("Hello "+ userName +" welcome ");
		
		System.out.println("Password is "+ password);
		
	}

}
