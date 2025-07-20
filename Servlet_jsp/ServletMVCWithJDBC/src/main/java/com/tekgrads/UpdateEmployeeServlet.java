package com.tekgrads;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/UpdateEmployeeServlet")
public class UpdateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateEmployeeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String id =  request.getParameter("id");
			EmployeeService service = new EmployeeService();
			Employee employee = service.getEmployee(Integer.parseInt(id));
			request.setAttribute("emp", employee);
			request.getRequestDispatcher("editEmployee.jsp").forward(request, response);

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmployeeService service = new EmployeeService();
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String salary = request.getParameter("salary");
		String city = request.getParameter("city");
		String prof = request.getParameter("prof");
		String project = request.getParameter("project");
		String[] tasks = request.getParameterValues("tasks");
		String id =  request.getParameter("id");

		// Creating Employee object and setting values using setters
		Employee employee = new Employee();
		employee.setId(Integer.parseInt(id));
		employee.setName(name);
		employee.setAge(Integer.parseInt(age));
		employee.setSalary(Double.parseDouble(salary));
		employee.setCity(city);
		employee.setProf(prof);
		employee.setProject(project);
		employee.setTasks(tasks);
		service.updateEmployee(employee);
		response.sendRedirect("DisplayEmployeeServlet");

	}


}