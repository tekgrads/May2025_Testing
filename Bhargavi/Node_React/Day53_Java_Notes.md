Day 53
# React API:

### Filename: `src/App.js`

```javascript
import logo from './logo.svg';
import './App.css';
import Test1 from './Test1';
import Test2 from './Test2';
import Test3 from './Test3';

function App() {
  return (
    <div className="App">
      <Test3/>
    </div>
  );
}

export default App;
```

### Filename: `src/Test1.js`

```javascript
export default function Test1() {
    const callToApi = () => {
        fetch('http://localhost:9090/test/t1')
           // .then(() => console.log('ok'))
            .then((response) => response.text())
              .then((response) => console.log(response))
            .catch(() => console.log('error'))
    }
    return (<>
        <button onClick={callToApi} type='button'>Call to API 123</button>
    </>)
}
```

### Filename: `src/Test2.js`

```javascript
export default function Test2() {
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
```

### Filename: `src/Test3.js`

```javascript
import { useState } from "react";

export default function Test3() {
    const [msg, setMsg] = useState([]);
    const callToApi = () => {
        fetch('http://localhost:9090/test/t4')
           // .then(() => console.log('ok'))
            .then((response) => response.json())
              .then((response) => {
                console.log(response); 
                setMsg(response)
            })
            .catch(() => console.log('error'))
    }
    return (<>
        <button onClick={callToApi} type='button'>Call to API 123</button>
       <h1>{msg.join(', ')}</h1>
    </>)
}
```