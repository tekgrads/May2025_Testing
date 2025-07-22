File Handling in Java

---

## 🧠 What is File Handling?

File handling in Java allows you to **create, read, write, update, and delete** files using classes from the `java.io` and `java.nio.file` packages.

---

## 📁 Common Classes Used

| Class Name        | Description                                |
|-------------------|--------------------------------------------|
| `File`            | Used to create, delete, and inspect files  |
| `FileReader`      | Reads character files                      |
| `BufferedReader`  | Reads text efficiently                     |
| `FileWriter`      | Writes to character files                  |
| `BufferedWriter`  | Writes text efficiently                    |
| `Scanner`         | Reads input including from files           |
| `PrintWriter`     | Prints formatted text to file              |

---

## 🔹 1. Creating a File

```java
import java.io.File;
import java.io.IOException;

public class CreateFile {
    public static void main(String[] args) {
        try {
            File file = new File("example.txt");
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
🔹 2. Writing to a File
java
Copy
Edit
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("example.txt");
            writer.write("Hello, Java File Handling!");
            writer.close();
            System.out.println("Successfully written to the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
🔹 3. Reading from a File
java
Copy
Edit
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) {
        try {
            File file = new File("example.txt");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                System.out.println(data);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
🔹 4. Deleting a File
java
Copy
Edit
import java.io.File;

public class DeleteFile {
    public static void main(String[] args) {
        File file = new File("example.txt");
        if (file.delete()) {
            System.out.println("Deleted: " + file.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }
}
🛠 File Class Methods
Method Name	Description
createNewFile()	Creates a new file
delete()	Deletes the file
exists()	Checks if the file exists
getName()	Returns file name
getAbsolutePath()	Returns the absolute path
length()	Returns file size in bytes
canRead() / canWrite()	Checks permissions

🔐 Exception Handling
File operations often throw checked exceptions like:

IOException

FileNotFoundException

Use try-catch to handle them properly.

