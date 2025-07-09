## Class 23: (06/07/2025)

### HashSet
- Stores unique elements only.
- No duplicates allowed.
- No guaranteed order of elements (insertion order not preserved).
- Allows one null element.
- Backed internally by a HashMap for storage.

#### Code for HashSet:
```java
import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;

public class Example15 {
	public static void main(String[] args) {
		HashSet hashSet = new HashSet();
		
		hashSet.add(new Employee("Ramesh", 28, 20000d, "HCL"));
		hashSet.add(new Employee("Ramesh", 28, 20000d, "HCL"));
		hashSet.add(new Employee("Rakesh", 30, 4000d, "Accenture"));
		hashSet.add(new Employee("Suresh", 31, 1000d, "Infosys"));
		hashSet.add(new Employee("Harish", 31, 100000d, "Cognizant"));
		hashSet.add(new Employee("Chandan", 31, 10000d, "Persistent"));
		hashSet.add(new Employee("Ravi", 31, 50000d, "Flipkart"));
		
		System.out.println(hashSet);
	}
}
```

---

### HashMap
- Stores data as key-value pairs.
- No order is maintained (insertion or sorting).
- Allows one null key and multiple null values.
- Duplicate keys are not allowed — new value replaces old.
- Provides fast key-based access (average time complexity: O(1)).

#### Code for HashMap:
```java
import java.util.HashMap;

public class Example16 {
	public static void main(String[] args) {
		HashMap map = new HashMap();
		
		map.put(1, "Suresh");
		map.put(2, "Ramesh");
		map.put(3, "Rakesh");
		map.put(4, "Hareesh");
		map.put(null, "Test");
		map.put(5, null);
		map.put(4, "Sateesh");
		
		System.out.println(map);
		System.out.println(map.get(1));
		System.out.println(map.get(null));
	}
}
```

---

### TreeMap
- Implements NavigableMap and SortedMap interfaces.
- Stores entries in ascending key order by default.
- Does not allow null keys, but allows multiple null values.
- Duplicate keys are not allowed (latest value replaces the old one).

#### Code For TreeMap:
```java
import java.util.HashMap;
import java.util.TreeMap;

public class Example17 {
	public static void main(String[] args) {
		TreeMap map = new TreeMap();
		
		map.put(6, new Employee("Ravi", 31, 50000d, "Flipkart"));
		map.put(1, new Employee("Ramesh", 28, 20000d, "HCL"));			
		map.put(4, new Employee("Harish", 31, 100000d, "Cognizant"));
		map.put(5, new Employee("Chandan", 31, 10000d, "Persistent"));
		map.put(2, new Employee("Rakesh", 30, 4000d, "Accenture"));
		map.put(3, new Employee("Suresh", 31, 1000d, "Infosys"));
		
		System.out.println(map);
	}
}
```

---

### Generics
- Heterogeneous = different objects
- Generics is used to restrict heterogeneous.
- This concept is derived from templates.
- It ensures type safety.

#### Example code:
```java
public class Ex4 {
	public static void main(String[] args) {
		Test<Integer, String, Integer> t = new Test<>(1, "Test");
		t.checkDataType();
		System.out.println(t.returnAnyDataType("Integer"));
		System.out.println("----------------------");
		Test<String, String, String> t2 = new Test<>("One", "Two");
		t2.checkDataType();
		System.out.println(t.returnAnyDataType("String"));
	}
}

class Test<T, K, P> {
	T i;
	K j;

	public Test(T i, K j) {
		this.i = i;
		this.j = j;
	}

	void checkDataType() {
		System.out.println("i type is " + i.getClass().getTypeName());
		System.out.println("j type is " + j.getClass().getTypeName());
	}

	P returnAnyDataType(String type) {
		if (type.equals("Integer")) {
			return (P) Integer.valueOf(1);
		} else if (type.equals("String")) {
			return (P) "test";
		}
		return null;
	}
}
```

---

### Wildcard Generics
- Wildcard in Generics allows writing flexible code without knowing the exact type.
- Syntax:
  - `<?>` – unknown type
  - `<? extends ParentClass>` – any subclass of ParentClass
  - `<? super ParentClass>` – ParentClass or its superclasses

#### Example code:
```java
public class Ex5 {
	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		al.add(1);
		al.add("test");
		System.out.println(al);

		List<String> list = new ArrayList<>();
		list.add("Test");
		list.add("Test2");
		System.out.println(list);

		List<?> list2 = new ArrayList<>();
		// list2.add("Test"); // not allowed

		List<? extends Number> list3 = new ArrayList<>();
		// list3.add(1); // not allowed

		List<? super Number> list4 = new ArrayList<>();
		list4.add(1);
		list4.add(2.0);
		System.out.println(list4);
	}
}
```

---

### HashMap with Generics
#### Example code:
```java
public class Ex6 {
    public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap();
		map.put(1, "Raju");
		map.put(6, "Rajesh");
		map.put(3, "Rakesh");
		map.put(2, "Ramesh");
		map.put(4, "Suresh");
		
		System.out.println(map);
		
		for (Entry<Integer, String> entry : map.entrySet()) {
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}
	}
}
