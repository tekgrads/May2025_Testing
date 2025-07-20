
# Java File Handling 

## File

A `File` in Java is an object representing a file or directory path on your system. It is part of the `java.io` package and is used to:

- Create files/directories
- Read/write/delete files
- Check file properties
- All file-related IO operations throw **checked exceptions**, so `try-catch` blocks are required.

### Example 1: Create a Directory

```java
import java.io.File;

public class Example1 {
    public static void main(String[] args) {
        File dir = new File("test");
        dir.mkdir();
        System.out.println("Directory created successfully.");
    }
}
```

### Example 2: Create a File

```java
import java.io.File;
import java.io.IOException;

public class Example2 {
    public static void main(String[] args) {
        File file = new File("test.txt");
        try {
            file.createNewFile();
            System.out.println("File created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

## FileReader

Used to read characters from a file, typically one character at a time or line-by-line using `BufferedReader`.

### Example 3: Read from File

```java
import java.io.*;

public class Example3 {
    public static void main(String[] args) {
        File file = new File("abc.txt");

        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

## FileWriter

Used to write characters to a file.

- Always close with `flush()` and `close()` methods.
- Handle IO exceptions using `try-catch`.

### Example 4: Write to File

```java
import java.io.FileWriter;
import java.io.IOException;

public class Example4 {
    public static void main(String[] args) {
        FileWriter writer = null;

        try {
            writer = new FileWriter("test.txt");
            writer.write("This is a file handling example.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.flush();
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
```

## BufferedReader & BufferedWriter

- `BufferedReader` reads efficiently using a buffer.
- `BufferedWriter` writes efficiently with a buffer.

Buffered I/O is preferred for performance over character streams like `FileReader`/`FileWriter`.

## FileInputStream / FileOutputStream

Used to handle raw byte streams (for binary files or character data converted to bytes).

### Example 5: Read and Write using Streams

```java
import java.io.*;

public class Example5 {
    public static void main(String[] args) {
        File file = new File("abc_new.txt");

        try (FileOutputStream fos = new FileOutputStream(file)) {
            String content = "Line 1\nLine 2\nLine 3";
            fos.write(content.getBytes());
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

## Serialization & Deserialization

Serialization is the process of saving an object’s state to a file, and deserialization restores the object from that file.

### Employee.java (Serializable)

```java
import java.io.Serializable;

public class Employee implements Serializable {
    private String name;
    private double salary;
    private String company;

    public Employee(String name, double salary, String company) {
        this.name = name;
        this.salary = salary;
        this.company = company;
    }

    @Override
    public String toString() {
        return name + " - " + salary + " - " + company;
    }
}
```

### Example 6: Serialize Object

```java
import java.io.*;

public class Example6 {
    public static void main(String[] args) {
        Employee emp = new Employee("Sowmya", 50000, "HCL");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employee.dat"))) {
            oos.writeObject(emp);
            System.out.println("Employee object serialized.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### Example 7: Deserialize Object

```java
import java.io.*;

public class Example7 {
    public static void main(String[] args) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employee.dat"))) {
            Employee emp = (Employee) ois.readObject();
            System.out.println("Deserialized object: " + emp);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
```

## transient Keyword

A variable marked with `transient` will not be serialized. It will take a default value when deserialized.

## Externalization

Externalization gives full control over the serialization process using `writeExternal()` and `readExternal()` from the `Externalizable` interface.

### Employee_new.java

```java
import java.io.*;

public class Employee_new implements Externalizable {
    private int id;
    private String name;
    private double salary;

    public Employee_new() {}

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
        return "Employee[id=" + id + ", name=" + name + ", salary=" + salary + "]";
    }
}
```

### Example 8: Write Using Externalization

```java
import java.io.*;

public class Example8 {
    public static void main(String[] args) {
        Employee_new emp = new Employee_new(25, "Sathvika", 90000.00);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employee_ext.dat"))) {
            oos.writeObject(emp);
            System.out.println("Externalized object written.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### Example 9: Read Using Externalization

```java
import java.io.*;

public class Example9 {
    public static void main(String[] args) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employee_ext.dat"))) {
            Employee_new emp = (Employee_new) ois.readObject();
            System.out.println("Read externalized object: " + emp);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
```

## final, finally, finalize

| Keyword     | Description                                                  |
|-------------|--------------------------------------------------------------|
| `final`     | Prevents modification of variables, methods, or class        |
| `finally`   | Block that always runs after try-catch                       |
| `finalize()`| Called by garbage collector before destroying an object      |

### Example 10: Using all Three

```java
public class FinalDemo {

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize() called for: " + this);
    }

    public static void main(String[] args) {
        final int number = 42;
        System.out.println("Final variable: " + number);

        try {
            int result = 100 / 10;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Finally block always runs.");
        }

        FinalDemo obj1 = new FinalDemo();
        FinalDemo obj2 = new FinalDemo();
        obj1 = null;
        obj2 = null;

        System.gc();

        System.out.println("End of main method.");
    }
}
```
