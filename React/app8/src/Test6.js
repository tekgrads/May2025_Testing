import { useState } from "react"
import axios from "axios"
export default function Test12() {
    const [firstName, setFirstName] = useState("")
    const [lastName, setLastName] = useState("")
    const [age, setAge] = useState(0);
    const submitHandler = (event) => {
        event.preventDefault();
        console.log(firstName, lastName, age)
        const person = { firstName, lastName, age };
        console.log(person)
         axios.post('http://localhost:9090/test/t12', person)
        .
        then(response => response.data)
        .then(data => console.log(data))
        .catch(error => console.log(error))
    }
    return (<>
        First Name : <input type="text"
            value={firstName}
            onChange={(event) => setFirstName(event.target.value)} /><br />
        Last Name : <input type="text"
            value={lastName}
            onChange={(event) => setLastName(event.target.value)} /><br />
        Age : <input type="number"
            value={age}
            onChange={(event) => setAge(event.target.value)} /><br />
        <button onClick={submitHandler} type="button">Submit</button>
    </>)
}