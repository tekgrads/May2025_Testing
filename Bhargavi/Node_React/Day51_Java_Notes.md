Day 51


---

# Syn and asyn operations and function call backs:

---

### Filename: `App.js`

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
```

---

### Filename: `Test1.js`

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

---

### Filename: `Test2.js`

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

---

### Filename: `Test4.js`

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

---
