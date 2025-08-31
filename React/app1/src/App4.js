import './App.css'; function App4() {
const array1 = [10, 20, 30];
const array2 = [1.0, 2.5, 3.70];
const array3 = ["abc", 'abc', "hello"];
const array4 = ["abc", 10, 'abc', "hello", 400, true];
return (
<>
Array1 : {array1} <br /> Array2 : {array2} <br /> Array3 : {array3} <br /> Array4 : {array4}   <br />
<hr />
Array1 : {array1.join(',')} <br /> Array2 : {array2.join(',')} <br /> Array3 : {array3.join(',')} <br /> Array4 : {array4.join(',')} <br />
<hr />
Array1 : {array1.join(' - ')} <br /> Array2 : {array2.join(' - ')} <br /> Array3 : {array3.join(' - ')} <br /> Array4 : {array4.join(' - ')} <br />
<hr />
 
</>
);
}
export default App4;
