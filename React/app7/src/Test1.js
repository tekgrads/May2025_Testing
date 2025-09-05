export default function Test1() {
    const test = () => {
        console.log(1);
        console.log('before loop');
        for (var i = 1; i <= 9999999999; i++) {
        }
        console.log('after loop', i)
        console.log(2);
        console.log(3);
        console.log(4);
        console.log(5);
    }
    return (
        <>
            <button type="button" onClick={test}>test</button>
        </>
    );
}