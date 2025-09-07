# React  – JSON, Arrays, Forms, and Object Methods

##  Working with JSON Data

### `person.json`
```json
[
  { "name": "John", "age": 30 },
  { "name": "Jane", "age": 25 },
  { "name": "Bob", "age": 35 }
]
```

**Explanation**:
- JSON file holds an **array of objects**.  
- Each object has two properties: `name` and `age`.  
- React fetches this file and renders it dynamically.

---

### `App.js` – Fetch JSON Data
```javascript
import { useEffect, useState } from 'react';
import './App.css';

function App() {
  const [persons, setPersons] = useState([]);

  useEffect(() => {
    fetch('Person.json')
      .then(res => res.json())
      .then(data => setPersons(data));
  }, []);

  return (
    <>
      {persons.map(person =>
        <h1 key={person.name}>Name:{person.name}, Age:{person.age}</h1>
      )}
    </>
  );
}
export default App;
```

**Explanation**:
- `useState([])` initializes `persons` as empty.
- `useEffect` runs **once** after first render to fetch JSON.  
- `fetch()` → loads `Person.json` → `.json()` converts to object.  
- Data stored in state using `setPersons`.  
- `map()` loops through persons and displays them.

**Output**:
```
Name:John, Age:30
Name:Jane, Age:25
Name:Bob, Age:35
```

---

##  Arrays in React

### Example 1 – Display Arrays
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
  );
}
export default App2;
```

**Explanation**:
- `a1` = static array.  
- `a2` = dynamic array managed by state.  
- `.join(',')` converts arrays to string with commas.

**Output**:
```
1,2,3,4,5
0,2,3,4,5
```

---

### Example 2 – Map with Keys
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
  );
}
export default App;
```

**Explanation**:
- `map()` creates JSX elements for each array item.  
- **Keys** are required in lists for React optimization.  
- Can use `item` or `index` as keys.

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
      {a2.filter(item => item > 20).map((item, index) => <span key={index}>{item}, </span>)} <br />
      {a2.filter(item => item % 10 === 0).map((item, index) => <span key={index}>{item}, </span>)} <br />
    </>
  );
}
export default App;
```

**Explanation**:
- First line → prints all items.  
- Second line → prints numbers greater than 20.  
- Third line → prints numbers divisible by 10.

**Output**:
```
10, 15, 20, 25, 30, 40, 45, 50, 60,
25, 30, 40, 45, 50, 60,
10, 20, 30, 40, 50, 60,
```

---

##  Forms

### Multiple Fields Example
```javascript
import { useState } from "react"; 

function App() {
  const [firstName, setFirstName] = useState(''); 
  const [password, setPassword] = useState(''); 
  const [address, setAddress] = useState(''); 
  const [education, setEducation] = useState(''); 

  const printData = () => {
    const person = { firstName, password, address, education };
    console.log(person);
  }

  return (
    <>
      First Name : <input type='text' value={firstName}
        placeholder='Enter your name'
        onChange={(e) => setFirstName(e.target.value)} /><br />

      Password : <input type='password' value={password}
        placeholder='Enter your password'
        onChange={(e) => setPassword(e.target.value)} /><br />

      Address : <textarea value={address}
        placeholder='Enter your address'
        onChange={(e) => setAddress(e.target.value)} /><br />

      Education :
      <select value={education} onChange={(e) => setEducation(e.target.value)}>
        <option value=''>Select</option>
        <option value='B.Tech'>B.Tech</option>
        <option value='M.Tech'>M.Tech</option>
        <option value='B.A'>B.A</option>
        <option value='M.A'>M.A</option>
      </select><br />

      <button onClick={printData} type='button'>Submit</button>
    </>
  );
}
export default App;
```

**Output** (diagram style):
```
First Name : [__________]
Password   : [__________]
Address    : [__________]
Education  : [Select ▼]
[ Submit ]
```

---

### Person Object with Change Button
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
        ([key, value]) => <span key={key}>{key},{value}, </span>
      )}
      <br />
      <button onClick={changeData}>Submit</button>
    </>
  );
}
export default App;
```

**Explanation**:
- Displays object entries.  
- On submit, `age` is removed and UI updates.

---

### Email & Password Form
```javascript
import { useState } from "react"; 
function App() {
  const [email, setEmail] = useState(''); 
  const [password, setPassword] = useState('');

  const printData = () => {
    console.log({ email, password });
  }

  return (
    <>
      Email : <input type='email' value={email}
        placeholder='Enter your email'
        onChange={(e) => setEmail(e.target.value)} /><br />

      Password : <input type='password' value={password}
        placeholder='Enter your password'
        onChange={(e) => setPassword(e.target.value)} /><br />

      <button onClick={printData}>Submit</button>
    </>
  );
}
export default App;
```

---

## Array Methods in React

### Using `reduce()` – Sum
```javascript
function App() {
  const arr = [10, 20, 30, 40, 50];
  const result = arr.reduce((sum, num) => sum + num, 0);

  return <>Sum = {result}</>;
}
export default App;
```

**Output**:
```
Sum = 150
```

---

### Sorting Numbers
```javascript
function App() {
  const numbers = [5, 2, 9, 1, 7];
  const sorted = [...numbers].sort((a, b) => a - b);

  return <>Sorted Numbers: {sorted.join(", ")}</>;
}
export default App;
```

**Output**:
```
Sorted Numbers: 1, 2, 5, 7, 9
```

---

### Sorting Strings
```javascript
function App() {
  const names = ["John", "Alice", "Bob", "David"];
  const sorted = [...names].sort();

  return <>Sorted Names: {sorted.join(", ")}</>;
}
export default App;
```

**Output**:
```
Sorted Names: Alice, Bob, David, John
```

---

##  Object Methods

### Object.keys()
```javascript
function App() {
  const person = { name: "John", age: 30, gender: "male" };
  const keys = Object.keys(person);
  return <>Keys: {keys.join(", ")}</>;
}
export default App;
```

**Output**:
```
Keys: name, age, gender
```

---

### Object.values()
```javascript
function App() {
  const person = { name: "John", age: 30, gender: "male" };
  const values = Object.values(person);
  return <>Values: {values.join(", ")}</>;
}
export default App;
```

**Output**:
```
Values: John, 30, male
```

---

### Object.entries()
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
  );
}
export default App;
```

**Output**:
```
name : John
age : 30
gender : male
```

 
