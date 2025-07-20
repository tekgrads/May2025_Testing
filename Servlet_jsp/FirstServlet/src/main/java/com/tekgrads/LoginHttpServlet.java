package com.tekgrads;

import java.io.IOException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/loginHttp")
public class LoginHttpServlet extends HttpServlet{	
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String userName = req.getParameter("username");
		String password = req.getParameter("password");
		//res.getWriter().print("ServetOne is running"+count++);
		
		res.getWriter().print("Hello "+ userName +" welcome from post");
		
		System.out.println("Password is "+ password);
       
    }
	
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String userName = req.getParameter("username");
		String password = req.getParameter("password");
		//res.getWriter().print("ServetOne is running"+count++);
		
		res.getWriter().print("Hello "+ userName +" welcome from Get");
		
		System.out.println("Password is "+ password);
       
    }
	
	
	
}
