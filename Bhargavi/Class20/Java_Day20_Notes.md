DAY20
Advanced Java Concepts
1. Reflection API
Reflection in Java allows you to inspect and modify classes, methods, and fields at runtime.

"It's like asking an object — 'Tell me all your secrets!' And Java actually answers."

import java.lang.reflect.*;

class Robot {
    public void greet() {
        System.out.println("Hello, human!");
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("Robot");
        Method method = clazz.getMethod("greet");
        Object obj = clazz.getDeclaredConstructor().newInstance();
        method.invoke(obj); // Outputs: Hello, human!
    }
}
2. Island Objects
Island objects are unreachable objects that reference each other, forming a group that's no longer reachable from any active part of the program.

"Imagine a group of friends stranded on an island — they talk to each other, but no one else knows they exist."

Garbage collector will eventually clean them up.

class P {
    P p1;

    public static void main(String[] args) {
        P p1 = new P();
        P p2 = new P();
        P p3 = new P();

        p1.p1 = p2;
        p2.p1 = p3;
        p3.p1 = p1;

        p1 = p2 = p3 = null;
    }
}

3. Strings, String Pool

String: Sequence of characters (immutable).
String Pool: Special memory region for string literals (avoids duplication).

String a = "Java";
String b = "Java";
System.out.println(a == b); // true - both refer to the same object in pool

String c = new String("Java");
System.out.println(a == c); // false - 'c' is outside the pool
Use .equals() to compare contents and == to compare references.

4. StringBuffer
Mutable and Thread-safe
Uses synchronized methods

Example:
StringBuffer s1 = new StringBuffer("abc");
s1.append("123");
System.out.println(s1); // abc123
StringBuffer s2 = new StringBuffer("abc");
System.out.println(s1 == s2); // false
System.out.println(s1.equals(s2)); // false

5. StringBuilder
Mutable, but not thread-safe
Faster in single-threaded environments
StringBuilder sb = new StringBuilder("xyz");
sb.append("123");
System.out.println(sb);

6. Arrays
Container that holds fixed-size collection of same-type elements

Basic Example:
int[] arr = new int[5];
arr[0] = 10;
System.out.println(arr[0]);

Enhanced For Loop:
for (int val : arr) {
    System.out.println(val);
}

Print Full Array:
import java.util.Arrays;
System.out.println(Arrays.toString(arr));

7. Array Sorting
int[] nums = {42, 5, 7, 100, 1};
Arrays.sort(nums);
System.out.println(Arrays.toString(nums));

8. Employee Example
 Store Employee Details:
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
            new Employee("Suresh", 28, 90000d, "Google"),
            new Employee("Meena", 24, 85000d, "Amazon")
        };
for (Employee e : employees) {
            System.out.println(e);
        }
    }
}

