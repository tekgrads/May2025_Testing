export default function Test9() {
    const test = () => {
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
        p1.then((res) => {
            console.log("P1 then:",
                res);
        });
        p2.then((res) => {
            console.log("P2 then:",
                res);
        });
        console.log("End");
    }
    return (
        <>
            <button type="button" onClick={test}>test</button>
        </>
    );
}