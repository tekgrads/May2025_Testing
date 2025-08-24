# React - Detailed Guide

## 1. What is React?

React is a **JavaScript library** developed by Facebook (now Meta) for
building **user interfaces (UIs)**, especially for **single-page
applications (SPAs)** where high performance and dynamic content
rendering are required.

### Key Features

-   **Component-Based Architecture**: UI is divided into reusable
    components.
-   **Virtual DOM**: Improves performance by updating only parts of the
    page that change.
-   **Declarative**: Developers describe what they want UI to look like,
    React handles updates.
-   **Unidirectional Data Flow**: Makes code predictable and easier to
    debug.
-   **Cross-Platform**: Works for Web (React) and Mobile (React Native).

------------------------------------------------------------------------

## 2. Why Use React?

-   **Fast Rendering**: Virtual DOM makes UI updates efficient.
-   **Reusable Components**: Reduces code duplication and simplifies
    maintenance.
-   **Strong Community Support**: Huge ecosystem with libraries like
    Redux, React Router.
-   **SEO-Friendly**: Server-side rendering improves search engine
    visibility.
-   **Learning Curve**: Easier to pick up compared to full frameworks
    like Angular.

------------------------------------------------------------------------

## 3. How React is Useful

-   **Interactive UI Development**: Used for building modern,
    responsive, and dynamic web apps.
-   **Large-Scale Applications**: Suitable for apps like dashboards,
    e-commerce, and social networks.
-   **Reusable UI Components**: Build once and reuse across different
    parts of the application.
-   **Rich Ecosystem**: Supports integrations with tools like Redux,
    Next.js, and Material UI.

------------------------------------------------------------------------

## 4. Installation Requirements

### 4.1 Prerequisites

-   **Node.js & npm** (Node Package Manager)
-   A **Code Editor** like Visual Studio Code
-   Basic knowledge of JavaScript, HTML, and CSS

### 4.2 Steps to Install React

#### Step 1: Install Node.js

-   Go to [Node.js Official Site](https://nodejs.org)
-   Download the **LTS version**
-   Install using default settings

#### Step 2: Verify Installation

``` bash
node -v
npm -v
```

#### Step 3: Create React App (Using Vite - Fast Method)

``` bash
npm create vite@latest my-app
cd my-app
npm install
npm run dev
```

Open `http://localhost:5173` in your browser.

#### Step 4: Alternative - Create React App (CRA)

``` bash
npx create-react-app my-app
cd my-app
npm start
```

------------------------------------------------------------------------

## 5. First React Component Example

``` javascript
function Welcome() {
  return <h1>Hello, React!</h1>;
}

export default Welcome;
```

------------------------------------------------------------------------

## 6. Advantages of React

-   High performance via Virtual DOM
-   Huge community and third-party libraries
-   Easy to maintain and scale applications
-   Used by major companies: Facebook, Instagram, Netflix, Airbnb

