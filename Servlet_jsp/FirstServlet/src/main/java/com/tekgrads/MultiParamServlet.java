package com.tekgrads;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SampleServlet3
 */
@WebServlet("/MultiParamServlet")
public class MultiParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MultiParamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html"); // Set content type for HTML response
		response.getWriter().println("<html><body>");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String salary = request.getParameter("salary");
		String city = request.getParameter("city");
		String prof = request.getParameter("prof");
		String project = request.getParameter("project");
		String[] tasks = request.getParameterValues("tasks");

		
		// Display details in a formatted way
        response.getWriter().println("<h2>User Details</h2>");
        response.getWriter().println("<p><b>Name:</b> " + name + "</p>");
        response.getWriter().println("<p><b>Age:</b> " + age + "</p>");
        response.getWriter().println("<p><b>Salary:</b> " + salary + "</p>");
        response.getWriter().println("<p><b>City:</b> " + city + "</p>");
        response.getWriter().println("<p><b>Profession:</b> " + prof + "</p>");
        response.getWriter().println("<p><b>Selected Project:</b> " + project + "</p>");

        // Handling multiple selected tasks
        response.getWriter().println("<p><b>Assigned Tasks:</b></p>");
        if (tasks != null && tasks.length > 0) {
            response.getWriter().println("<ul>");
            for (String task : tasks) {
                response.getWriter().println("<li>" + task + "</li>");
            }
            response.getWriter().println("</ul>");
        } else {
            response.getWriter().println("<p>No tasks selected.</p>");
        }

        response.getWriter().println("</body></html>");

	}

}