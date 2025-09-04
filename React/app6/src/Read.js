import { useBooks } from "./BookContext";
export default function Read({ id }) {
    const { books, setBooks } = useBooks();
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