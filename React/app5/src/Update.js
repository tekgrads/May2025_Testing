// export default function Update()
// { return (<>
// <h1>I am in the Update</h1>
// </>)
// }

import { useParams } from "react-router-dom";
export default function Update() {
    const { id, dept } = useParams();
    return (<>
        <h1>I am in the Update, dept: {dept} and id : {id}</h1>
    </>)
}