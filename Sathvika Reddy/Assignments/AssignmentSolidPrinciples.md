# SOLID Design Principles in OOP: 
Example: Student Management System

##  Introduction:

*SOLID* is an acronym that represents five principles of object-oriented software design. These principles help developers write code that is easy to maintain, extend, and refactor.

> These are general best practices in object-oriented design, ideal for building robust applications like a *Student Details System*, where data like student enrollment, performance, etc., are involved.

##  S — Single Responsibility Principle (SRP)

> *Definition:* A class should have only *one reason to change* – it should only do one job.

###  General Idea:
Split responsibilities into separate classes—this improves maintainability.

###  Example:
Suppose you have a Student class that does both data storage and file I/O:

java
class Student {
    String name;
    int age;

    void saveToFile() {
        // Save to file logic
    }
}


* Problem:* Student does both modeling & file handling.

* Fix (SRP Applied):*

java
class Student {
    String name;
    int age;
}

class StudentFileHandler {
    void saveToFile(Student student) {
        // Logic to save student
    }
}


Now each class does only one thing:  
- Student only stores data  
- StudentFileHandler handles persistence

##  O — Open/Closed Principle (OCP)

> *Definition:* Software entities should be *open for extension* but *closed for modification*.

###  Example:
You want to have grading logic for undergraduate and postgraduate students.

* Bad (violates OCP):*

java
class Grader {
    String grade(Student s) {
        if (s.type.equals("UG")) return "A";
        else if (s.type.equals("PG")) return "B";
        // keep adding more types to modify
    }
}


* Good (OCP Applied):*

java
interface GradingStrategy {
    String grade();
}

class UGGrading implements GradingStrategy {
    public String grade() {
        return "A";
    }
}

class PGGrading implements GradingStrategy {
    public String grade() {
        return "B";
    }
}


You can now *extend* for PhD or others *without changing* existing code.

##  L — Liskov Substitution Principle (LSP)

> *Definition:* Subtypes must be substitutable for their base types without altering functionality.

###  Example:

java
class Student {
    String getName() { return "Student"; }
}

class UGStudent extends Student {
    String getName() { return "UG Student"; }
}


If UGStudent can be used wherever Student is expected, *LSP is maintained*.

* Violation Example:*
If a subclass throws UnsupportedOperationException or changes method meaning, LSP is broken.

## I — Interface Segregation Principle (ISP)

> *Definition:* Clients should not be forced to implement interfaces they don’t use.

###  Example:

* Bad Design:*

java
interface StudentActivity {
    void attendLecture();
    void submitThesis(); // Not all students do this
}

class UGStudent implements StudentActivity {
    public void attendLecture() {}
    public void submitThesis() {
        // forced to implement something not applicable
    }
}


* Better ISP Design:*

java
interface LectureParticipant {
    void attendLecture();
}
interface ResearchParticipant {
    void submitThesis();
}

class UGStudent implements LectureParticipant {
    public void attendLecture() {}
}


Each class only implements what it truly needs.

##  D — Dependency Inversion Principle (DIP)

> *Definition:* High-level modules should not depend on low-level modules. Both should depend on *abstractions*.

###  Example:

* Without DIP (tight coupling):*

java
class MySQLDatabase {
    void save(Student student) {}
}

class StudentService {
    MySQLDatabase db = new MySQLDatabase(); // Direct dependency
}


* With DIP:*

java
interface Database {
    void save(Student student);
}

class MySQLDatabase implements Database {
    public void save(Student student) {}
}

class StudentService {
    Database db;
    StudentService(Database db) {
        this.db = db;
    }
}


Now StudentService works with any database implementing Database interface.


