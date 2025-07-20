package com.tekgrads;


import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(
		urlPatterns = "/SessionDemo", initParams = { @WebInitParam(name = "name", value = "Default Username")}
		)
public class SessionDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() {
		System.out.println("SessionDemo go created");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType(" text / html ");
		PrintWriter writer = response.getWriter();

		String userName = request.getParameter("name");
		HttpSession session = request.getSession();
		ServletContext context = request.getServletContext();
		if (userName != null && !userName.isEmpty()) {
			session.setAttribute("savedUserName", userName);
			context.setAttribute("savedUserName", userName);
		}

		writer.println(" Request parameter has username as " + userName);
		writer.println(" Session parameter has username as " + (String) session.getAttribute("savedUserName"));
		writer.println(" Context parameter has username as " + (String) context.getAttribute("savedUserName"));
		writer.println(" Config parameter has default username as "
				+ (String) this.getServletConfig().getInitParameter("name"));	
		
		
	}

	
}
