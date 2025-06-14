
# Java Concepts Overview

## 1. Instance Initialization Blocks (IIB)
- Used to initialize instance variables.
- Runs every time an object is created, before the constructor.
- Can have multiple IIBs; executed in order of appearance.

## 2. Constructors
- Special method called when an object is created.
- No return type; name same as class.
- Can be overloaded with different parameters.

## 3. `this` Keyword
- Refers to the current object.
- Used to access instance variables, call other constructors.
- Resolves ambiguity between instance and local variables.

## 4. Combo of SIB, IIB, Static & Non-Static Variables, Constructor Overloading, Polymorphism

### Static Initialization Block (SIB)
- Runs once when the class is loaded.
- Used to initialize static variables.

### Instance Initialization Block (IIB)
- Runs every time before constructor.
- Initializes instance variables.

### Static Variables
- Shared across all instances.
- Initialized at class loading.

### Non-Static Variables
- Unique for each object.
- Initialized via IIB or constructor.

### Constructor Overloading
- Multiple constructors with different parameters.
- Helps in flexible object creation.

### Polymorphism
- **Compile-Time (Overloading):** Same method name with different parameters.
- **Run-Time (Overriding):** Subclass method overrides parent class method.

## Pros and Cons

### Pros
- Clean code with reusable blocks.
- Flexible object creation.
- Enhanced readability and organization.
- Supports object-oriented principles.

### Cons
- Complex flow (esp. with IIB/SIB).
- Misuse of `this` may cause confusion.
- Overuse of overloading/overriding can lead to maintenance issues.
