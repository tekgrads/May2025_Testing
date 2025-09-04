import { useEffect, useState } from "react";
import { useBooks } from "./BookContext";
export default function Update({ id,
    action }) {
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