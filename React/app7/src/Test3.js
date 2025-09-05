// export default function Test3() {
//     const test1 = () => {
//         console.log('from test1');
//     }
//     const test2 = (f1) => {
//         console.log('test2 begin');
//         f1();
//         console.log('test2 middle');
//         f1();
//         console.log('test2 end');
//     }
//     const test3 = () => {
//         test2(test1);
//     }
//     return (
//         <>
//             <button type="button" onClick={test3}>test</button>
//         </>
//     );
// }


// export default function Test2() {
//     const test1 = () => {
//         console.log('from test1');
//     }
//     const test2 = (f1) => {
//         console.log('test2 begin');
//         f1();
//         console.log('test2 end');
//     }
//     const test3 = (f1) => {
//         console.log('test3begin');
//         f1();
//         console.log('test3 end');
//     }
//     const test4 = () => {
//         //test3(test2(test1));
//           test3(() => {
//             console.log('inside arraow function');
//             test2(test1);
//               console.log('end of  arraow function');
//         });

//     }
//     return (
//         <>
//             <button type="button" onClick={test4}>test</button>
//         </>
//     );
// }
// //the above code gives an error
// // We should modify test4 method like the bello
// // const test4 = () => {
// //     test3(() => test2(test1));
// // }


// export default function Test2() {
//     const test1 = () => {
//         console.log('from test1');
//     }
//     const test2 = (f1) => {
//         console.log('test2 begin');
//         f1();
//         console.log('test2 end');
//     }
//     const test3 = (f1) => {
//         console.log('test3 begin');
//         f1();
//         console.log('test3 end');
//     }
//     const test4 = (f1) => {
//         console.log('test4 begin');
//         f1();
//         console.log('test4 end');
//     }
//     const test5 = () => {
//         //test2(test1);
//         // console.log('--------------- ')
//         // test3(() => {
//         //     console.log('inside arrow function for test3');
//         //     test2(test1)
//         //     console.log('end of arrow function for test3');
//         // });
//         // console.log('--------------- ');
//         // test4(() => {
//         //     console.log('inside arrow function for test4');
//         //     test3(() => {
//         //         console.log('inside arrow function for test3');
//         //         test2(test1)
//         //         console.log('end of arrow function for test3');

//         //     });
//         //     console.log('end of arrow function for test4');
//         // });
//     }
//     return (
//         <>
//             <button type="button" onClick={test5}>test</button>
//         </>
//     );
// }


// export default function Test2() {
//     const test1 = (arg1) => {
//         console.log('from test1:' + arg1);
//     }
//     const test2 = (f1) => {
//         console.log('test2begin');
//         var results = 100;
//         f1(results);
//         console.log('test2 end');
//     }
//     const test3 = () => {
//         test2(test1);
//     }
//     return (
//         <>
//             <button type="button" onClick={test3}>test</button>
//         </>
//     );
// }


export default function Test2() {
    const test1 = (arg1) => {
        console.log('from test1:' + arg1);
    }
    const test2 = (f1, arg1) => {
        console.log('test2 begin: ' +arg1); 
        var results = 100;
        f1(results);
        console.log('test2 end');
    }
    const test3 = (f1, arg1) => {
        console.log('test3 begin:' +
            arg1); var results = 200;
        f1(results);
        console.log('test3 end');
    }
    const test4 = () => {
        test2(test1, 100);
        console.log('---------- ');
        test2((arg1) => test1(arg1), 100);
        console.log('---------- ');
        test3((arg1) => test2(test1, arg1), 300);
    }
    return (
        <>
            <button type="button" onClick={test4}>test</button>
        </>
    );
}