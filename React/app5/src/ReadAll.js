// export default function ReadAll()
// { return (<>
// <h1>I am in the Read All</h1>
// </>)
// }

import { useNavigate } from "react-router-dom";
export default function ReadAll() {
    const navigate = useNavigate();
    const gotoDelete = () => {
        navigate("/delete");
    }
    return (<>
        <h1>
            I am in the Read All <br />
            <button onClick={gotoDelete}>Delete</button>
        </h1>
    </>)
}