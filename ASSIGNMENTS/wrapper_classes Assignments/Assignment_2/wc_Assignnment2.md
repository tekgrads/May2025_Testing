
---

###  1. `InvalidMarkException.java`

```java
public class InvalidMarkException extends Exception {
    public InvalidMarkException(String message) {
        super(message);
    }
}
```

---

###  2. `Student.java`

```java
public class Student {
    private String name;
    private Double mark1, mark2, mark3;

    public Student(String name) {
        this.name = name;
    }

    public void setMarks(String m1, String m2, String m3) {
        try {
            mark1 = parseAndValidate(m1);
            mark2 = parseAndValidate(m2);
            mark3 = parseAndValidate(m3);
        } catch (NumberFormatException e) {
            System.out.println("Exception: Invalid number format!");
        } catch (InvalidMarkException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    private Double parseAndValidate(String markStr) throws InvalidMarkException {
        Double mark = Double.parseDouble(markStr);
        if (mark < 0) {
            throw new InvalidMarkException("Invalid mark: cannot be negative");
        }
        if (mark > 100) {
            throw new InvalidMarkException("Invalid mark: cannot be greater than 100");
        }
        return mark;
    }

    public double calculateAverage() {
        if (mark1 == null || mark2 == null || mark3 == null) {
            return 0.0;
        }
        return (mark1 + mark2 + mark3) / 3;
    }

    public char getGrade() {
        double avg = calculateAverage();
        if (avg >= 90) return 'A';
        else if (avg >= 75) return 'B';
        else if (avg >= 60) return 'C';
        else if (avg >= 40) return 'D';
        else return 'F';
    }
}
```

---

###  3. `Main.java`

```java
public class Main {
    public static void main(String[] args) {
        Student s = new Student("Rahul");

        s.setMarks("85", "95", "70");       // Valid
        double avg = s.calculateAverage();
        char grade = s.getGrade();
        System.out.println("Average: " + String.format("%.2f", avg));
        System.out.println("Grade: " + grade);

        s.setMarks("-10", "90", "80");      // Negative mark
        s.setMarks("100", "abc", "90");     // Invalid format
    }
}
```

---

###  Expected Output:

```
Average: 83.33
Grade: B
Exception: Invalid mark: cannot be negative
Exception: Invalid number format!

