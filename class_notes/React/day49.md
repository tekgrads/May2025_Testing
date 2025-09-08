# React Continuation:
---

### **A.js**

```javascript
export default function A() {
    return (<div>I am from A.js</div>);
}
```

**Explanation:**
This is a simple functional component that returns a `div` element displaying text. It uses the default export so it can be imported without curly braces.

**Output:**
I am from A.js

---

### **B.js**

```javascript
export default function B() {
    return (<div>I am from B.js</div>);
}
```

**Explanation:**
Another functional component returning a `div` with a message. Similar to `A.js` but with different text.

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

**Explanation:**
`Child1` renders text and includes another component `Child11`. It demonstrates **component nesting** and the use of `<br />` for line breaks.

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

**Explanation:**
A simple functional component returning text. It is used inside `Child1` to demonstrate component composition.

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

**Explanation:**
`Create` component displays a heading using `<h1>` element. It represents a simple UI for creation functionality.

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

**Explanation:**
This component renders a heading indicating the "Delete" section. It can be used in CRUD operations.

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

**Explanation:**
This component demonstrates:

1. Props usage (`firstName`, `names`, `person`, `persons`, `test`, `f1`).
2. Iterating arrays with `.map()` to display multiple persons.
3. Handling events with buttons.
4. Nested component import (commented out `Level2Child` can be used if required).

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

**Explanation:**
`Read` component demonstrates **React Router** usage with `useParams` to read URL parameters dynamically. `id` will come from the route.

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

**Explanation:**
`Level3Child` nests another component `Level4Child`. It demonstrates component composition and structured UI hierarchy.

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

**Explanation:**
This component shows **multiple route parameters** (`id` and `dept`) using `useParams`. It is useful in dynamic updates for CRUD apps.

**Output (for URL `/update/101/IT`):**
I am in the Update, dept: IT and id : 101

---

