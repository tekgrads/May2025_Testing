import './App.css';
import { useEffect } from 'react';
function SessionStorage() {
    useEffect(()=> {
            const persons
                = [
                    { "id": '1', "name": "ramu", "age": 20, "address": "BTM" },
                    { "id": '2', "name": "ravi", "age": 25, "address": "BTM" },
                    { "id": '3', "name": "rakesh", "age": 30, "address": "JP Nagar" }
                ]
        sessionStorage.setItem("data", JSON.stringify(persons));
    }, []);
    return (
       <>This is Session Component</>
    );
}
export default SessionStorage;