# Java File Handling & Object Serialization (Examples)

---

## 📤 File Writing using `OutputStream`

```java
package com.tekgrads;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Example6 {
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

---

## 💾 Serialization

> Convert object → byte stream (for file/network)

### Serialization Code

```java
package com.tekgrads;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Example7 {
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

---

## 📥 Deserialization

```java
package com.tekgrads;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Example8 {
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

## ⚠️ `transient` Keyword

> Prevents a field from being serialized. Default value will be stored instead.

---

## 🧰 Externalization

> You manually define how object data is written/read using `Externalizable`

### Employee_new.java

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

### Write with Externalization

```java
package com.tekgrads;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Example9 {
    public static void main(String[] args) {
        Employee_new emp = new Employee_new(105, "kavya", 78000.00);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employee_ext.dat"))) {
            oos.writeObject(emp);
            System.out.println("Employee object written using Externalization");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### Read with Externalization

```java
package com.tekgrads;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Example10 {
    public static void main(String[] args) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employee_ext.dat"))) {
            Employee_new emp = (Employee_new) ois.readObject();
            System.out.println("Read from file: " + emp);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
```

---

## `final`, `finally`, `finalize` in Java

| Keyword   | Description |
|-----------|-------------|
| `final`   | Declares constants, prevents changes (variables/methods/classes) |
| `finally` | Block that always executes after `try-catch` |
| `finalize()` | Called by GC before destroying object (cleanup method) |

### Example:

```java
package com.tekgrads;

public class Final {

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize() method called for object: " + this);
    }

    public static void main(String[] args) {
        final int a = 100;
        System.out.println("The final variable value is: " + a);

        try {
            System.out.println("Inside try block");
            int result = 50 / 10;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Caught an exception: " + e);
        } finally {
            System.out.println("This is the finally block. It always executes.");
        }

        Final obj1 = new Final();
        Final obj2 = new Final();

        obj1 = null;
        obj2 = null;

        System.gc(); // Suggest GC

        System.out.println("End of main method");
    }
}
```

---