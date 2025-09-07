
# Synchronous and Asynchronous Operations, Function Callbacks


## 1. **Synchronous Operations**

* **Definition**: Code runs **line by line**, in sequence.
* The next line will **not start** until the current one finishes.
* If one operation takes a long time (like a loop or network call), it blocks the rest of the code.

**Example (JavaScript):**

```javascript
console.log("Step 1");
for (let i = 0; i < 9999999999; i++) { } // long task
console.log("Step 2");
```

**Output:**

```
Step 1
Step 2   // printed only after the loop finishes
```

---

## 2. **Asynchronous Operations**

* **Definition**: Code can **start a task** and then continue running without waiting for the task to finish.
* Once the task is done, it notifies the program (via a **callback**, a **Promise**, or `async/await`).
* Common in tasks like **fetching data**, **timers**, or **file I/O**.

**Example (JavaScript):**

```javascript
console.log("Step 1");

setTimeout(() => {
  console.log("Step 2 (after 2 seconds)");
}, 2000);

console.log("Step 3");
```

**Output:**

```
Step 1
Step 3
Step 2 (after 2 seconds)
```
---

## 3. **Function Callbacks**

* A **callback** is a function passed as an **argument** to another function.
* The function receiving the callback can **execute it later**.
* Callbacks are often used to handle asynchronous results.

**Example (basic callback):**

```javascript
function greet(name, callback) {
  console.log("Hello, " + name);
  callback(); // run the callback function
}

function afterGreeting() {
  console.log("This runs after greeting!");
}

greet("Sathvika", afterGreeting);
```

**Output:**

```
Hello, Sathvika
This runs after greeting!
```

**Example (with async callback):**

```javascript
function fetchData(callback) {
  setTimeout(() => {
    console.log("Data fetched!");
    callback();
  }, 2000);
}

fetchData(() => console.log("Now we can use the data!"));
```

**Output:**

```
Data fetched!          // after 2 seconds
Now we can use the data!
```

## Filename: `App.js`

```javascript
import logo from './logo.svg';
import './App.css';
import Test1 from './Test1';
import Test2 from './Test2';
import Test3 from './Test3';
import Test4 from './Test4';

function App() {
  return (
    <div className="App">
      <Test4/> 
    </div>
  );
}

export default App;
````

**Explanation:**
This is the root component of the application. It imports four components (`Test1`, `Test2`, `Test3`, and `Test4`). Only `Test4` is rendered inside the `App` component, so clicking the button in `Test4` will demonstrate function callbacks.

---

## Filename: `Test1.js`

```javascript
export default function Test1() {
    const test = () => {
        console.log(1);
        console.log('before loop');
        for (var i = 1; i <= 9999999999; i++) {
        }
        console.log('after loop', i)
        console.log(2);
        console.log(3);
        console.log(4);
        console.log(5);
    }
    return (
        <>
            <button type="button" onClick={test}>test</button>
        </>
    );
}
```

**Explanation:**
This component demonstrates **synchronous execution**.

* When the button is clicked, the `test` function executes.
* A long `for` loop simulates a blocking operation.
* Logs before and after the loop show that the execution waits until the loop finishes before continuing.
  This illustrates how synchronous code can block further execution.

---

## Filename: `Test2.js`

```javascript
export default function Test2() {
    const test1 = (arg1) => {
        console.log('from test1:' + arg1);
    }
    const test2 = (f1, arg1) => {
        console.log('test2 begin: ' + arg1); 
        var results = 100;
        f1(results);
        console.log('test2 end');
    }
    const test3 = (f1, arg1) => {
        console.log('test3 begin:' + arg1); 
        var results = 200;
        f1(results);
        console.log('test3 end');
    }
    const test4 = () => {
        test2(test1, 100);
        console.log('---------- ');
        test2((arg1) => test1(arg1), 100);
        console.log('---------- ');
        test3((arg1) => test2(test1, arg1), 300);
    }
    return (
        <>
            <button type="button" onClick={test4}>test</button>
        </>
    );
}
```

**Explanation:**
This component demonstrates **function callbacks**.

* `test1` simply logs its argument.
* `test2` and `test3` both accept a function (`f1`) and an argument, execute some logic, then call `f1` with a result.
* Inside `test4`:

  * First, `test2` calls `test1` directly.
  * Then, `test2` calls `test1` using an arrow function wrapper.
  * Finally, `test3` calls `test2`, which in turn calls `test1`.

This demonstrates how callbacks can be passed between functions to chain execution.

---

## Filename: `Test4.js`

```javascript
export default function Test4() {
    const test1 = (arg1) => {
        console.log('from test1:' + arg1);
    }
    const test2 = (f1, arg1) => {
        console.log('test2 begin: ' + arg1); 
        var results = 100;
        f1(results);
        console.log('test2 end');
    }
    const test3 = (f1, arg1) => {
        console.log('test3 begin:' + arg1); 
        var results = 200;
        f1(results);
        console.log('test3 end');
    }
    const test4 = (f1, arg) => {
        console.log('test4 begin: ' + arg); 
        var results = 300;
        f1(results);
        console.log('test4 end');
    }
    const test5 = () => {
        test2(test1, 100);
        console.log('--------------- ')
        test3((a) => test2(test1, a + 100), 200);
        console.log('--------------- ');
        test4((a) => { 
            test3((b) => test2(test1, a + b + 100), a + 200) 
        }, 300);
    }
    return (
        <>
            <button type="button" onClick={test5}>test</button>
        </>
    );
}
```

**Explanation:**
This component extends the callback chaining concept with **nested callbacks**.

* `test1` logs a value.
* `test2`, `test3`, and `test4` each log their start, process some data, and then call a callback (`f1`).
* In `test5`:

  1. `test2` calls `test1` directly.
  2. `test3` is given a callback that calls `test2`, which then calls `test1`.
  3. `test4` is given a callback that calls `test3`, which calls `test2`, which finally calls `test1`.

This nesting shows how callbacks can form chains of execution, similar to how asynchronous flows can be managed before using Promises or `async/await`.

```
