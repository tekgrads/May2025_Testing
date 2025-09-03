# React

---

## 1) Email and Password Form (React)

**Key ideas**
- Use **controlled components**: the input value lives in React state.
- Validate on every change or on submit.
- Show inline error messages and disable submit until valid.

### Minimal but robust example
```jsx
import React, { useState, useMemo } from "react";

function EmailPasswordForm() {
  const [form, setForm] = useState({ email: "", password: "" });
  const [submitted, setSubmitted] = useState(false);

  // Simple email regex (good enough for UI checks; server must re-validate)
  const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

  const errors = useMemo(() => {
    const e = {};
    if (!form.email) e.email = "Email is required";
    else if (!emailRegex.test(form.email)) e.email = "Enter a valid email";

    if (!form.password) e.password = "Password is required";
    else if (form.password.length < 8) e.password = "Min 8 characters required";

    return e;
  }, [form]);

  const isValid = Object.keys(errors).length === 0;

  const handleChange = (e) => {
    const { name, value } = e.target;
    setForm((prev) => ({ ...prev, [name]: value }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    setSubmitted(true);
    if (!isValid) return;
    // proceed
    alert(JSON.stringify(form, null, 2));
  };

  return (
    <form onSubmit={handleSubmit} style={{ maxWidth: 420, margin: "1rem auto" }}>
      <h2>Sign In</h2>

      <label>
        Email
        <input
          type="email"
          name="email"
          value={form.email}
          onChange={handleChange}
          placeholder="you@example.com"
        />
      </label>
      {submitted && errors.email && <div style={{ color: "crimson" }}>{errors.email}</div>}

      <br />

      <label>
        Password
        <input
          type="password"
          name="password"
          value={form.password}
          onChange={handleChange}
          placeholder="••••••••"
        />
      </label>
      {submitted && errors.password && <div style={{ color: "crimson" }}>{errors.password}</div>}

      <br />
      <button type="submit" disabled={!isValid}>Submit</button>
    </form>
  );
}

export default EmailPasswordForm;
```



## 2) Using `reduce()` for Sum

`reduce(callback, initialValue)` combines array values into a single result.

**Callback signature:** `(accumulator, currentValue, index, array) => newAccumulator`

### Basic number sum
```js
const nums = [1, 2, 3, 4];
const sum = nums.reduce((acc, n) => acc + n, 0); // 10
```

### Sum of object fields (cart total)
```js
const cart = [
  { item: "Book", price: 300, qty: 2 },
  { item: "Pen", price: 20, qty: 5 },
];
const total = cart.reduce((acc, p) => acc + p.price * p.qty, 0); // 700
```

### React example: live sum of inputs
```jsx
import React, { useState } from "react";

function SumCalculator() {
  const [values, setValues] = useState([0, 0, 0]);

  const update = (i, val) => {
    const next = [...values];
    next[i] = Number(val) || 0;
    setValues(next);
  };

  const sum = values.reduce((acc, n) => acc + n, 0);

  return (
    <div>
      <h3>Sum: {sum}</h3>
      {values.map((v, i) => (
        <input
          key={i}
          type="number"
          value={v}
          onChange={(e) => update(i, e.target.value)}
          style={{ display: "block", marginBottom: 8 }}
        />
      ))}
    </div>
  );
}

export default SumCalculator;
```

**Pitfalls**
- Always pass an **initialValue** (e.g., `0`). Without it, `reduce` uses the first element as the initial accumulator and may throw on empty arrays.

---

## 3) Sorting Numbers

`Array.prototype.sort()` sorts **lexicographically** by default (treats values as strings). Provide a comparator for numeric sort.

### Examples
```js
const nums = [10, 1, 20, 3];

// Ascending
const asc = [...nums].sort((a, b) => a - b); // [1, 3, 10, 20]

// Descending
const desc = [...nums].sort((a, b) => b - a); // [20, 10, 3, 1]
```

### React example: toggle numeric sort
```jsx
import React, { useState, useMemo } from "react";

function NumberSorter() {
  const [nums] = useState([10, 1, 20, 3, 2, 100]);
  const [direction, setDirection] = useState("asc");

  const sorted = useMemo(() => {
    return [...nums].sort((a, b) => direction === "asc" ? a - b : b - a);
  }, [nums, direction]);

  return (
    <div>
      <button onClick={() => setDirection(d => d === "asc" ? "desc" : "asc")}>
        Toggle: {direction}
      </button>
      <ul>
        {sorted.map((n, i) => <li key={i}>{n}</li>)}
      </ul>
    </div>
  );
}

export default NumberSorter;
```

---

## 4) Sorting Strings

Use `localeCompare` for correct alphabetical order and case/diacritic handling.

### Examples
```js
const names = [ "Anna", "bob"];

// Case-insensitive ascending
const asc = [...names].sort((a, b) => a.localeCompare(b, undefined, { sensitivity: "base" }));

// Descending
const desc = [...names].sort((a, b) => b.localeCompare(a, undefined, { sensitivity: "base" }));
```

### React example: sort by name or length
```jsx
import React, { useMemo, useState } from "react";

function StringSorter() {
  const [list] = useState(["React", "javascript", "Vue", "Angular"]);
  const [mode, setMode] = useState("alpha"); // 'alpha' | 'length'
  const [direction, setDirection] = useState("asc");

  const sorted = useMemo(() => {
    const arr = [...list];
    if (mode === "alpha") {
      arr.sort((a, b) =>
        direction === "asc"
          ? a.localeCompare(b, undefined, { sensitivity: "base" })
          : b.localeCompare(a, undefined, { sensitivity: "base" })
      );
    } else {
      arr.sort((a, b) => (direction === "asc" ? a.length - b.length : b.length - a.length));
    }
    return arr;
  }, [list, mode, direction]);

  return (
    <div>
      <button onClick={() => setMode(m => (m === "alpha" ? "length" : "alpha"))}>
        Mode: {mode}
      </button>
      <button onClick={() => setDirection(d => (d === "asc" ? "desc" : "asc"))}>
        Direction: {direction}
      </button>

      <ul>
        {sorted.map((s, i) => <li key={i}>{s}</li>)}
      </ul>
    </div>
  );
}

export default StringSorter;
```

---

## 5) `Object.keys()`, `Object.values()`, `Object.entries()`



### Signatures
- `Object.keys(obj)` → `string[]` of property names.
- `Object.values(obj)` → array of property values.
- `Object.entries(obj)` → array of `[key, value]` pairs.

### Example
```js
const user = { id: 1, name: "Sai", active: true };
Object.keys(user);    // ["id", "name", "active"]
Object.values(user);  // [1, "Sai", true]
Object.entries(user); // [["id",1], ["name","Sai"], ["active",true]]
```

### React example: render key/value table from an object
```jsx
import React from "react";

function KeyValueTable({ obj }) {
  const entries = Object.entries(obj);

  return (
    <table border="1" cellPadding="6" style={{ borderCollapse: "collapse" }}>
      <thead>
        <tr>
          <th>Key</th>
          <th>Value</th>
        </tr>
      </thead>
      <tbody>
        {entries.map(([k, v]) => (
          <tr key={k}>
            <td>{k}</td>
            <td>{String(v)}</td>
          </tr>
        ))}
      </tbody>
    </table>
  );
}

// Usage
export default function Demo() {
  const profile = { id: 42, name: "Charitha", skills: ["JS", "React"], active: true };
  return <KeyValueTable obj={profile} />;
}
```

### Extra: convert entries back to an object
```js
const entries = [["id", 1], ["name", "Sai"]];
const obj = Object.fromEntries(entries); // { id: 1, name: "Sai" }
```

**Tips**
- If you need stable iteration order, modern engines keep property insertion order for plain objects.
- For dynamic datasets, consider using a **Map** when you need ordered key-value pairs or non-string keys.

---

## Explanation
- **Form (Email/Password):** controlled inputs + client validation; server must re-check.
- **`reduce` for sums:** always pass an initial value; great for totals/aggregations.
- **Sorting numbers:** use a comparator `(a, b) => a - b` or `(b - a)`.
- **Sorting strings:** `localeCompare` for proper alphabetical behavior.
- **Object helpers:** `keys/values/entries` to inspect and render objects; `fromEntries` to rebuild.
