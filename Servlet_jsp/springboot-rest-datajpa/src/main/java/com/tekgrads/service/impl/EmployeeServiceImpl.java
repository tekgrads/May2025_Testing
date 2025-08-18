package com.tekgrads.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tekgrads.dto.EmployeeDTO;
import com.tekgrads.entities.Employee;
import com.tekgrads.mapper.EmployeeMapper;
import com.tekgrads.repositories.EmployeeRepository;
import com.tekgrads.service.EmployeeService;

@Service
@Qualifier("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public List<EmployeeDTO> getAllEmployees() {
		return employeeRepository.findAll().stream().map(EmployeeMapper::toDTO) // convert Entity → DTO
				.collect(Collectors.toList());
	}
	
	@Override
	public List<EmployeeDTO> getAllEmployeesOrderBySal() {
		return employeeRepository.findAllByOrderBySalaryDesc().stream().map(EmployeeMapper::toDTO) // convert Entity → DTO
				.collect(Collectors.toList());
	}

	@Override
	public EmployeeDTO getEmployeeById(int id) {
		Optional<Employee> employeeOptional = employeeRepository.findById(id);
		Employee employee = employeeOptional.get();
		return EmployeeMapper.toDTO(employee);
	}

	@Override
	public void addEmployee(EmployeeDTO employee) {
		Employee entity = EmployeeMapper.toEntity(employee);
		employeeRepository.save(entity);
	}

	@Override
	public void updateEmployee(EmployeeDTO employee) {
		Employee entity = EmployeeMapper.toEntity(employee);
		employeeRepository.save(entity);
	}

	@Override
	public void deleteEmployee(int id) {
		employeeRepository.deleteById(id);
	}
	
	// Custom queries -----------------
    public List<EmployeeDTO> findByName(String name) {
        return employeeRepository.findByName(name)
                .stream()
                .map(EmployeeMapper::toDTO)
                .collect(Collectors.toList());
    }
    
 // Custom queries -----------------
    public List<EmployeeDTO> findByDepartment(String department) {
        return employeeRepository.findByDepartment(department)
                .stream()
                .map(EmployeeMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<EmployeeDTO> findByNameAndDepartment(String name, String department) {
        return employeeRepository.findByNameAndDepartment(name, department)
                .stream()
                .map(EmployeeMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<EmployeeDTO> findByNameOrderBySalaryDesc(String name) {
        return employeeRepository.findByNameOrderBySalaryDesc(name)
                .stream()
                .map(EmployeeMapper::toDTO)
                .collect(Collectors.toList());
    }
    
    public List<EmployeeDTO> findByNameOrderBySalaryDescCustom(String name) {
        return employeeRepository.findByNameOrderBySalaryDescCustom(name)
                .stream()
                .map(EmployeeMapper::toDTO)
                .collect(Collectors.toList());
    }

}
