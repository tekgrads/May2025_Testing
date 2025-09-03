# React Form Fields with Examples

This document explains how to work with **Form Fields** in React, including arrays, mapping, keys, filtering, and handling multiple fields in real-world applications.

---

## 1. Basic Form Field Example

```jsx
import React, { useState } from "react";

function SimpleForm() {
  const [name, setName] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    alert(`Hello, ${name}`);
  };

  return (
    <form onSubmit={handleSubmit}>
      <label>
        Name:
        <input
          type="text"
          value={name}
          onChange={(e) => setName(e.target.value)}
        />
      </label>
      <button type="submit">Submit</button>
    </form>
  );
}

export default SimpleForm;
