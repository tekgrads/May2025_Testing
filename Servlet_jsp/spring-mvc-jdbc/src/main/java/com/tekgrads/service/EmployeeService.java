package com.tekgrads.service;

import java.util.List;

import com.tekgrads.dto.EmployeeDTO;

public interface EmployeeService {
	List<EmployeeDTO> getAllEmployees();

	EmployeeDTO getEmployeeById(int id);

	void addEmployee(EmployeeDTO employee);

	void updateEmployee(EmployeeDTO employee);

	void deleteEmployee(int id);
}
