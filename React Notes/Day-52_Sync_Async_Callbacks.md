
# Synchronous & Asynchronous Operations with Callbacks

### Synchronous Operations
In synchronous operations, code executes **line by line**. Each line waits for the previous one to complete before executing.

### Asynchronous Operations
In asynchronous operations, some tasks can run in the background (like API calls, setTimeout, etc.), and the code continues execution without waiting for them to finish.

### Callback Functions
A callback is a function passed as an argument to another function, which is then invoked inside the outer function to complete a certain action.

---

### Filename: `App.js`

```javascript
import './App.css';
import Orders from './Orders';
import Customers from './Customers';

function App() {
  return (  
    <div className="App">
      <Orders/> 
    </div>
  );
}

export default App;
```

---

### Filename: `Orders.js`

```javascript
export default function Orders() {
    const placeOrder = () => {
        console.log("Placing order...");
        console.log("Checking stock...");

        for (let i = 1; i <= 5000000000; i++) {
            // Simulating heavy task (sync operation)
        }

        console.log("Stock confirmed.");
        console.log("Payment processed.");
        console.log("Order completed.");
    }

    return (
        <>
            <button type="button" onClick={placeOrder}>Place Order</button>
        </>
    );
}
```

---

### Filename: `Customers.js`

```javascript
export default function Customers() {
    const logCustomer = (id) => {
        console.log("Customer ID received: " + id);
    }

    const getCustomer = (callback, id) => {
        console.log("Fetching customer details for ID: " + id);
        let data = { id, name: "John Doe" };
        callback(data.id);
        console.log("Customer fetch complete");
    }

    const getOrders = (callback, id) => {
        console.log("Fetching orders for customer ID: " + id);
        let order = { id, product: "Laptop" };
        callback(order.id);
        console.log("Orders fetch complete");
    }

    const handleClick = () => {
        getCustomer(logCustomer, 1);
        console.log("---------- ");
        getCustomer((id) => logCustomer(id), 2);
        console.log("---------- ");
        getOrders((id) => getCustomer(logCustomer, id), 3);
    }

    return (
        <>
            <button type="button" onClick={handleClick}>Get Customer Data</button>
        </>
    );
}
```
