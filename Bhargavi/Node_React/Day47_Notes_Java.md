Day 47
# React Continuation:
---

### person.json

```json
[
  { "name": "John", "age": 30 },
  { "name": "Jane", "age": 25 },
  { "name": "Bob", "age": 35 }
]
```

**Explanation**:
This JSON file holds an array of objects. Each object contains two properties: `name` and `age`. We will use React’s `fetch` API to read this file and display the data dynamically.

---

### App.js

```javascript
import logo from './logo.svg';
import './App.css';
import index from './index';
import { useEffect, useState } from 'react';

function App() {
  const [persons, setPersons] = useState([]);

  useEffect(() => {
    fetch('Person.json')
      .then(res => res.json())
      .then(data => setPersons(data))
  }, []);

  return (
    <>
      {persons.map(person =>
        <h1>Name:{person.name}, Age:{person.age}</h1>
      )}
    </>
  );
}
export default App;
```
**Output**:

```
Name:John, Age:30
Name:Jane, Age:25
Name:Bob, Age:35
```

---

## How `fetch` works here

* `fetch` sends a request to `Person.json`.
* The response is converted into a JavaScript object using `.json()`.
* That object is passed to `setPersons`, which updates state.
* React re-renders the component and shows the data dynamically.

---

## What is `useEffect`?

* `useEffect` is a React hook for side effects (like fetching data).
* It runs after the component renders.
* With `[]` as dependency, it runs only once (on mount).
* If data changes in state, React updates the output automatically.

---

## Next Topic – Form Fields (app3)

### Example 1 – Basic array display

```javascript
import { useState } from "react";
function App2() {
  const a1 = [1, 2, 3, 4, 5];
  const [a2, setA2] = useState([0, 2, 3, 4, 5]); 

  return (
    <>
      {a1.join(',')} <br />
      {a2.join(',')} <br />
    </>
  )
}
export default App2;
```


**Output**:

```
1,2,3,4,5
0,2,3,4,5
```

---

### Example 2 – Using `map` with `key`

```javascript
import { useState } from 'react';
function App() {
  const a1 = [1, 2, 3, 4, 5];
  const [a2, setA2] = useState([0, 2, 3, 4, 5]); 
  return (
    <>
      {a1.map((item) => <span key={item}>{item}, </span>)} <br />
      {a1.map((item, index) => <span key={index}>{item}, </span>)} <br />      
    </>
  )
}
export default App;
```

**Output**:

```
1, 2, 3, 4, 5, 
1, 2, 3, 4, 5,
```

---

### Example 3 – Filtering and Mapping

```javascript
import { useState } from 'react';
function App() {
  const [a2, setA2] = useState([10, 15, 20, 25, 30, 40, 45, 50, 60]);
  return (
    <>
      {a2.map((item, index) => <span key={index}>{item}, </span>)} <br /> 
      {a2.filter((item) => item > 20).map((item, index) => <span key={index}>{item}, </span>)} <br />
      {a2.filter((item) => item % 10 === 0).map((item, index) => <span key={index}>{item}, </span>)} <br />
    </>
  )
}
export default App;
```

**Output**:

```
10, 15, 20, 25, 30, 40, 45, 50, 60,
25, 30, 40, 45, 50, 60,
10, 20, 30, 40, 50, 60,
```

---
---

## Form with multiple fields:

### App.js

```javascript
import { useState } from "react"; 

function App() {
  const [firstName, setFirstName] = useState(''); 
  const [password, setPassword] = useState(''); 
  const [address, setAddress] = useState(''); 
  const [education, setEducation] = useState(); 

  const printData = () => {
    const person = { firstName, password, address, education };
    console.log(person);
  }

  return (
    <>
      First Name : <input type='text'
        value={firstName} placeholder='Enter your name'
        onChange={(e) => setFirstName(e.target.value)} />
      <br />

      Password : <input type='password'
        value={password} placeholder='Enter your password'
        onChange={(e) => setPassword(e.target.value)} />
      <br />

      Address : <textarea value={address} placeholder='Enter your address'
        onChange={(e) => setAddress(e.target.value)} />
      <br />

      Education :
      <select value={education} onChange={(e) => setEducation(e.target.value)}>
        <option value=''>Select</option>
        <option value='B.Tech'>B.Tech</option>
        <option value='M.Tech'>M.Tech</option>
        <option value='B.A'>B.A</option>
        <option value='M.A'>M.A</option>
      </select>
      <br />

      <button onClick={printData} type='button'>Submit</button>
    </>
  )
}

export default App;
```

**Output in Browser** (diagram style):

```
First Name : [__________]
Password   : [__________]
Address    : [__________]
Education  : [Select ▼]
[ Submit ]
```

---

## Person object with change button:

### App.js

```javascript
import { useState } from 'react';
function App() {
  const [person1, setPerson1] = useState({
    name: "John", age: 30, gender: "male"
  });

  const changeData = () => {
    const person2 = { ...person1 };
    delete person2.age;
    setPerson1(person2);
  }

  return (
    <>
      {Object.entries(person1).map(
        (entry) => <span key={entry}>{entry}, </span>
      )} 
      <br />
      <button onClick={changeData} type="button">Submit</button>
    </>
  )
}
export default App;
```

**Output in Browser**:

```
name,John, age,30, gender,male,
[ Submit ]
```

After clicking **Submit**:

```
name,John, gender,male,
[ Submit ]
```

---

## Email and Password form:

### App.js

```javascript
import { useState } from "react"; 

function App() {
  const [email, setEmail] = useState(''); 
  const [password, setPassword] = useState('');

  const printData = () => {
    const person = { email, password };
    console.log(person);
  }

  return (
    <>
      Email : <input type='email'
        value={email} placeholder='Enter your email'
        onChange={(e) => setEmail(e.target.value)} />
      <br />

      Password : <input type='password'
        value={password} placeholder='Enter your password'
        onChange={(e) => setPassword(e.target.value)} />
      <br />

      <button onClick={printData} type='button'>Submit</button>
    </>
  )
}

export default App;
```

**Output in Browser**:

```
Email    : [__________]
Password : [__________]
[ Submit ]
```

---
---

## Using `reduce()` for sum:

### App.js

```javascript
function App() {
  const arr = [10, 20, 30, 40, 50];
  const result = arr.reduce((sum, num) => sum + num, 0);

  return (
    <>
      Sum = {result}
    </>
  )
}
export default App;
```

**Output in Browser**:

```
Sum = 150
```

---

## Sorting numbers:

### App.js

```javascript
function App() {
  const numbers = [5, 2, 9, 1, 7];
  const sorted = [...numbers].sort((a, b) => a - b);

  return (
    <>
      Sorted Numbers: {sorted.join(", ")}
    </>
  )
}
export default App;
```

**Output in Browser**:

```
Sorted Numbers: 1, 2, 5, 7, 9
```

---

## Sorting strings:

### App.js

```javascript
function App() {
  const names = ["John", "Alice", "Bob", "David"];
  const sorted = [...names].sort();

  return (
    <>
      Sorted Names: {sorted.join(", ")}
    </>
  )
}
export default App;
```


**Output in Browser**:

```
Sorted Names: Alice, Bob, David, John
```

---

## Object.keys():

### App.js

```javascript
function App() {
  const person = { name: "John", age: 30, gender: "male" };
  const keys = Object.keys(person);

  return (
    <>
      Keys: {keys.join(", ")}
    </>
  )
}
export default App;
```

**Output in Browser**:

```
Keys: name, age, gender
```

---

##  Object.values():

### App.js

```javascript
function App() {
  const person = { name: "John", age: 30, gender: "male" };
  const values = Object.values(person);

  return (
    <>
      Values: {values.join(", ")}
    </>
  )
}
export default App;
```

**Output in Browser**:

```
Values: John, 30, male
```

---

## Object.entries():

### App.js

```javascript
function App() {
  const person = { name: "John", age: 30, gender: "male" };
  const entries = Object.entries(person);

  return (
    <>
      {entries.map(([key, value]) => (
        <div key={key}>{key} : {value}</div>
      ))}
    </>
  )
}
export default App;
```




