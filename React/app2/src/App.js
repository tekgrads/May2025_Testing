// import './App.css';
// import Product from './components/product/product';
// import Skill from './components/skill/skill';
// import Student from './components/student/student';

// function App() {
//   return (
//     <>
//       App Component
//       <Student/>
//        <Skill/>
//            <Skill/>
//       <Product/>
//     </>
//   );
// }

// export default App;


// import { useState } from "react"; 

// function App() {
//     var i = 1;
//     var [j, setJ] = useState(1);
//     const changeValues = () => {
//         i = i + 1;
//         setJ(j + 1)
//     }
//     return (<>
//         i value: {i} <br /> j: {j} <br />
//         <button onClick={changeValues}>Change</button>
//     </>);
// }
// export default App;


// import { useEffect, useState } from 'react';

// function App() {

//     var [j, setJ] = useState(1);     
//     useEffect(()=> {
//         console.log("useEffect called");
//         setJ(200);
//     });
//     return (<> j: {j} <br />
//     </>);
// }
// export default App;


// import logo from './logo.svg';
// import './App.css';
// import index from './index'
// import { useEffect, useState } from 'react'; 
// function App() {
//     var [j, setJ] = useState(1);
//     var [i, setI] = useState(1);

//     useEffect(() => {
//         console.log("useEffect called");        
//     },[]);

//     const changeJValues = () => {
//         setJ(j + 1)       
//     }

//      const changeIValues = () => {       
//         setI(i + 1)
//     }
//     return (<> j: {j} <br />
//     i: {i} <br />
//         <button onClick={changeJValues}>Change J</button>
//         <button onClick={changeIValues}>Change I</button>
//     </>);
// }
// export default App;



import logo from './logo.svg';
import './App.css';
import index from './index'
import { useEffect, useState } from 'react';
function App() {
    const [persons, setPersons] = useState([]);

    useEffect(() => {
        fetch('Person.json')
            .then(res => res.json())
            .then(data => setPersons(data))
    }, []);
    return (<>
        {
            persons.map(person => <h1>Name:{person.name}, Age:{person.age}</h1>)
        }
    </>);
}
export default App;
