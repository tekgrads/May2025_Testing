package com.tekgrads.mapper;

import com.tekgrads.dto.EmployeeDTO;
import com.tekgrads.entities.Employee;

public class EmployeeMapper {

    public static EmployeeDTO toDTO(Employee employee) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(employee.getId());
        dto.setName(employee.getName());
        dto.setDepartment(employee.getDepartment());
        dto.setSalary(employee.getSalary());
        return dto;
    }

    public static Employee toEntity(EmployeeDTO dto) {
        Employee employee = new Employee();
        employee.setId(dto.getId());
        employee.setName(dto.getName());
        employee.setDepartment(dto.getDepartment());
        employee.setSalary(dto.getSalary());
        return employee;
    }
}
