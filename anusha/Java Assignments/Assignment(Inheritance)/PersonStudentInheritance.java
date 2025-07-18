// Superclass: Person
class Person {
    private String name;
    private double height;
    private double weight;

    // Parameterized constructor
    public Person(String name, double height, double weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    // Display method
    public void displayPersonInfo() {
        System.out.println("Name: " + name);
        System.out.println("Height: " + height + " cm");
        System.out.println("Weight: " + weight + " kg");
    }
}

// Subclass: Student
class Student extends Person {
    private int sno;
    private String course;
    private double fee;

    // No-argument constructor with default values
    public Student() {
        super("ANU", 160.0, 55.0); // Default Person values
        this.sno = 1;
        this.course = "CSE";
        this.fee = 50000.0;
    }

    // Parameterized constructor
    public Student(String name, double height, double weight, int sno, String course, double fee) {
        super(name, height, weight); // Call superclass constructor
        this.sno = sno;
        this.course = course;
        this.fee = fee;
    }

    // Setters
    public void setSno(int sno) {
        this.sno = sno;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    // Getters
    public int getSno() {
        return sno;
    }

    public String getCourse() {
        return course;
    }

    public double getFee() {
        return fee;
    }

    // Display method
    public void displayStudentInfo() {
        displayPersonInfo(); // Call parent display method
        System.out.println("Student No: " + sno);
        System.out.println("Course: " + course);
        System.out.println("Fee: ₹" + fee);
        System.out.println("--------------------------");
    }
}

// Main class
public class PersonStudentInheritance {
    public static void main(String[] args) {
        // Using no-arg constructor
        Student student1 = new Student();
        System.out.println("Student 1 (No-arg constructor):");
        student1.displayStudentInfo();

        // Using parameterized constructor
        Student student2 = new Student("Anusha", 162.5, 54.0, 101, "Data Science", 75000.0);
        System.out.println("Student 2 (Parameterized constructor):");
        student2.displayStudentInfo();
    }
}
