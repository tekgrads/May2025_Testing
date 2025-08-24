
#  InheritableThreadLocal & Object Class Methods in Java

##  1. InheritableThreadLocal

InheritableThreadLocal allows child threads to inherit values from the parent thread’s ThreadLocal.

###  Example:
```java
class InheritableThreadLocalDemo {
    public static void main(String[] args) {
        InheritableThreadLocal<String> local = new InheritableThreadLocal<>();
        local.set("Parent Thread Value");

        Thread child = new Thread(() -> {
            System.out.println("Child Thread Value: " + local.get());
        });

        child.start();
    }
}
```
####  Output:
```
Child Thread Value: Parent Thread Value
```

---

##  2. Object Class Methods

###  a. `toString()` – String representation of the object
```java
class Student {
    int id = 1;
    String name = "Sathvika";

    public String toString() {
        return id + " - " + name;
    }

    public static void main(String[] args) {
        Student s = new Student();
        System.out.println(s);  // calls toString()
    }
}
```
####  Output:
```
1 - Sathvika
```

---

###  b. `equals()` – compares content of two objects
```java
class Student {
    int id;
    Student(int id) { this.id = id; }

    public boolean equals(Object o) {
        Student s = (Student)o;
        return this.id == s.id;
    }

    public static void main(String[] args) {
        Student a = new Student(10);
        Student b = new Student(10);
        System.out.println(a.equals(b));  // true
    }
}
```
####  Output:
```
true
```

---

###  c. `hashCode()` – returns object’s hash code
```java
class HashDemo {
    int x;
    HashDemo(int x) { this.x = x; }

    public int hashCode() {
        return x * 10;
    }

    public static void main(String[] args) {
        HashDemo h = new HashDemo(5);
        System.out.println(h.hashCode());
    }
}
```
####  Output:
```
50
```

---

###  d. `clone()` – creates and returns a copy
```java
class Person implements Cloneable {
    int age = 20;

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Person p1 = new Person();
        Person p2 = (Person) p1.clone();

        System.out.println("Original: " + p1.age);
        System.out.println("Cloned: " + p2.age);
    }
}
```
####  Output:
```
Original: 20
Cloned: 20
```

---

###  e. `notify()` and `notifyAll()` – wake up waiting threads
```java
class NotifyDemo {
    synchronized void demo() {
        try {
            wait();
        } catch (InterruptedException e) {}
        System.out.println("Thread Resumed");
    }

    public static void main(String[] args) {
        NotifyDemo obj = new NotifyDemo();

        Thread t1 = new Thread(() -> obj.demo());
        t1.start();

        try { Thread.sleep(500); } catch (Exception e) {}

        synchronized(obj) {
            obj.notify(); // or obj.notifyAll();
        }
    }
}
```
####  Output:
```
Thread Resumed
```

---

###  f. `wait()`, `wait(long timeout)`, `wait(long timeout, int nanos)`

```java
class WaitDemo {
    synchronized void waitExample() {
        try {
            System.out.println("Waiting for 1 second...");
            wait(1000);
            System.out.println("Done waiting.");
        } catch (InterruptedException e) {}
    }

    public static void main(String[] args) {
        WaitDemo d = new WaitDemo();

        Thread t = new Thread(() -> d.waitExample());
        t.start();
    }
}
```
####  Output:
```
Waiting for 1 second...
Done waiting.
```

