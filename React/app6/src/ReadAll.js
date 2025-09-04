import { useBooks } from "./BookContext";
import { useState } from "react";
import Create from "./Create";
import Read from "./Read";
import Update from "./Update";
import Delete from "./Delete";
export default function ReadAll() {
    const { books, setBooks } = useBooks();
    const [create, setCreate] = useState(false);
    const [update, setUpdate] = useState(false);
    const [deleteComponent, setDeleteComponent] = useState(false);
    const goToCreate = () => {
        setCreate(true);
        setRead(false);
        setDeleteComponent(false);
    }

    const [read, setRead] = useState(false);
    const [id, setId] = useState(0);

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
                    <tr>
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
        <br></br>
        <button onClick={goToCreate}>Create</button>
        <br></br>
        {create && <Create action={setCreate} />}
        {read && <Read id={id} />}
        {update && <Update id={id} action={setUpdate} />}
        {deleteComponent && <Delete id={id} action={setDeleteComponent} />}
    </>)
}
