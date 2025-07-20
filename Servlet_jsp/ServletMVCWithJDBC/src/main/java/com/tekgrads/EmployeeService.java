package com.tekgrads;

import java.util.List;

public class EmployeeService {
    private EmployeeDAO employeeDAO = new EmployeeDAO();

    public int addEmployee(Employee employee) {
        return employeeDAO.saveEmployee(employee);
    }

    public Employee getEmployee(int id) {
        return employeeDAO.getEmployeeById(id);
    }
    
    public List<Employee> getEmployees() {
        return employeeDAO.getEmployees();
    }
    
    public boolean updateEmployee(Employee employee) {
        return employeeDAO.updateEmployee(employee);
    }
    
    public boolean deleteEmployee(int id) {
        return employeeDAO.deleteEmployee(id);
    }
}