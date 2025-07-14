📂 Java File Handling Concepts
📁 File in Java
A File in Java represents the path to a file or directory and is part of the java.io package. It supports operations like creating, reading, writing, deleting, and checking file properties.

⚠️ All IO operations throw checked exceptions, so they require try-catch blocks.

📝 Example 1: Create a Directory
java
Copy
Edit
package com.tekgrads;

import java.io.File;

public class Example1 {
    public static void main(String[] args) {
        File f = new File("test");
        f.mkdir();
        System.out.println("completed");
    }
}
📝 Example 2: Creating a File
java
Copy
Edit
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
📖 FileReader
FileReader reads data from a file character by character.

📝 Example 3: FileReader Program
java
Copy
Edit
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
🖊️ FileWriter
FileWriter is used to write characters to a file. Always close it using flush() and close().

📝 Example 4: FileWriter Program
java
Copy
Edit
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
📚 BufferedReader
BufferedReader efficiently reads text using buffers. Paired with InputStreamReader to convert byte streams to character streams.

📄 BufferedWriter and File Streams
Efficiently writes/reads data using buffers and byte streams.

📝 Example 6: Using FileOutputStream and FileInputStream
java
Copy
Edit
package com.tekgrads;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Example6 {
    public static void main(String[] args) {
        File file = new File("abc_new.txt");

        // Writing to file
        try (FileOutputStream fos = new FileOutputStream(file)) {
            String content = "this is a 1st line\nthis is 2nd line\nthis is 3rd line";
            byte[] bytes = content.getBytes();
            fos.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Reading from file
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
📦 Serialization & Deserialization
Serialization: Converts object into byte stream.

Deserialization: Recreates object from byte stream.

📝 Example 7: Serialization
java
Copy
Edit
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
📝 Example 8: Deserialization
java
Copy
Edit
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
🔒 transient Keyword
Used in serialization to prevent a field from being serialized. Its value will not be saved and restored.

🔁 Externalization
You control the serialization logic using Externalizable interface.

🔸 Methods:
writeExternal(): Controls what is written.

readExternal(): Controls what is read.

📝 Employee_new.java (Class with Externalization)
java
Copy
Edit
package com.tekgrads;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Employee_new implements Externalizable {

    private int id;
    private String name;
    private double salary;

    public Employee_new() {} // mandatory public no-arg constructor

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
📝 Example 9: Writing Externalized Object
java
Copy
Edit
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
📝 Example 10: Reading Externalized Object
java
Copy
Edit
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
🔑 Final, Finally, Finalize
Keyword	Purpose
final	Constant or unchangeable (variable, method, class)
finally	Always executes after try-catch
finalize()	Cleanup before garbage collection

📝 Example 11: Final, Finally, Finalize
java
Copy
Edit
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

        System.gc(); // Suggests GC to run

        System.out.println("End of main method");
    }
}