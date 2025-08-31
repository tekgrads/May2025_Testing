// export default function Read()
// { return (<>
// <h1>I am in the Read</h1>
// </>)
// }

import { useParams } from "react-router-dom";
export default function Read() {
    const { id } = useParams();
    return (<>
        <h1>I am in the Read with id : {id}</h1>
    </>)
}