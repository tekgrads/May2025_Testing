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
	
	// Get all employees
		@GetMapping("/getAllEmployeesOrderBySal")
		public ResponseEntity<List<EmployeeDTO>> listEmployeesOrderBySal() {
			List<EmployeeDTO> employees = employeeService.getAllEmployeesOrderBySal();
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
	
	
	// Custom Queries -----------------
    @GetMapping("/search/by-name")
    public List<EmployeeDTO> findByName(@RequestParam String name) {
        return employeeService.findByName(name);
    }
    
 // Custom Queries -----------------
    @GetMapping("/search/by-department")
    public List<EmployeeDTO> findByDepartment(@RequestParam String department) {
        return employeeService.findByDepartment(department);
    }


    @GetMapping("/search/by-name-department")
    public List<EmployeeDTO> findByNameAndDepartment(@RequestParam String name,
                                                     @RequestParam String department) {
        return employeeService.findByNameAndDepartment(name, department);
    }

    @GetMapping("/search/by-name-salary-desc")
    public List<EmployeeDTO> findByNameOrderBySalaryDesc(@RequestParam String name) {
        return employeeService.findByNameOrderBySalaryDesc(name);
    }
}
