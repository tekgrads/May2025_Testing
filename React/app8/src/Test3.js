import { useState } from "react";
export default function Test1() {
    const [msg, setMsg] = useState([]);
    const callToApi = () => {
        fetch('http://localhost:9090/test/t4')
           // .then(() => console.log('ok'))
            .then((response) => response.json())
              .then((response) => {
                console.log(response); 
                setMsg(response)
            })
            .catch(() => console.log('error'))
    }
    return (<>
        <button onClick={callToApi} type='button'>Call to API 123</button>
       <h1>{msg.join(', ')}</h1>
    </>)
}