package com.tekgrads;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/sq")
public class SqServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		Integer result = (Integer)req.getAttribute("result");
//		Integer num1 = Integer.parseInt(req.getParameter("num1"));
//		Integer num2 = Integer.parseInt(req.getParameter("num2"));
		Integer result = 0;
		Integer num1 = 0;
		Integer num2 = 0;
		
		for (Cookie cookie : req.getCookies()) {
	        if ("num1".equals(cookie.getName())) {
	             num1 = Integer.parseInt(cookie.getValue());
	            // Do something with value
	        } else if("num2".equals(cookie.getName())) {
	        	 num2 = Integer.parseInt(cookie.getValue());
	        } else if("result".equals(cookie.getName())) {
	        	result =  Integer.parseInt(cookie.getValue());
	        }
	    }
		Integer sq = result*result;
		res.getWriter().print("Hello the square of "+num1+" "+num2+" is" + sq);
		
		
		
			

	}
}
