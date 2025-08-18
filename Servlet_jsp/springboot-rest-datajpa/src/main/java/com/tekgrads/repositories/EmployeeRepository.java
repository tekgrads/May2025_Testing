package com.tekgrads.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tekgrads.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	// 1. Find employee(s) by exact name
    List<Employee> findByName(String name);

    // 2. Find employee(s) by name AND department
    List<Employee> findByNameAndDepartment(String name, String department);

    // 3. Find employees by name, ordered by salary descending
    List<Employee> findByNameOrderBySalaryDesc(String name);

    // 4. (Optional) If you want all employees ordered by salary desc
    List<Employee> findAllByOrderBySalaryDesc();

    // 5. (Optional) Using JPQL query
    @Query("SELECT e FROM Employee e WHERE e.name = :name ORDER BY e.salary DESC")
    List<Employee> findByNameOrderBySalaryDescCustom(@Param("name") String name);
    
    // Find all employees belonging to a department
    List<Employee> findByDepartment(String department);
}
