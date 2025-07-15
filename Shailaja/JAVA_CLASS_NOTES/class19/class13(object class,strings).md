Object Class in Java
Definition
Object is the superclass of all classes in Java.

All classes directly or indirectly inherit from it.

It defines methods that are available to all objects.

Common Methods in Object Class
Method	Description
toString()	Returns a string representation of the object
equals(Object)	Compares two objects for logical equality
hashCode()	Returns a hash code value for the object
getClass()	Returns the runtime class of the object
clone()	Creates and returns a copy of the object (shallow by default)

1. toString() Method
Default: Returns classname@hashcode

Override to print meaningful data

Example 1: Default toString()
java
Copy
Edit
class A {
    int i;
}
java
Copy
Edit
A a = new A();
System.out.println("The value of i is: " + a.i);
System.out.println("The value of a is: " + a);
Output:

kotlin
Copy
Edit
The value of i is: 0
The value of a is: com.tekgrads.A@7106e68e
Example 2: Overridden toString()
java
Copy
Edit
class B {
    int i, j;
    public String toString() {
        return "i=" + i + " and j=" + j;
    }
}
Output:

ini
Copy
Edit
i=10 and j=20
i=20 and j=30
2. equals() Method
==: compares references

equals(): compares content (logical equality)

Override for content comparison

Example 3: Overriding equals()
java
Copy
Edit
class C {
    int i;
    public boolean equals(Object obj) {
        if (!(obj instanceof C)) return false;
        return this.i == ((C) obj).i;
    }
}
Output:

arduino
Copy
Edit
false
true
Example 4: equals() and toString() Together
java
Copy
Edit
class D {
    int i, j;
    public boolean equals(Object obj) {
        return this.i == ((D) obj).i && this.j == ((D) obj).j;
    }
}
Output:

nginx
Copy
Edit
D [i=100, j=200]
D [i=100, j=200]
false
true
3. hashCode() Method
Same content → same hash code (if equals() is true)

Override for collections (e.g. HashMap, HashSet)

Example 5: Custom hashCode
java
Copy
Edit
class E {
    int i, j;
    public int hashCode() {
        return Integer.toString(i).hashCode() + Integer.toString(j).hashCode();
    }
}
Output:

yaml
Copy
Edit
3170
3170
4. clone() Method
Creates a shallow copy

Must implement Cloneable interface

Must override clone() method

Example 6: Basic clone()
java
Copy
Edit
class F implements Cloneable {
    public F cloneMyobj() throws CloneNotSupportedException {
        return (F) this.clone();
    }
}
Output:

ini
Copy
Edit
i=100
i=100
Deep Copy
Creates an independent copy of the object and its nested objects

Example 7: Deep Copy using clone()
java
Copy
Edit
class G implements Cloneable {
    int i, j;
    public G cloneMyObj() throws CloneNotSupportedException {
        return (G) this.clone();
    }
}
Output:

makefile
Copy
Edit
i=10, j=20
i=10, j=20
After Changing g2 i value
i=10, j=20
i=30, j=20
After changing g3 i value
i=40, j=20
i=40, j=20
Pass by Reference
Java passes object references by value

Changes affect original object

Example 8: Pass by Reference
java
Copy
Edit
public static void changeHValues(H h2) {
    h2.i = 10;
    h2.j = 20;
}
Output:

makefile
Copy
Edit
i=1, j=2
Entered in changeHValues
Exited from changeHValues
After executing changeHValues
i=10, j=20
Pass by Value
Java always passes arguments by value

For objects, value = reference

For primitives, no effect on original

Example 9: Pass by Value
java
Copy
Edit
public static void changePrimitive(int i) {
    i = 1000;
}
Output:

makefile
Copy
Edit
i=10, j=20
i =100
Entered in changePrimitive
Exited from changePrimitive
After executing changePrimitive
i =100
Shallow Copy
Clones object but shares references of inner objects

Example 10: Shallow Copy
java
Copy
Edit
class K implements Cloneable {
    int b;
    J i;
    public K cloneMyObj() throws CloneNotSupportedException {
        return (K) this.clone();
    }
}
Output:

makefile
Copy
Edit
k1= b=20, i=a=10
k2= b=20, i=a=10

After modifying k2.i.a = 100
k1= b=20, i=a=100
k2= b=20, i=a=100