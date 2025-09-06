export default function Test2() {
    const test = () => {
        // Synchronous
        console.log("Start");
        // Synchronous
        const promise = new Promise((resolve, reject) => {
            console.log("Promise executor");
            // Macrotask
            setTimeout(() => {
                console.log("setTimeOut from Promise");
            }, 0
            )
            resolve("Resolved");
        });
        // Microtask
        promise.then((value) => {
            console.log("Promise then: " + value);
        });
        // Macrotask
        setTimeout(() => {
            console.log("setTimeout");
        }, 0);
        // Synchronous
        console.log("End");
    }
    return (
        <>
            <button type="button" onClick={test}>test</button>
        </>
    );
}