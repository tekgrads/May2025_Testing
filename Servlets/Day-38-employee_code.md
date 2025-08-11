***spring-mvc-jdbc project conversion***
# EmployeeDTO.java
```java
package com.tekgrads.dto;

public class EmployeeDTO {
    private int id;
    private String name;
    private int age;
    private double salary;
    private String city;
    private String profession;
    private String project;

    public EmployeeDTO() {}

    public EmployeeDTO(int id, String name, int age, double salary, String city, String profession, String project) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.city = city;
        this.profession = profession;
        this.project = project;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getProfession() { return profession; }
    public void setProfession(String profession) { this.profession = profession; }

    public String getProject() { return project; }
    public void setProject(String project) { this.project = project; }
}
```

# EmployeeServiceImpl.java
```java
package com.tekgrads.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tekgrads.dto.EmployeeDTO;
import com.tekgrads.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return null;
    }
}
```

# EmployeeDAO.java
```java
package com.tekgrads.dao;

import com.tekgrads.dto.EmployeeDTO;
import java.util.List;

public interface EmployeeDAO {
    List<EmployeeDTO> getAllEmployees();
}
```

# EmployeeDAOImpl.java
```java
package com.tekgrads.dao.impl;

import com.tekgrads.dao.EmployeeDAO;
import com.tekgrads.dto.EmployeeDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private JDBCTemplate jdbcTemplate;

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        String sql = "select * from employee";
        return jdbcTemplate.query(sql, new EmployeeRowMapper());
    }
}
```

# EmployeeRowMapper.java
```java
package com.tekgrads.rowmapper;

import com.tekgrads.dto.EmployeeDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<EmployeeDTO> {

    @Override
    public EmployeeDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        EmployeeDTO employee = new EmployeeDTO();

        employee.setId(rs.getInt("id"));
        employee.setName(rs.getString("name"));
        employee.setAge(rs.getInt("age"));
        employee.setSalary(rs.getDouble("salary"));
        employee.setCity(rs.getString("city"));
        employee.setProfession(rs.getString("profession"));
        employee.setProject(rs.getString("project"));

        return employee;
    }
}
```
