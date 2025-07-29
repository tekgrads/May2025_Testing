# ✅ SOLID Principles in Java:

## 🔹 1. S – Single Responsibility Principle (SRP)

**Definition:** A class should have only one reason to change, meaning it should have only one job.

### ✅ Example

```java
class Employee {
    String name;
    int id;

    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

class EmployeeDisplay {
    public void m1(Employee emp) {
        System.out.println("Employee ID: " + emp.id);
        System.out.println("Employee Name: " + emp.name);
    }
}

public class SRPExample {
    public static void main(String[] args) {
        Employee emp = new Employee("Sowmya", 101);
        EmployeeDisplay d = new EmployeeDisplay();
        d.m1(emp); // calling m1 method
    }
}
```

### 🖥️ Output

```
Employee ID: 101
Employee Name: Sowmya
```

---

## 🔹 2. O – Open/Closed Principle (OCP)

**Definition:** A class should be open for extension but closed for modification.

### ✅ Example

```java
class Employee {
    String name;
    int id;

    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

class EmployeeDisplay {
    public void m1(Employee emp) {
        System.out.println("Employee ID: " + emp.id);
        System.out.println("Employee Name: " + emp.name);
    }
}

interface EmployeeSalary {
    double EmployeeSalary(Employee emp);
}

class FullTimeEmployeeSalary implements EmployeeSalary {
    public double EmployeeSalary(Employee emp) {
        return 50000.00;
    }
}

class PartTimeEmployeeSalary implements EmployeeSalary {
    public double EmployeeSalary(Employee emp) {
        return 20000.00;
    }
}

public class ORPExample {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Sowmya", 101);
        Employee emp2 = new Employee("Rama", 102);
        EmployeeDisplay d = new EmployeeDisplay();

        d.m1(emp1);

        EmployeeSalary fullTime = new FullTimeEmployeeSalary();
        EmployeeSalary partTime = new PartTimeEmployeeSalary();

        System.out.println("Full-time salary: " + fullTime.EmployeeSalary(emp1));
        System.out.println("Part-time salary: " + partTime.EmployeeSalary(emp1));

        d.m1(emp2);

        System.out.println("Full-time salary: " + fullTime.EmployeeSalary(emp2));
        System.out.println("Part-time salary: " + partTime.EmployeeSalary(emp2));
    }
}
```

### 🖥️ Output

```
Employee ID: 101
Employee Name: Sowmya
Full-time salary: 50000.0
Part-time salary: 20000.0
Employee ID: 102
Employee Name: Rama
Full-time salary: 50000.0
Part-time salary: 20000.0
```

---


## 3. 🔁 L – Liskov Substitution Principle (LSP)

**Definition:** Subclasses should be usable in place of their parent class without errors.

### ✅ Example

```java
class Employee {
    protected int id;
    protected String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void work() {
        System.out.println(name + " (ID: " + id + ") is working");
    }
}

class Manager extends Employee {
    public Manager(int id, String name) {
        super(id, name); // calling parent constructor
    }

    @Override
    public void work() {
        System.out.println(name + " (Manager) is managing the team");
    }
}

class Developer extends Employee {
    public Developer(int id, String name) {
        super(id, name); // calling parent constructor
    }

    @Override
    public void work() {
        System.out.println(name + " (Developer) is writing code");
    }
}

public class LSPExample {
    public static void main(String[] args) {
        Employee emp1 = new Manager(101, "Sowmya");
        Employee emp2 = new Developer(102, "Ramya");

        emp1.work();  
        emp2.work();  
    }
}
```

### 🖥️ Output

```
Sowmya (Manager) is managing the team
Ramya (Developer) is writing code
```

✅ `Manager` and `Developer` extend `Employee` and can be used wherever `Employee` is expected.

---

## 4. 📑 I – Interface Segregation Principle (ISP)

**Definition:** A class should not be forced to implement methods it doesn’t use.

### ✅ Example

```java
interface Working {
    void work();
}

interface Reporting {
    void report();
}

interface Writing {
    void write();
}

class Employee {
    protected int id;
    protected String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Developer extends Employee implements Working, Reporting {
    public Developer(int id, String name) {
        super(id, name);
    }

    public void work() {
        System.out.println(name + " ID: " + id + " is writing code.");
    }

    public void report() {
        System.out.println(name + " is writing a project report.");
    }
}

class HRExecutive extends Employee implements Working, Writing {
    public HRExecutive(int id, String name) {
        super(id, name);
    }

    public void work() {
        System.out.println(name + " ID: " + id + " is managing employee records.");
    }

    public void write() {
        System.out.println(name + " is writing monthly reports.");
    }
}

public class ISPExample {
    public static void main(String[] args) {
        Developer dev = new Developer(101, "Sowmya");
        HRExecutive hr = new HRExecutive(103, "Ramya");

        dev.work();
        dev.report();
        System.out.println();

        hr.work();
        hr.write();
    }
}
```

### 🖥️ Output

```
Sowmya ID: 101 is writing code.
Sowmya is writing a project report.

Ramya ID: 103 is managing employee records.
Ramya is writing monthly reports.
```

---

## 5. 🔄 D – Dependency Inversion Principle (DIP)

**Definition:** High-level classes should not depend on low-level classes. Both should depend on abstractions.

### ✅ Example

```java
// Employee class with id and name
class Employee {
    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }
}

// Abstraction for saving employees (this is the dependency)
interface EmployeeData {
    void save(Employee emp);
}

// Low-level module: one type of implementation
class DatabaseData implements EmployeeData {
    public void save(Employee emp) {
        System.out.println("Saving employee " + emp.getName() + " ID: " + emp.getId() + " to the database.");
    }
}

// High-level module: depends on abstraction, not on the concrete class
class EmployeeService {
    private EmployeeData d;

    // Injecting dependency through constructor
    public EmployeeService(EmployeeData d) {
        this.d = d;
    }

    public void saveEmployee(Employee emp) {
        d.save(emp);
    }
}

// Main class
public class DIPExample {
    public static void main(String[] args) {
        Employee emp = new Employee(101, "Sowmya");

        // We can change the implementation without modifying EmployeeService
        EmployeeData empdata = new DatabaseData();

        EmployeeService empservice = new EmployeeService(empdata);
        empservice.saveEmployee(emp);
    }
}
```

### 🖥️ Output

```
Saving employee Sowmya ID: 101 to the database.
```

---

## 📊 Summary Table – SOLID Principles

| Principle | Definition                                 | Simple Example                                 |
| --------- | ------------------------------------------ | ---------------------------------------------- |
| **SRP**   | One class = One job                        | Separate data and printing classes             |
| **OCP**   | Extend without changing existing code      | Add new shape classes without editing old ones |
| **LSP**   | Subclasses replace parent without breaking | Parrot is a Bird; Ostrich can't fly = violates |
| **ISP**   | Don’t force unused methods                 | Separate interfaces for print, scan, fax       |
| **DIP**   | Depend on interfaces, not concrete classes | Use `Keyboard` interface instead of concrete   |

