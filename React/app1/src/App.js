import './App.css';
// function App() {
// // const test1 = () => {
// // var a = 5;
// // console.log(a);
// // a = 40;
// // console.log(a);
// // a = 50;
// // console.log(a);
// // a = "abc";
// // console.log(a);
// // a = true;
// // console.log(a);
// // a = 56.6;
// // console.log(a);
// // a = 'abc hello xyz';
// // console.log(a);
// // }

// // const test2 = () => {
// // for(var i = 1; i <= 10; i++){
// // console.log("loop body:" + i);
// // }
// // }

// const test3 = () => {
// if(true){
// var a1 = 5;
// console.log("inside if:" + a1);
// }
// console.log("outside if block:" + a1);
// }

// console.log(a1);


// const test3_let = () => {
// if(true){
// let a = 5;
// console.log("inside if:" + a);
// }
// console.log("outside if block:" + a);
// }

// // const test4 = () => {
// // console.log(a);
// // }
// const test5 = () =>
// { var a = 5;
// console.log(a);
// a = 40;
// console.log(a);
// var a = 400;
// console.log(a);
// a = "abc";
// console.log(a);
// var a = 'hello';
// console.log(a);
// }

// return (
// <>
// {/* <button onClick={test1}>Test 1</button> */}
// {/* <button onClick={test2}>Test 2</button> */}
// <button onClick={test3_let}>Test 3</button>
// {/* <button onClick={test4}>Test 4</button> */}
// {/* <button onClick={test5}>Test 5</button> */}
// </>
// );
// }
// export default App


////////////////////////////////////////////////////////




// function App() {

// const test1 = () =>
// { 
//     alert("test1")
// }

// const test2 = (e) =>
// { 
//     e.stopPropagation();
//      alert("test2");
// }

// return (
// <div onClick={test1}>

//     <h1 onClick={test2}>React App</h1>
// </div>
// );
// }
// export default App;


/////////////////////////////////////////////////////////



// function App() {

//     function test1() {
//         console.log("test1"); 
//         alert('i am from test1'); 
//         console.log(test2());
//     }

//     function test2() {
//         console.log("test 2"); 
//         alert('i am from test2'); 
//         test3(); 
//         console.log('	');
//         test3(20000); 
//         console.log('	');
//         test3(20000, 30000);
//         console.log('	');
//         test3(20000, 30000, 40000);
//         return 1000;
//     }
//     function test3(a1, arg2, p1) {
//         console.log("test3"); 
//         alert('i am from test3');
//         console.log(a1, arg2, p1); 
//         return 1000;
//     }
//     return (
//         <button type='button' onClick={test1}>Click me</button>
//     );
// }
// export default App;


////////////////////////////////////////////////


// function App() {
// const test1 = function(){ 
//     console.log("test1"); alert('i am from test1'); 
//     console.log(test2());
// }
// const test2 = function (){ 
//     console.log("test2"); alert('i am from test2'); test3();
// console.log('	');
// test3(20000); console.log('	');
// test3(20000, 30000);
// console.log('	');
// test3(20000, 30000, 40000);
// return 1000;
// }
// const test3 = function (a1, arg2, p1){ 
//     console.log("test3"); 
//     alert('i am from test3'); 
//     console.log(a1, arg2, p1); 
//     return 1000;
// }

// return (
// <button type='button' onClick={test1}>Click me</button>
// );
// }
// export default App;


///////////////////////////////////////////////////////


// function App() {

//     const test1 = () => {
//         console.log("test1"); 
//         alert('i am from test1');
//          console.log(test2());
//     }
//     const test2 = () => {
//         console.log("test2"); alert('i am from test2'); test3();
//         console.log('	');
//         test3(20000); console.log('	');
//         test3(20000, 30000);
//         console.log('	');
//         test3(20000, 30000, 40000);
//         return 1000;
//     }
//     const test3 = (a1, arg2, p1) => {
//         console.log("test3"); alert('i am from test3'); console.log(a1, arg2, p1); return 1000;
//     }
//     return (
//         <button type='button' onClick={test1}>Click me</button>
//     );
// }
// export default App;



