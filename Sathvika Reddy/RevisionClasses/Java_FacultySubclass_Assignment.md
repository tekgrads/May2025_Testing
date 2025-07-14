###  Java Code for Faculty Subclass:

```java
class Person {
    String name;
    String course;
    double fee;

    void listen() {
        System.out.println(name + " is listening " + course);
    }

    void reply() {
        System.out.println(name + " is replying " + course + " questions");
    }

    void write() {
        System.out.println(name + " is writing " + course + " notes");
    }

    void read() {
        System.out.println(name + " is reading " + course + " notes");
    }
}

class Employee extends Person {
    double sal;
    double exp;
}

class Faculty extends Employee {
    int fno;
    String dept;

    void teach() { }
    void conductExam() { }
}

public class Institute2 {
    public static void main(String[] args) {

        // Object of Person
        Person p = new Person();
        p.name = "Sathvika";
        p.course = "Java";
        p.fee = 10000;
        p.listen();
        p.read();
        // p.sal = 40000; //  Error: sal is not accessible with Person reference
        // p.exp = 2.0;   //  Error: exp is not accessible with Person reference
        // p.fno = 12345;   //  Error: fno is not accessible with Person reference
        // p.dept = "IT"; // Error: dept is not accessible with Person reference

        // Object of Employee
        Employee e = new Employee();
        e.name = "Sathvika";
        e.course = "Java";
        e.fee = 10000;
        e.sal = 60000;
        e.exp = 2.5;
        e.listen();
        e.write();
        // e.fno = 101;   //  Error: fno is not accessible with Employee reference
        // e.dept = "IT"; //  Error: dept is not accessible with Employee reference

        // Object of Faculty
        Faculty f = new Faculty();
        f.name = "Sathvika";
        f.course = "Java";
        f.fee = 20000;
        f.sal = 50000;
        f.exp = 3.0;
        f.fno = 200;
        f.dept = "IT";
        f.read();
        f.teach();
    }
}
```

---

###  Accessability for Classes:

* `Faculty` object can access **all fields and methods** from `Person`, `Employee`, and `Faculty`.
* `Employee` object can access fields and methods from `Person` and `Employee`, but **not from `Faculty`**.
* `Person` object can only access its **own fields and methods**.

