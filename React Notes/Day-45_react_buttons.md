# React Buttons and State

In React, **buttons** are commonly used to trigger actions such as
updating state, submitting forms, or performing side effects. React
provides the `useState` hook to handle dynamic values and updates when a
user interacts with buttons.

------------------------------------------------------------------------

## 1. Basic Button in React

A button is created using the `<button>` element.

**Example:**

``` jsx
function App() {
  return (
    <button onClick={() => alert("Button clicked!")}>
      Click Me
    </button>
  );
}
```

------------------------------------------------------------------------

## 2. Button with State (useState)

React's `useState` hook allows you to store and update values when a
button is clicked.

**Example: Counter**

``` jsx
import { useState } from "react";

function Counter() {
  const [count, setCount] = useState(0);

  return (
    <div>
      <p>You clicked {count} times</p>
      <button onClick={() => setCount(count + 1)}>
        Increase
      </button>
      <button onClick={() => setCount(count - 1)}>
        Decrease
      </button>
      <button onClick={() => setCount(0)}>
        Reset
      </button>
    </div>
  );
}

export default Counter;
```

-   `count` → current state value.
-   `setCount` → function to update state.
-   Each button updates the state differently.

------------------------------------------------------------------------

## 3. Disabling a Button

You can use state to **enable or disable** a button.

**Example:**

``` jsx
import { useState } from "react";

function DisableButton() {
  const [disabled, setDisabled] = useState(false);

  return (
    <div>
      <button disabled={disabled}>
        {disabled ? "Disabled" : "Active"}
      </button>
      <button onClick={() => setDisabled(!disabled)}>
        Toggle Disabled
      </button>
    </div>
  );
}

export default DisableButton;
```

------------------------------------------------------------------------

## 4. Changing Button Text with State

You can change the button label dynamically using state.

**Example:**

``` jsx
import { useState } from "react";

function ToggleButton() {
  const [isOn, setIsOn] = useState(false);

  return (
    <button onClick={() => setIsOn(!isOn)}>
      {isOn ? "ON" : "OFF"}
    </button>
  );
}

export default ToggleButton;
```

------------------------------------------------------------------------

## 5. Multiple Buttons with Different Actions

Each button can trigger different state updates.

**Example:**

``` jsx
import { useState } from "react";

function MultiActionButton() {
  const [message, setMessage] = useState("Click a button!");

  return (
    <div>
      <p>{message}</p>
      <button onClick={() => setMessage("Hello!")}>Say Hello</button>
      <button onClick={() => setMessage("Goodbye!")}>Say Goodbye</button>
      <button onClick={() => setMessage("Reset!")}>Reset</button>
    </div>
  );
}

export default MultiActionButton;
```

------------------------------------------------------------------------


