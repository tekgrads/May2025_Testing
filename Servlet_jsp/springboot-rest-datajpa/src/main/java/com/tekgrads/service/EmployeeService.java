package com.tekgrads.service;

import java.util.List;
import java.util.stream.Collectors;

import com.tekgrads.dto.EmployeeDTO;
import com.tekgrads.mapper.EmployeeMapper;

public interface EmployeeService {
	List<EmployeeDTO> getAllEmployees();

	EmployeeDTO getEmployeeById(int id);

	void addEmployee(EmployeeDTO employee);

	void updateEmployee(EmployeeDTO employee);

	void deleteEmployee(int id);

	public List<EmployeeDTO> findByName(String name);

	public List<EmployeeDTO> findByNameAndDepartment(String name, String department);

	public List<EmployeeDTO> findByNameOrderBySalaryDesc(String name);

	public List<EmployeeDTO> findByNameOrderBySalaryDescCustom(String name);
	public List<EmployeeDTO> findByDepartment(String department);

	List<EmployeeDTO> getAllEmployeesOrderBySal();
}
