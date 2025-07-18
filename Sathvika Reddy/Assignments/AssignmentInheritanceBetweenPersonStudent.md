## Assignment-Inheritance Between Person and Student

```java
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
    public void showPersonDetails() {
        System.out.println("Name: " + name);
        System.out.println("Height: " + height + " cm");
        System.out.println("Weight: " + weight + " kg");
    }
}

class Student extends Person {
    private int sno;
    private String course;
    private double fee;

    // No-argument constructor with default values
    public Student() {
        super("Default Name", 160.0, 60.0); // default values for Person
        this.sno = 1;
        this.course = "B.Tech";
        this.fee = 25000.0;
    }

    // Parameterized constructor
    public Student(String name, double height, double weight, int sno, String course, double fee) {
        super(name, height, weight); // Person constructor
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
    public void showStudentDetails() {
        showPersonDetails(); // Display from Person class
        System.out.println("Student Number: " + sno);
        System.out.println("Course: " + course);
        System.out.println("Fee: ₹" + fee);
    }
}

public class StudentTest {
    public static void main(String[] args) {
        // Object using no-arg constructor
        Student s1 = new Student();
        System.out.println("Student 1 (Default Constructor):");
        s1.showStudentDetails();

        System.out.println();

        // Object using parameterized constructor
        Student s2 = new Student("Sathvika", 165.0, 55.0, 102, "MCA", 35000.0);
        System.out.println("Student 2 (Parameterized Constructor):");
        s2.showStudentDetails();
    }
}
```

---

### Explanation:

* `Person` has only a parameterized constructor and manages basic details.
* `Student` inherits from `Person` and adds its own fields with two types of constructors:

  * A default constructor sets predefined values.
  * A parameterized one allows customization.
* Setters/getters in both classes provide encapsulation.
* Two student objects are created to demonstrate both constructor usages.


