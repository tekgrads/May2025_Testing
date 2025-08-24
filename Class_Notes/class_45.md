
# Node.js and React Fundamentals

---

## Node.js Installation
1. Go to the [official Node.js website](https://nodejs.org).
2. Download the **LTS (Long-Term Support)** version for stability.
3. Install using **default settings**.
4. Verify installation:
   ```bash
   node -v
   npm -v
   ```
   - `node -v` → Displays installed Node.js version.
   - `npm -v` → Displays installed npm (Node Package Manager) version.

---

## VS Code Installation
1. Download from [Visual Studio Code](https://code.visualstudio.com).
2. Install with default settings.
3. Why VS Code?
   - Provides extensions for Node.js, React, GitHub.
   - Built-in terminal to run commands (`node`, `npm`, `npx`).
   - Debugging and IntelliSense support for JavaScript.

---

## What is Node.js?
- Node.js is a **JavaScript runtime environment**.
- It allows JavaScript to run **outside the browser**.
- It uses the **V8 engine** (also used by Google Chrome).
- **Why it was created beyond JavaScript?**
  - Originally, JavaScript was only used inside browsers.
  - Node.js allows developers to use JavaScript for **server-side programming**.
  - Provides event-driven, non-blocking I/O for efficient handling of requests.

---

## How Node.js is Useful for React
- React is a JavaScript library that needs a **development server**.
- Node.js provides this server and enables package management through **npm**.
- Node.js allows:
  - Running build tools.
  - Using `npm` or `npx` to create React apps.
  - Compiling **JSX** and bundling React code for browsers.

---

## React Introduction
- React is a **JavaScript library** for building user interfaces.
- Developed and maintained by **Facebook**.
- Core Features:
  - **Component-based** → Reusable UI pieces.
  - **Virtual DOM** → Improves performance.
  - **Declarative** → Easier to manage complex UIs.

### Example: Simple React App
**App.js**
```javascript
function App() {
  return (
    <div>
      <h1>Hello, React!</h1>
      <p>This is my first React component.</p>
    </div>
  );
}


export default App;
```

**Output in Browser:**
```
Hello, React!
This is my first React component.
```

---

## Node vs npm
- **Node.js**: A runtime to execute JavaScript outside the browser.
- **npm** (Node Package Manager): A tool to install, manage, and share JavaScript packages/libraries.

---

## npm vs npx
- **npm**:
  - Installs packages globally or locally.
  - Example:
    ```bash
    npm install react
    ```
- **npx**:
  - Executes a package without installing it globally.
  - Useful for one-time commands.
  - Example:
    ```bash
    npx create-react-app myapp
    ```

---

## npx create-react-app
Command to create a new React project:
```bash
npx create-react-app myapp
```

- **npx** ensures you are using the latest version.
- **create-react-app** sets up a React project with:
  - Default folder structure (`src`, `public`).
  - Webpack, Babel, and development server pre-configured.

---

## Versioning in React (Major, Minor, Patch)
React (and other npm packages) use **Semantic Versioning**:
- **Major** (X.0.0): Breaking changes.
- **Minor** (0.X.0): New features, backward compatible.
- **Patch** (0.0.X): Bug fixes, backward compatible.

Example:
- `17.0.2`
  - `17` → Major
  - `0` → Minor
  - `2` → Patch

---

## Carrot (^) Symbol in package.json
- Example: `"react": "^17.0.2"`
- The `^` symbol means:
  - Install the latest **minor** or **patch** versions.
  - In this case: Anything from `17.0.2` up to `<18.0.0`.

---

## Understanding node_modules
- Folder created when running `npm install`.
- Contains all **dependencies** and their **sub-dependencies**.
- Often very large in size because each library may have its own libraries.

---

## React Dev Server Requests
When you run `npm start` in a React app, the dev server loads:
- `http://localhost:3000/favicon.ico`
- `http://localhost:3000/logo192.png`
- `http://localhost:3000/manifest.json`
- `http://localhost:3000/robots.txt`

These files come from the `public/` directory.

---

## index.html
- Found in the `public/` folder.
- The **single HTML file** used by React apps.
- Contains:
  ```html
  <div id="root"></div>
  ```
- React renders components inside this root div.

---

## index.js
- Found in the `src/` folder.
- Entry point for React app.
- Renders `App` component into the `root` div from `index.html`.

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

## test.js
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
