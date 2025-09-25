import { useState } from "react";
import axios from "axios"
export default function Test5() {
    const [msg, setMsg] = useState([]);
    const callToApi = async () => {
        await axios.get('http://localhost:9090/test/t4')                       
              .then((response) => {
                console.log(response.data); 
                setMsg(response.data)
            })
            .catch(() => console.log('error'))
            console.log('after fetch call');
    }
    return (<>
        <button onClick={callToApi} type='button'>Call to API 123</button>
       <h1>{msg.join(', ')}</h1>
    </>)
}