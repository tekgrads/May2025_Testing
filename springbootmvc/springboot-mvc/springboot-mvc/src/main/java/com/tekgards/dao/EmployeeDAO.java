package com.tekgards.dao;


import java.util.List;

import com.tekgrads.dto.EmployeeDTO;

public interface EmployeeDAO {
    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO getEmployeeById(int id);
    void addEmployee(EmployeeDTO employee);
    void updateEmployee(EmployeeDTO employee);
    void deleteEmployee(int id);
}

