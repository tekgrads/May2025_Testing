# React Hooks

---

## What are Hooks?

**Hooks** are functions that let you “hook into” React features from function components (state, lifecycle, context, etc.).

### Rules of Hooks
1. **Only call hooks at the top level.**  
   Never inside loops, conditions, or nested functions.  
2. **Only call hooks from React functions.**  
   (Function components or your own custom hooks.)

Why? React relies on **call order** to match state with components between renders.

---

## Step 1 — `useState`: Controlled inputs

`useState` stores stateful values and triggers re-renders when they change.

**Goal:** Manage form fields as _controlled inputs_.

```jsx
import React, { useState } from "react";

export default function Step1() {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");

  return (
    <form>
      <label>
        Name
        <input
          value={name}
          onChange={(e) => setName(e.target.value)}
          placeholder="Ada Lovelace"
        />
      </label>

      <label>
        Email
        <input
          type="email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
          placeholder="ada@example.com"
        />
      </label>

      <pre>{JSON.stringify({ name, email }, null, 2)}</pre>
    </form>
  );
}
```

**Key idea:** The `value` of each input is always the state. The UI mirrors state.

---

## Step 2 — `useEffect`: Side effects & validation

`useEffect` runs **after render** for side effects: validation, subscriptions, fetching, localStorage, etc.  
You control when it runs via the **dependency array**.

**Goal:** Validate email whenever it changes and persist the draft to `localStorage`.

```jsx
import React, { useEffect, useState } from "react";

export default function Step2() {
  const [email, setEmail] = useState("");
  const [emailError, setEmailError] = useState("");

  // On mount, hydrate from localStorage
  useEffect(() => {
    const saved = localStorage.getItem("draftEmail");
    if (saved) setEmail(saved);
  }, []); // runs once on mount

  // On email change, validate + persist
  useEffect(() => {
    const ok = /\S+@\S+\.\S+/.test(email);
    setEmailError(ok || email.length === 0 ? "" : "Please enter a valid email");

    localStorage.setItem("draftEmail", email);
  }, [email]);

  // Cleanups
  useEffect(() => {
    const onBeforeUnload = () => console.log("Bye!");
    window.addEventListener("beforeunload", onBeforeUnload);
    return () => window.removeEventListener("beforeunload", onBeforeunload);
  }, []);

  return (
    <div>
      <input
        type="email"
        value={email}
        onChange={(e) => setEmail(e.target.value)}
        placeholder="you@domain.com"
        aria-describedby="emailHelp"
      />
      {emailError && <div role="alert">{emailError}</div>}
      <small id="emailHelp">We’ll never share your email.</small>
    </div>
  );
}
```

---

## Step 3 — `useRef`: DOM access & previous values

`useRef` holds a mutable `.current` value that **does not cause re-renders**.

**Use cases:**
- Focus a field on mount
- Scroll to an error
- Store previous state

```jsx
import React, { useEffect, useRef, useState } from "react";

export default function Step3() {
  const nameRef = useRef(null);
  const prevNameRef = useRef("");
  const [name, setName] = useState("");

  useEffect(() => {
    nameRef.current?.focus();
  }, []);

  useEffect(() => {
    prevNameRef.current = name; // remember after each render
  });

  return (
    <div>
      <input
        ref={nameRef}
        value={name}
        onChange={(e) => setName(e.target.value)}
        placeholder="Your name"
      />
      <p>Previous name: {prevNameRef.current}</p>
    </div>
  );
}
```

---
