# FILEHANDLING

## FILE

A File in Java is an object that represents the path to a file or directory on your computer.
It is used to create, read, write, delete, or check the properties of files and folders.
It is a part of `java.io` package.
All IO are checked exceptions, and we include try-catch blocks.

### Example 1: Create a Directory

```java
package com.tekgrads;

import java.io.File;

public class Example1 {
    public static void main(String[] args) {
        File f = new File("test");
        f.mkdir();
        System.out.println("completed");
    }
}
```

### Example 2: Creating a File

```java
package com.tekgrads;

import java.io.File;
import java.io.IOException;

public class Example2 {
    public static void main(String[] args) {
        File f = new File("test.txt");
        try {
            f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

---

## FILE-READER

`FileReader` is used to read data (characters) from a file, one character at a time.

### Example 3: FileReader Program

```java
package com.tekgrads;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Example5 {
    public static void main(String[] args) {
        File file = new File("abc.txt");

        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {

            String s = br.readLine();
            while (s != null) {
                System.out.println(s);
                s = br.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

---

## FILE-WRITER

`FileWriter` is used to write characters to a file.
`finally` block is always executed.
We must close the connection using `flush()` and `close()` methods.
It is a type of checked Exception.

### Example 4: FileWriter Program

```java
package com.tekgrads;

import java.io.FileWriter;
import java.io.IOException;

public class Example3 {
    public static void main(String[] args) {
        FileWriter out = null;
        try {
            out = new FileWriter("test.txt");
            out.write("this is filehandling");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.flush();
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
```

## BUFFEREDREADER

`BufferedReader` is used to read text from a character-based input stream efficiently, by buffering characters.
`InputStreamReader` converts byte streams into character streams.
It acts as a bridge between byte-based input (like FileInputStream) and character-based reading.

### Example: Program using BufferedReader

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

## BUFFEREDWRITER

`BufferedWriter` is used to write text to a file efficiently by buffering characters before writing them.
`OutputStreamWriter` converts characters into bytes and writes them to an output stream (e.g., file).

### Example: Program using BufferedWriter

```java
package com.tekgrads;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Example6 {
    public static void main(String[] args) {
        File file = new File("abc_new.txt");

        // Writing to the file using OutputStream
        try (FileOutputStream fos = new FileOutputStream(file)) {
            String content = "this is a 1st line\nthis is 2nd line\nthis is 3rd line";
            byte[] bytes = content.getBytes();
            fos.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Reading from the file using InputStream
        try (FileInputStream fis = new FileInputStream(file)) {
            int ch;
            while ((ch = fis.read()) != -1) {
                System.out.print((char) ch); // cast byte to char
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

---

## SERIALIZATION & DESERIALIZATION

**Serialization** is the process of converting an object into a byte stream so that it can be easily saved to a file or transmitted over a network.
This byte stream can later be **deserialized** to recreate the original object.

### Example: Serialization

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

### Example: Deserialization

```java
package com.tekgrads;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Example8 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("employee.dat");
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



## Example 8: Read the file and print the objects

```java
package com.tekgrads;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Example8 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("employee.dat");
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

## Transient Keyword

The `transient` keyword is used in file handling with serialization to prevent a field from being serialized.
Even though we assign a value to a variable, if it's marked `transient`, the serialized output will not contain that value — it will be `null` or default.

---

## Externalization

**Externalization** is a process in Java file handling where the programmer manually controls how an object is written to and read from a file, using the `Externalizable` interface.
Unlike `Serializable`, it is **not** a marker interface and contains two methods:

1. `writeExternal()` – specify what data to write
2. `readExternal()` – specify what data to read

---

## Example 9: Externalization Write Program

### Employee\_new\.java

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

    // Mandatory public no-arg constructor
    public Employee_new() {
    }

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

### Example9.java - Writing Object

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

---

## Example 10: Read Externalized Object

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



# Final, Finally, Finalize Keywords in Java

## final

* `final` is a keyword used to declare constants.
* It can be applied to variables, methods, or classes to prevent modification.

  * Final variable: cannot be reassigned.
  * Final method: cannot be overridden.
  * Final class: cannot be extended.

## finally

* `finally` is a block that always executes after a `try-catch` block.
* It runs whether or not an exception occurs.
* If an exception occurs **before the try block**, the `finally` block will **not** be executed.

## finalize

* `finalize()` is a method invoked by the Garbage Collector before destroying the object.
* It is used to perform cleanup operations before the object is removed from memory.

---

## Example 11: Program on `final`, `finally`, and `finalize` keywords

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

        // Suggest to JVM to run Garbage Collector
        System.gc();

        System.out.println("End of main method");
    }
}
```

---




