package com.tekgrads.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tekgards.dao.EmployeeDAO;
import com.tekgrads.dto.EmployeeDTO;
import com.tekgrads.service.EmployeeService;

@Service
@Qualifier("employeeService")
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeDAO employeeDAO;
	
	@Override
	public List<EmployeeDTO> getAllEmployees() {
		return employeeDAO.getAllEmployees();
	}

	@Override
    public EmployeeDTO getEmployeeById(int id) {
        return employeeDAO.getEmployeeById(id);
    }

    @Override
    public void addEmployee(EmployeeDTO employee) {
        employeeDAO.addEmployee(employee);
    }

    @Override
    public void updateEmployee(EmployeeDTO employee) {
        employeeDAO.updateEmployee(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
    }

}
