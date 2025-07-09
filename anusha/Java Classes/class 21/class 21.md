# Arrays.sort with Comparator & Difference Between Array and Collection

---

## 🔄 Arrays.sort() with Comparator

`Arrays.sort()` can be used not just for primitive arrays, but also for object arrays by using a **Comparator**.

---

### ✅ Example 1: Primitive Array

```java
package com.tekgrads;

import java.util.Arrays;

public class Example3 {

	public static void main(String[] args) {
		int x[] = {100, 1, 200, 1000, 20, 1500, 2};
		
		System.out.println(Arrays.toString(x));
		
		Arrays.sort(x); // Ascending sort for primitive array
		
		System.out.println(Arrays.toString(x));
	}
}
✅ Example 2: Basic Array Operations
package com.tekgrads;

import java.util.Arrays;

public class Example1 {

	public static void main(String[] args) {
		int x[] = new int[10];
		
		for(int i = 0; i < x.length; i++) {
			x[i] = i;
		}
		
		for(int i = 0; i < x.length; i++) {
			System.out.println(x[i]);
		}
		
		System.out.println("----------------------");
		
		for(int i : x) {
			System.out.println(x[i]);
		}
		
		System.out.println(x); // Prints object reference
		
		System.out.println(Arrays.toString(x)); // Prints array content
	}
}
✅ Example 3: Sorting Objects with Comparator
package com.tekgrads;

import java.util.Arrays;
import java.util.Comparator;

class Student {
	String name;
	int marks;
	
	Student(String name, int marks) {
		this.name = name;
		this.marks = marks;
	}
	
	@Override
	public String toString() {
		return name + " - " + marks;
	}
}

public class Example4 {

	public static void main(String[] args) {
		Student[] students = {
			new Student("Anu", 85),
			new Student("Ravi", 72),
			new Student("Zara", 90),
			new Student("Meena", 67)
		};

		// Sorting by marks (ascending)
		Arrays.sort(students, new Comparator<Student>() {
			public int compare(Student s1, Student s2) {
				return s1.marks - s2.marks;
			}
		});

		System.out.println("Sorted by marks (asc):");
		for(Student s : students) {
			System.out.println(s);
		}

		// Sorting by name (alphabetical)
		Arrays.sort(students, new Comparator<Student>() {
			public int compare(Student s1, Student s2) {
				return s1.name.compareTo(s2.name);
			}
		});

		System.out.println("\nSorted by name (alphabetical):");
		for(Student s : students) {
			System.out.println(s);
		}
	}
}
