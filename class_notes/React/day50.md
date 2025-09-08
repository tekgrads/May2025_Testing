# CRUD Operations and Session Storage in React

## 1. Introduction
In web applications, **CRUD** (Create, Read, Update, Delete) operations are fundamental for managing data.  
In React, CRUD operations are implemented using **state** and **event handlers**.  

Additionally, **sessionStorage** can be used to store data temporarily in the browser.  
- Data remains available as long as the tab is open.  
- Once the tab/browser is closed, data is cleared.  

---

## 2. CRUD Operations in React

CRUD stands for:
- **Create** → Add new data  
- **Read** → Display data  
- **Update** → Modify existing data  
- **Delete** → Remove data  

---

## 3. Using `sessionStorage`
In React, you can use `sessionStorage` to persist data within a session:

```js
// Save to sessionStorage
sessionStorage.setItem("key", JSON.stringify(data));

// Read from sessionStorage
const data = JSON.parse(sessionStorage.getItem("key"));

// Remove from sessionStorage
sessionStorage.removeItem("key");
```

---

## 4. Full Example – CRUD with Session Storage

We’ll create a modular CRUD app with the following files:

```
src/
│── App.js
│── Create.js
│── Read.js
│── Update.js
│── Delete.js
```

---

### `App.js`

```jsx
import React, { useState, useEffect } from "react";
import Create from "./Create";
import Read from "./Read";

function App() {
  const [items, setItems] = useState(() => {
    const savedData = sessionStorage.getItem("items");
    return savedData ? JSON.parse(savedData) : [];
  });

  const [editIndex, setEditIndex] = useState(null);

  useEffect(() => {
    sessionStorage.setItem("items", JSON.stringify(items));
  }, [items]);

  return (
    <div style={{ margin: "20px" }}>
      <h1>React CRUD with Session Storage</h1>

      <Create items={items} setItems={setItems} editIndex={editIndex} setEditIndex={setEditIndex} />

      <Read items={items} setEditIndex={setEditIndex} setItems={setItems} />
    </div>
  );
}

export default App;
```

---

### `Create.js`

Handles **Create** and **Update** logic.

```jsx
import React, { useState, useEffect } from "react";

function Create({ items, setItems, editIndex, setEditIndex }) {
  const [input, setInput] = useState("");

  useEffect(() => {
    if (editIndex !== null) {
      setInput(items[editIndex]);
    }
  }, [editIndex, items]);

  const handleSubmit = () => {
    if (input.trim() === "") return;

    if (editIndex !== null) {
      const updatedItems = [...items];
      updatedItems[editIndex] = input;
      setItems(updatedItems);
      setEditIndex(null);
    } else {
      setItems([...items, input]);
    }

    setInput("");
  };

  return (
    <div style={{ marginBottom: "20px" }}>
      <input
        type="text"
        value={input}
        placeholder="Enter item"
        onChange={(e) => setInput(e.target.value)}
      />
      <button onClick={handleSubmit}>
        {editIndex !== null ? "Update" : "Add"}
      </button>
    </div>
  );
}

export default Create;
```

---

### `Read.js`

Displays all items and uses **Update** + **Delete**.

```jsx
import React from "react";
import Update from "./Update";
import DeleteItem from "./Delete";

function Read({ items, setEditIndex, setItems }) {
  return (
    <div>
      <h2>Items List</h2>
      {items.length === 0 ? (
        <p>No items available.</p>
      ) : (
        <ul>
          {items.map((item, index) => (
            <li key={index}>
              {item}{" "}
              <Update index={index} setEditIndex={setEditIndex} />
              <DeleteItem index={index} items={items} setItems={setItems} />
            </li>
          ))}
        </ul>
      )}
    </div>
  );
}

export default Read;
```

---

### `Update.js`

Marks an item for editing.

```jsx
import React from "react";

function Update({ index, setEditIndex }) {
  const handleEdit = () => {
    setEditIndex(index);
  };

  return <button onClick={handleEdit}>Edit</button>;
}

export default Update;
```

---

### `Delete.js`

Removes an item.

```jsx
import React from "react";

function DeleteItem({ index, items, setItems }) {
  const handleDelete = () => {
    const filteredItems = items.filter((_, i) => i !== index);
    setItems(filteredItems);
  };

  return <button onClick={handleDelete}>Delete</button>;
}

export default DeleteItem;
```

---

## 5. How It Works

1. **App.js** → Manages state & `sessionStorage`.  
2. **Create.js** → Handles adding and updating items.  
3. **Read.js** → Lists items, includes edit and delete buttons.  
4. **Update.js** → Sets which item should be edited.  
5. **Delete.js** → Removes an item.  
6. All changes are saved in `sessionStorage` so data persists until the tab is closed.  

---

## 6. Difference Between `localStorage` and `sessionStorage`

| Feature          | localStorage | sessionStorage |
|------------------|--------------|----------------|
| Lifetime         | Permanent (until cleared) | Ends when tab/browser closes |
| Scope            | All tabs from same origin | Only the current tab |
| Use Cases        | User settings, saved data | Temporary data, form steps |

---
Perfect 👍 You want a **dedicated Markdown file** with **React sessionStorage examples only**.
Here’s a clean, detailed version:

---

````markdown
# Session Storage in React

## 1. Introduction
- **sessionStorage** in React is used to store data **temporarily** in the browser.  
- The data remains as long as the **tab is open**.  
- Once the tab/browser is closed, the data is automatically cleared.  

---

## 2. Basic Usage in React

You can use **sessionStorage** with React hooks (`useState`, `useEffect`) to store and retrieve data.

### Example 1: Storing a Username

```jsx
import React, { useState, useEffect } from "react";

function SessionStorageExample() {
  // Load initial value from sessionStorage
  const [name, setName] = useState(() => {
    return sessionStorage.getItem("username") || "";
  });

  // Save value to sessionStorage whenever name changes
  useEffect(() => {
    sessionStorage.setItem("username", name);
  }, [name]);

  return (
    <div style={{ margin: "20px" }}>
      <h1>Session Storage Example</h1>
      <input
        type="text"
        value={name}
        placeholder="Enter your name"
        onChange={(e) => setName(e.target.value)}
      />
      <p>Hello, {name ? name : "Guest"}!</p>
    </div>
  );
}

export default SessionStorageExample;
````

✅ If you type a name and refresh the tab, the name persists.
❌ If you close the tab and reopen it, the data is cleared.

---

## 3. Example with a List (CRUD + Session Storage)

```jsx
import React, { useState, useEffect } from "react";

function TodoApp() {
  const [task, setTask] = useState("");
  const [tasks, setTasks] = useState(() => {
    const saved = sessionStorage.getItem("tasks");
    return saved ? JSON.parse(saved) : [];
  });

  useEffect(() => {
    sessionStorage.setItem("tasks", JSON.stringify(tasks));
  }, [tasks]);

  const addTask = () => {
    if (task.trim() === "") return;
    setTasks([...tasks, task]);
    setTask("");
  };

  const deleteTask = (index) => {
    setTasks(tasks.filter((_, i) => i !== index));
  };

  return (
    <div style={{ margin: "20px" }}>
      <h1>Todo App with Session Storage</h1>
      <input
        type="text"
        value={task}
        placeholder="Enter a task"
        onChange={(e) => setTask(e.target.value)}
      />
      <button onClick={addTask}>Add</button>

      <ul>
        {tasks.map((t, index) => (
          <li key={index}>
            {t} <button onClick={() => deleteTask(index)}>Delete</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default TodoApp;
```

---

## 4. Custom Hook for Session Storage

To make reuse easier, we can create a **custom hook**:

```jsx
import { useState, useEffect } from "react";

function useSessionStorage(key, initialValue) {
  const [value, setValue] = useState(() => {
    const stored = sessionStorage.getItem(key);
    return stored ? JSON.parse(stored) : initialValue;
  });

  useEffect(() => {
    sessionStorage.setItem(key, JSON.stringify(value));
  }, [key, value]);

  return [value, setValue];
}

export default useSessionStorage;
```

### Usage Example:

```jsx
import React from "react";
import useSessionStorage from "./useSessionStorage";

function Counter() {
  const [count, setCount] = useSessionStorage("count", 0);

  return (
    <div>
      <h1>Count: {count}</h1>
      <button onClick={() => setCount(count + 1)}>Increment</button>
      <button onClick={() => setCount(0)}>Reset</button>
    </div>
  );
}

export default Counter;
```

---

## 5. Real-World Use Cases in React

* Save **form inputs** temporarily before submission.
* Store **search filters** or **sorting preferences**.
* Maintain **wizard/multi-step form progress**.
* Store **temporary tokens or session-based authentication**.

---


