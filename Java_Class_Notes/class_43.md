#  Spring Boot MVC Project -- Employee Management

##  Introduction

Spring Boot is a powerful framework built on top of Spring.\
It eliminates the need for boilerplate configuration, simplifies
development, and allows developers to quickly build stand-alone,
production-ready applications.

### Why Spring Boot?

-   Reduces configuration overhead.
-   Provides embedded servers (Tomcat, Jetty, Undertow).
-   Supports production-ready features (metrics, health checks,
    externalized configuration).

### Spring Initializr

Spring Initializr is a web-based tool to bootstrap Spring Boot
applications.\
URL: <https://start.spring.io>

------------------------------------------------------------------------

##  Spring MVC vs Spring Boot MVC

-   **Spring MVC** requires manual configuration of DispatcherServlet,
    ViewResolvers, etc.
-   **Spring Boot MVC** auto-configures DispatcherServlet,
    ViewResolvers, and provides embedded server.

------------------------------------------------------------------------

##  Application Configuration

### `application.properties`

``` properties
spring.datasource.url=jdbc:mysql://localhost:3306/employee_db
spring.datasource.username=root
spring.datasource.password=admin
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

------------------------------------------------------------------------

##  Project Files

### `pom.xml`

``` xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-jdbc</artifactId>
    </dependency>
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
    </dependency>
</dependencies>
```

### `SpringbootMvcApplication.java`

``` java
@SpringBootApplication
public class SpringbootMvcApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootMvcApplication.class, args);
    }
}
```

### DAO Layer -- `EmployeeDAO.java`

``` java
public interface EmployeeDAO {
    void save(EmployeeDTO employee);
    List<EmployeeDTO> findAll();
}
```

### DAO Implementation -- `EmployeeDAOImpl.java`

``` java
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(EmployeeDTO employee) {
        String sql = "INSERT INTO employees(name, department, salary) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, employee.getName(), employee.getDepartment(), employee.getSalary());
    }

    @Override
    public List<EmployeeDTO> findAll() {
        return jdbcTemplate.query("SELECT * FROM employees", new EmployeeRowMapper());
    }
}
```

### DTO -- `EmployeeDTO.java`

``` java
public class EmployeeDTO {
    private int id;
    private String name;
    private String department;
    private double salary;
    // Getters and Setters
}
```

### Row Mapper -- `EmployeeRowMapper.java`

``` java
public class EmployeeRowMapper implements RowMapper<EmployeeDTO> {
    @Override
    public EmployeeDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        EmployeeDTO emp = new EmployeeDTO();
        emp.setId(rs.getInt("id"));
        emp.setName(rs.getString("name"));
        emp.setDepartment(rs.getString("department"));
        emp.setSalary(rs.getDouble("salary"));
        return emp;
    }
}
```

### Service Layer -- `EmployeeService.java`

``` java
public interface EmployeeService {
    void addEmployee(EmployeeDTO employee);
    List<EmployeeDTO> getEmployees();
}
```

### Service Implementation -- `EmployeeServiceImpl.java`

``` java
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public void addEmployee(EmployeeDTO employee) {
        employeeDAO.save(employee);
    }

    @Override
    public List<EmployeeDTO> getEmployees() {
        return employeeDAO.findAll();
    }
}
```

### Controller -- `HomeController.java`

``` java
@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "index";
    }
}
```

### Controller -- `EmployeeController.java`

``` java
@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeService.getEmployees());
        return "employee-list";
    }

    @PostMapping
    public String saveEmployee(@ModelAttribute EmployeeDTO employee) {
        employeeService.addEmployee(employee);
        return "redirect:/employees";
    }
}
```

### Templates

**`about.html`**

``` html
<h2>About Page</h2>
<p>Welcome to Employee Management System using Spring Boot MVC</p>
```

**`employee-list.html`**

``` html
<h2>Employee List</h2>
<table>
  <tr><th>ID</th><th>Name</th><th>Department</th><th>Salary</th></tr>
  <tr th:each="emp : ${employees}">
    <td th:text="${emp.id}"></td>
    <td th:text="${emp.name}"></td>
    <td th:text="${emp.department}"></td>
    <td th:text="${emp.salary}"></td>
  </tr>
</table>
```

------------------------------------------------------------------------

## Database

``` sql
CREATE DATABASE employee_db;
USE employee_db;

CREATE TABLE employees (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(50),
  department VARCHAR(50),
  salary DOUBLE
);
```

------------------------------------------------------------------------

##  Flow of Execution

1.  User sends request → Controller.\
2.  Controller calls Service.\
3.  Service interacts with DAO.\
4.  DAO performs DB operation.\
5.  Response flows back → Service → Controller → View.

------------------------------------------------------------------------


