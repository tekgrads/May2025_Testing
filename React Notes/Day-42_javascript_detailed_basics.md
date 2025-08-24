# JavaScript Basics

## 1. Introduction to JavaScript

JavaScript (JS) is a high-level, dynamic, and interpreted programming
language that is widely used to make web pages interactive.\
It is a core technology of the World Wide Web alongside HTML and CSS.

### Why Learn JavaScript?

-   Enhances user experience with interactive elements.
-   Runs on both client-side (browser) and server-side (Node.js).
-   Large ecosystem of libraries and frameworks (React, Vue, Angular).

------------------------------------------------------------------------

## 2. Setting Up JavaScript Environment

### 2.1 Using Browser

Most browsers come with a built-in JavaScript engine.\
You can write JS code directly in the **Developer Console**: - Press
`F12` or `Ctrl+Shift+I` in Chrome/Edge/Firefox. - Go to **Console** tab
and type:

``` javascript
console.log("Hello, JavaScript!");
```

### 2.2 Using Node.js

Node.js allows JavaScript to run outside the browser.

#### Installation Steps

1.  Go to [Node.js Official Site](https://nodejs.org).
2.  Download the **LTS version** for your operating system.
3.  Run installer with default settings.

#### Verify Installation

Open terminal/command prompt and run:

npm -v

You should see version numbers if installed correctly.

------------------------------------------------------------------------

## 3. JavaScript Basics

### 3.1 Variables

Variables store data. Three keywords: `var`, `let`, and `const`.

``` javascript
var name = "Alice";   // function scoped
let age = 25;         // block scoped
const city = "Paris"; // constant value
```

### 3.2 Data Types

JavaScript has **Primitive** and **Reference** data types.

#### Primitive

-   Number: `let x = 10;`
-   String: `let y = "Hello";`
-   Boolean: `let flag = true;`
-   Null: `let n = null;`
-   Undefined: `let u;`
-   Symbol: `let s = Symbol('id');`
-   BigInt: `let b = 12345678901234567890n;`

#### Reference

-   Object: `let person = {name: "John", age: 30};`
-   Array: `let colors = ["Red", "Green", "Blue"];`

### 3.3 Operators

-   Arithmetic: `+`, `-`, `*`, `/`, `%`
-   Comparison: `==`, `===`, `!=`, `>`, `<`, `>=`, `<=`
-   Logical: `&&`, `||`, `!`
-   Assignment: `=`, `+=`, `-=`, `*=`

### 3.4 Functions

Reusable blocks of code.

``` javascript
function greet(name) {
    return "Hello " + name;
}
console.log(greet("Alice"));
```

Arrow function:

``` javascript
const greet = (name) => `Hello ${name}`;
```

### 3.5 Control Structures

#### If-Else

``` javascript
let age = 20;
if (age >= 18) {
    console.log("Adult");
} else {
    console.log("Minor");
}
```

#### Loops

-   For loop

``` javascript
for (let i = 0; i < 5; i++) {
    console.log(i);
}
```

-   While loop

``` javascript
let i = 0;
while (i < 5) {
    console.log(i);
    i++;
}
```

### 3.6 Objects

``` javascript
let user = {
    name: "John",
    age: 30,
    greet: function() {
        console.log("Hello " + this.name);
    }
};
user.greet();
```

### 3.7 DOM Manipulation

``` javascript
document.getElementById("demo").innerHTML = "Hello JS!";
```

------------------------------------------------------------------------

## 4. Writing Your First JavaScript Program

1.  Create a file `index.html`:

``` html
<!DOCTYPE html>
<html>
  <head><title>JS Test</title></head>
  <body>
    <h1 id="demo">Welcome</h1>
    <script src="app.js"></script>
  </body>
</html>
```

2.  Create `app.js`:

``` javascript
document.getElementById("demo").innerHTML = "Hello JavaScript";
```


