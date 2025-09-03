# React Hooks 

React provides several hooks that make it easier to manage state, side effects, and lifecycle events in functional components. Below are some commonly used hooks explained with an example of a **User Registration Form**.

---

## 1. useState
The `useState` hook allows us to manage state in functional components.

**Example:**
```jsx
import React, { useState } from "react";

function RegistrationForm() {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");

  return (
    <form>
      <input 
        type="text" 
        placeholder="Name" 
        value={name} 
        onChange={(e) => setName(e.target.value)} 
      />
      <input 
        type="email" 
        placeholder="Email" 
        value={email} 
        onChange={(e) => setEmail(e.target.value)} 
      />
    </form>
  );
}
```
---

## 2. useEffect
The `useEffect` hook lets us perform side effects, such as form validation or API calls.

**Example:**
```jsx
import React, { useState, useEffect } from "react";

function RegistrationForm() {
  const [email, setEmail] = useState("");
  const [isValid, setIsValid] = useState(true);

  useEffect(() => {
    setIsValid(email.includes("@"));
  }, [email]);

  return (
    <div>
      <input 
        type="email" 
        value={email} 
        onChange={(e) => setEmail(e.target.value)} 
        placeholder="Email"
      />
      {!isValid && <p style={{color: "red"}}>Invalid email!</p>}
    </div>
  );
}
```
---

## 3. useRef
The `useRef` hook is useful for accessing DOM elements or persisting values across renders without re-rendering.

**Example:**
```jsx
import React, { useRef } from "react";

function RegistrationForm() {
  const inputRef = useRef(null);

  const focusInput = () => {
    inputRef.current.focus();
  };

  return (
    <div>
      <input type="text" ref={inputRef} placeholder="Enter name" />
      <button onClick={focusInput}>Focus Input</button>
    </div>
  );
}
```
---

## 4. useContext
The `useContext` hook allows us to access data from React Context without prop drilling.

**Example:**
```jsx
import React, { useContext, useState, createContext } from "react";

const UserContext = createContext();

function RegistrationForm() {
  const [user, setUser] = useState({ name: "", email: "" });

  return (
    <UserContext.Provider value={{ user, setUser }}>
      <UserForm />
    </UserContext.Provider>
  );
}

function UserForm() {
  const { user, setUser } = useContext(UserContext);

  return (
    <div>
      <input 
        type="text" 
        value={user.name} 
        onChange={(e) => setUser({ ...user, name: e.target.value })} 
        placeholder="Name" 
      />
      <input 
        type="email" 
        value={user.email} 
        onChange={(e) => setUser({ ...user, email: e.target.value })} 
        placeholder="Email" 
      />
    </div>
  );
}
```
---


# explanation
- **useState** → Manage state variables  
- **useEffect** → Perform side effects  
- **useRef** → Access DOM elements or persist values  
- **useContext** → Share state without prop drilling  
 


