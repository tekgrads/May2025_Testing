📚 Collections Framework Overview
Java Collections Framework is a unified architecture to store, retrieve, and manipulate groups of objects.
Located in java.util package.

🔁 ArrayList vs LinkedList
# 🔁 ArrayList vs LinkedList in Java

Both `ArrayList` and `LinkedList` are implementations of the `List` interface in Java and are used to store ordered collections of elements. However, they differ significantly in terms of **performance**, **internal implementation**, and **use-cases**.

---

## 🔍 Core Differences

| Feature / Operation     | ArrayList                             | LinkedList                               |
|-------------------------|----------------------------------------|-------------------------------------------|
| **Internal Structure**  | Dynamic array                          | Doubly linked list                        |
| **Access Time (get())** | Fast (O(1)) – direct index access      | Slow (O(n)) – traversal required          |
| **Insertion (middle)**  | Slow (O(n)) – shifting required        | Fast (O(1)) – pointer adjustments         |
| **Insertion (end)**     | Fast (amortized O(1))                  | Fast (O(1))                               |
| **Deletion (middle)**   | Slow (O(n)) – shifting required        | Fast (O(1)) – pointer adjustments         |
| **Deletion (end)**      | Fast (O(1))                            | Fast (O(1))                               |
| **Memory usage**        | Less (stores only data)                | More (stores data + prev & next pointers) |
| **Iteration**           | Fast due to better cache locality      | Slower due to pointer chasing             |
| **Random Access**       | Supported                              | Not supported                             |
| **Performance**         | Better for search, less memory usage   | Better for frequent insertion/deletion    |
| **Thread Safety**       | Not synchronized by default            | Not synchronized by default               |

---

## ✅ When to Use What?

- **Use `ArrayList` when:**
  - You need fast random access (`get(index)`).
  - Insertions/deletions are mostly at the end.
  - Memory usage is a concern.

- **Use `LinkedList` when:**
  - You need frequent insertions/deletions at the beginning or middle.
  - Random access is not required.
  - You're working with large data where shifts are expensive.

---

## 📦 Example Code

### ➕ ArrayList Example

package com.tekgrads;

import java.util.ArrayList;

public class Example1 {

	public static void main(String[] args) {
		
		ArrayList al = new ArrayList();
		
		al.add(1);
		al.add("One");
		al.add(200.00);
		al.add('c');
		al.add(null);		
		System.out.println(al);
		
		al.remove(2);
		
		System.out.println(al);
		
		al.add(2, "New Element");
		System.out.println(al);
		System.out.println(al.get(2));
		
		System.out.println(al.contains(1));
		
		ArrayList al2 = new ArrayList();
		al2.add(1);
		al2.add("One");
		System.out.println(al.containsAll(al2));
		al2.add("Three");
		System.out.println(al.containsAll(al2));
		
		System.out.println("Pritning ArrayList");
		System.out.println(al);
		al.remove(0);
		al.remove("One");
		System.out.println(al);
		
		
	}

}

➕ LinkedList Example
package com.tekgrads;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Example3 {

	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		
		System.out.println(l);
		
		l.addFirst(0);
		l.addLast(5);
		System.out.println(l);
		
		
		ArrayList al = new ArrayList();
		
		LinkedList ll = new LinkedList(al);
		

	}

}

🧠 Comparator vs Comparable
package com.tekgrads;

import java.util.Comparator;
import java.util.TreeSet;

public class Example12 {

	public static void main(String[] args) {
		TreeSet treeSet = new TreeSet(new MyComparator());
		
		treeSet.add(100);
		treeSet.add(10);
		treeSet.add(50);		
		treeSet.add(6);
		treeSet.add(6);
		treeSet.add(1);
		//treeSet.add(null);
		
		System.out.println(treeSet);

	}

}


class MyComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		if(o1>o2) {
			return -1;
		} else if(o1<o2) {
			return 1;
		} else {
			return 0;
		}
	}
	
}

📦 ArrayList Constructors
ArrayList() → default
ArrayList(int capacity) → with initial capacity
ArrayList(Collection c) → copies from another collection

🧮 Vector
Legacy class from Java 1.0.
Thread-safe (synchronized).
Slower than ArrayList in single-threaded apps

package com.tekgrads;

import java.util.Vector;

public class Example5 {

	public static void main(String[] args) {
		Vector v = new Vector();

		System.out.println(v.capacity()); //[10]

		for(int i=0;i<10;++i){

		v.addElement(i);
		}

		System.out.println(v.capacity()); //[10]

		v.addElement("A");

		System.out.println(v.capacity()); //[20]

		System.out.println(v);

	}

}