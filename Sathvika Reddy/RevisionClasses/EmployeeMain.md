# Employee Project in Java

## Code:

class Employee {
    private int eno;
    private String ename;
    private double sal;
    private String dept;

    // Setter methods
    public void setEno(int eno) {
        this.eno = eno;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    // Getter methods
    public int getEno() {
        return eno;
    }

    public String getEname() {
        return ename;
    }

    public double getSal() {
        return sal;
    }

    public String getDept() {
        return dept;
    }

    // Method to display employee details
    public void display() {
        System.out.println("Employee No: " + eno);
        System.out.println("Name: " + ename);
        System.out.println("Salary: " + sal);
        System.out.println("Department: " + dept);
    }

    // Method to increase salary by 20%
    public void increaseSalary() {
        sal = sal + (sal * 0.20);
        System.out.println("Salary after 20% hike: " + sal);
    }
}

public class EmployeeMain {
    public static void main(String[] args) {
        Employee e = new Employee();

        // Setting values using setters
        e.setEno(101);
        e.setEname("Ravi");
        e.setSal(30000);
        e.setDept("HR");

        // Display original details
        e.display();

        // Increase salary and show new salary
        e.increaseSalary();
    }
}
