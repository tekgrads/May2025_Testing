
# Java String, StringBuffer, and StringBuilder

## **STRING**

- It is a group of characters.
- It has in-built methods.
- Strings are **immutable** — once created, they cannot be changed.

## **Character**
- Holds a single character.

---

## **Creating Strings**

### **Example 1: String Comparison**

```java
package com.tekgrads;

public class Example {

	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "abc";
		
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
	}
}
```

**Output:**
```
true
true
96354
96354
```

---

### **Example 2: Using `new` Operator**

```java
package com.tekgrads;

public class Example2 {

	public static void main(String[] args) {
		String s1 = new String("abc");
		String s2 = new String("abc");

        System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		System.out.println(s1.hashCode() == s2.hashCode());
	}
}
```

**Output:**
```
false
true
true
```

---

## **String Memory Areas**

### **Constant Pool**
- No duplicates allowed.

### **Non-Constant Pool**
- Created using `new` keyword.
- Duplicates are allowed.

---

### **Example 3: String Immutability**

```java
package com.tekgrads;

public class Example3 {

	public static void main(String[] args) {
		String s1 = "abc";
		
		System.out.println(s1);
		s1 = s1 + "123";
		System.out.println(s1);
		s1 = s1 + "hello";
		System.out.println(s1);
	}
}
```

**Output:**
```
abc
abc123
abc123hello
```

---

## **Concatenation Operator**

- Adding strings using:
  - `+` operator
  - `concat()` method

---

### **Example 4: Concatenation Using `+`**

```java
package com.tekgrads;

public class Example4 {

	public static void main(String[] args) {
		String s1 = "ja";
		String s2 = "va";
		String s3 = "java";
		String s4 = s1 + s2;
		
		System.out.println(s3 == s4);
	}
}
```

**Output:**
```
false
```

---

### **Example 5: Concatenation Using `concat()`**

```java
package com.tekgrads;

public class Example5 {

	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = s1.concat("123");
		
		System.out.println(s1);
		System.out.println(s2);
	}
}
```

**Output:**
```
abc
abc123
```

---

## **String Methods**

### **Example 6: Various Methods**

```java
package com.tekgrads;

public class Example6 {

	public static void main(String[] args) {
		String s1 = "abcc";
		System.out.println(s1.length());
		System.out.println(s1.charAt(1));
		System.out.println(s1.indexOf('b'));
		System.out.println(s1.lastIndexOf('c'));
		System.out.println(s1.substring(1));
		System.out.println(s1.substring(1,2));
		System.out.println(s1.toUpperCase());
	}
}
```

**Output:**
```
4
b
1
3
bcc
b
ABCC
```

---

## **Split() Method**

### **Example 7**

```java
package com.tekgrads;

public class Example7 {

	public static void main(String[] args) {
		String names = "rakesh,suresh,ramesh,harish";
		String[] nameArray = names.split(",");
		
		for (String name : nameArray) {
			System.out.println(name);
		}
	}
}
```

**Output:**
```
rakesh
suresh
ramesh
harish
```

---

## **StringBuffer**

- **Mutable**
- Created with `new` keyword
- `equals()` and `hashCode()` are **not overridden**
- `reverse()` method is available
- All methods are **synchronized**

---

## **StringBuilder**

- Similar to `StringBuffer`
- All methods are **non-synchronized**

---

### **Example 8: StringBuffer Append**

```java
package com.tekgrads;

public class Example8 {
	public static void main(String[] args) {
		StringBuffer s1 = new StringBuffer("abc");
		System.out.println(s1);
		s1.append("123");
		System.out.println(s1);
		s1.append("xyz");
		System.out.println(s1);
	}
}
```

**Output:**
```
abc
abc123
abc123xyz
```

---

### **Example 9: Comparing StringBuffer**

```java
package com.tekgrads;

public class Example9 {

	public static void main(String[] args) {
		StringBuffer s1 = new StringBuffer("abc");
		StringBuffer s2 = new StringBuffer("abc");
		
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		System.out.println(s1.hashCode() == s2.hashCode());
		System.out.println(s1.reverse());
	}
}
```

**Output:**
```
false
false
false
cba
```
