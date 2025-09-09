
# CRUD Operations and Sessions

### useContext

`useContext` in React is a hook that allows you to access values from a context without passing props manually at every level. It simplifies state sharing across deeply nested components. Context is usually created using `createContext` and consumed using `useContext`.

---

### CRUD operations for API

CRUD stands for Create, Read, Update, and Delete. In React, these operations are commonly performed with APIs to manage data. For example, `POST` for create, `GET` for read, `PUT/PATCH` for update, and `DELETE` for deletion.

---

### Session Storage using React

Session storage stores data temporarily for a single browser session. It is useful for persisting data until the user closes the tab. In React, you can use `sessionStorage.setItem()` and `sessionStorage.getItem()` with hooks like `useEffect` to manage session data.

---

### Filename: `App.js`

```javascript
import { useState } from "react";
import { MovieContext } from "./MovieContext";
import ReadAll from "./ReadAll";
import SessionStorage from "./SessionStorage";
import ReadAll_SS from "./ReadAll_SS";

function App() {
  const [movies, setMovies] = useState([
    { id: 1, title: 'Inception', director: 'Christopher Nolan', rating: 9 },
    { id: 2, title: 'Interstellar', director: 'Christopher Nolan', rating: 8.5 },
  ]);

  return (
    <>
      {/* <MovieContext.Provider value={{ movies, setMovies }}>
        <ReadAll />
      </MovieContext.Provider> */}
      <SessionStorage />
      <ReadAll_SS />
    </>
  );
}
export default App;
```

---

### Filename: `MovieContext.js`

```javascript
import { createContext, useContext } from "react";

export const MovieContext = createContext();

export const useMovies = () => {
    const context = useContext(MovieContext);
    if (!context) {
        throw new Error("useMovies must be used within a MovieProvider");
    }
    return context;
}
```

---

### Filename: `Create.js`

```javascript
import { useState } from "react";
import { useMovies } from "./MovieContext";

export default function Create({ action }) {
    const { movies, setMovies } = useMovies();
    const [id, setId] = useState('');
    const [title, setTitle] = useState('');
    const [director, setDirector] = useState('');
    const [rating, setRating] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();
        const newMovie = { id, title, director, rating };
        setMovies([...movies, newMovie]);
        setId('');
        setTitle('');
        setDirector('');
        setRating('');
        action(false);
    }

    return (<>
        ID : <input type="text" value={id} onChange={(e) => setId(e.target.value)} /> <br />
        Title : <input type="text" value={title} onChange={(e) => setTitle(e.target.value)} /> <br />
        Director : <input type="text" value={director} onChange={(e) => setDirector(e.target.value)} /> <br />
        Rating : <input type="text" value={rating} onChange={(e) => setRating(e.target.value)} /> <br />
        <button onClick={handleSubmit}>Add Movie</button><br />
    </>)
}
```

---

### Filename: `Delete.js`

```javascript
import { useMovies } from "./MovieContext";

export default function Delete({ id, action }) {
    const { movies, setMovies } = useMovies();
    const movie = movies.find(m => m.id === id);

    const handleDelete = () => {
        if (window.confirm('Are you sure you want to delete this movie?')) {
            setMovies(movies.filter(m => m.id !== id));
        }
        action(false);
    }

    return (<>
        <h1>
            Id: {movie.id} <br />
            Title: {movie.title} <br />
            Director: {movie.director} <br />
            Rating: {movie.rating} <br />
            <button onClick={handleDelete}>Confirm Delete</button>
        </h1>
    </>)
}
```

---

### Filename: `Read.js`

```javascript
import { useMovies } from "./MovieContext";

export default function Read({ id }) {
    const { movies } = useMovies();
    const movie = movies.find(m => m.id === id);

    return (<>
        <h1>
            Id: {movie.id} <br />
            Title: {movie.title} <br />
            Director: {movie.director} <br />
            Rating: {movie.rating} <br />
        </h1>
    </>)
}
```

---

### Filename: `ReadAll.js`

```javascript
import { useMovies } from "./MovieContext";
import { useState } from "react";
import Create from "./Create";
import Read from "./Read";
import Update from "./Update";
import Delete from "./Delete";

export default function ReadAll() {
    const { movies } = useMovies();
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
        <h1>Movie List</h1>
        <table border='1'>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Director</th>
                    <th>Rating</th>
                </tr>
            </thead>
            <tbody>
                {movies.map((movie) =>
                    <tr key={movie.id}>
                        <td>{movie.id}</td>
                        <td>{movie.title}</td>
                        <td>{movie.director}</td>
                        <td>{movie.rating}</td>
                        <td><button onClick={() => goToRead(movie.id)}>Read</button></td>
                        <td><button onClick={() => goToUpdate(movie.id)}>Update</button></td>
                        <td><button onClick={() => goToDelete(movie.id)}>Delete</button></td>
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
        setData(JSON.parse(sessionStorage.getItem('employees')))
    }, [])

    return (<>
        <table border='1'>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Department</th>
                    <th>Salary</th>
                </tr>
            </thead>
            <tbody>
                {data.map((emp) =>
                    <tr key={emp.id}>
                        <td>{emp.id}</td>
                        <td>{emp.name}</td>
                        <td>{emp.department}</td>
                        <td>{emp.salary}</td>
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
        const employees = [
            { "id": '1', "name": "Alice", "department": "HR", "salary": 40000 },
            { "id": '2', "name": "Bob", "department": "Engineering", "salary": 60000 },
            { "id": '3', "name": "Charlie", "department": "Marketing", "salary": 50000 }
        ]
        sessionStorage.setItem("employees", JSON.stringify(employees));
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
import { useMovies } from "./MovieContext";

export default function Update({ id, action }) {
    const { movies, setMovies } = useMovies();
    const [title, setTitle] = useState('');
    const [director, setDirector] = useState('');
    const [rating, setRating] = useState('');

    useEffect(() => {
        const movie = movies.find((movie) => movie.id === id);
        if (movie) {
            setTitle(movie.title);
            setDirector(movie.director);
            setRating(movie.rating);
        }
    }, [])

    const handleSubmit = (e) => {
        e.preventDefault();
        const newMovie = { id, title, director, rating };
        const allMovies = [...movies];
        const index = allMovies.findIndex((movie) => movie.id === id);
        allMovies[index] = newMovie;
        setMovies([...allMovies]);
        action(false);
    }

    return (<>
        Title : <input type="text" value={title} onChange={(e) => setTitle(e.target.value)} /> <br />
        Director : <input type="text" value={director} onChange={(e) => setDirector(e.target.value)} /> <br />
        Rating : <input type="text" value={rating} onChange={(e) => setRating(e.target.value)} /> <br />
        <button onClick={handleSubmit}>Update Movie</button><br />
    </>)
}
```
