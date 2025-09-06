export default function Test2() {
    const test =  async () => {
        console.log("Start");
        const p1 = new Promise((resolve) => {
            console.log("P1 executor");
            setTimeout(() => {
                console.log("P1 setTimeout");
                resolve("P1 done");
            }, 0);
        });
        const p2 = new Promise((resolve) => {
            console.log("P2 executor");
            setTimeout(() => {
                console.log("P2 setTimeout");
                resolve("P2 done");
            }, 0);
        });
        const p3 = new Promise((resolve) => {
            console.log("P3 executor");
            setTimeout(() => {
                console.log("P3 setTimeout");
                resolve("P3 done");
            }, 0);
        });
       await  p1.then((res) => {
            console.log("P1 then:",
                res);
        });
        console.log("middle");
        p2.then((res) => {
            console.log("P2 then:", res);
        });
        console.log("End");
        p3.then((res) => {
            console.log("P3 then:",
                res);
        });
    }
    return (
        <>
            <button type="button" onClick={test}>test</button>
        </>
    );
}