class Person {
    String name;
    int age;


    Person(String name, int age) {
        this.name = name;
        this.age  = age;
    }
}

class Employee extends Person {
  
    String employeeId;
    double salary;

    Employee(String name, int age, String employeeId, double salary) {
        super(name, age);            
        this.employeeId = employeeId;
        this.salary      = salary;
    }
}

class Faculty extends Employee {
  
    String department;
    String subject;

    Faculty(String name, int age, String employeeId,double salary, String department, String subject) {
        super(name, age, employeeId, salary); 
        this.department = department;
        this.subject    = subject;
    }
}

public class Main {
    public static void main(String[] args) {

       
        Person p = new Person("sathvika", 21);
        System.out.println("Person");
        System.out.println("Name : " + p.name);
        System.out.println("Age  : " + p.age);
        System.out.println();

       
        Employee e = new Employee("laxmi", 21, "E102", 45_000);
        System.out.println("Employee");
        System.out.println("Name       : " + e.name);       
        System.out.println("Age        : " + e.age);        
        System.out.println("EmployeeId : " + e.employeeId);
        System.out.println("Salary     : " + e.salary);
        System.out.println();

       
        Faculty f = new Faculty("Charu", 40, "F301", 65_000,"Computer Science", "Data Structures");
        System.out.println("Faculty");
        // inherited from Person
        System.out.println("Name       : " + f.name);
        System.out.println("Age        : " + f.age);
        // inherited from Employee
        System.out.println("EmployeeId : " + f.employeeId);
        System.out.println("Salary     : " + f.salary);
        // Faculty‑specific
        System.out.println("Department : " + f.department);
        System.out.println("Subject    : " + f.subject);
    }
}
