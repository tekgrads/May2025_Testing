Reflection API in Java
What is Reflection?
Reflection is a feature that allows a Java program to inspect or modify its structure at runtime (methods, fields, constructors).

It belongs to the java.lang.reflect package.

Key Classes in Reflection API
Class/Interface	Description
Class	Represents classes and interfaces
Method	Represents a method
Field	Represents a field
Constructor	Represents a constructor
Array, Modifier	Utility classes for working with arrays, modifiers, etc.

Example 1: List Method Names Using Reflection
java
Copy
Edit
package com.tekgrads;
import java.lang.reflect.Method;

class A {
    public void m1() {
        System.out.println("It is the 1st method with no parameters");
    }
    public void m2(int i) {
        System.out.println("It is the 2nd method having parameters, and the value is " + i);
    }
}

public class Example1 {
    public static void main(String[] args) throws ClassNotFoundException {
        String className = "com.tekgrads.A";
        Class c1 = Class.forName(className);
        Method[] m = c1.getDeclaredMethods();

        for (Method m1 : m) {
            System.out.println(m1.getName());
        }
    }
}
Output (may vary by method order):

nginx
Copy
Edit
m2
m1
Example 2: Creating Object and Invoking Methods via Reflection
java
Copy
Edit
package com.tekgrads;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class B {
    public void m1() {
        System.out.println("this is 1st method");
    }
    public void m2() {
        System.out.println("this is 2nd method");
    }
}

public class Example2 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException {
        String className = "com.tekgrads.B";
        loadClass(className);
    }

    private static void loadClass(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class c1 = Class.forName(className);
        Method[] methods = c1.getDeclaredMethods();
        Object obj = c1.newInstance();

        for (Method m : methods) {
            System.out.println("Method name is " + m.getName());
            m.invoke(obj);
        }
    }
}
Output:

pgsql
Copy
Edit
Method name is m2
this is 2nd method
Method name is m1
this is 1st method
Important Reflection Notes for Interviews
Reflection is powerful but can break encapsulation.

It is slower than direct access.

Avoid using in performance-critical code.

Common use cases: Frameworks, Debuggers, Dependency Injection tools (e.g., Spring).

Island Objects
What are Island Objects?
A group of interconnected objects that are no longer reachable from any active thread or GC root, making them eligible for garbage collection.

They form a logical island in heap memory — connected internally, but disconnected from the rest of the program.

Example Program: Island Object
java
Copy
Edit
package com.tekgrads;

class C {
    C c1;
}

public class IslandObjects {
    public static void main(String[] args) {
        C c1 = new C();
        C c2 = new C();
        C c3 = new C();

        c1.c1 = c2;
        c2.c1 = c3;
        c3.c1 = c1;

        c1 = c2 = c3 = null;

        System.out.println("The Island object process is completed");
    }
}
Output:

csharp
Copy
Edit
The Island object process is completed
Explanation:

Although c1, c2, and c3 refer to each other, all external references are removed, making them unreachable, and thus garbage collectable.



✅ 1. String in Java
String is a class in java.lang package.

Immutable: Once created, it cannot be changed.

Stored in String Constant Pool (SCP) or Heap (based on how it's created).

🔹 Ways to Create a String
Method	Code	Stored In
Literal	String s = "abc";	String Constant Pool (SCP)
Using new	String s = new String("abc");	Heap (Non-SCP)

🔹 Example – Difference Between == and .equals()
java
Copy
Edit
String s1 = "abc";
String s2 = "abc";
String s3 = new String("abc");

System.out.println(s1 == s2);       // true  (same reference)
System.out.println(s1 == s3);       // false (different memory)
System.out.println(s1.equals(s3));  // true  (same content)
✅ 2. String Constant Pool vs Heap
Feature	Constant Pool (SCP)	Heap / Non-Constant Pool
Created with	String literal	new String()
Duplicate values	Avoided (interned)	Allowed (each gets new memory)
Memory efficient	Yes	No
== returns	true (same ref)	false (diff object)
.equals() returns	true	true (if content same)

✅ 3. String Concatenation
java
Copy
Edit
String s = "abc";
s = s + "123";        // Using +
s = s.concat("xyz");  // Using concat()
📌 Note: Concatenation results in new objects in heap, not constant pool.

✅ 4. Important String Methods
Method	Description	Example
length()	Returns string length	s.length()
charAt(i)	Returns char at index i	s.charAt(0)
indexOf('a')	First index of character	s.indexOf('a')
lastIndexOf('a')	Last index of character	s.lastIndexOf('a')
substring(i, j)	Substring from i to j-1	s.substring(1, 4)
toUpperCase()	Converts to upper case	s.toUpperCase()
compareTo()	Lexicographic comparison	s1.compareTo(s2)
replace('a','z')	Replace all 'a' with 'z'	s.replace('a','z')
repeat(n)	Repeats the string n times	s.repeat(3)
isEmpty()	Checks if string is empty	s.isEmpty()

🔹 Example on .split()
java
Copy
Edit
String colors = "red,green,blue";
String[] arr = colors.split(",");

for(String color : arr) {
    System.out.println(color);
}
Output:

nginx
Copy
Edit
red
green
blue
✅ 5. StringBuffer
Mutable → Contents can be changed.

Thread-safe (synchronized) → Suitable for multithreading.

Use when there are frequent modifications to the string.

🔹 StringBuffer Methods
Method	Description
append()	Adds data at the end
insert(index, val)	Inserts value at index
delete(start, end)	Deletes chars from start to end-1
reverse()	Reverses the content

🔹 Example: StringBuffer Operations
java
Copy
Edit
StringBuffer sb = new StringBuffer("xyz");
sb.append("123");          // xyz123
sb.append("abc");          // xyz123abc
sb.insert(8, 2);           // xyz123ab2c
sb.delete(0, 2);           // z123ab2c
System.out.println(sb.reverse()); // c2ba321z
🔹 Comparison of StringBuffers
java
Copy
Edit
StringBuffer sb1 = new StringBuffer("abc");
StringBuffer sb2 = new StringBuffer("abc");

System.out.println(sb1 == sb2);          // false
System.out.println(sb1.equals(sb2));     // false
System.out.println(sb1.hashCode() == sb2.hashCode()); // false
📌 .equals() is not overridden in StringBuffer, so it behaves like ==.

✅ Key Interview Points
Topic	Must Remember
Strings	Immutable, stored in SCP if literals
== vs equals()	== → reference, .equals() → content
Constant Pool	Avoids duplicates
StringBuffer	Mutable, thread-safe
StringBuilder	Mutable, not thread-safe (faster in single-threaded apps)
concat vs append	concat() is for String (returns new), append() is for StringBuffer (modifies in place)