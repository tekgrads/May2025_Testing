# Java Packages and Access Modifiers

## PACKAGES

A package in Java can be viewed as a directory/folder containing a set of related classes and interfaces. It helps organize Java resources, prevents namespace collisions, and provides modular code structure.

### Benefits of Using Packages

1. **Organization and Modularity**  
   Helps in structuring large projects by grouping related classes.

2. **Access Control and Encapsulation**  
   Use access modifiers (`public`, `protected`, `private`) to control visibility.

3. **Preventing Naming Conflicts**  
   Acts as a namespace, avoiding class name collisions.

4. **Code Reuse and Reusability**  
   Reuse classes and interfaces across multiple applications.

5. **Namespace Management**  
   Ensures unique identification for elements in a project.

---

### User-Defined Packages

Create packages using the `package` keyword.

#### Example 1: Simple Java Program

```java
class Main1 {
    public static void main(String[] args) {
        System.out.println("inside main method");
    }
}


# Output of the Program

```
inside main method
```

---

## 2. Simple Packages Program

### 📄 `pack1.java`
```java
package pack1;

class Main1 {
    public static void main(String[] args) {
        System.out.println("inside pack1 method");
    }
}
```

**Execution Commands:**
```bash
javac -d ../classes pack1/*.java
java -cp ../classes pack1.Main1
```

**Output:**
```
inside pack1 method
```

---

### 📄 `pack2.java`
```java
package pack2;

class Main1 {
    public static void main(String[] args) {
        System.out.println("inside pack2 method");
    }
}
```

**Execution Commands:**
```bash
javac -d ../classes pack2/*.java
java -cp ../classes pack2.Main1
```

**Output:**
```
inside pack2 method
```

---

## 3. Program on Packages

### 📁 `package1`

📄 `Emp1.java`
```java
package emp1;

class Emp1 {
    void display() {
        System.out.println("employee1 name is sowmya");
    }

    public static void main(String[] args) {
        Emp1 a = new Emp1();
        a.display();
    }
}
```

**Execution Commands:**
```bash
javac -d ../classes emp1/*.java
java -cp ../classes emp1.Emp1
```

**Output:**
```
employee1 name is sowmya
```

---

### 📁 `package2`

📄 `Emp2.java`
```java
package emp2;

class Emp2 {
    void display() {
        System.out.println("employee2 name is sneha");
    }

    public static void main(String[] args) {
        Emp2 a = new Emp2();
        a.display();
    }
}
```

**Execution Commands:**
```bash
javac -d ../classes emp2/*.java
java -cp ../classes emp2.Emp2
```

**Output:**
```
employee2 name is sneha
```
```

---



# 📦 Java Package Programs in Git Format

## 4. Folder Inside a Folder Using Packages

### 📁 `com` Package

```java
package com;

class Main1 {
    public static void main(String[] args) {
        System.out.println("inside main method");
    }
}
```

**Execution:**

```bash
javac -d ../classes com/*.java
java -cp ../classes com.Main1
```

**Output:**

```
inside main method
```

---

### 📁 `com.tekgrads` Package

```java
package com.tekgrads;

class Main1 {
    public static void main(String[] args) {
        System.out.println("inside tekgrads");
    }
}
```

**Execution:**

```bash
javac -d ../classes com/tekgrads/*.java
java -cp ../classes com.tekgrads.Main1
```

**Output:**

```
inside tekgrads
```

---

### 📁 `com.rst` Package

```java
package com.rst;

class Main1 {
    public static void main(String[] args) {
         System.out.println("inside rst");
    }
}
```

**Execution:**

```bash
javac -d ../classes com/rst/*.java
java -cp ../classes com.rst.Main1
```

**Output:**

```
inside rst
```





# 📦 Java Package Programs in Git Format

## 4. Folder Inside a Folder Using Packages

### 📁 `com` Package

```java
package com;

class Main1 {
    public static void main(String[] args) {
        System.out.println("inside main method");
    }
}
```

**Execution:**

```bash
javac -d ../classes com/*.java
java -cp ../classes com.Main1
```

**Output:**

```
inside main method
```

---

### 📁 `com.tekgrads` Package

```java
package com.tekgrads;

class Main1 {
    public static void main(String[] args) {
        System.out.println("inside tekgrads");
    }
}
```

**Execution:**

```bash
javac -d ../classes com/tekgrads/*.java
java -cp ../classes com.tekgrads.Main1
```

**Output:**

```
inside tekgrads
```

---

### 📁 `com.rst` Package

```java
package com.rst;

class Main1 {
    public static void main(String[] args) {
        System.out.println("inside rst");
    }
}
```

**Execution:**

```bash
javac -d ../classes com/rst/*.java
java -cp ../classes com.rst.Main1
```

**Output:**

```
inside rst
```

---

## 5. Multiple Files in Nested Packages

### 📁 `com` Package

```java
package com;

class Main1 {
    public static void main(String[] args) {
        System.out.println("inside main method");
    }
}
```

**Execution:**

```bash
javac -d ../classes com/*.java
java -cp ../classes com.Main1
```

**Output:**

```
inside main method
```

---

### 📁 `com.tekgrads` - Main1.java

```java
package com.tekgrads;

class Main1 {
    public static void main(String[] args) {
        System.out.println("inside main1 tekgrads");
    }
}
```

**Execution:**

```bash
javac -d ../classes com/tekgrads/*.java
java -cp ../classes com.tekgrads.Main1
```

**Output:**

```
inside main1 tekgrads
```

### 📁 `com.tekgrads` - Main3.java

```java
package com.tekgrads;

class Main3 {
    public static void main(String[] args) {
        System.out.println("inside main3 tekgrads");
    }
}
```

**Execution:**

```bash
javac -d ../classes com/tekgrads/*.java
java -cp ../classes com.tekgrads.Main3
```

**Output:**

```
inside main3 tekgrads
```

---

### 📁 `com.rst` - Main1.java

```java
package com.rst;

class Main1 {
    public static void main(String[] args) {
        System.out.println("inside main1 rst com");
    }
}
```

**Execution:**

```bash
javac -d ../classes com/rst/*.java
java -cp ../classes com.rst.Main1
```

**Output:**

```
inside main1 rst com
```

### 📁 `com.rst` - Main3.java

```java
package com.rst;

class Main3 {
    public static void main(String[] args) {
        System.out.println("inside main3 rst com");
    }
}
```

**Execution:**

```bash
javac -d ../classes com/rst/*.java
java -cp ../classes com.rst.Main3
```

**Output:**

```
inside main3 rst com
```

---

## 6. Nested Folders for Amazon and Flipkart Sites

### 📁 `ai` Package

```java
package ai;

class Main2 {
    void show() {
        System.out.println("webpage");
    }

    public static void main(String[] args) {
        System.out.println("this is a main page");
        Main2 b = new Main2();
        b.show();
    }
}
```

**Execution:**

```bash
javac -d ../classes ai/*.java
java -cp ../classes ai.Main2
```

**Output:**

```
this is a main page
webpage
```

---

### 📁 `ai.amazon` Package

```java
package ai.amazon;

class Main2 {
    void show() {
        System.out.println("webpage");
    }

    public static void main(String[] args) {
        System.out.println("this is a amazon web page");
        Main2 b = new Main2();
        b.show();
    }
}
```

**Execution:**

```bash
javac -d ../classes ai/amazon/*.java
java -cp ../classes ai.amazon.Main2
```

**Output:**

```
this is a amazon web page
webpage
```

---

### 📁 `ai.flip` Package

```java
package ai.flip;

class Main2 {
    void show() {
        System.out.println("webpage");
    }

    public static void main(String[] args) {
        System.out.println("this is a flipkart main page");
        Main2 b = new Main2();
        b.show();
    }
}
```

**Execution:**

```bash
javac -d ../classes ai/flip/*.java
java -cp ../classes ai.flip.Main2
```

**Output:**

```
this is a flipkart main page
webpage
```

---

✅ **Summary:**

Java packages provide a clean segregation of code across folders and modules for better maintainability and clarity.






# 🔐 Access Specifiers in Java

Access specifiers, also known as access modifiers, in Java define the **visibility and accessibility** of classes, variables, methods, and constructors.

There are **4 types** of access specifiers in Java:

---

## 1. `private`

* **Visibility**: Accessible **only within the declaring class**.
* **Usage**: Provides the **highest level of encapsulation**, restricting access to internal implementation details.
* ❌ Cannot be accessed from outside the class (not even by subclasses or other classes in the same package).

---

## 2. `public`

* **Visibility**: Accessible from **any other class**, regardless of the package.
* **Usage**: Provides the **broadest level** of access.

---

## 3. `protected`

* **Visibility**: Accessible **within the same package** and by **subclasses** in other packages.
* **Usage**: Allows for **inheritance-based access** while maintaining some level of encapsulation.

---

## 4. *default* (no modifier specified)

* **Visibility**: Accessible **only within the same package**.
* **Usage**: Known as **package-private access**. If no access modifier is explicitly specified, the member or class has default access.

---

## 🧾 Where Access Specifiers Can Be Used

* **Classes**: `public`, *default*
* **Variables**: `private`, `public`, `protected`, *default*
* **Methods**: `private`, `public`, `protected`, *default*

---

# 📦 Accessing and Inheriting Access Modifiers in Packages

| Access Specifier | Usage                                                 | Inheritance                                                    |
| ---------------- | ----------------------------------------------------- | -------------------------------------------------------------- |
| `private`        | Within the **same class** only                        | ❌ Not inheritable                                              |
| *default*        | Within the **same package**                           | ✅ Inheritable within the package                               |
| `public`         | Anywhere                                              | ✅ Inheritable everywhere                                       |
| `protected`      | Within **same package**, subclasses in other packages | ✅ Inheritable to subclasses; use restricted to subclass itself |

⚠️ Note: `protected` members **can be inherited to classes outside the package**, but **must be accessed only within the subclass**. To use it outside, you must **re-inherit** it again.

---

✅ **Summary**

Java’s access modifiers are a powerful way to control how the members of your classes are accessed and used. 
Proper use of access modifiers enhances code encapsulation, modularity, and reusability.
