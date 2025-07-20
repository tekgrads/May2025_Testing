package com.tekgrads;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/sqSessionDemo")
public class SqServlet_Session extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession sn = req.getSession();
		
		Integer result = (Integer)sn.getAttribute("result");
		Integer num1 = (Integer)(sn.getAttribute("num1"));
		Integer num2 = (Integer)(sn.getAttribute("num2"));
		
		Integer sq = result*result;
		res.getWriter().print("Hello the square of "+num1+" "+num2+" is" + sq);
		
		
		
			

	}
}
