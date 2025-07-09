# Java Concepts: Reflection API & Island Objects

## 🔍 Reflection API

**Definition**:  
Reflection allows you to load classes dynamically and invoke methods at runtime without knowing their names at compile time.

### ✅ Example

```java
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
		
		Method[] methods = c1.getDeclaredMethods();
		Object obj = c1.newInstance();
		
		for (Method m : methods) {
			System.out.println("Calling " + m.getName());
			m.invoke(obj);
		}
	}
}
```

### 🔽 Output
```
true
Calling test1
In test1 method
Calling test2
in test2
```

---

## 🧠 Island Objects

**Definition**:  
Island objects are a group of objects that reference each other but are no longer reachable from any active part of the application. These become eligible for garbage collection.

### ✅ Example

```java
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
		p2.p1 = p3;
		p3.p1 = p1;

		p1 = p2 = p3 = null;
		System.out.println("Completed");
	}
}
```

### 🔽 Output
```
Completed
```

---

