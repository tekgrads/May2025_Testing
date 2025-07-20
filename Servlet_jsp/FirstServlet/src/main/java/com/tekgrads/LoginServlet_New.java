package com.tekgrads;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet_New")
public class LoginServlet_New extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginService service = new LoginService();
		
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		boolean isLoginSuccess = service.authenticate(userId, password);	
		if(isLoginSuccess) {
			User user = service.getUser(userId);
			request.getSession().setAttribute("user", user);
			//response.sendRedirect("success.jsp");
			
			//request.setAttribute("user", user);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("success.jsp");
			requestDispatcher.forward(request, response);
		} else {
			response.sendRedirect("Login.jsp");
		}
		
		
	}

	
}