Generics in Java
What are Generics?
Generics in Java allow classes, interfaces, and methods to operate on objects of various types while providing compile-time type safety.

Key Points:
Works with classes, interfaces, and methods.

Provides type-safe templates.

Reduces the need for explicit type casting.

Avoids ClassCastException.

Increases code reusability.

Why Use Generics?
Feature	Benefit
Type Safety	Detects errors at compile time
Code Reusability	Write once, use for multiple data types
Readability	Code becomes cleaner and more understandable
No Casting Required	Avoids runtime casting issues

Example 1: Generic Class and Method
java
Copy
Edit
package com.tekgrads;

public class Example1 {
    public static void main(String[] args) {
        Test<Integer, String, Integer> t = new Test<>(1, "Test");
        t.checkDataType();
        System.out.println(t.returnAnyDataType("Integer"));

        System.out.println();

        Test<String, String, String> t2 = new Test<>("One", "Two");
        t2.checkDataType();
        System.out.println(t2.returnAnyDataType("String"));

        System.out.println();

        Test<String, Integer, String> t3 = new Test<>("hii", 1);
        t3.checkDataType();
        System.out.println(t3.returnAnyDataType("String"));

        System.out.println();

        Test<String, String, Integer> t4 = new Test<>("hii", "hello");
        t4.checkDataType();
        System.out.println(t4.returnAnyDataType("Integer"));
    }
}

class Test<A, B, C> {
    A i;
    B j;

    public Test(A i, B j) {
        this.i = i;
        this.j = j;
    }

    void checkDataType() {
        System.out.println("i type is " + i.getClass().getTypeName());
        System.out.println("j type is " + j.getClass().getTypeName());
    }

    C returnAnyDataType(String type) {
        if (type.equals("Integer")) {
            return (C) Integer.valueOf(1);
        } else if (type.equals("String")) {
            return (C) "abc";
        }
        return null;
    }
}
Output
pgsql
Copy
Edit
i type is java.lang.Integer
j type is java.lang.String
1

i type is java.lang.String
j type is java.lang.String
abc

i type is java.lang.String
j type is java.lang.Integer
abc

i type is java.lang.String
j type is java.lang.String
1
Wildcard Generics
What is a Wildcard in Generics?
Wildcard <?> is used when the exact type is unknown. It helps in creating more flexible methods or classes that can work with any data type within certain bounds.

Syntax:
<?> – unknown type

<? extends T> – any subclass of T

<? super T> – T or any of its superclasses

Example 2: Wildcard Generics in Lists
java
Copy
Edit
package com.tekgrads;

import java.util.ArrayList;
import java.util.List;

public class Example2 {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(9);
        l.add(7);
        l.add(10);
        l.add(15);
        System.out.println("The list elements are: " + l);

        List<? super Number> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2.0);
        l1.add(20.00);
        l1.add(15);
        System.out.println("Elements on list2: " + l1);

        List<? super Object> l2 = new ArrayList<>();
        l2.add(100);
        l2.add("one");
        l2.add(10.0);
        l2.add(90.00);
        l2.add('a');
        System.out.println("Elements on list3: " + l2);
    }
}
Output
less
Copy
Edit
The list elements are: [1, 9, 7, 10, 15]
Elements on list2: [1, 2.0, 20.0, 15]
Elements on list3: [100, one, 10.0, 90.0, a]
Interview Questions on Generics
What are Generics in Java and why are they used?

Can we use primitive types like int or double in Generics?

No, only objects (e.g., Integer, Double) are allowed.

What is the difference between <? extends T> and <? super T>?

What is type erasure in Generics?

Can we create an array of generic type in Java?

What is the default type for an unbounded wildcard (<?>)?

How do Generics improve type safety at compile time?

How do bounded types (<T extends Class>) work in Generics?