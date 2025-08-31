// import './App.css'; function App() {
// return (<>
// <input type='button' value='Add'/>
// <button>Delete</button>
// </>);
// }
// export default App;

// import { useState } from "react";

// function App() {
//   const [firstName, setFirstName] = useState('John');
//   return (<>
//     <input type='text'
//       value={firstName} placeholder='Enter your name' />
//   </>)
// }
// export default App;


// import { useState } from "react";

// function App() {
//   const [firstName, setFirstName] = useState(''); 

//   return (<>
//     <input type='text'
//       value={firstName} placeholder='Enter your name'
//       onChange={(e) => setFirstName(e.target.value)}
//     />
//     <p>Hello {firstName}</p>
//   </>)
// }
// export default App;


// import { useState } from "react"; function App() {
//   const [firstName, setFirstName] = useState('');

//   const printData = () => {
//     console.log(firstName);
//   }
//   return (<>
//     <input type='text'
//       value={firstName} placeholder='Enter your name'
//       onChange={(e) => setFirstName(e.target.value)}
//     /><br />
//     <button onClick={printData} type='button'>Click me</button>
//   </>)
// }
// export default App;


// import { useState } from "react";

// function App() {
//   const [password, setPassword] = useState(''); const printData = () => {
//     console.log(password);
//   }
//   return (<>
//     <input type='password'
//       value={password} placeholder='Enter your password'
//       onChange={(e) => setPassword(e.target.value)}
//     /><br />
//     <button onClick={printData} type='button'>Click me</button>
//   </>)
// }
// export default App;



// import { useState } from "react";

// function App() {
//   const [address, setAddress] = useState('Mumbai'); const printData = () => {
//     console.log(address);
//   }
//   return (<>
//     <textarea onChange={(e) => setAddress(e.target.value)} value={address}
//       placeholder='Enter your address' />

//     <br />
//     <button onClick={printData} type='button'>Click me</button>


//   </>)
// }


// export default App;



// import { useState } from "react"; 

// function App() {
//   const [date, setDate] = useState();

//   const printData = () => {
//     console.log(date);
//   }
//   return (<>
//     <input type="date"
//       value={date} placeholder='dd-mm-yyyy'
//       onChange={(e) => setDate(e.target.value)} />
//     <br />
//     <button onClick={printData} type='button'>Click me</button>


//   </>)
// }



//export default App;



// import { useState } from "react";

// function App() {
//   const [dob, setDob] = useState(); 
//   const printData = () => {
//     console.log(dob);
//   }
//   return (<>
//     <input type="datetime-local" value={dob} placeholder='dd-mm-yyyy'
//       onChange={(e) => setDob(e.target.value)} />
//     <br />
//     <button onClick={printData} type='button'>Click me</button>



//   </>)
// }

// export default App;


// import { useState } from "react"; 

// function App() {
//   const [education, setEducation] = useState(); 
//   const printData = () => {
//     console.log(education);
//   }
//   return (<>
//     Education :
//     <select value={education}
//       onChange={(e) => setEducation(e.target.value)}>
//       <option value=''>Select</option>
//       <option value='B.Tech'>B.Tech</option>
//       <option value='M.Tech'>M.Tech</option>
//       <option value='B.A'>B.A</option>
//       <option value='M.A'>M.A</option>
//     </select>
//     <br />
//     <button onClick={printData} type='button'>Click me</button>
//   </>)
// }
// export default App;



// import { useState } from "react"; function App() {
//   const [firstName, setFirstName] = useState('');
//   const [password, setPassword] = useState('');
//   const [address, setAddress] = useState('');

//   const [education, setEducation] = useState();
//   const printData = () => {
//     console.log(firstName); console.log(password); console.log(address); console.log(education);
//   }
//   return (<>
//     First Name : <input type='text'
//       value={firstName} placeholder='Enter your name'
//       onChange={(e) => setFirstName(e.target.value)} />
//     <br />
//     Password : <input type='password'
//       value={password} placeholder='Enter your password'
//       onChange={(e) => setPassword(e.target.value)} />
//     <br />
//     Address : <textarea value={address}
//       placeholder='Enter your address'
//       onChange={(e) => setAddress(e.target.value)} />


//     <br /> Education :
//     <select value={education}
//       onChange={(e) => setEducation(e.target.value)}>
//       <option value=''>Select</option>
//       <option value='B.Tech'>B.Tech</option>
//       <option value='M.Tech'>M.Tech</option>
//       <option value='B.A'>B.A</option>
//       <option value='M.A'>M.A</option>
//     </select>
//     <br />
//     <button onClick={printData} type='button'>Click me</button>

//   </>)
// }



// export default App;



// import { useState } from "react"; function App() {
//   const [firstName, setFirstName] = useState(''); 
//   const [password, setPassword] = useState(''); 
//   const [address, setAddress] = useState(''); 
//   const [education, setEducation] = useState(); 
//   const printData = () => {
//     const person =
//     {
//       firstName, password, address, education
//     }
//     console.log(person);
//   }
//   return (<>
//     First Name : <input type='text'
//       value={firstName} placeholder='Enter your name'
//       onChange={(e) => setFirstName(e.target.value)} />
//     <br />
//     Password : <input type='password'
//       value={password} placeholder='Enter your password'
//       onChange={(e) => setPassword(e.target.value)} />
//     <br />
//     Address : <textarea value={address} placeholder='Enter your address'
//       onChange={(e) => setAddress(e.target.value)} />

//     <br /> Education :

//     <select value={education}
//       onChange={(e) => setEducation(e.target.value)}>
//       <option value=''>Select</option>
//       <option value='B.Tech'>B.Tech</option>
//       <option value='M.Tech'>M.Tech</option>
//       <option value='B.A'>B.A</option>
//       <option value='M.A'>M.A</option>
//     </select>
//     <br />
//     <button onClick={printData} type='button'>Click me</button>

//   </>)
// }



// export default App;


// import { useState } from "react"; function App() {
//   const [firstName, setFirstName] = useState(''); const [email, setEmail] = useState('');
//   const [password, setPassword] = useState('');
//   const printData = () => {
//     const person = {
//       firstName, email,
//       password
//     }
//     console.log(person);
//   }
//   return (<>
//     First Name : <input type='text'
//       value={firstName} placeholder='Enter your name'
//       onChange={(e) => setFirstName(e.target.value)} />
//     <br />
//     Email : <input type='email'
//       value={email} placeholder='Enter your email'
//       onChange={(e) => setEmail(e.target.value)} />
//     <br />
//     Password : <input type='password'
//       value={password} placeholder='Enter your password'
//       onChange={(e) => setPassword(e.target.value)} />

//     <br />
//     <button onClick={printData} type='button'>Click me</button>



//   </>)
// }



// export default App;



// import { useState } from "react"; function App() {
//   const [email, setEmail] = useState(''); const [password, setPassword] = useState('');

//   const printData = () => {
//     const person = {
//       email, password
//     }
//     console.log(person);
//   }
//   return (<>
//     Email : <input type='email'
//       value={email} placeholder='Enter your email'
//       onChange={(e) => setEmail(e.target.value)} />
//     <br />
//     Password : <input type='password'
//       value={password} placeholder='Enter your password'
//       onChange={(e) => setPassword(e.target.value)} />

//     <br />
//     <button onClick={printData} type='button'>Click me</button>




//   </>)
// }


// export default App;

















