````markdown
# Node JS Notes:

## Node.js Installation
- Download Node.js from the official site (https://nodejs.org).
- Install using the installer with default settings.
- Verify installation by running `node -v` and `npm -v` in terminal.

## VS Code Installation
- Download VS Code from (https://code.visualstudio.com).
- Install with default settings.
- Useful for writing, debugging, and running Node.js/React code.

## What is Node.js and Why it is Created Beyond JavaScript
- Node.js is a runtime environment that allows running JavaScript outside the browser.
- It was created to handle server-side tasks using JavaScript.
- Designed for asynchronous, event-driven programming, making it efficient for I/O operations.
- Enables JavaScript to be used for full-stack development.

## How Node.js is Useful for React to Run
- React needs a development server to run, provided by Node.js.
- Node.js allows use of `npm` or `npx` to install and manage React libraries.
- It compiles JSX and bundles React code for browser execution.

## React Introduction
- React is a JavaScript library for building user interfaces.
- Developed by Facebook to create fast, scalable, and dynamic web apps.
- Uses component-based architecture and virtual DOM.

---

## Example: test.js
```javascript
let i=1;
let j=2;
console.log(i+j);
console.log("hey sathvika ");
````

### Output:

```
D:\React>node test.js
3
hey sathvika
```

---

## Node vs npm

* **Node**: JavaScript runtime environment.
* **npm**: Node Package Manager, used to install/manage packages.

## npm vs npx

* **npm**: Installs packages globally or locally.
* **npx**: Executes a package directly without permanent installation.

---

## npx create-react-app

Command:

```
npx create-react-app app1
```

Execution:

```
Local:            http://localhost:3000
On Your Network:  http://10.115.8.198:3000
```

---

## Major, Minor, and Patch Version in React

* **Major**: Breaking changes.
* **Minor**: New features, backward compatible.
* **Patch**: Bug fixes, backward compatible.

## ^ Carrot Symbol in package.json

* Ensures updates within the same major version.
* Example: `^16.8.0` allows updates up to `<17.0.0`.

## Understanding node\_modules

* Directory where all installed npm packages are stored.
* Contains dependencies and sub-dependencies.

---

## React Dev Server Requests

```
http://localhost:3000/favicon.ico
http://localhost:3000/logo192.png
http://localhost:3000/manifest.json
http://localhost:3000/robots.txt
```

---

## index.html

* The main HTML file inside `public` folder in React project.
* Acts as the entry point for rendering React components.
* Contains a root `<div id="root">` where React injects components.
* Provides links to CSS, icons, and metadata.

## index.js

* The main JavaScript entry file in `src` folder.
* Renders the `App` component inside the root div of `index.html`.
* Imports necessary modules like React and ReactDOM.
* Connects React components with the DOM.

---

## app.js

```javascript
import logo from '/logo.svg';
import './App.css';

function App() {
  return (
    <div>
      This App Componenet
    </div>
  );
}

export default App;
```

---

## test.js

```javascript
let i = 1;
// let l = 2;   // invalid variable name, so commented

// console.log(1 + 1);

console.log("Hello World doing addition with method");

console.log(add(1, 1));
console.log(add(3, 5));
console.log(subtract(3, 5));

function add(a, b) {
  return a + b;
}

const subtract = (a, b) => {
  return a - b;
};
```

---

## Another way (test.js alternative)

```javascript
let i = 1;
let j = 2;

// console.log(1 + 1);

console.log("Hello world doing addition with method");

console.log(add(i, j));
console.log(add(3, 5));
console.log(multiply(3, 5));
console.log(subtract(3, 5));

const subtract = (a, b) => {
  return a - b;
};

function multiply(a, b) {
  return a * b;
}

function add(a, b) {
  return a + b;
}
```

