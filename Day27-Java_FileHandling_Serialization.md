
# Java File Handling, Serialization & Keywords (`final`, `finally`, `finalize`)

---

##  Java File Handling

Java provides the `java.io` and `java.nio` packages for file operations.

### Reading a File using FileReader
```java
import java.io.*;

public class ReadFile {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("sample.txt");
            int i;
            while ((i = fr.read()) != -1)
                System.out.print((char) i);
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### Writing to a File using FileWriter
```java
import java.io.*;

public class WriteFile {
    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("sample.txt");
            fw.write("Hello File Handling!");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

---

##  Serialization & Deserialization

###  Serialization
Converting an object into a byte stream.

```java
import java.io.*;

class Student implements Serializable {
    int id;
    String name;
    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class SerializeExample {
    public static void main(String[] args) throws IOException {
        Student s1 = new Student(101, "Alice");
        FileOutputStream fout = new FileOutputStream("student.ser");
        ObjectOutputStream out = new ObjectOutputStream(fout);
        out.writeObject(s1);
        out.close();
        fout.close();
        System.out.println("Object serialized");
    }
}
```

### Deserialization
Reading the object back from byte stream.

```java
import java.io.*;

public class DeserializeExample {
    public static void main(String[] args) throws Exception {
        FileInputStream fin = new FileInputStream("student.ser");
        ObjectInputStream in = new ObjectInputStream(fin);
        Student s = (Student) in.readObject();
        System.out.println("ID: " + s.id + ", Name: " + s.name);
        in.close();
        fin.close();
    }
}
```

---

##  Externalization

More control than serialization; we must implement `writeExternal` and `readExternal`.

```java
import java.io.*;

class Employee implements Externalizable {
    int id;
    String name;

    public Employee() {} // public no-arg constructor

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(id);
        out.writeObject(name);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        id = in.readInt();
        name = (String) in.readObject();
    }
}
```

---

## final, finally, finalize

### final
- Used to declare constants, prevent method overriding or inheritance.
```java
final int MAX = 100; // constant
final class Vehicle {} // cannot be extended
```

### finally
- Block that **always executes** after try-catch.
```java
try {
    int x = 5 / 0;
} catch (ArithmeticException e) {
    System.out.println("Error");
} finally {
    System.out.println("This will always run.");
}
```

### finalize
- Method called by **garbage collector** before destroying the object.
```java
protected void finalize() {
    System.out.println("Object is garbage collected");
}
```

---

## Summary

| Concept         | Description |
|----------------|-------------|
| File Handling  | Reading and writing files using `FileReader`, `FileWriter` |
| Serialization  | Converts object to byte stream |
| Deserialization| Converts byte stream back to object |
| Externalization| Manual control of serialization |
| final          | Constant or non-overridable |
| finally        | Executes always |
| finalize       | Called before GC |

