# JavaScript: Callbacks, Promises, Microtasks, Macrotasks, Fetch, Async/Await, Axios

This document explains JavaScript asynchronous concepts with examples.

------------------------------------------------------------------------

## 1. Callbacks with Promises (Test5.js)

``` javascript
export default function Test5() {
    const w1 = (resolve, reject) => {
        // Simulate a task
        // return resolve(1000);
        return reject('something went wrong');
    }

    const test = () => {
        const p1 = new Promise(w1);
        p1.then((res) => console.log(res))
          .catch((err) => console.log(err));
    }

    return (
        <>
            <button type="button" onClick={test}>test</button>
        </>
    );
}
```

### Example Explanation

-   The promise executor takes `resolve` and `reject`.
-   If task succeeds → `resolve(value)`.
-   If task fails → `reject(error)`.

------------------------------------------------------------------------

## 2. Chaining Promises (Test6.js)

``` javascript
export default function Test6() {
    const doTask1 = (arg1) => {
        return new Promise((resolve) => {
            console.log('from doTask1:' + arg1);
            resolve(arg1 + 200);
        });
    }

    const doTask2 = (arg1) => {
        return new Promise((resolve) => {
            console.log('from doTask2:' + arg1);
            resolve(arg1 + 200);
        });
    }

    const doTask3 = (arg1) => {
        return new Promise((resolve) => {
            console.log('from doTask3:' + arg1);
            resolve(arg1 + 300);
        });
    }

    const test = () => {
        doTask1(10)
            .then(result1 => doTask2(result1))
            .then(result2 => doTask3(result2))
            .then(finalResult => console.log('Final Result:', finalResult))
            .catch(err => console.error(err));
    }

    return (
        <>
            <button type="button" onClick={test}>test</button>
        </>
    );
}
```

### Example Explanation

-   Each task is chained using `.then()`.
-   Final result flows through multiple promises.

------------------------------------------------------------------------

## 3. Microtasks vs Macrotasks (Test7.js)

``` javascript
export default function Test7() {
    const test = () => {
        console.log("Start");
        const promise = new Promise((resolve) => {
            console.log("Promise executor");
            resolve("Resolved");
        });
        promise.then((value) => {
            console.log("Promise then: " + value);
        });
        setTimeout(() => {
            console.log("setTimeout");
        }, 0);
        console.log("End");
    }

    return (
        <>
            <button type="button" onClick={test}>test</button>
        </>
    );
}
```

### Output Order:

    Start
    Promise executor
    End
    Promise then: Resolved
    setTimeout

-   **Microtasks**: `promise.then()` → runs before `setTimeout`.
-   **Macrotasks**: `setTimeout`.

------------------------------------------------------------------------

## 4. Promise + setTimeout inside (Test8.js)

``` javascript
export default function Test8() {
    const test = () => {
        console.log("Start");
        const promise = new Promise((resolve) => {
            console.log("Promise executor");
            setTimeout(() => {
                console.log("setTimeout from Promise");
            }, 0);
            resolve("Resolved");
        });
        promise.then((value) => {
            console.log("Promise then: " + value);
        });
        setTimeout(() => {
            console.log("setTimeout");
        }, 0);
        console.log("End");
    }

    return (
        <>
            <button type="button" onClick={test}>test</button>
        </>
    );
}
```

### Output Order:

    Start
    Promise executor
    End
    Promise then: Resolved
    setTimeout
    setTimeout from Promise

------------------------------------------------------------------------

## 5. Using Async/Await

``` javascript
async function fetchData() {
    try {
        const response = await fetch('https://jsonplaceholder.typicode.com/posts/1');
        const data = await response.json();
        console.log(data);
    } catch (err) {
        console.error('Error:', err);
    }
}
```

-   `await` pauses execution until the promise resolves.

------------------------------------------------------------------------

## 6. Using Axios (Simpler Fetch)

``` javascript
import axios from "axios";

async function getData() {
    try {
        const res = await axios.get('https://jsonplaceholder.typicode.com/posts/1');
        console.log(res.data);
    } catch (err) {
        console.error(err);
    }
}
```

-   Axios automatically parses JSON.

------------------------------------------------------------------------

# Summary

-   **Callbacks**: Older style async.
-   **Promises**: Handle async with `.then()` / `.catch()`.
-   **Microtasks vs Macrotasks**: `Promise.then()` runs before
    `setTimeout`.
-   **Async/Await**: Cleaner syntax for promises.
-   **Fetch/Axios**: For API calls.
