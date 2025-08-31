
//import './App.css';
// import f3, { f1, f2, v1 } from './Hello1';
// function App8() {
//     const test1 = () => {
//         f1();
//         f2();
//         f3();
//         console.log(v1);
//     }
//     return (

//         <>
//             <button type='button' onClick={test1}>Test</button>
//         </>
//     );
// }

// export default App8;



// const i = 10;

// function App()
// { 
//     const j = 20;
//     return (<>{i}-{j}-{k}-{m}</ >);
// }
// const k = 30;

// export default App; 
// const m = 50;


// const t1 = () =>
// { return 10;
// }
// function App()
// { 
//     const t2 = () =>
//     { 
//         return 20;
//     }
// return (<h1>{t1()}-{t2()}-{t3()}-{t4()}</h1>);
// }
// const t3 = () =>
// { return 30;
// }
// export default App; 

// const t4 = () =>
// { return 40;
// }


// function App() {
//     const person = {
//         "name": "Mohan", "age": 20
//     }
//     return (<>{person.name}-{person.age}</ >);
// }
// export default App;


// function App() {
//     const marks = [100, 98, 57, 89, 80] 
//     return (<h1>
//         marks: {marks} <br /> marks: {marks.join(',')}
//     </h1>
//     );
// }
// export default App;



// function App() {
//     const marks = [100, 98, 57, 89, 80]
//     return (<h1>
//         marks: {marks.map(mark => mark)} <br />
//         marks: {marks.map(mark => <li>{mark}</li>)} <br />
//         marks: {marks.map(mark => <p key={mark}>{mark}</p>)} <br /> 
//         marks: {marks.map(mark => {
//             return <div key={mark}>{mark}</div>
//         })}

//         <br />
//     </h1>);
// }
// export default App;


// function App() {
//     const marks = [100, 98, 57, 89, 80]
//     marks.forEach(mark => console.log(mark)); 
//     return (<h1>
//         done
//     </h1>);
// }
// export default App;

// function App() {
//     const persons = [
//         {
//             "name": "ramu", "age": 20
//         },
//         {
//             "name": "ravi", "age": 21
//         }
//     ]
//     return (<h1>
//         {persons.map((person) =>
//             <div>
//                 <p>{person.name}</p>
//                 <p>{person.age}</p>
//             </div>)
//         }
//     </h1>);
// }
// export default App;

import './App.css'; 

function App() {
    return (
        <h1>
            I am from h1
        </h1>
    );
}
export default App;
