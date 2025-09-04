import { useBooks } from "./BookContext";
export default function Delete({ id, action }) {
    const { books, setBooks } = useBooks();
    const book = books.find(b => b.id === id);
    const handleDelete = () => {
        if (window.confirm('Are you sure you want to delete this book ? ')){ setBooks(books.filter(b => b.id !== id));
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