// export default function
//     Child1() {
//         return (<>I am in the Child1</>)
// }

import Child11 from './Child11'
export default function Child1() {
    return (<>
        I am in the Child1 begin<br />
        <Child11 /><br />
        I am at the Child1 end
    </>)
}