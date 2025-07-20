package com.tekgrads;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class AddServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Integer num1 = Integer.parseInt(req.getParameter("num1"));
		Integer num2 = Integer.parseInt(req.getParameter("num2"));
		Integer result = num1+num2;
//		RequestDispatcher rd = req.getRequestDispatcher("/sq");
		req.setAttribute("result", result);
//		rd.forward(req, res);
		Cookie cookie1 = new Cookie("num1", num1.toString());
		Cookie cookie2 = new Cookie("num2", num2.toString());
		Cookie cookie3 = new Cookie("result", result.toString());
		res.addCookie(cookie1);
		res.addCookie(cookie2);
		res.addCookie(cookie3);
		res.sendRedirect("sq");
	}
}
