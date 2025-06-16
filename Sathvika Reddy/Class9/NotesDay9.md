
# Day 9: Java Packages, Class Files & Access Specifiers

## 🗂️ Keeping `.java` and `.class` Files in Different Folders

**Structure:**
```bash
src/
└── com/
    └── funnycode/
        └── Chicken.java

bin/
└── com/
    └── funnycode/
        └── Chicken.class
```

**Chicken.java**
```java
package com.funnycode;

public class Chicken {
    public void cluck() {
        System.out.println("🐔 Cluck Cluck!");
    }
}
```

**Compiling it:**
```bash
javac -d bin src/com/funnycode/Chicken.java
```

## 📦 Packages

A package is like a folder for your Java classes. Think of it as a closet organizing your socks (classes)!

```java
package com.funnyzoo.animals;

public class Cow {
    public void moo() {
        System.out.println("🐄 Moo Moo!");
    }
}
```

## 📁 Packages in Multiple Folder Structure

```bash
src/
└── zoo/
    └── mammals/
        └── Elephant.java
```

```java
package zoo.mammals;

public class Elephant {
    public void trumpet() {
        System.out.println("🐘 Toooot!");
    }
}
```

Compile and run:
```bash
javac -d bin src/zoo/mammals/Elephant.java
java -cp bin zoo.mammals.Elephant
```

## 🔐 Access Specifiers

### 1. **public** – Everyone’s invited! 🎉
```java
public class Monkey {
    public void swing() {
        System.out.println("🙈 I’m swinging in public!");
    }
}
```

### 2. **private** – It’s MY banana! 🍌
```java
public class Monkey {
    private void secretBananaPlan() {
        System.out.println("🤫 Stealing bananas at midnight!");
    }
}
```

### 3. **protected** – Family matters 👨‍👩‍👧‍👦
```java
public class Monkey {
    protected void familyOnly() {
        System.out.println("🐵 Family-only grooming session!");
    }
}
```

### 4. **default** – Friendly neighbors access 🏘️ (no specifier)
```java
class Monkey {
    void hangOut() {
        System.out.println("🙊 Just chilling in the same package!");
    }
}
```

## 📚 Default Access Specifier Behavior

| Element     | Default if not specified | Who Can Access?                        |
|-------------|--------------------------|----------------------------------------|
| Class       | package-private          | Classes in the same package            |
| Method      | package-private          | Classes in the same package            |
| Attribute   | package-private          | Classes in the same package            |

## 🧬 Accessing & Inheriting Access Specifiers

```java
package jungle;

public class Lion {
    protected void roar() {
        System.out.println("🦁 Roarrrrr!");
    }
}
```

```java
package safari;
import jungle.Lion;

public class Cub extends Lion {
    public void callMom() {
        roar(); // 🦁 Can access protected method through inheritance
    }
}
