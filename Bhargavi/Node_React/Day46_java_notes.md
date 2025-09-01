Day 46
# React Continuation:

```html
Filename: dom_testing/index.html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Basic DOM Features Demo</title>
  <style>
    body { font-family: Arial, sans-serif; padding: 20px; }
    #myDiv { padding: 10px; border: 1px solid #333; margin-top: 10px; }
    .highlight { background-color: yellow; }
  </style>
</head>
<body>
  <h1 id="title">Hello DOM</h1>

  <button onclick="changeText()">Change Title Text</button>
  <button onclick="toggleHighlight()">Toggle Highlight</button>
  <button onclick="addParagraph()">Add Paragraph</button>
  <button onclick="removeParagraph()">Remove Paragraph</button>

  <div id="myDiv">
    <p id="para1">This is a paragraph inside a div.</p>
  </div>

  <script>
    // Change text content
    function changeText() {
      document.getElementById("title").textContent = "DOM Manipulation in Action!";
    }

    // Toggle CSS class
    function toggleHighlight() {
      document.getElementById("myDiv").classList.toggle("highlight");
    }

    // Add new element
    function addParagraph() {
      let newPara = document.createElement("p");
      newPara.textContent = "This is a new paragraph.";
      document.getElementById("myDiv").appendChild(newPara);
    }

    // Remove the last paragraph
    function removeParagraph() {
      let div = document.getElementById("myDiv");
      if (div.lastChild && div.lastChild.tagName === "P") {
        div.removeChild(div.lastChild);
      }
    }
  </script>
</body>
</html>
```

```css
Filename: src/App.css
.App {
  text-align: center;
}

.App-logo {
  height: 40vmin;
  pointer-events: none;
}

@media (prefers-reduced-motion: no-preference) {
  .App-logo {
    animation: App-logo-spin infinite 20s linear;
  }
}

.App-header {
  background-color: #282c34;
  min-height: 100vh;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  font-size: calc(10px + 2vmin);
  color: white;
}

.App-link {
  color: #61dafb;
}

@keyframes App-logo-spin {
  from {
    transform: rotate(0deg);
  }
  to {
    transform: rotate(360deg);
  }
}
```

```javascript
Filename: src/App.js
import './App.css';

function App() {
  const test3 = () => {
    if(true){
      var a1 = 5;
      console.log("inside if:" + a1);
    }
    console.log("outside if block:" + a1);
  }

  const test3_let = () => {
    if(true){
      let a = 5;
      console.log("inside if:" + a);
    }
    console.log("outside if block:" + a);
  }

  const test5 = () => {
    var a = 5;
    console.log(a);
    a = 40;
    console.log(a);
    var a = 400;
    console.log(a);
    a = "abc";
    console.log(a);
    var a = 'hello';
    console.log(a);
  }

  return (
    <>
      <button onClick={test3_let}>Test 3</button>
    </>
  );
}
export default App;
```

```javascript
Filename: src/App.test.js
import { render, screen } from '@testing-library/react';
import App from './App';

test('renders learn react link', () => {
  render(<App />);
  const linkElement = screen.getByText(/learn react/i);
  expect(linkElement).toBeInTheDocument();
});
```

```javascript
Filename: src/App2.js
import './App.css';

function App2() {
  const test1 = () => {
    let a = 10;
    console.log(a);
    a = 20;
    console.log(a);
    a = 'abc';
    console.log(a);
    a = true;
    console.log(a);
    a = 56.4;
    console.log(a);
  }

  const test2 = () => {
    for(let i = 0; i < 10; i++) {
      console.log(i);
    }
    console.log(i);
  }

  return (
    <>
      <button onClick={test2}>Click me</button>
    </>
  );
}
export default App2;
```

```javascript
Filename: src/App3.js
import './App.css';

function App3() {
  const test1 = () => {
    const i = 10;
    console.log(i);
    i = 10;
    console.log(i);
  }

  const test2 = () => {
    if(true) {
      const i = 10;
      console.log(i);
    }
    console.log(i);
  }

  const test3 = () => {
    const i = 10;
    console.log(i);
    const i2 = 10;
    console.log(i2);
  }

  return (
    <>
      <button onClick={test2}>Test</button>
    </>
  );
}
export default App3;
```

```css
Filename: src/index.css
body {
  margin: 0;
  font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', 'Roboto', 'Oxygen',
    'Ubuntu', 'Cantarell', 'Fira Sans', 'Droid Sans', 'Helvetica Neue',
    sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}

code {
  font-family: source-code-pro, Menlo, Monaco, Consolas, 'Courier New',
    monospace;
}
```

```javascript
Filename: src/index.js
import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import App2 from './App2';
import App3 from './App3';
import reportWebVitals from './reportWebVitals';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
     <App3 />
  </React.StrictMode>
);

reportWebVitals();
```

```javascript
Filename: src/reportWebVitals.js
const reportWebVitals = onPerfEntry => {
  if (onPerfEntry && onPerfEntry instanceof Function) {
    import('web-vitals').then(({ getCLS, getFID, getFCP, getLCP, getTTFB }) => {
      getCLS(onPerfEntry);
      getFID(onPerfEntry);
      getFCP(onPerfEntry);
      getLCP(onPerfEntry);
      getTTFB(onPerfEntry);
    });
  }
};
export default reportWebVitals;
```




