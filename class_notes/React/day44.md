React Buttons and State
1. Introduction

In React, state is used to store data that can change over time, and buttons are often used to update this state.
When a button is clicked, it triggers an event that can modify the state, and React will re-render the component with the new state.

2. What is State?

State is a built-in object in React components.

It determines how the component behaves and what it renders.

State updates are asynchronous and should be done using the setState function (in class components) or the useState hook (in functional components).

3. Example 1 — Basic Button with State (Functional Component)
import React, { useState } from 'react';

function Counter() {
  // Declare state variable
  const [count, setCount] = useState(0);

  return (
    <div>
      <h2>Count: {count}</h2>
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


✅ Explanation

useState(0) → initializes count to 0.

setCount() → updates the state.

Each button click updates the state → React re-renders the UI.

4. Example 2 — Toggle Button
import React, { useState } from 'react';

function ToggleButton() {
  const [isOn, setIsOn] = useState(false);

  return (
    <div>
      <button onClick={() => setIsOn(!isOn)}>
        {isOn ? 'ON' : 'OFF'}
      </button>
    </div>
  );
}

export default ToggleButton;


✅ Explanation

isOn holds a boolean state.

Button text changes dynamically based on the state.

Each click toggles between true and false.

5. Example 3 — Multiple Buttons Controlling State
import React, { useState } from 'react';

function ColorChanger() {
  const [color, setColor] = useState("black");

  return (
    <div>
      <h2 style={{ color: color }}>Current Color: {color}</h2>
      <button onClick={() => setColor("red")}>Red</button>
      <button onClick={() => setColor("green")}>Green</button>
      <button onClick={() => setColor("blue")}>Blue</button>
    </div>
  );
}

export default ColorChanger;


✅ Explanation

State variable color is updated when buttons are clicked.

Text color changes dynamically.

6. Example 4 — Disabling a Button After Click
import React, { useState } from 'react';

function SubmitButton() {
  const [isDisabled, setIsDisabled] = useState(false);

  const handleClick = () => {
    alert("Submitted!");
    setIsDisabled(true);
  };

  return (
    <button onClick={handleClick} disabled={isDisabled}>
      {isDisabled ? "Submitted" : "Submit"}
    </button>
  );
}

export default SubmitButton;


✅ Explanation

The button is active initially.

After the first click, it becomes disabled.

7. Key Takeaways

State in React allows dynamic UI updates.

Buttons act as event triggers to modify state.

Use useState hook in functional components.

Always use setState (or setCount, etc.) → never modify state directly.

👉 React Buttons + State = Interactive UI 🚀