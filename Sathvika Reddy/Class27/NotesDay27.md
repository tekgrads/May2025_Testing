
# Java File Handling & Serialization

## File Writing using OutputStream

```java
package com.tekgrads;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Example1{ 
    public static void main(String[] args) {
        File file = new File("abc_new.txt");

        try (FileOutputStream fos = new FileOutputStream(file)) {
            String content = "this is a 1st line\nthis is 2nd line\nthis is 3rd line";
            byte[] bytes = content.getBytes();
            fos.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream fis = new FileInputStream(file)) {
            int ch;
            while ((ch = fis.read()) != -1) {
                System.out.print((char) ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```



## Serialization

```java
package com.tekgrads;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Example2 { 
    public static void main(String[] args) {
        Employee emp = new Employee("sowmya", 50000, "HCL");

        try (FileOutputStream fos = new FileOutputStream("employee.data");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(emp);
            System.out.println("Employee object written to employee.data");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```



## Deserialization

```java
package com.tekgrads;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Example3 { 
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("employee.data");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            Employee emp = (Employee) ois.readObject();
            System.out.println("Read from file: " + emp);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
```


---

## Externalization

```java
package com.tekgrads;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Employee_new implements Externalizable {
    private int id;
    private String name;
    private double salary;

    public Employee_new() {} // Required

    public Employee_new(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(id);
        out.writeUTF(name);
        out.writeDouble(salary);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        id = in.readInt();
        name = in.readUTF();
        salary = in.readDouble();
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
    }
}
```


---

## final, finally, finalize

**Explanation:**  
`final` is used for constants, preventing method overriding and inheritance.  
`finally` is a block that executes always after try-catch.  
`finalize()` is a deprecated method called before garbage collection.

---

## Stream API Concepts

### filter()

**Explanation:**  
Used to select elements that match a specific condition from a stream. It returns a new stream with filtered values.

---

### flatMap()

**Explanation:**  
Flattens nested structures into a single stream. Commonly used when working with collections of collections.

---

### groupingBy()

**Explanation:**  
Collects elements of a stream into a Map grouped by a classifier function. Useful for categorizing data.

---

### Optional

**Explanation:**  
A container object that may or may not contain a non-null value. Avoids null pointer exceptions in return values.

---

### LocalDate and LocalTime

**Explanation:**  
Classes introduced in Java 8 to handle date and time more efficiently. They are immutable and thread-safe, unlike older Date/Calendar APIs.
