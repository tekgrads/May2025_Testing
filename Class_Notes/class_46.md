
##  Files Overview

### 1. `dom_testing/index.html`

This file shows **basic DOM manipulation** without React.  
It includes:

- Changing text dynamically.
- Toggling CSS classes.
- Adding new paragraphs.
- Removing existing paragraphs.

#### Example Features:
```html
<h1 id="title">Hello DOM</h1>
<button onclick="changeText()">Change Title Text</button>
<button onclick="toggleHighlight()">Toggle Highlight</button>
<button onclick="addParagraph()">Add Paragraph</button>
<button onclick="removeParagraph()">Remove Paragraph</button>
```

#### Key Functions:
- **`changeText()`** → Updates heading text using `textContent`.
- **`toggleHighlight()`** → Toggles `highlight` CSS class.
- **`addParagraph()`** → Creates and appends a new `<p>` element.
- **`removeParagraph()`** → Removes the last paragraph inside the `div`.

---

### 2. `src/App.js`

Demonstrates the **behavior of `var` vs `let`** in React functions.

- **`test3()`** → Uses `var`.  
  Variables declared with `var` are **function-scoped**, so they are accessible outside the `if` block.

- **`test3_let()`** → Uses `let`.  
  Variables declared with `let` are **block-scoped**, so trying to access them outside the block throws an error.

- **`test5()`** → Shows how `var` allows **redeclaration and reassignment**, even with different types.

#### Example:
```javascript
const test3 = () => {
  if(true){
    var a1 = 5;
    console.log("inside if:" + a1);
  }
  console.log("outside if block:" + a1); // Works with var
}

const test3_let = () => {
  if(true){
    let a = 5;
    console.log("inside if:" + a);
  }
  console.log("outside if block:" + a); // ❌ Error (a is block-scoped)
}
```

---

### 3. `src/App2.js`

Explores the behavior of `let`.

- **`test1()`** → Demonstrates **reassignment** of a `let` variable with different data types (number, string, boolean, float).

- **`test2()`** → Demonstrates `let` inside a loop.  
  Since `let` is **block-scoped**, trying to access `i` outside the loop results in an error.

#### Example:
```javascript
for(let i = 0; i < 10; i++) {
  console.log(i);
}
console.log(i); // ❌ Error (i is not defined outside loop)
```

---

### 4. `src/App3.js`

Explores the behavior of `const`.

- **`test1()`** → You cannot reassign a `const` variable after declaration.

- **`test2()`** → `const` is block-scoped.  
  Variables declared inside an `if` block cannot be accessed outside it.

- **`test3()`** → Declaring two different constants with different names is valid.

#### Example:
```javascript
const test1 = () => {
  const i = 10;
  console.log(i);
  i = 20; // ❌ Error (const cannot be reassigned)
}
```

---

### 5. `src/index.js`

This is the **entry point** of the React app.  
It renders React components (`App`, `App2`, `App3`) into the DOM.

```javascript
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <App3 />   // Renders App3 component
  </React.StrictMode>
);
```

---

### 6. CSS Files

- **`src/App.css`** → Defines styles specific to React components (`App`, `App2`, `App3`).  
- **`src/index.css`** → Global CSS styles for the entire project.

---

### 7. `src/reportWebVitals.js`

Helps measure **performance metrics** like:

- **CLS** (Cumulative Layout Shift)  
- **FID** (First Input Delay)  
- **FCP** (First Contentful Paint)  
- **LCP** (Largest Contentful Paint)  
- **TTFB** (Time to First Byte)

These metrics are useful for analyzing app performance.

---

## Key Takeaways

- **DOM Manipulation** → Can be done directly with vanilla JS (`getElementById`, `createElement`, `classList.toggle`).  
- **var** → Function-scoped, allows redeclaration and reassignment.  
- **let** → Block-scoped, allows reassignment but **not redeclaration** in the same scope.  
- **const** → Block-scoped, **cannot be reassigned** or redeclared.  
- **React Components (`App`, `App2`, `App3`)** → Demonstrate how `var`, `let`, and `const` behave differently inside functions.  
