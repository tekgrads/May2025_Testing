Day 49
# React Continuation:
---

### **A.js**

```javascript
export default function A() {
    return (<div>I am from A.js</div>);
}
```
**Output:**
I am from A.js

---

### **B.js**

```javascript
export default function B() {
    return (<div>I am from B.js</div>);
}
```

**Output:**
I am from B.js

---

### **Child1.js**

```javascript
import Child11 from './Child11'

export default function Child1() {
    return (
        <>
            I am in the Child1 begin<br />
            <Child11 /><br />
            I am at the Child1 end
        </>
    )
}
```
**Output:**
I am in the Child1 begin
I am at Child11
I am at the Child1 end

---

### **Child11.js**

```javascript
export default function Child11() {
    return (<>I am at Child11</>)
}
```

**Output:**
I am at Child11

---

### **Create.js**

```javascript
export default function Create() {
    return (
        <>
            <h1>I am in the create</h1>
        </>
    )
}
```
**Output:**
I am in the create

---

### **Delete.js**

```javascript
export default function Delete() {
    return (
        <>
            <h1>I am in the Delete</h1>
        </>
    )
}
```
**Output:**
I am in the Delete

---

### **Level1Child.js**

```javascript
import Level2Child from './Level2Child';

export default function Level1Child({firstName, names, person, persons, test, f1}) {
    return (
        <>
            Level1Child begin <br />
            First Name: { firstName } <br />
            Names: { names.join(", ") } <br />
            Person: { person.firstName } { person.lastName } {person.age}<br />
            Persons: { persons.map(p => (<span key={p.firstName}>{p.firstName} {p.lastName} {p.age}; </span>)) } <br />
            <button type='button' onClick={test}>Button</button><br />
            <button type='button' onClick={f1}>Button</button><br />
            Level1Child end <br />
        </>
    )
}
```

This component demonstrates:

1. Props usage (`firstName`, `names`, `person`, `persons`, `test`, `f1`).
2. Iterating arrays with `.map()` to display multiple persons.
3. Nested component import (commented out `Level2Child` can be used if required).

**Output (example props):**
Level1Child begin
First Name: Sathvika
Names: Alice, Bob, Charlie
Person: John Doe 30
Persons: Alice Doe 25; Bob Smith 28; Charlie Brown 22;
\[Button]
\[Button]
Level1Child end

---

### **Read.js**

```javascript
import { useParams } from "react-router-dom";

export default function Read() {
    const { id } = useParams();
    return (
        <>
            <h1>I am in the Read with id : {id}</h1>
        </>
    )
}
```
**Output (for URL `/read/101`):**
I am in the Read with id : 101

---

### **Level3Child.js**

```javascript
import Level4Child from "./Level4Child";

export default function Level3Child() {
    return (
        <>
            Level3Child begin <br />
            <Level4Child />
            Level3Child end <br />
        </>
    )
}
```

**Output:**
Level3Child begin
(Level4Child content)
Level3Child end

---

### **Update.js**

```javascript
import { useParams } from "react-router-dom";

export default function Update() {
    const { id, dept } = useParams();
    return (
        <>
            <h1>I am in the Update, dept: {dept} and id : {id}</h1>
        </>
    )
}
```

**Output (for URL `/update/101/IT`):**
I am in the Update, dept: IT and id : 101

---
