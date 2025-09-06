# Crud operations and sessions

### useContext

`useContext` in React is a hook that allows you to access values from a context without passing props manually at every level. It simplifies state sharing across deeply nested components. Context is usually created using `createContext` and consumed using `useContext`.

### CRUD operations for API

CRUD stands for Create, Read, Update, and Delete. In React, these operations are commonly performed with APIs to manage data. For example, `POST` for create, `GET` for read, `PUT/PATCH` for update, and `DELETE` for deletion.

### Session Storage using React

Session storage stores data temporarily for a single browser session. It is useful for persisting data until the user closes the tab. In React, you can use `sessionStorage.setItem()` and `sessionStorage.getItem()` with hooks like `useEffect` to manage session data.

---

### Filename: `App.js`

```javascript
import { useState } from "react";
import { BookContext } from "./BookContext";
import ReadAll from "./ReadAll";
import SessionStorage from "./SessionStorage";
import ReadAll_SS from "./ReadAll_SS";

function App() {
  const [books, setBooks] = useState([
    {
      id: 1,
      title: 'Harry Potter',
      author: 'J.K. Rowling',
      price: 10
    },
    {
      id: 2,
      title: 'The Hobbit',
      author: 'J.R.R. Tolkien',
      price: 15
    },
    {
      id: 3,
      title: 'The Lord of the Rings',
      author: 'J.R.R. Tolkien',
      price: 20
    }
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
```

---

### Filename: `BookContext.js`

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

---

### Filename: `Create.js`

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

---

### Filename: `Delete.js`

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

---

### Filename: `Read.js`

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

---

### Filename: `ReadAll.js`

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

---

### Filename: `ReadAll_SS.js`

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
        <>This is Session Component</>
    );
}
export default SessionStorage;
```

---

### Filename: `Update.js`

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

---

