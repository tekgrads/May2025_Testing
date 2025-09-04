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
      author: 'J.R.R. Tolkien', price:
        20
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