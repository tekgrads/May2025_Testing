import logo from './logo.svg';
import './App.css';
import { Link } from 'react-router-dom';
import Child1 from './Child1';
import Child11 from './Child11';
import Level1Child from './Level1Child';
import { useState } from 'react';

function App() {
  const names = ["ramu", "sita", "gita", "hari"];
  const person =
  {
    firstName: 'John',
    lastName: 'Doe',
    age: 30
  }

  const persons =
    [{
      firstName: 'John',
      lastName: 'Doe',
      age: 30
    },
    {
      firstName: 'Mohan',
      lastName: 'Babu',
      age: 32
    }];

  const test = () => {
    console.log("from test in app component");
  }
  const [count, setCount] = useState(10);
  const f1 = () => {
    setCount(count + 1);
  }
  return (
    // <div className="App">
    //   <Link to="/">Go to home</Link>&nbsp;
    //   <Link to="/read/6">Go to read</Link>&nbsp;
    //   {/* <Link to="/update">Go to update</Link>&nbsp; */}
    //   <Link to="/update/software/10">Go To Update</Link>&nbsp;
    //   <Link to="/delete">Go to delete</Link>&nbsp;
    //   <Link to="/readAll">Read All</Link>&nbsp;
    //   <Link to="/goToA">Go To A</Link>&nbsp;
    //   <Link to="/gotoB">Go To B</Link><br />
    // </div>
    <>
      {/* <Child1/><br/>    */}

      <h1>
        I am in the App beginning <br />
        <Level1Child firstName="ramu" names={names} person={person} persons={persons} test={test} f1={f1} />
        {count} <br/>
        I am at the App end
      </h1>
    </>

  );
}

export default App;
