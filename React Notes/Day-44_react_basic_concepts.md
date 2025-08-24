# React Basic Concepts:

React is a **JavaScript library** for building user interfaces. It
allows developers to create reusable UI components and manage the state
of applications effectively.

------------------------------------------------------------------------

## 1. React Components

-   Components are the **building blocks** of a React application.
-   A component is a JavaScript function or class that returns JSX
    (JavaScript XML).
-   Types of Components:
    -   **Functional Components**: Defined as functions, usually with
        hooks.
    -   **Class Components**: Defined as ES6 classes (less common in
        modern React).

**Example:**

``` jsx
function Greeting() {
  return <h1>Hello, World!</h1>;
}
```

------------------------------------------------------------------------

## 2. JSX (JavaScript XML)

-   JSX is a syntax extension for JavaScript that looks similar to HTML.
-   It allows embedding expressions inside curly braces `{ }`.

**Example:**

``` jsx
const name = "Cherry";
const element = <h1>Hello, {name}!</h1>;
```

------------------------------------------------------------------------

## 3. React Props

-   **Props (properties)** are used to pass data from a parent component
    to a child component.
-   Props are **read-only** (immutable).

**Example:**

``` jsx
function Welcome(props) {
  return <h1>Hello, {props.name}</h1>;
}

// Usage
<Welcome name="Cherry" />
```

------------------------------------------------------------------------

## 4. React State

-   **State** represents dynamic data that changes over time.
-   State can only be used inside components.

**Example (with useState hook):**

``` jsx
import { useState } from "react";

function Counter() {
  const [count, setCount] = useState(0);

  return (
    <div>
      <p>You clicked {count} times</p>
      <button onClick={() => setCount(count + 1)}>Click Me</button>
    </div>
  );
}
```

------------------------------------------------------------------------

## 5. React Hooks

Hooks allow functional components to use state and lifecycle features.

-   **useState** → For managing state in functional components.
-   **useEffect** → For side effects (like fetching data, DOM
    manipulation).
-   **useContext** → For accessing context values without prop drilling.
-   **useRef** → For accessing/manipulating DOM elements directly.
-   **Custom Hooks** → Developers can create reusable hooks.

**Example (useEffect):**

``` jsx
import { useState, useEffect } from "react";

function Timer() {
  const [time, setTime] = useState(0);

  useEffect(() => {
    const interval = setInterval(() => setTime(time + 1), 1000);
    return () => clearInterval(interval); // cleanup
  }, [time]);

  return <p>Timer: {time}</p>;
}
```

------------------------------------------------------------------------

## 6. React DOM

-   **ReactDOM** is the package that provides DOM-specific methods for
    rendering components.
-   Commonly used function: `ReactDOM.createRoot()` and `root.render()`.

**Example:**

``` jsx
import React from "react";
import ReactDOM from "react-dom/client";
import App from "./App";

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(<App />);
```

------------------------------------------------------------------------

## 7. React Lifecycle (Class Components)

Even though hooks replaced lifecycle methods, they still exist in class
components: - **componentDidMount** → Runs after the component is
mounted. - **componentDidUpdate** → Runs after state/props change. -
**componentWillUnmount** → Runs before component is removed.

------------------------------------------------------------------------

## 8. Virtual DOM

-   The **Virtual DOM** is a lightweight copy of the real DOM.
-   React updates only the parts of the DOM that changed instead of
    reloading the whole UI, which improves performance.

------------------------------------------------------------------------

## 9. React Events

-   React events are written in **camelCase** (e.g., `onClick`,
    `onChange`).
-   Functions are passed as event handlers.

**Example:**

``` jsx
<button onClick={() => alert("Clicked!")}>Click Me</button>
```

------------------------------------------------------------------------

## 10. React Router (for Navigation)

-   A separate library (`react-router-dom`) used for navigation in React
    apps.

**Example:**

``` jsx
import { BrowserRouter, Routes, Route, Link } from "react-router-dom";

function App() {
  return (
    <BrowserRouter>
      <nav>
        <Link to="/">Home</Link>
        <Link to="/about">About</Link>
      </nav>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/about" element={<About />} />
      </Routes>
    </BrowserRouter>
  );
}
```

------------------------------------------------------------------------

# Conclusion

React provides a simple and powerful way to build **interactive UIs**
using components, hooks, props, and state. Its efficient **Virtual DOM**
handling and reusable architecture make it one of the most popular
front-end frameworks today.
