export default function Test1() {
    const callToApi = () => {
        fetch('http://localhost:9090/test/t3')
           // .then(() => console.log('ok'))
            .then((response) => response.json())
              .then((response) => console.log(response))
            .catch(() => console.log('error'))
    }
    return (<>
        <button onClick={callToApi} type='button'>Call to API 123</button>
    </>)
}