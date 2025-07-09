# Java Class 20 Notes – 🔍 Reflection API in Java

## 📌 1. What is Reflection in Java?

- Reflection is an API that allows Java programs to **inspect** and **manipulate** internal properties of classes, methods, constructors, and fields **at runtime**.
- It is part of the `java.lang.reflect` package.

> 🔍 With Reflection, you can examine or modify the behavior of classes even if you don't know their names at compile time.

---

## 🧠 Use Cases

- IDEs and Debuggers (e.g., Eclipse, IntelliJ)
- Frameworks like Spring, Hibernate
- Serialization & Deserialization (e.g., JSON <-> Java)
- Testing frameworks (JUnit, Mockito)
- Dependency Injection
- Dynamic proxies

---

## 📦 Key Classes in `java.lang.reflect`

| Class/Interface | Description                              |
|-----------------|------------------------------------------|
| `Class<?>`       | Represents a Java class or interface     |
| `Method`         | Represents a method of a class           |
| `Field`          | Represents a field (variable) of a class |
| `Constructor`    | Represents a class constructor           |
| `Modifier`       | Used to inspect access levels            |

---

## 🛠️ Example: Accessing Class Information

package com.tekgrads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class A {
	public void test1() {
		System.out.println("In test1 method");
	};
	public void test2() {
		System.out.println("in test2");
	};
}

public class Example1 {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String className = "com.tekgrads.A";
		
		loadClass(className);
		
				

	}

	private static void loadClass(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class c1 = Class.forName(className);
		
		Class c2 = Class.forName(className);
		
		
		System.out.println(c1 == c2);
		
		Method [] methods = c1.getDeclaredMethods();
		
		Object obj = c1.newInstance();
		
		for(Method m : methods) {
			System.out.println("Calling "+ m.getName());
			
			m.invoke(obj);
		}
		
		
		
		
	}

}

## 🌴 2. Island Objects in Java

### 🧠 Definition:

**Island objects** are a **group of objects that reference each other** (form a cycle or network), but none of them are reachable from the **root references** (like main thread, static variables, etc.).

> 🔄 Even though they reference each other, they become **unreachable** from the rest of the application and are thus **eligible for garbage collection (GC)**.

---

## 🧩 Example:

package com.tekgrads;

class P {
	P p1;
}

public class IslandObjects {

	public static void main(String[] args) {
		P p1 = new P();
		P p2 = new P();
		P p3 = new P();
		p1.p1 = p2;
		p2.p1=p3;
		p3.p1=p1;
		
		p1=p2=p3=null;
		
		System.out.println("Completed");

	}

}

## 💬 3. Strings & String Pool

### 🔤 What is a String?
- A sequence of characters.
- **Immutable** – once created, can't be changed.

### 💾 String Pool
- Special memory area inside the JVM where string literals are stored to **avoid duplication**.

### ✅ Example:
```java
String s1 = "Java";
String s2 = "Java";
String s3 = new String("Java");

System.out.println(s1 == s2); // true (both from pool)
System.out.println(s1 == s3); // false (new object in heap)

🔗 String Concatenation
String a = "ja";
String b = "va";
String c = "java";
String d = a + b;

System.out.println(c == d); // false (runtime creation)

📌 Common String Methods:
String s = "abcc";

s.length();                // 4
s.charAt(1);               // 'b'
s.indexOf('b');            // 1
s.lastIndexOf('c');        // 3
s.substring(1);            // "bcc"
s.toUpperCase();           // "ABCC"
new StringBuilder(s).reverse(); // "ccba"


✂️ Split Example:
String names = "apple,cat,dog";
String[] arr = names.split(",");
for (String n : arr) {
    System.out.println(n);
}

🔄 4. StringBuffer

Mutable

Thread-safe (synchronized methods)

✅ Example:
StringBuffer s1 = new StringBuffer("abc");
s1.append("123");
System.out.println(s1); // abc123

StringBuffer s2 = new StringBuffer("abc");
System.out.println(s1 == s2);        // false
System.out.println(s1.equals(s2));   // false


🚀 5. StringBuilder
Mutable

Not thread-safe

Faster in single-threaded environments

✅ Example:
StringBuilder sb = new StringBuilder("xyz");
sb.append("123");
System.out.println(sb); // xyz123
📦 6. Arrays
Container for fixed-size elements of the same type.

✅ Basic Example:
int[] arr = new int[5];
arr[0] = 10;
System.out.println(arr[0]); // 10

✅ Enhanced For Loop:
for (int val : arr) {
    System.out.println(val);
}


✅ Print Full Array:
import java.util.Arrays;
System.out.println(Arrays.toString(arr));


7. Array Sorting
✅ Example:
int[] nums = {42, 5, 7, 100, 1};
Arrays.sort(nums);
System.out.println(Arrays.toString(nums)); // [1, 5, 7, 42, 100]


👨‍💼 8. Employee Example
✅ Store Employee Details:

class Employee {
    String name;
    Integer age;
    Double salary;
    String company;

    public Employee(String name, Integer age, Double salary, String company) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.company = company;
    }

    public String toString() {
        return name + " " + age + " " + salary + " " + company;
    }
}

public class Ex4 {
    public static void main(String[] args) {
        Employee[] employees = {
            new Employee("Shyam", 28, 90000d, "Google"),
            new Employee("Anu", 24, 85000d, "Amazon")
        };

        for (Employee e : employees) {
            System.out.println(e);
        }
    }
}
💾 Output:

Shyam 28 90000.0 Google
Anu 24 85000.0 Amazon