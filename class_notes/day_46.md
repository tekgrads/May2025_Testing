Filename: dom_testing/App.css .App { text-align: center; }

.App-logo { height: 40vmin; pointer-events: none; }

@media (prefers-reduced-motion: no-preference) { .App-logo { animation:
App-logo-spin infinite 20s linear; } }

.App-header { background-color: #282c34; min-height: 100vh; display:
flex; flex-direction: column; align-items: center; justify-content:
center; font-size: calc(10px + 2vmin); color: white; }

.App-link { color: #61dafb; }

@keyframes App-logo-spin { from { transform: rotate(0deg); } to {
transform: rotate(360deg); } } Filename: dom_testing/App.js import {
useState } from "react";

export default function App() { const \[count, setCount\] = useState(0);

return ( \<div style={{ textAlign: "center", marginTop: "50px" }}\>
```{=html}
<h1>
```
Counter App
```{=html}
</h1>
```
      <p data-testid="count-value">Count: {count}</p>
      <button onClick={() => setCount(count + 1)}>Increment</button>
    </div>

); } Filename: dom_testing/App.test.js import { render, screen,
fireEvent } from "@testing-library/react"; import App from "./App";

test("increments counter when button is clicked", () =\> {
render(`<App />`{=html});

const button = screen.getByText("Increment"); const countValue =
screen.getByTestId("count-value");

// Initially count should be 0
expect(countValue.textContent).toBe("Count: 0");

// Click button fireEvent.click(button);

// Count should be 1 now expect(countValue.textContent).toBe("Count:
1"); });

Filename: dom_testing/index.css body { margin: 0; font-family:
-apple-system, BlinkMacSystemFont, 'Segoe UI', 'Roboto', 'Oxygen',
'Ubuntu', 'Cantarell', 'Fira Sans', 'Droid Sans', 'Helvetica Neue',
sans-serif; -webkit-font-smoothing: antialiased;
-moz-osx-font-smoothing: grayscale; }

code { font-family: source-code-pro, Menlo, Monaco, Consolas, 'Courier
New', monospace; }

Filename: dom_testing/index.js import React from 'react'; import
ReactDOM from 'react-dom/client'; import './index.css'; import App from
'./App'; import reportWebVitals from './reportWebVitals';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render( \<React.StrictMode\> `<App />`{=html} \</React.StrictMode\>
);

// If you want to start measuring performance in your app, pass a
function // to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more:
https://bit.ly/CRA-vitals reportWebVitals();

Filename: dom_testing/reportWebVitals

const reportWebVitals = onPerfEntry =\> { if (onPerfEntry && onPerfEntry
instanceof Function) { import('web-vitals').then(({ getCLS, getFID,
getFCP, getLCP, getTTFB }) =\> { getCLS(onPerfEntry);
getFID(onPerfEntry); getFCP(onPerfEntry); getLCP(onPerfEntry);
getTTFB(onPerfEntry); }); } };

Filename: setup Test.js

export default reportWebVitals;

// jest-dom adds custom jest matchers for asserting on DOM nodes. //
allows you to do things like: //
expect(element).toHaveTextContent(/react/i) // learn more:
https://github.com/testing-library/jest-dom import
'@testing-library/jest-dom';
