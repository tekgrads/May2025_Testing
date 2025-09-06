import axios from "axios";
export default function Test13() {
    const test = async () => {
        console.log(1);
        await axios.get('https://jsonplaceholder.typicode.com/posts')
            .then((results) => console.log(results))
            .catch((err) => console.log(err));
        console.log(2);
        console.log(3);
        console.log(4);
        console.log(5);
    }
    return (
        <>
            <button type="button" onClick={test}>test</button>
        </>
    );
}