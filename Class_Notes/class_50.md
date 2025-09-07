
# CRUD Operations and Session Storage in React

---

## useContext

The `useContext` hook in React allows components to consume values directly from a context without having to pass props manually through each level of the component tree.  
This is especially useful for **state management across deeply nested components**.  

A context is first created with `createContext`, and components use `useContext` to access the stored value.

---

## CRUD Operations with API

CRUD represents the four primary operations for managing data:

- **Create** → `POST`
- **Read** → `GET`
- **Update** → `PUT` or `PATCH`
- **Delete** → `DELETE`

In React, these operations are often connected to APIs. Each operation manipulates data and updates the UI accordingly.

---

## Session Storage in React

Session storage keeps data temporarily for a single browser session. The data is cleared once the browser tab is closed.  
In React, it can be used to **persist data during navigation**. Common methods:

- `sessionStorage.setItem("key", value)` → stores a value.
- `sessionStorage.getItem("key")` → retrieves a value.

Using hooks like `useEffect` ensures that data is written or read at the right lifecycle stage.

---

## Filename: `App.js`

```javascript
import { useState } from "react";
import { BookContext } from "./BookContext";
import ReadAll from "./ReadAll";
import SessionStorage from "./SessionStorage";
import ReadAll_SS from "./ReadAll_SS";

function App() {
  const [books, setBooks] = useState([
    { id: 1, title: 'Harry Potter', author: 'J.K. Rowling', price: 10 },
    { id: 2, title: 'The Hobbit', author: 'J.R.R. Tolkien', price: 15 },
    { id: 3, title: 'The Lord of the Rings', author: 'J.R.R. Tolkien', price: 20 }
  ]);

  return (
    <>
      {/* {books.map(book => <div>{book.title}</div>)}
      <BookContext.Provider value={{ books, setBooks }}>
        <ReadAll />
      </BookContext.Provider> */}
      <SessionStorage />
      <ReadAll_SS />
    </>
  );
}
export default App;
````

**Explanation:**
This is the root component. It initializes book data using `useState`. It also demonstrates how components can be conditionally used:

* A context provider (`BookContext.Provider`) shares `books` and `setBooks`.
* Components like `SessionStorage` and `ReadAll_SS` demonstrate session storage functionality.

---

## Filename: `BookContext.js`

```javascript
import { createContext, useContext } from "react";

export const BookContext = createContext();

export const useBooks = () => {
    const context = useContext(BookContext);
    if (!context) {
        throw new Error("useBooks must be used within a BookProvider");
    }
    return context;
}
```

**Explanation:**
Here, a context called `BookContext` is created. The helper hook `useBooks` ensures that components safely consume this context. If used outside of a provider, it throws an error for safety.

---

## Filename: `Create.js`

```javascript
import { useState } from "react";
import { useBooks } from "./BookContext";

export default function Create({ action }) {
    const { books, setBooks } = useBooks();
    const [id, setId] = useState('');
    const [title, setTitle] = useState('');
    const [author, setAuthor] = useState('');
    const [price, setPrice] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();
        const newBook = { id, title, author, price };
        setBooks([...books, newBook]);
        setId('');
        setTitle('');
        setAuthor('');
        setPrice('');
        action(false);
    }

    return (<>
        ID : <input type="text" value={id} onChange={(e) => setId(e.target.value)} /> <br />
        Title : <input type="text" value={title} onChange={(e) => setTitle(e.target.value)} /> <br />
        Author : <input type="text" value={author} onChange={(e) => setAuthor(e.target.value)} /> <br />
        Price : <input type="text" value={price} onChange={(e) => setPrice(e.target.value)} /> <br />
        <button onClick={handleSubmit}>Add Book</button><br />
    </>)
}
```

**Explanation:**
This component handles book creation. It maintains local form state for book details and updates the global context (`books`) when the form is submitted. After adding, the form resets and the component is closed using `action(false)`.

---

## Filename: `Delete.js`

```javascript
import { useBooks } from "./BookContext";

export default function Delete({ id, action }) {
    const { books, setBooks } = useBooks();
    const book = books.find(b => b.id === id);

    const handleDelete = () => {
        if (window.confirm('Are you sure you want to delete this book ? ')) {
            setBooks(books.filter(b => b.id !== id));
        }
        action(false);
    }

    return (<>
        <h1>
            Id: {book.id} <br />
            Title: {book.title} <br />
            Author: {book.author} <br />
            Price: {book.price} <br />
            <button onClick={handleDelete}>Do you want to Delete</button>
        </h1>
    </>)
}
```

**Explanation:**
This component shows book details and allows deletion. When confirmed, the selected book is removed from the list using `filter`. The component then closes with `action(false)`.

---

## Filename: `Read.js`

```javascript
import { useBooks } from "./BookContext";

export default function Read({ id }) {
    const { books } = useBooks();
    const book = books.find(b => b.id === id);

    return (<>
        <h1>
            Id: {book.id} <br />
            Title: {book.title} <br />
            Author: {book.author} <br />
            Price: {book.price} <br />
        </h1>
    </>)
}
```

**Explanation:**
This component retrieves a book by its `id` and displays its details. It uses the global `books` context, making it reusable for any selected book.

---

## Filename: `ReadAll.js`

```javascript
import { useBooks } from "./BookContext";
import { useState } from "react";
import Create from "./Create";
import Read from "./Read";
import Update from "./Update";
import Delete from "./Delete";

export default function ReadAll() {
    const { books } = useBooks();
    const [create, setCreate] = useState(false);
    const [update, setUpdate] = useState(false);
    const [deleteComponent, setDeleteComponent] = useState(false);
    const [read, setRead] = useState(false);
    const [id, setId] = useState(0);

    const goToCreate = () => {
        setCreate(true);
        setRead(false);
        setDeleteComponent(false);
    }

    const goToRead = (id) => {
        setRead(true);
        setCreate(false);
        setUpdate(false);
        setDeleteComponent(false);
        setId(id);
    }

    const goToUpdate = (id) => {
        setRead(false);
        setCreate(false);
        setUpdate(true);
        setDeleteComponent(false);
        setId(id);
    }

    const goToDelete = (id) => {
        setRead(false);
        setCreate(false);
        setUpdate(false);
        setDeleteComponent(true);
        setId(id);
    }

    return (<>
        <h1>Read All</h1>
        <table border='1'>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Author</th>
                    <th>Price</th>
                </tr>
            </thead>
            <tbody>
                {books.map((book) =>
                    <tr key={book.id}>
                        <td>{book.id}</td>
                        <td>{book.title}</td>
                        <td>{book.author}</td>
                        <td>{book.price}</td>
                        <td><button onClick={() => goToRead(book.id)}>Read</button></td>
                        <td><button onClick={() => goToUpdate(book.id)}>Update</button></td>
                        <td><button onClick={() => goToDelete(book.id)}>Delete</button></td>
                    </tr>
                )}
            </tbody>
        </table>
        <br />
        <button onClick={goToCreate}>Create</button>
        <br />
        {create && <Create action={setCreate} />}
        {read && <Read id={id} />}
        {update && <Update id={id} action={setUpdate} />}
        {deleteComponent && <Delete id={id} action={setDeleteComponent} />}
    </>)
}
```

**Explanation:**
This component displays all books in a table. Each book row includes buttons for reading, updating, and deleting. It also provides a button to create new books. Component visibility is managed using state variables like `create`, `read`, `update`, and `deleteComponent`.

---

## Filename: `ReadAll_SS.js`

```javascript
import { useEffect, useState } from "react";

export default function ReadAll_SS() {
    const [data, setData] = useState([]);

    useEffect(() => {
        setData(JSON.parse(sessionStorage.getItem('data')))
    }, [])

    return (<>
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
                    </tr>)}
            </tbody>
        </table>
    </>)
}
```

**Explanation:**
This component reads a `data` array stored in `sessionStorage` and displays it in a table format. The `useEffect` ensures that the data is loaded only when the component first renders.

---

## Filename: `SessionStorage.js`

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
        <>This is Session Component</>
    );
}
export default SessionStorage;
```

**Explanation:**
This component initializes some static `persons` data and stores it in `sessionStorage` when the component mounts. Other components, like `ReadAll_SS`, can then access and display this data.

---

## Filename: `Update.js`

```javascript
import { useEffect, useState } from "react";
import { useBooks } from "./BookContext";

export default function Update({ id, action }) {
    const { books, setBooks } = useBooks();
    const [title, setTitle] = useState('');
    const [author, setAuthor] = useState('');
    const [price, setPrice] = useState('');

    useEffect(() => {
        const book = books.find((book) => book.id === id);
        if (book) {
            setTitle(book.title);
            setAuthor(book.author);
            setPrice(book.price);
        }
    }, [])

    const handleSubmit = (e) => {
        e.preventDefault();
        const newBook = { id, title, author, price };
        const allBooks = [...books];
        const index = allBooks.findIndex((book) => book.id === id);
        allBooks[index] = newBook;
        setBooks([...allBooks]);
        action(false);
    }

    return (<>
        Title : <input type="text" value={title} onChange={(e) => setTitle(e.target.value)} /> <br />
        Author : <input type="text" value={author} onChange={(e) => setAuthor(e.target.value)} /> <br />
        Price : <input type="text" value={price} onChange={(e) => setPrice(e.target.value)} /> <br />
        <button onClick={handleSubmit}>Update Book</button><br />
    </>)
}

```
