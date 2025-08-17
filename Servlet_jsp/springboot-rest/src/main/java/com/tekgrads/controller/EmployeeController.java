package com.tekgrads.controller;

import com.tekgrads.dto.EmployeeDTO;
import com.tekgrads.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // 👈 Now it's a REST controller
@RequestMapping("/api") // 👈 keep the same base path
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// Get all employees
	@GetMapping("/getAllEmployees")
	public ResponseEntity<List<EmployeeDTO>> listEmployees() {
		List<EmployeeDTO> employees = employeeService.getAllEmployees();
		return ResponseEntity.ok(employees); // 200 OK + JSON
	}

	// Save employee (insert or update)
	@PostMapping("/save")
	public ResponseEntity<String> saveEmployee(@RequestBody EmployeeDTO employee) {
		employeeService.addEmployee(employee);
		return ResponseEntity.status(HttpStatus.CREATED).body("Employee added successfully");
	}

	// Edit employee
	@PutMapping("/edit")
	public ResponseEntity<EmployeeDTO> editEmployee(@RequestBody EmployeeDTO employee) {		
		employeeService.updateEmployee(employee);
		if (employee != null) {
			return ResponseEntity.ok(employee);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	// Delete employee
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") int id) {
		employeeService.deleteEmployee(id);
		return ResponseEntity.ok("Employee deleted successfully");
	}
}
