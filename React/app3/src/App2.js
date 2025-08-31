// import { useState } from "react";
// function App2() {
//     const a1 = [1, 2, 3, 4, 5];
//     const [a2, setA2] = useState([0, 2, 3, 4, 5]); 

//     return (<>
//         {a1.join(',')} <br />
//         {a2.join(',')} <br />
//     </>)
// }
// export default App2;


// import { useState } from 'react';
// function App() {
//     const a1 = [1, 2, 3, 4, 5];
//     const [a2, setA2] = useState([0, 2, 3, 4, 5]); return (<>
//         {a1.map((item) => <span key={item}>{item}, </span>)} <br />
//         {a1.map((item, index) => <span key={index}>{item}, </span>)} <br />      
//     </>)
// }
// export default App;


// import { useState } from 'react';
// function App() {
//     const [a2, setA2] = useState([10, 15, 20, 25, 30, 40, 45, 50, 60]);
//     return (<>
//         {a2.map((item, index) => <span key={index}>{item}, </span>)} <br />
//         {a2.filter((item, index) => item > 20)
//             .map((item, index) => <span key={index}>{item}, </span>)} <br />
//         {a2.filter((item, index) => item % 10 == 0)
//             .map((item, index) => <span key={index}>{item}, </span>)} <br />
//     </>)
// }
// export default App;



// import { useState } from 'react';
// function App() {
//     const [a2, setA2] = useState([10, 15, 20, 25, 30, 40, 45, 50, 60]);
//     return (<>
//         {a2.map((item, index) => <span key={index}>{item}, </span>)} <br /> sum: {a2.reduce((a, b) => a + b, 0)} <br /> 
//         multiplication:{a2.reduce((a, b) => a * b, 1)} <br />
//         max value: {a2.reduce((a, b) => a > b ? a : b)} <br />

//         min value:{a2.reduce((a, b) => a < b ? a : b)} <br />
//     </>)
// }
// export default App;




// import { useState } from 'react'; import './App.css';
// function App() {
//     const [array, setArray] = useState([101, 120, 40, 510, 601, 70, 180, 9, 100]);
//      const handleFinalize = () => {
//         setArray([array.sort((a, b) => a - b)]);
//     }
//     return (<>
//         <h1>Array: {array.join(',')}</h1>
//         <button onClick={handleFinalize}>Finalize</button>
//     </>);
// }
// export default App;



// import { useState } from 'react'; import './App.css';
// function App() {
//     const [array, setArray] = useState(["hello", "world", "react", "js", "css", "btm", "test", "abc"]); 

//     const handleFinalize = () => {
//         setArray([array.sort((a, b) => a.localeCompare(b))]);
//     }
//     return (<>
//         <h1>Array: {array.join(',')}</h1>
//         <button onClick={handleFinalize}>Finalize</button>
//     </>);
// }
// export default App;



// import { useState } from 'react'; import './App.css';
// function App() {
//     const [array, setArray] = useState(["hello", "world", "react", "js", "css", "bpm", "test", "abc"]); 
//     const [results, setResults] = useState([]);
//     const handleFinalize = () => {
//         setResults(array.filter((item) => item.includes("c")));
//     }
//     return (<>
//         <h1>Array: {array.join(',')}</h1>
//         <h1>Results: {results.join(',')}</h1>
//         <button onClick={handleFinalize}>Search</button>
//     </>);
// }
// export default App;



// import { useState } from 'react'; import './App.css';
// function App() {
//     const [array, setArray] = useState([121, 453, 431, 765, 984]);
//     const [results, setResults] = useState([]);
//     const handleFinalize = () => {
//         setResults(array.filter((item) => item.toString().includes("4")));
//     }
//     return (<>
//         <h1>Array: {array.join(',')}</h1>
//         <h1>Results: {results.join(',')}</h1>
//         <button onClick={handleFinalize}>Search</button>
//     </>);
// }
// export default App;


// import { useState } from 'react';
// function App() {
//     const [person, setPerson] = useState({
//         name: "John", age: 30, gender: "male"
//     });
//     return (<>
//         Name: {person.name} <br /> Age: {person.age} <br /> Gender: {person.gender} <br />
//     </>)
// }
// export default App;


// import { useState } from 'react';
// function App() {
//     const [person, setPerson] = useState({
//         name: "John", age: 30,

//         gender: "male"
//     });
//     const str = JSON.stringify(person); 
//     return (<>
//         {str}
//     </>)
// }
// export default App;



// import { useState } from 'react';
// function App() {
//     const [person, setPerson] = useState({
//         name: "John", age: 30, gender: "male"
//     });
//     const str = JSON.stringify(person); 

//     const person1 = JSON.parse(str); 
//     return (<>
//         Name: {person1.name} <br /> Age: {person1.age} <br /> Gender: {person1.gender} <br />
//     </>)
// }
// export default App;


// import { useState } from 'react';
// function App() {
//     const [person, setPerson] = useState({
//         name: "John", age: 30, gender: "male"
//     });
//     const allKeys = Object.keys(person); 
//     return (<>
//         {allKeys.join(', ')} <br />
//         {allKeys.map((key) => <span key={key}>
//             {key} </span>)} <br />
//         {allKeys.map((key) => <span key={key}>
//             {key} : {person[key]}, </span>)} <br />
//     </>)
// }
// export default App;



// import { useState } from 'react';
// function App() {
//     const [person, setPerson] = useState({
//         name: "John", age: 30, gender: "male"
//     });
//     const allValues = Object.values(person); return (<>
//         {allValues
//             .join(', ')} <br />
//         {allValues.map((v) => <span key={v}>
//             {v} </span>)} <br />

//     </>)
// }
// export default App;


// import { useState } from 'react';
// function App() {
//     const [person, setPerson] = useState({
//         name: "John", age: 30, gender: "male"
//     });
//     const allEntries = Object.entries(person); 

//     console.log(allEntries);


//     return (<>
//         {allEntries.join('; ')} <br />

//         {allEntries.map((entry) =>
//             <span key={entry}>{entry}, </span>
//         )} <br />
//         {allEntries.map((entry) =>
//             <span key={entry}>{entry[0]} : {entry[1]}, </span>
//         )} <br />

//         {allEntries.map(([key, value]) =>
//             <span key={key}>{key}: {value}, </span>
//         )} <br />
//     </>)
// }
// export default App;

// import { useState } from 'react';
// function App() {
//     const [person1, setPerson1] = useState({
//         name: "John", age: 30, gender: "male"
//     });
//     const [person2, setPerson2] = useState({
//         weight: 56.89,
//         height: 5.4
//     });
//     const person3 = Object.assign(person1, person2); 
//     return (<>
//         {Object.entries(person1).map(
//             (entry) => <span key={entry}>{entry},</span>)} <br />
//         {Object.entries(person2).map(
//             (entry) => <span key={entry}>{entry},</span>)} <br />
//         {Object.entries(person3).map(
//             (entry) => <span key={entry}>{entry},</span>)} <br />
//     </>)
// }
// export default App;



// import { useState } from 'react';
// function App() {
//     const [person1, setPerson1] = useState({
//         name: "John", age: 30, gender: "male"
//     });
//     const addData = () => {
//         const person2 = { ...person1, weight: 77.56 };
//          setPerson1(person2)
//     }
//     return (<>
//         {Object.entries(person1).map(
//             (entry) => <span key={entry}>{entry},</span>)} <br />
//         <button onClick={addData} type="button">Add</button>
//     </>)
// }
// export default App;


import { useState } from 'react';
function App() {
    const [person1, setPerson1] = useState({
        name: "John", age: 30, gender: "male"
    });
    const changeData = () => {
        const person2 = { ...person1 }; 
        delete person2.age;
         setPerson1(person2)
    }
    return (<>
        {Object.entries(person1).map(
            (entry) => <span key={entry}>{entry},</span>)} <br />

        <button onClick={changeData} type="button">Change</button>
    </>)
}
export default App;



