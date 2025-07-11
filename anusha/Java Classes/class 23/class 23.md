
# Generics in Java

Generics allow you to write code that works with **heterogeneous (different data types)** using a single class.

---

## ✅ Key Points

- Avoids `ClassCastException`
- Works with classes, interfaces, and methods
- Provides a type-safe template

---

## 🚀 Benefits of Generics

- Code reusability
- Type safety
- No need for explicit type casting

---

## 🔸 Example 1: Program for Generics

```java
package com.tekgrads;

public class Example1 {
    public static void main(String[] args) {
        Test<Integer, String, Integer> t = new Test<>(1, "Test");
        t.checkDataType();
        System.out.println(t.returnAnyDataType("Integer"));

        System.out.println();

        Test<String, String, String> t2 = new Test<>("One", "Two");
        t2.checkDataType();
        System.out.println(t.returnAnyDataType("String"));

        System.out.println();

        Test<String, Integer, String> t3 = new Test<>("hii", 1);
        t3.checkDataType();
        System.out.println(t.returnAnyDataType("String"));

        System.out.println();

        Test<String, String, Integer> t4 = new Test<>("hii", "hello");
        t4.checkDataType();
        System.out.println(t.returnAnyDataType("Integer"));
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
```

### ✅ Output

```
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
```

---

## 🌀 Wildcard Generics

Wildcard in Generics allows writing **flexible code** without knowing the exact type.

### 🔹 Syntax

- `<?>` – unknown type (ambiguous)
- `<? extends Parent>` – any subclass of `Parent`
- `<? super Parent>` – `Parent` or any of its superclasses

---

## 🔸 Example 2: Program for Wildcard Generics

```java
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

        // wildcard generics
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
```

### ✅ Output

```
The list elements are: [1, 9, 7, 10, 15]
Elements on list2: [1, 2.0, 20.0, 15]
Elements on list3: [100, one, 10.0, 90.0, a]
```

---

## 🔸 Example 3: Program on HashMap Using Generics

```java
package com.tekgrads;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Map;

public class Example3 {
    public static void main(String[] args) {
        Map<Integer, String> hm = new HashMap<>();

        hm.put(1, "Ramya");
        hm.put(5, "sowmya");
        hm.put(3, "kavya");
        hm.put(2, "swetha");
        hm.put(4, "navya");

        System.out.println(hm);

        for (Entry<Integer, String> entry : hm.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
    }
}
```

### ✅ Output

```
{1=Ramya, 2=swetha, 3=kavya, 4=navya, 5=sowmya}
Key = 1, Value = Ramya
Key = 2, Value = swetha
Key = 3, Value = kavya
Key = 4, Value = navya
Key = 5, Value = sowmya
```
