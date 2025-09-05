export default function Test2() {
    const test = () => {
        console.log(1);
        setTimeout(() => {
            console.log('inside setTimeout 1');
            console.log('begin in setTimeout1');
            //time consuming operation
            for (var i = 1; i < 999; i++) {
            }
            console.log('end in setTimeout1');
        }, 10000);
        console.log(2);
        console.log(3);
        console.log(4);
        for(var i = 1; i < 9999999999; i++){
        }
        setTimeout(() => {
            console.log('inside setTimeout 2');
            console.log('begin in setTimeout2');
            //time consuming operation
            for (var i = 1; i < 9999999999; i++) {
            }
            console.log('end in setTimeout2');
        }, 5000);
        console.log(5);
    }
    return (
        <>
            <button type="button" onClick={test}>test</button>
        </>
    );
}