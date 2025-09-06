export default function Test4() {
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
        console.log('test3 begin:' + arg1); 
        var results = 200;
        f1(results);
        console.log('test3 end');
    }
    const test4 = (f1, arg) => {
        console.log('test4 begin: ' +arg); 
        var results = 300;
        f1(results);
        console.log('test4 end');
    }
    const test5 = () => {
        test2(test1, 100);
        console.log('--------------- ')
        test3((a) => test2(test1, a + 100), 200);
        console.log('--------------- ');
        test4((a) => { test3((b) => test2(test1, a + b + 100), a + 200) }, 300);
    }
    return (
        <>
            <button type="button" onClick={test5}>test</button>
        </>
    );
}