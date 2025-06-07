# 📝 DAY-3 – Java Basics: Data Types, Access Specifiers & Arrays

---

## 📚 Data Types in Java

In Java, data types define the type of data a variable can hold.

---

### 🔹 Two Main Categories:
1. **Primitive Data Types**
2. **Non-Primitive (Reference) Data Types**

---

### 1️⃣ Primitive Data Types (8 Types)

| Type     | Size     | Description                             | Example                  |
|----------|----------|-----------------------------------------|--------------------------|
| `byte`   | 1 byte   | Stores small integers (-128 to 127)     | `byte b = 100;`          |
| `short`  | 2 bytes  | Larger than byte                        | `short s = 5000;`        |
| `int`    | 4 bytes  | Default integer type                    | `int i = 100000;`        |
| `long`   | 8 bytes  | Very large integers                     | `long l = 123456789L;`   |
| `float`  | 4 bytes  | Decimal values (single precision)       | `float f = 3.14f;`       |
| `double` | 8 bytes  | Decimal values (double precision)       | `double d = 3.14159;`    |
| `char`   | 2 bytes  | Single character (Unicode)              | `char c = 'A';`          |
| `boolean`| 1 bit    | Stores true or false                    | `boolean flag = true;`   |

---

### 2️⃣ Non-Primitive (Reference) Data Types

Non-primitive types are created using classes and can store multiple values or complex structures.

Includes:
- **String** → sequence of characters
- **Array** → collection of elements of the same type
- **Class** → blueprint for creating objects
- **Interface** → defines contract/structure
- **Object** → instance of a class

#### Examples:
```java
String name = "Anusha";
int[] numbers = {1, 2, 3, 4};

 Sample Code:

public class DataTypeExample {
    public static void main(String[] args) {
        int age = 21;
        double marks = 95.75;
        char grade = 'A';
        boolean passed = true;
        String name = "Anusha";

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + grade);
        System.out.println("Passed: " + passed);
    }
}

ccess Specifiers in Java
Access specifiers define the visibility or accessibility of classes, methods, variables, and constructors.

Access Specifier	Within Class	Within Package	Outside Package (Subclass)	Outside Package (Non-subclass)
private    	          ✅	             ❌                        ❌                                 ❌
(default)	          ✅         	     ✅	                 	❌                                 ❌
protected	          ✅                 ✅	                ❌                                 ❌
public  		  ✅	              ✅                       ❌                                 ✅ 

🔎 Examples:
1. private:


class Student {
    private int marks = 90;
}
2. (default) (no modifier):


class Student {
    int age = 20;  // default access
}
3. protected:


class Student {
    protected String name = "Anusha";
}
4. public:


public class Student {
    public void display() {
        System.out.println("Public method");
    }
}
📦 ARRAY in Java
An array is a group of values stored in a single variable name, accessed using indexes.

💻 Example:

class A {
    public static void main(String args[]) {
        System.out.println("Hello World " + args[0]);
        System.out.println("Hello World " + args[1]);
        System.out.println("Hello World " + args[2]);
        System.out.println("Hello World " + args[3]);
    }
}
✅ Arrays, data types, and access specifiers are foundational concepts that every Java programmer should understand.


