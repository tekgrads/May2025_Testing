# React 

## 1. useEffect()

`useEffect` is a React Hook that lets you run side effects in function components. Side effects include data fetching, subscriptions, or manually changing the DOM.

### Example: Fetching Data
```jsx
import React, { useState, useEffect } from "react";

function Users() {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    fetch("https://jsonplaceholder.typicode.com/users")
      .then(response => response.json())
      .then(data => setUsers(data));
  }, []); // Empty array means it runs only once after component mounts

  return (
    <div>
      <h2>User List</h2>
      <ul>
        {users.map(user => (
          <li key={user.id}>{user.name}</li>
        ))}
      </ul>
    </div>
  );
}

export default Users;
```

---

## 2. Form Fields

React uses controlled components for form inputs, meaning the input values are controlled by React state.

### Example: Single Input Field
```jsx
import React, { useState } from "react";

function NameForm() {
  const [name, setName] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    alert("Submitted: " + name);
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

export default NameForm;
```

---

## 3. Using map with key

When rendering lists in React, you should use `map` and provide a unique `key` prop for each element. Keys help React identify which items changed, are added, or removed.

### Example: Rendering a List
```jsx
function Fruits() {
  const fruitList = ["Apple", "Banana", "Cherry"];

  return (
    <ul>
      {fruitList.map((fruit, index) => (
        <li key={index}>{fruit}</li>
      ))}
    </ul>
  );
}
```

---

## 4. Filtering and Mapping

You can filter data before rendering with `map`.

### Example: Filtering Even Numbers
```jsx
function Numbers() {
  const nums = [1, 2, 3, 4, 5, 6];

  return (
    <ul>
      {nums.filter(num => num % 2 === 0).map(num => (
        <li key={num}>{num}</li>
      ))}
    </ul>
  );
}
```

---

## 5. Form with Multiple Fields

You can manage multiple input fields in a form using a single state object.

### Example: Multiple Input Fields
```jsx
import React, { useState } from "react";

function RegistrationForm() {
  const [formData, setFormData] = useState({
    name: "",
    email: "",
    password: ""
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(formData);
  };

  return (
    <form onSubmit={handleSubmit}>
      <input
        type="text"
        name="name"
        placeholder="Name"
        value={formData.name}
        onChange={handleChange}
      />
      <input
        type="email"
        name="email"
        placeholder="Email"
        value={formData.email}
        onChange={handleChange}
      />
      <input
        type="password"
        name="password"
        placeholder="Password"
        value={formData.password}
        onChange={handleChange}
      />
      <button type="submit">Register</button>
    </form>
  );
}

export default RegistrationForm;
```

---

# Explantion

- **useEffect**: Runs side effects like data fetching.  
- **Form Fields**: Inputs controlled by state.  
- **map with key**: Helps React render lists efficiently.  
- **Filtering + Mapping**: Combine filtering and rendering lists.  
- **Multiple Fields**: Use an object to manage form inputs.  
