# Assignment with Routing and Session Storage


### Filename: `App.js`
```javascript
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import { useState } from "react";
import { BookContext } from "./BookContext";
import ReadAll from "./ReadAll";
import SessionStorage from "./SessionStorage";
import ReadAll_SS from "./ReadAll_SS";

function App() {
  const [books, setBooks] = useState([
    { id: 1, title: "Harry Potter", author: "J.K. Rowling", price: 10 },
    { id: 2, title: "The Hobbit", author: "J.R.R. Tolkien", price: 15 },
    { id: 3, title: "The Lord of the Rings", author: "J.R.R. Tolkien", price: 20 }
  ]);

  return (
    <BookContext.Provider value={{ books, setBooks }}>
      <Router>
        <nav style={{ marginBottom: "20px" }}>
          <Link to="/" style={{ marginRight: "15px" }}>Home</Link>
          <Link to="/crud" style={{ marginRight: "15px" }}>CRUD Operations</Link>
          <Link to="/session">Session Storage</Link>
        </nav>
        <Routes>
          <Route path="/" element={<h2>Welcome to App6 with Routing</h2>} />
          <Route path="/crud" element={<ReadAll />} />
          <Route path="/session" element={
            <>
              <SessionStorage />
              <ReadAll_SS />
            </>
          } />
        </Routes>
      </Router>
    </BookContext.Provider>
  );
}
export default App;
```

---

### Filename: `SessionStorage.js`
```javascript
import './App.css';
import { useEffect } from 'react';

function SessionStorage() {
    useEffect(() => {
        const persons = [
            { "id": '1', "name": "ramu", "age": 20, "address": "BTM" },
            { "id": '2', "name": "ravi", "age": 25, "address": "BTM" },
            { "id": '3', "name": "rakesh", "age": 30, "address": "JP Nagar" }
        ]
        sessionStorage.setItem("data", JSON.stringify(persons));
    }, []);

    return (
        <h3>Session Storage Data has been saved. Check table below.</h3>
    );
}
export default SessionStorage;
```

---

### Filename: `ReadAll_SS.js`
```javascript
import { useEffect, useState } from "react";

export default function ReadAll_SS() {
    const [data, setData] = useState([]);

    useEffect(() => {
        const stored = sessionStorage.getItem('data');
        if (stored) {
            setData(JSON.parse(stored));
        }
    }, []);

    return (
        <>
            <h2>Reading from Session Storage</h2>
            <table border='1'>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Age</th>
                        <th>Address</th>
                    </tr>
                </thead>
                <tbody>
                    {data.map((person) =>
                        <tr key={person.id}>
                            <td>{person.id}</td>
                            <td>{person.name}</td>
                            <td>{person.age}</td>
                            <td>{person.address}</td>
                        </tr>
                    )}
                </tbody>
            </table>
        </>
    );
}
```

---

## Browser Output:

### `http://localhost:3000/`
```
Home   CRUD Operations   Session Storage
Welcome to App6 with Routing
```

---

### `http://localhost:3000/crud`
```
Home   CRUD Operations   Session Storage

Read All
ID   Title                Author           Price
1    Harry Potter         J.K. Rowling     10    Read   Update   Delete
2    The Hobbit           J.R.R. Tolkien   15    Read   Update   Delete
3    The Lord of the Rings J.R.R. Tolkien  20    Read   Update   Delete
899  Sathvika_Biography   Sathvika         2000  Read   Update   Delete

Create
Id: 899
Title: Sathvika_Biography
Author: Sathvika
Price: 2000
```

---

### `http://localhost:3000/session`
```
Home   CRUD Operations   Session Storage

Session Storage Data has been saved. Check table below.
Reading from Session Storage
ID   Name   Age   Address
1    ramu   20    BTM
2    ravi   25    BTM
3    rakesh 30    JP Nagar
```
