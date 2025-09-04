import { useEffect, useState } from "react";
export default function ReadAll_SS() {
    const [data, setData] = useState([]);
    useEffect(() => {
        setData(JSON.parse(sessionStorage.getItem('data')))
    }, [])
    return (<>
        <table border='1'>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Age</th>
                    <th>Address</th>
                    <th>Read</th>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                {data.map((person) =>
                    <tr>
                        <td>{person.id}</td>
                        <td>{person.name}</td>
                        <td>{person.age}</td>
                        <td>{person.address}</td>                        
                    </tr>)}
            </tbody>
        </table>
       </>)
}