# STRINGS

---

In Java, a `String` is a sequence of characters.
It is not a primitive data type like `int` or `char`;
instead, it is an object of the `String` class in the `java.lang` package.

Example for `char`:

```java
char a = 'a'; // it holds only one character
```

Example for `String`:

```java
String s1 = "abc"; // it is a group of characters called string
```

---

## Creating Strings

We can create strings in 2 ways:

1. **By using a variable name**

```java
String s1 = "tekgrads";
```

2. **By using the `new` keyword**

```java
String s1 = new String("tekgrads");
```

---

## Difference Between `==` and `.equals()` Methods

| Operator    | Compares           | Used For                                            |
| ----------- | ------------------ | --------------------------------------------------- |
| `==`        | Reference or value | Reference check (objects), value check (primitives) |
| `.equals()` | Actual content     | Strings and other objects                           |

---

## Example:

```java
package com.tekgrads;

public class Example1 {

    public static void main(String[] args) {
        String s1 = "abc"; // 1st way to create a string
        String s2 = "abc";
        String s3 = new String("abc"); // 2nd way to create a string

        System.out.println(s1 == s2);       // true
        System.out.println(s1 == s3);       // false

        System.out.println(s1.equals(s2));  // true
        System.out.println(s1.equals(s3));  // true

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s3.hashCode());
    }
}
```

---

### Output:

```
true
false
true
true
96354
96354
96354
```

---







### Constant Pool

The **constant pool** is a special memory area in Java where string literals are stored to save memory.

* If two strings have the same value, **duplicates are not allowed** in the constant pool.
* Even if we assign the same string, it points to the **previous string** for memory optimization.

```java
String s1 = "abc";
String s2 = "abc";
```

---

### Non-Constant Pool 

The **non-constant pool** refers to **heap memory**, where strings created using the `new` keyword are stored.

* Even if the values are the same, **new objects are created**.
* If we create the same string using `new`, a new memory address is assigned every time.

```java
String s3 = new String("abc"); // Creates a new object with a different memory address
```

* When comparing strings from the non-constant pool:

  * `==` returns `false` because it compares memory addresses.
  * `.equals()` returns `true` because it compares the actual values of the strings.

---
# String Concatenation

Concatenation means joining two or more strings to make one single string.

We can concatenate strings in **2 ways**:

1. Using the `+` operator
2. Using the `.concat()` method

---

## Example 2:

```java
package com.tekgrads;

public class Example2 {

    public static void main(String[] args) {
        String s1 = "abc";
        System.out.println(s1);

        // Concatenation - 1st way
        s1 = s1 + "1230";
        System.out.println(s1);

        s1 = s1 + "def";
        System.out.println(s1);

        // Concatenation - 2nd way
        s1 = s1.concat("hello");
        System.out.println(s1);
    }
}
```

### Output:

```
abc
abc1230
abc1230def
abc1230defhello
```

> ✅ Concatenation of 2 strings happens in the **Non-Constant Pool**.



## Example 3: 

```java
package com.tekgrads;

public class Example3 {
    public static void main(String[] args) {
        String s1 = "pro";       // stored in constant pool
        String s2 = "gram";      // stored in constant pool
        String s3 = "program";   // stored in constant pool
        String s4 = s1 + s2;      // stored in non-constant pool

        // we cannot compare the constant and non-constant pool using ==
        System.out.println(s3 == s4); // false

        // we can compare the constant and non-constant pool using .equals()
        System.out.println(s3.equals(s4)); // true

        String s5 = s1.concat(s2); // stored in non-constant pool
        System.out.println(s5);

        System.out.println(s3 == s5);      // false
        System.out.println(s3.equals(s5)); // true
    }
}
```

### Output

```
false
true
program
false
true
```

### Notes

* We cannot compare the constant and non-constant pool using `==`
* We can compare the constant and non-constant pool using `.equals()`
* In the above example: `s1`, `s2`, `s3` are in the constant pool; `s4`, `s5` are in the non-constant pool
* Strings in the constant pool never change
* Strings are **immutable**

---

# String Methods with Examples

## Example 4

```java
package com.tekgrads;

public class Example4 {
    public static void main(String[] args) {
        String s1 = "abcc";
        System.out.println(s1.length());          // returns length
        System.out.println(s1.charAt(1));         // character at index 1
        System.out.println(s1.indexOf('b'));      // index of 'b'
        System.out.println(s1.lastIndexOf('c'));  // last index of 'c'
        System.out.println(s1.substring(1));      // from index 1 to end
        System.out.println(s1.substring(1, 3));   // from index 1 to 2
        System.out.println(s1.toUpperCase());     // convert to uppercase

        String s2 = "abc";
        System.out.println(s1.compareTo(s2));     // lexicographic comparison
        System.out.println(s1.hashCode());        // hash code of string
        System.out.println(s1.isEmpty());         // check if string is empty
        System.out.println(s1.repeat(2));         // repeat string twice
        System.out.println(s1.replace('a', 'z')); // replace 'a' with 'z'
        System.out.println(s1);                   // original string (unchanged)
    }
}
```

### Output

```
4
b
1
3
bcc
bc
ABCC
0
2987073
false
abccabcc
zbcc
abcc
```

---




## `split()` 

The `split()` method is used to break a string into parts (substrings) based on a given separator.

* `split()` breaks one string into many
* Returns an **array of strings**
* Commonly used with commas (`,`), spaces (`" "`), or any character

---

## Example 5

```java
package com.tekgrads;

public class Example5 {

    public static void main(String[] args) {
        String names = "green,red,blue,yellow";

        String[] nameArray = names.split(",");

        for (String name : nameArray) {
            System.out.println(name);
        }
    }
}
```

### Output:

```
green
red
blue
yellow
```






# StringBuffer in Java

Unlike `String`, which cannot be changed after creation, a `StringBuffer` **can be modified** — you can add, delete, or change characters.

* `StringBuffer` is **mutable**.
* **Thread-safe** → Safe to use in **multi-threaded programs** because it is **synchronized**.

---

## Common Methods on `StringBuffer`

| Method      | Description                   |
| ----------- | ----------------------------- |
| `append()`  | Adds text at the end          |
| `insert()`  | Inserts text at a given index |
| `delete()`  | Deletes text between indices  |
| `reverse()` | Reverses the string content   |

---

## Example 6: Using StringBuffer Methods

```java
package com.tekgrads;

public class Example6 {
    public static void main(String[] args) {
        StringBuffer s1 = new StringBuffer("xyz");
        System.out.println(s1);

        s1.append("123");       // adding "123"
        System.out.println(s1);

        s1.append("abc");       // adding "abc"
        System.out.println(s1);

        s1.insert(8, 2);        // insert '2' at index 8
        System.out.println(s1);

        s1.delete(0, 2);        // delete characters from index 0 to 1
        System.out.println(s1);

        System.out.println(s1.reverse()); // reverse the string
    }
}
```

### Output

```
xyz
xyz123
xyz123abc
xyz123ab2c
z123ab2c
c2ba321z
```

---

## Example 7: Comparing Two StringBuffers

If you are using two different `StringBuffer` objects with the same content:

* `==` will return `false`
* `.equals()` will return `false` because it does not override `Object.equals()`
* `hashCode()` values will also be different

```java
package com.tekgrads;

public class Example7 {
    public static void main(String[] args) {
        StringBuffer s1 = new StringBuffer("abc");
        StringBuffer s2 = new StringBuffer("abc");

        System.out.println(s1 == s2);                 // false
        System.out.println(s1.equals(s2));            // false
        System.out.println(s1.hashCode() == s2.hashCode()); // false
    }
}
```

### Output

```
false
false
false
```

---
