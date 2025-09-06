export default function Test7() {
    const test = () => {
        // Synchronous
        console.log("Start");
        // Synchronous
        const promise = new Promise((resolve, reject) => {
            console.log("Promise executor");
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