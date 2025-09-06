export default function Test6() {
    const doTask1 = (arg1) => {
        return new Promise((resolve, reject) => {
            //do some logic
            console.log('from doTask1:' + arg1)
            return resolve(arg1 + 200);
           //reject('error in task1');
        })
    }
    const doTask2 = (arg1) => {
        return new Promise((resolve, reject) => {
            //do some logic
            console.log('from doTask2:' + arg1)
            return resolve(arg1 + 200);
        })
    }
    const doTask3 = (arg1) => {
        return new Promise((resolve, reject) => {
            //do some logic
            console.log('from doTask3:' + arg1)
            return resolve(arg1 + 300);
        })
    }
    const test = () => {
        doTask1(10)
        .then(result1 => doTask2(result1))
        .then(result2 => doTask3(result2))
        .then(finalResult => console.log('Final Result:', finalResult))
        .catch(err => console.error(err));
    }
    return (
        <>
            <button type="button" onClick={test}>test</button>
        </>
    );
}