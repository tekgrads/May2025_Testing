package com.tekgrads.dao.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tekgards.dao.EmployeeDAO;
import com.tekgrads.dto.EmployeeDTO;
import com.tekgrads.rowmapper.EmployeeRowMapper;

@Repository
@Qualifier("employeeDAO")
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
           

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        String sql = "SELECT * FROM employees";
        return jdbcTemplate.query(sql, new EmployeeRowMapper());
    }

    @Override
    public EmployeeDTO getEmployeeById(int id) {
        String sql = "SELECT * FROM employees WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new EmployeeRowMapper(), id);
    }

    @Override
    public void addEmployee(EmployeeDTO employee) {
        String sql = "INSERT INTO employees ( name, department, salary) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, employee.getName(), employee.getDepartment(), employee.getSalary());
    }

    @Override
    public void updateEmployee(EmployeeDTO employee) {
        String sql = "UPDATE employees SET name = ?, department = ?, salary = ? WHERE id = ?";
        jdbcTemplate.update(sql, employee.getName(), employee.getDepartment(), employee.getSalary(), employee.getId());
    }

    @Override
    public void deleteEmployee(int id) {
        String sql = "DELETE FROM employees WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
