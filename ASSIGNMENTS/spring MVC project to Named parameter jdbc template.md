
## 1. Database Table Schema

```sql
CREATE TABLE employees (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    city VARCHAR(100),
    department VARCHAR(100),
    age INT,
    salary DOUBLE,
    profession VARCHAR(100)
);
```

---

## 2. EmployeeDTO.java

```java
package com.example.dto;

public class EmployeeDTO {
    private int id;
    private String name;
    private String city;
    private String department;
    private int age;
    private double salary;
    private String profession;

    // Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public String getProfession() {
        return profession;
    }
    public void setProfession(String profession) {
        this.profession = profession;
    }
}
```

---

## 3. EmployeeRowMapper.java

```java
package com.example.mapper;

import com.example.dto.EmployeeDTO;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<EmployeeDTO> {
    @Override
    public EmployeeDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        EmployeeDTO emp = new EmployeeDTO();
        emp.setId(rs.getInt("id"));
        emp.setName(rs.getString("name"));
        emp.setCity(rs.getString("city"));
        emp.setDepartment(rs.getString("department"));
        emp.setAge(rs.getInt("age"));
        emp.setSalary(rs.getDouble("salary"));
        emp.setProfession(rs.getString("profession"));
        return emp;
    }
}
```

---

## 4. EmployeeDAO.java

```java
package com.example.dao;

import com.example.dto.EmployeeDTO;
import java.util.List;

public interface EmployeeDAO {
    List<EmployeeDTO> getAllEmployees();
    void addEmployee(EmployeeDTO employee);
    void updateEmployee(EmployeeDTO employee);
    void deleteEmployee(int id);
    EmployeeDTO getEmployeeById(int id);
}
```

---

## 5. EmployeeDAOImpl.java (Using NamedParameterJdbcTemplate)

```java
package com.example.dao;

import com.example.dto.EmployeeDTO;
import com.example.mapper.EmployeeRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        String sql = "SELECT * FROM employees";
        return namedParameterJdbcTemplate.query(sql, new EmployeeRowMapper());
    }

    @Override
    public void addEmployee(EmployeeDTO employee) {
        String sql = "INSERT INTO employees (name, city, department, age, salary, profession) " +
                     "VALUES (:name, :city, :department, :age, :salary, :profession)";
        namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(employee));
    }

    @Override
    public void updateEmployee(EmployeeDTO employee) {
        String sql = "UPDATE employees SET name=:name, city=:city, department=:department, age=:age, " +
                     "salary=:salary, profession=:profession WHERE id=:id";
        namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(employee));
    }

    @Override
    public void deleteEmployee(int id) {
        String sql = "DELETE FROM employees WHERE id=:id";
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource("id", id));
    }

    @Override
    public EmployeeDTO getEmployeeById(int id) {
        String sql = "SELECT * FROM employees WHERE id=:id";
        return namedParameterJdbcTemplate.queryForObject(
                sql,
                new MapSqlParameterSource("id", id),
                new EmployeeRowMapper()
        );
    }
}
```

---

## 6. EmployeeService.java

```java
package com.example.service;

import com.example.dto.EmployeeDTO;
import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> getAllEmployees();
    void addEmployee(EmployeeDTO employee);
    void updateEmployee(EmployeeDTO employee);
    void deleteEmployee(int id);
    EmployeeDTO getEmployeeById(int id);
}
```

---

## 7. EmployeeServiceImpl.java

```java
package com.example.service;

import com.example.dao.EmployeeDAO;
import com.example.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return employeeDAO.getAllEmployees();
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

    @Override
    public EmployeeDTO getEmployeeById(int id) {
        return employeeDAO.getEmployeeById(id);
    }
}
```

---

## 8. EmployeeController.java

```java
package com.example.controller;

import com.example.dto.EmployeeDTO;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/employeeHome")
    public String getAllEmployees(Model model) {
        List<EmployeeDTO> employees = employeeService.getAllEmployees();
        model.addAttribute("employeeList", employees);
        return "employee-list";
    }

    @RequestMapping("/add")
    public String addEmployee(@ModelAttribute("employee") EmployeeDTO employee) {
        employeeService.addEmployee(employee);
        return "redirect:/employeeHome";
    }

    @RequestMapping("/edit")
    public String editEmployee(@RequestParam int id, Model model) {
        EmployeeDTO emp = employeeService.getEmployeeById(id);
        model.addAttribute("employee", emp);
        return "employee-form";
    }

    @RequestMapping("/update")
    public String updateEmployee(@ModelAttribute("employee") EmployeeDTO employee) {
        employeeService.updateEmployee(employee);
        return "redirect:/employeeHome";
    }

    @RequestMapping("/delete")
    public String deleteEmployee(@RequestParam int id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employeeHome";
    }
}
```

---

## 9. employee-list.jsp

```jsp
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head><title>Employee List</title></head>
<body>
<h2>Employee List</h2>
<a href="employee-form.jsp">Add New Employee</a>
<table border="1" width="100%">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>City</th>
        <th>Department</th>
        <th>Age</th>
        <th>Salary</th>
        <th>Profession</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="emp" items="${employeeList}">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.name}</td>
            <td>${emp.city}</td>
            <td>${emp.department}</td>
            <td>${emp.age}</td>
            <td>${emp.salary}</td>
            <td>${emp.profession}</td>
            <td>
                <a href="edit?id=${emp.id}">Edit</a> |
                <a href="delete?id=${emp.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
```

---

## 10. employee-form.jsp

```jsp
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head><title>Employee Form</title></head>
<body>
<h2>Employee Form</h2>
<form action="add" method="post">
    Name: <input type="text" name="name"/><br/>
    City: <input type="text" name="city"/><br/>
    Department: <input type="text" name="department"/><br/>
    Age: <input type="number" name="age"/><br/>
    Salary: <input type="number" step="0.01" name="salary"/><br/>
    Profession: <input type="text" name="profession"/><br/>
    <input type="submit" value="Save"/>
</form>
</body>
</html>
```

---

## Execution Flow

1. **User Request** → Visits `/employeeHome` to see the list of employees.
2. **Controller** → Calls `EmployeeService.getAllEmployees()`.
3. **Service Layer** → Delegates to `EmployeeDAO`.
4. **DAO (NamedParameterJdbcTemplate)** → Executes SQL queries using **named parameters** (`:name`, `:city`, `:department`, etc.) instead of `?`.
5. **RowMapper** → Converts each row into `EmployeeDTO` object.
6. **Controller** → Passes list to JSP.
7. **View (JSP)** → Displays employees in a table with `department` field included.

Good question! Let’s carefully go through the **NamedParameterJdbcTemplate** example we wrote in the Spring MVC project and analyze its **execution flow and output**.

---

## Example: Saving an Employee

```java
@Override
public void saveEmployee(EmployeeDTO employee) {
    String sql = "INSERT INTO employee (id, name, department, salary) " +
                 "VALUES (:id, :name, :department, :salary)";
    
    MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue("id", employee.getId());
    params.addValue("name", employee.getName());
    params.addValue("department", employee.getDepartment());
    params.addValue("salary", employee.getSalary());
    
    namedParameterJdbcTemplate.update(sql, params);
}
```

### Execution Flow:

1. **SQL with Named Parameters**:
   Instead of `?` placeholders, the query has `:id`, `:name`, `:department`, and `:salary`.

2. **Parameter Mapping**:

   * `params.addValue("id", employee.getId());`
   * `params.addValue("name", employee.getName());`
   * `params.addValue("department", employee.getDepartment());`
   * `params.addValue("salary", employee.getSalary());`

   These values replace the named parameters in the SQL before execution.

3. **SQL Executed by Spring**:
   If `employee` object has:

   ```java
   new EmployeeDTO(101, "John Doe", "IT", 55000.0)
   ```

   Then the SQL executed by Spring will be:

   ```sql
   INSERT INTO employee (id, name, department, salary) 
   VALUES (101, 'John Doe', 'IT', 55000.0);
   ```

4. **Database Result**:
   A new row is inserted into the `employee` table.

---

## Example: Fetching All Employees

```java
@Override
public List<EmployeeDTO> getAllEmployees() {
    String sql = "SELECT * FROM employee";
    
    return namedParameterJdbcTemplate.query(sql, new EmployeeRowMapper());
}
```

### Execution Flow:

1. SQL generated:

   ```sql
   SELECT * FROM employee;
   ```

2. Spring executes the query and uses **EmployeeRowMapper** to convert each row into an `EmployeeDTO`.

3. Suppose the database has:

   ```text
   +-----+-----------+-------------+--------+
   | id  | name      | department  | salary |
   +-----+-----------+-------------+--------+
   | 101 | John Doe  | IT          | 55000  |
   | 102 | Jane Doe  | HR          | 60000  |
   +-----+-----------+-------------+--------+
   ```

4. The output in Java will be a list of employees:

   ```java
   [
     EmployeeDTO { id=101, name="John Doe", department="IT", salary=55000.0 },
     EmployeeDTO { id=102, name="Jane Doe", department="HR", salary=60000.0 }
   ]
   ```

---

## Example: Fetch Employee by ID

```java
@Override
public EmployeeDTO getEmployeeById(int id) {
    String sql = "SELECT * FROM employee WHERE id = :id";
    
    Map<String, Object> params = new HashMap<>();
    params.put("id", id);
    
    return namedParameterJdbcTemplate.queryForObject(sql, params, new EmployeeRowMapper());
}
```

### Execution Flow:

1. If `id=101`, Spring prepares:

   ```sql
   SELECT * FROM employee WHERE id = 101;
   ```

2. Executes query and maps the result to `EmployeeDTO`.

3. Output:

   ```java
   EmployeeDTO { id=101, name="John Doe", department="IT", salary=55000.0 }
   ```

---

Got it 👍 — let’s show the **entire `employee` table** (with sample data) after inserting some records using the **NamedParameterJdbcTemplate** in your Spring MVC project.

---

## Example Table: `employee`

After executing inserts like:

```java
saveEmployee(new EmployeeDTO(101, "John Doe", "IT", 55000.0));
saveEmployee(new EmployeeDTO(102, "Jane Doe", "HR", 60000.0));
saveEmployee(new EmployeeDTO(103, "Mike Smith", "Finance", 58000.0));
saveEmployee(new EmployeeDTO(104, "Emily Davis", "IT", 62000.0));
```

Your **database table** will look like this:

| id  | name        | department | salary  |
| --- | ----------- | ---------- | ------- |
| 101 | John Doe    | IT         | 55000.0 |
| 102 | Jane Doe    | HR         | 60000.0 |
| 103 | Mike Smith  | Finance    | 58000.0 |
| 104 | Emily Davis | IT         | 62000.0 |

---

## How Spring MVC Returns the Data

* **getAllEmployees()** → returns a `List<EmployeeDTO>`:

```java
[
  EmployeeDTO{id=101, name="John Doe", department="IT", salary=55000.0},
  EmployeeDTO{id=102, name="Jane Doe", department="HR", salary=60000.0},
  EmployeeDTO{id=103, name="Mike Smith", department="Finance", salary=58000.0},
  EmployeeDTO{id=104, name="Emily Davis", department="IT", salary=62000.0}
]
```

* **getEmployeeById(103)** → returns:

```java
EmployeeDTO{id=103, name="Mike Smith", department="Finance", salary=58000.0}
```

* **Console Output:**

```text
ID: 101 | Name: John Doe | Department: IT | Salary: 55000.0
ID: 102 | Name: Jane Doe | Department: HR | Salary: 60000.0
ID: 103 | Name: Mike Smith | Department: Finance | Salary: 58000.0
ID: 104 | Name: Emily Davis | Department: IT | Salary: 62000.0
```



