React continuation
App.js 
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
App.cs
import { useState } from "react";

export default function App() {
  const [count, setCount] = useState(0);

  return (
    <div style={{ textAlign: "center", marginTop: "50px" }}>
      <h1>Counter App</h1>
      <p data-testid="count-value">Count: {count}</p>
      <button onClick={() => setCount(count + 1)}>Increment</button>
    </div>
  );
}



app.test .js
import { render, screen, fireEvent } from "@testing-library/react";
import App from "./App";

test("increments counter when button is clicked", () => {
  render(<App />);
  
  const button = screen.getByText("Increment");
  const countValue = screen.getByTestId("count-value");

  // Initially count should be 0
  expect(countValue.textContent).toBe("Count: 0");

  // Click button
  fireEvent.click(button);

  // Count should be 1 now
  expect(countValue.textContent).toBe("Count: 1");
});

Run the npm start in terminal 
it will automatically generates to web page.