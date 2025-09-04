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