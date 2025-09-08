Day 52
# Function Callbacks, Promises, Microtasks, Macrotasks, Fetch, Await, and Axios

---

### Filename: `Test5.js`

```javascript
export default function Test5() {
    const w1 = (resolve, reject) => {
        //perform the logic and assume results as 1000
        //return resolve(1000);        
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

---

### Filename: `Test6.js`

```javascript
export default function Test6() {
    const doTask1 = (arg1) => {
        return new Promise((resolve, reject) => {
            console.log('from doTask1:' + arg1)
            return resolve(arg1 + 200);
        })
    }
    const doTask2 = (arg1) => {
        return new Promise((resolve, reject) => {
            console.log('from doTask2:' + arg1)
            return resolve(arg1 + 200);
        })
    }
    const doTask3 = (arg1) => {
        return new Promise((resolve, reject) => {
            console.log('from doTask3:' + arg1)
            return resolve(arg1 + 300);
        })
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

---

### Filename: `Test7.js`

```javascript
export default function Test7() {
    const test = () => {
        console.log("Start");
        const promise = new Promise((resolve, reject) => {
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

---

### Filename: `Test8.js`

```javascript
export default function Test2() {
    const test = () => {
        console.log("Start");
        const promise = new Promise((resolve, reject) => {
            console.log("Promise executor");
            setTimeout(() => {
                console.log("setTimeOut from Promise");
            }, 0)
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

---

### Filename: `Test9.js`

```javascript
export default function Test9() {
    const test = () => {
        console.log("Start");
        const p1 = new Promise((resolve) => {
            console.log("P1 executor");
            setTimeout(() => {
                console.log("P1 setTimeout");
                resolve("P1 done");
            }, 0);
        });
        const p2 = new Promise((resolve) => {
            console.log("P2 executor");
            setTimeout(() => {
                console.log("P2 setTimeout");
                resolve("P2 done");
            }, 0);
        });
        p1.then((res) => {
            console.log("P1 then:", res);
        });
        p2.then((res) => {
            console.log("P2 then:", res);
        });
        console.log("End");
    }
    return (
        <>
            <button type="button" onClick={test}>test</button>
        </>
    );
}
```

---

### Filename: `Test10.js`

```javascript
export default function Test10() {
    const test =  async () => {
        console.log("Start");
        const p1 = new Promise((resolve) => {
            console.log("P1 executor");
            setTimeout(() => {
                console.log("P1 setTimeout");
                resolve("P1 done");
            }, 0);
        });
        const p2 = new Promise((resolve) => {
            console.log("P2 executor");
            setTimeout(() => {
                console.log("P2 setTimeout");
                resolve("P2 done");
            }, 0);
        });
        const p3 = new Promise((resolve) => {
            console.log("P3 executor");
            setTimeout(() => {
                console.log("P3 setTimeout");
                resolve("P3 done");
            }, 0);
        });
       await  p1.then((res) => {
            console.log("P1 then:", res);
        });
        console.log("middle");
        p2.then((res) => {
            console.log("P2 then:", res);
        });
        console.log("End");
        p3.then((res) => {
            console.log("P3 then:", res);
        });
    }
    return (
        <>
            <button type="button" onClick={test}>test</button>
        </>
    );
}
```

---

### Filename: `Test11.js`

```javascript
export default function Test11() {
    const test = () => {
        console.log(1);
        fetch('https://jsonplaceholder.typicode.com/posts')
            .then(response => response.json())
            .then(json => console.log(json))
            .catch((err) => console.log(err));
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

---

### Filename: `Test12.js`

```javascript
export default function  Test12() {
    const test = async  () => {
        console.log(1);
        await fetch('https://jsonplaceholder.typicode.com/posts')
            .then(response => response.json())
            .then(json => console.log(json))
            .catch((err) => console.log(err));
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

---

### Filename: `Test13.js`

```javascript
import axios from "axios";
export default function Test13() {
    const test = async () => {
        console.log(1);
        await axios.get('https://jsonplaceholder.typicode.com/posts')
            .then((results) => console.log(results))
            .catch((err) => console.log(err));
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

---