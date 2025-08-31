// import { useState } from 'react';
// function App() {
//   const [gender, setGender] = useState('');
//   const printData = () => {
//     console.log(gender);
//   }
//   return (<>
//     Gender:
//     <input type='radio'
//       name='gender'
//       value='male'
//       onChange={(e) => setGender(e.target.value)} /> Male &nbsp;&nbsp;
//     <input type='radio'
//       name='gender'
//       value='female'
//       onChange={(e) => setGender(e.target.value)} /> Female <br />
//     <button onClick={printData}>Print Gender</button>
//   </>)
// }
// export default App;


// import { useState } from 'react';
// function App() {
//   const [gender, setGender] = useState('');
//   const genders = ['male', 'female']; //reference data
//   const printData = () => {
//     console.log(gender);
//   }
//   return (<>
//     Gender:
//     {genders.map(gen => <><input type='radio'
//       name='gender'
//       value={gen}
//       onChange={(e) => setGender(e.target.value)} />{gen} &nbsp;&nbsp;</>)} <br />
//     <button onClick={printData}>Print Gender</button>
//   </>)
// }
// export default App;


// import { useState } from 'react';
// function App() {
//   const [gender, setGender] = useState('');
//   const genders = [{ id: 1, name: 'Male' },
//   { id: 2, name: 'Female' },
//   { id: 3, name: 'Other' }];
//   const printData = () => {
//     console.log(gender);
//   }
//   return (<>
//     Gender:
//     {genders.map(gen => <><input type='radio'
//       name='gender'
//       value={gen.id}
//       onChange={(e) => setGender(e.target.value)} />{gen.name} &nbsp;&nbsp;</>)} <br />
//     <button onClick={printData}>Print Gender</button>
//   </>)
// }

// export default App;


// import { useState } from 'react';
// function App() {
//   const [selectedSkills, setSelectedSkills] = useState([]);
//   const printData = () => {
//     console.log(selectedSkills.join(','));
//   }
//   return (<>
//     Skills:
//     <input type='checkbox'
//       value='Java'
//       onChange={(e) => setSelectedSkills(e.target.checked ? [...selectedSkills, e.target.value] : selectedSkills.filter(skill => skill !==
//         e.target.value))} />Java &nbsp;&nbsp;
//     <input type='checkbox'
//       value='React'
//       onChange={(e) => setSelectedSkills(e.target.checked ? [...selectedSkills, e.target.value] : selectedSkills.filter(skill => skill !==
//         e.target.value))} />React &nbsp;&nbsp;
//     <input type='checkbox'
//       value='Angular'
//       onChange={(e) => setSelectedSkills(e.target.checked ? [...selectedSkills, e.target.value] : selectedSkills.filter(skill => skill !==
//         e.target.value))} />Angular <br />
//     <button onClick={printData}>Print Skills</button>
//   </>)
// }
// export default App;


// import { useState } from 'react';
// function App() {
//   const [selectedSkills, setSelectedSkills] = useState([]);
//   const handleSkill = (e) => {
//     const skill = e.target.value;
//     if (selectedSkills.includes(skill)) {
//       setSelectedSkills(selectedSkills.filter(s => s !==
//         skill));
//     }
//     else {
//       setSelectedSkills([...selectedSkills, skill]);
//     }
//   }
//   const printData = () => {
//     console.log(selectedSkills.join(','));
//   }
//   return (<>
//     Skills:
//     <input type='checkbox'
//       value='Java'
//       onChange={handleSkill} />Java &nbsp;&nbsp;
//     <input type='checkbox'
//       value='React'
//       onChange={handleSkill} />React &nbsp;&nbsp;
//     <input type='checkbox'
//       value='Angular'
//       onChange={handleSkill} />Angular <br />
//     <button onClick={printData}>Print Skills</button>
//   </>)
// }
// export default App;


// import { useState } from 'react';
// function App() {
//   const [selectedSkills, setSelectedSkills] = useState([]);
//   const skills = ['Java', 'React', 'Angular'];
//   const handleSkill = (e) => {
//     const skill =
//       e.target.value;
//     if (selectedSkills.includes(skill)) {
//       setSelectedSkills(selectedSkills.filter(s => s !==
//         skill));
//     }
//     else {
//       setSelectedSkills([...selectedSkills, skill]);
//     }
//   }
//   const printData = () => {
//     console.log(selectedSkills.join(','));
//   }
//   return (<>
//     Skills:
//     {skills.map(skill => (<><input type='checkbox'
//       value={skill}
//       onChange={handleSkill} />{skill} &nbsp;&nbsp;</>))}
//     <br />
//     <button onClick={printData}>Print Skills</button>
//   </>)
// }
// export default App;


// import { useState } from 'react';
// function App() {
//   const [selectedSkills, setSelectedSkills] = useState([]);
//   const skills = [{ id: 1, name: 'React' },
//   { id: 2, name: 'Angular' },
//   { id: 3, name: 'Vue' }];
//   const handleSkill = (e) => {
//     const skill = e.target.value;
//     if (selectedSkills.includes(skill)) {
//       setSelectedSkills(selectedSkills.filter(s => s !==
//         skill));
//     }
//     else {
//       setSelectedSkills([...selectedSkills, skill]);
//     }
//   }
//   const printData = () => {
//     console.log(selectedSkills.join(','));
//   }
//   return (<>
//     Skills:
//     {skills.map(skill => (<><input type='checkbox'
//       value={skill.id}
//       onChange={handleSkill} />{skill.name} &nbsp;&nbsp;</>))}
//     <br />
//     <button onClick={printData}>Print Skills</button>
//   </>)
// }
// export default App;


// import { useState } from 'react';
// function App() {
//   const [selectedEducations, setSelectedEducations] = useState([]);
//   const printData = () => {
//     console.log(selectedEducations.join(','));
//   }
//   return (<>
//     Education:
//     <select multiple
//       onChange={(e) => setSelectedEducations([...e.target.selectedOptions].map(option => option.value))}>
//       <option value="B.Tech">B.Tech</option>
//       <option value="M.Tech">M.Tech</option>
//       <option value="B.Arch">B.Arch</option>
//     </select><br />
//     <button onClick={printData}>Print Educations</button>
//   </>)
// }
// export default App;


// import { useState } from 'react';
// function App() {
//   const [selectedEducations, setSelectedEducations] = useState([]);
//   const educations = ["B.Tech", "M.Tech", "B.Arch"];
//   const printData = () => {
//     console.log(selectedEducations.join(','));
//   }
//   return (<>
//     Education:
//     <select multiple
//       onChange={(e) => setSelectedEducations([...e.target.selectedOptions].map(option => option.value))}>
//       {educations.map((education) => <option value={education}>{education}</option>)}
//     </select><br />
//     <button onClick={printData}>Print Educations</button>
//   </>)
// }
// export default App;


// import { useState } from 'react';
// function App() {
//   const [selectedEducations, setSelectedEducations] = useState([]);
//   const educations = [{ id: 1, name: 'B.Tech' },
//   { id: 2, name: 'M.Tech' },
//   { id: 3, name: 'PhD' }];
//   const printData = () => {
//     console.log(selectedEducations.join(','));
//   }
//   return (<>
//     Education:
//     <select multiple
//       onChange={(e) => setSelectedEducations([...e.target.selectedOptions].map(option => option.value))}>
//       {educations.map((education) => <option value={education.id}>{education.name}</option>)}
//     </select><br />
//     <button onClick={printData}>Print Educations</button>
//   </>)
// }
// export default App;


// import { useState } from 'react';
// function App() {
//   const [file, setFile] = useState(null);
//   const printData = () => {
//     console.log(file);
//   }
//   return (<>
//     File:
//     <input type="file" onChange={(e) => setFile(e.target.files[0])} />
//     <br />
//     <button onClick={printData}>click</button>
//   </>)
// }
// export default App;


// import { useState } from 'react';
// function App() {
//   const [resume, setResume] = useState(null);
//   const [profilePic, setProfilePic] = useState(null);
//   const printData = () => {
//     console.log(resume, profilePic);
//   }
//   return (<>
//     Resume:
//     <input type="file" onChange={(e) => setResume(e.target.files[0])} />
//     <br />
//     Profile Pic:
//     <input type="file" onChange={(e) => setProfilePic(e.target.files[0])} />
//     <br />
//     <button onClick={printData}>click</button>
//   </>)
// }
// export default App;


// import { useState } from 'react';
// function App() {
//   const [javaFiles, setJavaFiles] = useState(null);
//   const [allPics, setAllPics] = useState(null);
//   const printData = () => {
//     console.log(javaFiles);
//     console.log(allPics);
//   }
//   return (<>
//     SELECT JAVA FILES:
//     <input type="file" multiple onChange={(e) => setJavaFiles(e.target.files)} />
//     <br />
//     ALL PicS:
//     <input type="file" multiple onChange={(e) => setAllPics(e.target.files)} />
//     <br />
//     <button onClick={printData}>click</button>
//   </>)
// }
// export default App;


// import { useState } from 'react';
// function App() {
//   const [firstName, setFirstName] = useState("");
//   const [lastName, setLastName] = useState("");
//   const [age, setAge] = useState(0);
//   const [email, setEmail] = useState("");
//   const [gender, setGender] = useState("");
//   const [education, setEducation] = useState("");
//   const [address, setAddress] = useState("");
//   const [skills, setSkills] = useState("");
//   const [profilePic, setProfilePic] = useState("");
//   //reference data
//   const genders = ["Male", "Female", "Other"];
//   const educations = ["B.Tech", "M.Tech", "B.Sc", "M.Sc", "B.A", "M.A", "B.Com", "M.Com", "BBA", "MBA"];
//   const skillsList = ["Java", "Python", "C++", "C", "C#",
//     "JavaScript", "PHP", "Ruby", "Go", "Swift"];
//   const printData = () => {
//     const person = {
//       firstName, lastName, age, email,
//       gender, education, address, skills, profilePic
//     };
//     console.log(person);
//   }
//   const handleSkills = (e) => {
//     const skill =
//       e.target.value
//     if (e.target.checked) {
//       setSkills([...skills, skill]);
//     } else {
//       setSkills(skills.filter((item) => item !== skill));
//     }
//   }
//   return (<>
//     First Name :
//     <input type="text"
//       value={firstName}
//       onChange={(e) => setFirstName(e.target.value)} /><br />
//     Last Name :
//     <input type="text"
//       value={lastName}
//       onChange={(e) => setLastName(e.target.value)} /><br />Age :
//     <input type="number"
//       value={age}
//       onChange={(e) => setAge(e.target.value)} /><br />
//     Email :
//     <input type="email"
//       value={email}
//       onChange={(e) => setEmail(e.target.value)} /><br />
//     Gender :
//     {genders.map(gen => (<><input type='radio'
//       value={gen}
//       name="gender"
//       onChange={(e) => setGender(e.target.value)} /> {gen} </>))} <br />
//     Education :
//     <select value={education}
//       onChange={(e) => setEducation(e.target.value)}>
//       {educations.map(edu => (<option value={edu}>{edu}</option>))}
//     </select><br />
//     Address :
//     <textarea value={address}
//       onChange={(e) => setAddress(e.target.value)} /><br />
//     Skills :
//     {skillsList.map(skill => (<><input type='checkbox' value={skill} onChange={handleSkills} />{skill}</>))} <br />
//     Profile Pic :
//     <input type="file" onChange={(e) => setProfilePic(e.target.value)} /><br />
//     <button onClick={printData}>click</button>
//   </>)
// }
// export default App;


// import { useState } from 'react';
// function App() {
//   const [firstName, setFirstName] = useState("");
//   const [firstNameError, setFirstNameError] = useState("");
//   const printData = () => {
//     if (!firstName) {
//       setFirstNameError("First Name is required");
//     }
//     else {
//       setFirstNameError
//         ("");
//     }
//     console.log(firstName);
//   }
//   return (<>
//     First Name :
//     <input type="text"
//       value={firstName}
//       onChange={(e) => setFirstName(e.target.value)} />
//     {firstNameError && <span style={{ color: "red" }}>{firstNameError}</span>}
//     <br />
//     <button onClick={printData}>click</button>
//   </>)
// }
// export default App;

// import { useState } from 'react';
// function App() {
//   const [password, setPassword] = useState("");
//   const [passwordError, setPasswordError] = useState("");
//   const printData = () => {
//     if (!password) {
//       setPasswordError("Password is required");
//     }
//     else {
//       setPasswordError(
//         "");
//     }
//     console.log(password);
//   }
//   return (<>
//     Password :
//     <input type="password"
//       value={password}
//       onChange={(e) => setPassword(e.target.value)} />
//     {passwordError && <span style={{ color: "red" }}>{passwordError}</span>}
//     <br />
//     <button onClick={printData}>click</button>
//   </>)
// }
// export default App;


// import { useState } from 'react';
// function App() {
//   const [address, setAddress] = useState("");
//   const [addressError, setAddressError] = useState("");
//   const validateAndSubmit = () => {
//     if (!address) {
//       setAddressError("Address is required");
//     }
//     else {
//       setAddressError("");
// }
//     console.log(address);
//   }
//   return (<>
//     Address: <textarea value={address} onChange={(e) => setAddress(e.target.value)}></textarea>
//     {addressError && <span style={{ color: "red" }}>{addressError}</span>} <br />
//     <button onClick={validateAndSubmit}>Submit</button>
//   </>)
// }
// export default App;

// import { useState } from 'react';
// function App() {
//   const [doj, setDoj] = useState("");
//   const [dojError, setDojError] = useState("");
//   const validateAndSubmit = () => {
//     if (!doj) {
//       setDojError("DOJ is required");
//     }
//     else {
//       setDojError("");
// }
//     console.log(doj);
//   }
//   return (<>
//     DOJ: <input type="date" value={doj} onChange={(e) => setDoj(e.target.value)} />
//     {dojError && <span style={{ color: "red" }}>{dojError}</span>} <br />
//     <button onClick={validateAndSubmit}>Submit</button>
//   </>)
// }
// export default App;

// import { useState } from 'react';
// function App() {
//   const [dob, setDob] = useState("");
//   const [dobError, setDobError] = useState("");
//   const validateAndSubmit = () => {
//     if (!dob) {
//       setDobError("DOB is required");
//     }
//     else {
//       setDobError("");
//     }
//     console.log(dob);
//   }
//   return (<>
//     DOB: <input type="datetime-local" value={dob} onChange={(e) => setDob(e.target.value)} />
//     {dobError && <span style={{ color: "red" }}>{dobError}</span>} <br />
//     <button onClick={validateAndSubmit}>Submit</button>
//   </>)
// }
// export default App;

// import { useState } from 'react';
// function App() {
//   const [email, setEmail] = useState("");
//   const [emailError, setEmailError] = useState("");
//   const validateAndSubmit = () => {
//     if (!email) {
//       setEmailError("Email is required");
//     }
//     else {
//       setEmailError
//         ("");
//     }
//     console.log(email);
//   }
//   return (<>
//     Email: <input type="email" value={email} onChange={(e) => setEmail(e.target.value)} />
//     {emailError && <span style={{ color: "red" }}>{emailError}</span>} <br />
//     <button onClick={validateAndSubmit}>Submit</button>
//   </>)
// }
// export default App;


// import { useState } from 'react';
// function App() {
//   const [email, setEmail] = useState("");
//   const [emailError, setEmailError] = useState("");
//   const validateAndSubmit = () => {
//     if (!email) {
//       setEmailError("Email is required");
//       return;
//     }
//     else {
//       setEmailError
//         ("");
//     }
//     //email basic validation with a regex
//     if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email)) {
//       setEmailError("Email is not valid");
//     }
//     else {
//       setEmailError
//         ("");
//     }
//     console.log(email);
//   }
//   return (<>
//     Email: <input type="email" value={email} onChange={(e) => setEmail(e.target.value)} />
//     {emailError && <span style={{ color: "red" }}>{emailError}</span>} <br />
//     <button onClick={validateAndSubmit}>Submit</button>
//   </>)
// }
// export default App;

// import { useState } from 'react';
// function App() {
//   const [gender, setGender] = useState("");
//   const [genderError, setGenderError] = useState("");
//   const validateAndSubmit = () => {
//     if (!gender) {
//       setGenderError("Gender is required");
//     }
//     else {
//       setGenderError("");
//     }
//     console.log(gender);
//   }
//   return (<>
//     Gender: <input type="radio" value='male' name='gender' onChange={(e) => setGender(e.target.value)} />Male &nbsp;
//     <input type='radio' value='female' name='gender' onChange={(e) => setGender(e.target.value)} />Female &nbsp;
//     {genderError && <span style={{ color: "red" }}>{genderError}</span>} <br />
//     <button onClick={validateAndSubmit}>Submit</button>
//   </>)
// }
// export default App;

// import { useState } from 'react';
// function App() {
//   const [selectedSkills, setSelectedSkills] = useState([]);
//   const [skillsError, setSkillsError] = useState("");
//   const handleSkills = (e) => {
//     if (e.target.checked) {
//       setSelectedSkills([...selectedSkills, e.target.value]);
//     }
//     else {
//       setSelectedSkills(selectedSkills.filter(skill => skill !== e.target.value));
//     }
//   }
//   const validateAndSubmit = () => {
//     if (selectedSkills.length === 0) {
//       setSkillsError("Skills are required. select at least one");
//     }
//     else {
//       setSkillsError(
//         "");
//     }
//     console.log(selectedSkills);
//   }
//   return (<>
//     Skill:
//     <input type='checkbox' value='java' name='skills' onChange={handleSkills} />Java &nbsp;
//     <input type='checkbox' value='python' name='skills' onChange={handleSkills} />Python &nbsp;
//     <input type='checkbox' value='react' name='skills' onChange={handleSkills} />React &nbsp;
//     {skillsError && <span style={{ color: "red" }}>{skillsError}</span>} <br />
//     <button onClick={validateAndSubmit}>Submit</button>
//   </>)
// }
// export default App;

// import { useState } from 'react';
// function App() {
//   const [education, setEducation] = useState("");
//   const [educationError, setEducationError] = useState("");
//   const validateAndSubmit = () => {
//     if (!education) {
//       setEducationError("Education is required");
//     }
//     else {
//       setEducationError("");
//     }
//     console.log(education);
//   }
//   return (<>
//     Education:
//     <select value={education} onChange={(e) => setEducation(e.target.value)}>
//       <option value="">Select</option>
//       <option value="SSC">SSC</option>
//       <option value="HSC">HSC</option>
//       <option value="UG">UG</option>
//       <option value="PG">PG</option>
//     </select>
//     {educationError && <span style={{ color: "red" }}>{educationError}</span>} <br />
//     <button onClick={validateAndSubmit}>Submit</button>
//   </>)
// }
// export default App;

// import { useState } from 'react';
// function App() {
//   const [selectedEducations, setSelectedEducations] = useState([]);
//   const [educationError, setEducationError] = useState("");
//   const validateAndSubmit = () => {
//     if (selectedEducations.length ===
//       0) {
//         setEducationError("Education is required");
//     }
//     else {
//       setEducationError(
//         "");
//     }
//     console.log(selectedEducations);
//   }
//   return (<>
//     Education:
//     <select multiple onChange={(e) => setSelectedEducations([...e.target.selectedOptions].map(option => option.value))}>
//       <option value="">Select</option>
//       <option value="SSC">SSC</option>
//       <option value="HSC">HSC</option>
//       <option value="UG">UG</option>
//       <option value="PG">PG</option>
//     </select>
//     {educationError && <span style={{ color: "red" }}>{educationError}</span>} <br />
//     <button onClick={validateAndSubmit}>Submit</button>
//   </>)
// }
// export default App;


// import { useState } from 'react';
// function App() {
//   const [resume, setResume] = useState("");
//   const [resumeError, setResumeError] = useState("");
//   const validateAndSubmit = () => {
//     if (!resume) {
//       setResumeError("Resume is required");
//     }
//     else {
//       setResumeError("");
// }
//     console.log(resume);
//   }
//   return (<>
//     Resume:
//     <input type='file' onChange={(e) => setResume(e.target.files[0])} />
//     {resumeError && <span style={{ color: "red" }}>{resumeError}</span>} <br />
//     <button onClick={validateAndSubmit}>Submit</button>
//   </>)
// }
// export default App;


// import { useState } from 'react';
// function App() {
//   const [pics, setPics] = useState([]);
//   const [picsError, setPicsError] = useState("");
//   const validateAndSubmit = () => {
//     if (pics.length === 0) {
//       setPicsError("Select pics");
//     }
//     else {
//       setPicsError("");
//     }
//     console.log(pics);
//   }
//   return (<>
//     Resume:
//     <input type='file' multiple onChange={(e) => setPics(e.target.files)} />
//     {picsError && <span style={{ color: "red" }}>{picsError}</span>} <br />
//     <button onClick={validateAndSubmit}>Submit</button>
//   </>)
// }
// export default App;

// import { useState } from 'react';
// function App() {
//   const [firstName, setFirstName] = useState("");
//   const [username, setUsername] = useState("");
//   const [password, setPassword] = useState("");
//   const [firstNameError, setFirstNameError] = useState("");
//   const [usernameError, setUsernameError] = useState("");
//   const [passwordError, setPasswordError] = useState("");
//   const validateAndSubmit = () => {
//     if (firstName === "") {
//       setFirstNameError("First Name is required");
//     }
//     else {
//       setFirstNameError("")
//       ;
//     } if (username ===
//       "") {
//         setUsernameError("Username is required");
//     }
//     else {
//       setUsernameError("")
//       ;
//     } if (password ===
//       "") {
//         setPasswordError("Password is required");
//     }
//     else {
//       setPasswordError("");
//     } if (firstName !== "" && username !== "" && password !== "") {
//       //submit the form
//       alert("Form Submitted Successfully");
//     }
//   }
//   return (<>
//     First Name:
//     <input type="text"
//       value={firstName}
//       onChange={(e) => setFirstName(e.target.value)} />
//     {firstNameError && <span style={{ color: "red" }}>{firstNameError}</span>} <br />
//     Username:
//     <input type="text"
//       value={username}
//       onChange={(e) => setUsername(e.target.value)} />
//     {usernameError && <span style={{ color: "red" }}>{usernameError}</span>} <br />
//     Password:
//     <input type="password"
//       value={password}
//       onChange={(e) => setPassword(e.target.value)} />
//     {passwordError && <span style={{ color: "red" }}>{passwordError}</span>} <br />
//     <button onClick={validateAndSubmit}>Submit</button>
//   </>)
// }
// export default App;


// import { useRef, useState } from 'react';
// function App() {
//   const [firstName, setFirstName] = useState("");
//   const [username, setUsername] = useState("");
//   const [password, setPassword] = useState("");
//   const [firstNameError, setFirstNameError] = useState("");
//   const [usernameError, setUsernameError] = useState("");
//   const [passwordError, setPasswordError] = useState("");
//   const firstNameRef = useRef();
//   const usernameRef = useRef();
//   const passwordRef = useRef();
//   const validateAndSubmit = () => {
//     if (firstName === "") {
//       setFirstNameError("First Name is required");
//     }
//     else {
//       setFirstNameError("")
//       ;
//     } 
//     if (username ===
//       "") {
//         setUsernameError("Username is required");
//     }
//     else {
//       setUsernameError("")
//       ;
//     } 
//     if (password ==="") {
//         setPasswordError("Password is required");
//     }
//     else {
//       setPasswordError("");
//     } 
//     if (firstName ==="") {
//         firstNameRef.current.focus();
//     }
//     else if (username ==="") {
//         usernameRef.current.focus();
//     }
//     else if (password ==="") {
//         passwordRef.current.focus();
//     } 

//     if (firstName !== "" && username !== "" && password !== "") {
//       //submit the form
//       alert("Form Submitted Successfully");
//     }
//   }
//   return (<>
//     First Name:
//     <input type="text"
//       value={firstName}
//       onChange={(e) => setFirstName(e.target.value)}
//       ref={firstNameRef} />
//     {firstNameError && <span style={{ color: "red" }}>{firstNameError}</span>} <br />
//     Username:
//     <input type="text"
//       value={username}
//       onChange={(e) => setUsername(e.target.value)}
//       ref={usernameRef} />
//     {usernameError && <span style={{ color: "red" }}>{usernameError}</span>} <br />
//     Password:
//     <input type="password"
//       value={password}
//       ref={passwordRef}
//       onChange={(e) => setPassword(e.target.value)} />
//     {passwordError && <span style={{ color: "red" }}>{passwordError}</span>} <br />
//     <button onClick={validateAndSubmit}>Submit</button>
//   </>)
// }
// export default App;



// import { useRef, useState } from 'react';
// function App() {
//   const [firstName, setFirstName] = useState("");
//   const [username, setUsername] = useState("");
//   const [password, setPassword] = useState("");
//   const [errors, setErrors] = useState({});
//   const firstNameRef = useRef();
//   const usernameRef = useRef();
//   const passwordRef = useRef();
//   const validateAndSubmit = ()=> {
//       let localErrors = {};
//     if (firstName === "") {
//       localErrors = { ...localErrors, firstNameError: "First Name is required" };
//     }
//     else {
//       localErrors = { ...localErrors, firstNameError: "" }
//     } 
//     if (username === "") {
//       localErrors = { ...localErrors, usernameError: "Username is required" }
//     }
//     else {
//       localErrors = { ...localErrors, usernameError: "" }
//     } 
//     if (password === "") {
//       localErrors = { ...localErrors, passwordError: "Password is required" }
//     }
//     else {
//       localErrors = { ...localErrors, passwordError: "" }
//     }
//     setErrors(localErrors);
//     if (firstName ==="") {
//         firstNameRef.current.focus()
//         ;
//     }
//     else if (username ==="") {
//         usernameRef.current.focus();
//     }
//     else if (password ==="") {
//         passwordRef.current.focus();
//     } 

//     if (firstName !== "" && username !== "" && password !== "") {
//       //submit the form
//       alert("Form Submitted Successfully");
//     }
//   }
//   return (<>
//     First Name:
//     <input type="text"
//       value={firstName}
//       onChange={(e) => setFirstName(e.target.value)}
//       ref={firstNameRef} />
//     {errors.firstNameError && <span style={{ color: "red" }}>{errors.firstNameError}</span>} <br />
//     Username:
//     <input type="text"
//       value={username}
//       onChange={(e) => setUsername(e.target.value)}
//       ref={usernameRef} />
//     {errors.usernameError && <span style={{ color: "red" }}>{errors.usernameError}</span>} <br />
//     Password:
//     <input type="password"
//       value={password}
//       ref={passwordRef}
//       onChange={(e) => setPassword(e.target.value)} />
//     {errors.passwordError && <span style={{ color: "red" }}>{errors.passwordError}</span>} <br />
//     <button onClick={validateAndSubmit}>Submit</button>
//   </>)
// }
// export default App;


// import { useState, useRef } from 'react';
// function App() {
//   const [firstName, setFirstName] = useState("");
//   const [lastName, setLastName] = useState("");
//   const firstNameRef = useRef();
//   const lastNameRef = useRef();
//   const [errors, setErrors] = useState({});
//   const validateAndSubmit = ()=> {
//       const localErrors = {};
//     if (firstName === "") {
//       localErrors.firstNameError = "First Name is required";
//     }
//     else {
//       localErrors.firstNameError = "";
//     }
//     if (lastName === "") {
//       localErrors.lastNameError = "Last Name is required";
//     }
//     else {
//       localErrors.lastNameError = "";
//     }
//     setErrors(localErrors);
//     if (firstName ===
//       '') {
//         firstNameRef.current.focus();
//     }
//     else if (lastName ===
//       '') {
//         lastNameRef.current.focus();
//     } if (!localErrors.firstNameError && !
//       localErrors.lastNameError) {
//       //submit the form
//       alert("Form Submitted Successfully");
//     }
//   }
//   return (<>
//     First Name:
//     <input type="text"
//       value={firstName}
//       onChange={(e) => setFirstName(e.target.value)}
//       ref={firstNameRef} />
//     {errors.firstNameError && <span style={{ color: "red" }}>{errors.firstNameError}</span>} <br />
//     Last Name:
//     <input type="text"
//       value={lastName}
//       onChange={(e) => setLastName(e.target.value)}
//       ref={lastNameRef} />
//     {errors.lastNameError && <span style={{ color: "red" }}>{errors.lastNameError}</span>} <br />
//     <button onClick={validateAndSubmit}>Submit</button>
//   </>)
// }
// export default App;


// import { useState } from 'react';
// function App() {
//   const [username, setUsername] = useState("");
//   const [password, setPassword] = useState("");
//   const [errors, setErrors] = useState({});
//   const validateAndSubmit = ()=> {
//       let localErrors = {};
//     if (username === "") {
//       localErrors = { ...localErrors, usernameError: "Username is required" }
//     }
//     else {
//       localErrors = { ...localErrors, usernameError: "" }
//     } if (password === "") {
//       localErrors = { ...localErrors, passwordError: "Password is required" }
//     }
//     else {
//       localErrors = { ...localErrors, passwordError: "" }
//     }
//     setErrors(localErrors);
//     if (!localErrors.usernameError && !localErrors.passwordError) {
//       //submit the form
//       alert("Form Submitted Successfully");
//     }
//   }
//   return (<>
//     Username:
//     <input type="text"
//       value={username}
//       onChange={(e) => setUsername(e.target.value)} />
//     {errors.usernameError && <span style={{ color: "red" }}>{errors.usernameError}</span>} <br />
//     Password:
//     <input type="password"
//       value={password}
//       onChange={(e) => setPassword(e.target.value)} />
//     {errors.passwordError && <span style={{ color: "red" }}>{errors.passwordError}</span>} <br />
//     <button onClick={validateAndSubmit}>Submit</button>
//   </>)
// }
// export default App;



// 20. Complex signup form with the validation and the focus
import { useState , useRef} from 'react';
function App() {
  const [firstName, setFirstName] = useState("");
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [gender, setGender] = useState("");
  const [education, setEducation] = useState("");
  const [selectedSkills, setSelectedSkills] = useState([]);
  const [errors, setErrors] = useState({});
  const firstNameRef = useRef();
  const usernameRef = useRef();
  const passwordRef = useRef();
  const genderRef = useRef();
  const educationRef = useRef();
  const skillsRef = useRef();
  //reference data
  const genders = ["Male", "Female", "Other"];
  const educations = ["10th", "12th", "Graduate", "Post Graduate"];
  const skills = ["Java", "React", "Angular", "Spring", "Hibernate", "Python", "Javascript", "NodeJS", "Django", "Ruby"];
  const validateAndSubmit = () => {
    let localErrors = {};
    if (firstName === "") {
      localErrors = { ...localErrors, firstNameError: "First Name is required" };
    }
    else {
      localErrors = { ...localErrors, firstNameError: "" }
    } if (username === "") {
      localErrors = { ...localErrors, usernameError: "Username is required" }
    }
    else {
      localErrors = { ...localErrors, usernameError: "" }
    } if (password === "") {
      localErrors = { ...localErrors, passwordError: "Password is required" }
    }
    else {
      localErrors = { ...localErrors, passwordError: "" }
    } if (gender === "") {
      localErrors = { ...localErrors, genderError: "Gender is required" }
    }
    else {
      localErrors = { ...localErrors, genderError: "" }
    } if (education === "") {
      localErrors = { ...localErrors, educationError: "Education is required" }
    }
    else {
      localErrors = { ...localErrors, educationError: "" }
    } if (selectedSkills.length === 0) {
      localErrors = { ...localErrors, skillsError: "Atleast one skill is required" }
    }
    else {
      localErrors = { ...localErrors, skillsError: "" }
    }
    setErrors(localErrors);
    if (firstName ===
      "") {
        firstNameRef.current.focus()
        ;
    }
    else if (username ===
      "") {
        usernameRef.current.focus();
    }
    else if (password ===
      "") {
        passwordRef.current.focus();
    }
    else if (gender ===
      "") {
        genderRef.current.focus();
    }
    else if (education ===
      "") {
        educationRef.current.focus();
    }
    else if (selectedSkills.length ===
      0) {
        skillsRef.current.focus();
    }
    
    
    // if (!localErrors.firstNameError && !
    //   localErrors.usernameError && !
    //   localErrors.passwordError
    // ) {
    //   //submit the form
    //   alert("Form Submitted Successfully");
    // }
  }
  return (<>
    First Name:
    <input type="text"
      value={firstName}
      onChange={(e) => setFirstName(e.target.value)}
      ref={firstNameRef} />
    {errors.firstNameError && <span style={{ color: "red" }}>{errors.firstNameError}</span>} <br />
    Username:
    <input type="text"
      value={username}
      onChange={(e) => setUsername(e.target.value)}
      ref={usernameRef} />
    {errors.usernameError && <span style={{ color: "red" }}>{errors.usernameError}</span>} <br />
    Password:
    <input type="password"
      value={password}
      ref={passwordRef}
      onChange={(e) => setPassword(e.target.value)} />
    {errors.passwordError && <span style={{ color: "red" }}>{errors.passwordError}</span>} <br />
    Gender:
    {genders.map(gen => (<><input key={gen}
      type='radio'
      value={gen}
      onChange={e => setGender(e.target.value)}
      name="gender"
      ref={genderRef} />{gen} &nbsp;&nbsp;</>))}
    {errors.genderError && <span style={{ color: "red" }}>{errors.genderError}</span>} <br />
    Education:
    <select value={education}
      onChange={(e) => setEducation(e.target.value)}
      ref={educationRef}>
      <option value="">Select</option>
      {educations.map(edu => (<option key={edu} value={edu}>{edu}</option>))}
    </select>
    {errors.educationError && <span style={{ color: "red" }}>{errors.educationError}</span>} <br />
    Skills:
    {skills.map(skill => (<><input type='checkbox'
      id={skill}
      value={skill}
      ref={skillsRef}
      onChange={e => {
        if (e.target.checked) {
          setSelectedSkills([...selectedSkills, e.target.value])
        }
        else {
          setSelectedSkills(selectedSkills.filter(s => s !== e.target.value))
        }
      }} />{skill} &nbsp;&nbsp;</>
    ))}
    {errors.skillsError && <span style={{ color: "red" }}>{errors.skillsError}</span>} <br />
    <br />
    <button onClick={validateAndSubmit}>Submit</button>
  </>)
}
export default App;