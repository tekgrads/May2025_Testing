
---

###  `InvalidOrderException.java`

```java

public class InvalidOrderException extends Exception {
    public InvalidOrderException(String message) {
        super(message);
    }
}
```

---

###  `OrderItem.java`

```java

public class OrderItem {
    private String productName;
    private double price;
    private int quantity;

  
    public OrderItem(String name) {
        this.productName = name;
        this.price = 0.0;
        this.quantity = 0;
    }

    // Sets the price and quantity using String input
    public void setDetails(String priceStr, String qtyStr) {
        try {
           
            double parsedPrice = Double.parseDouble(priceStr);
            int parsedQty = Integer.parseInt(qtyStr);

            
            if (parsedPrice < 0) {
                throw new InvalidOrderException("Price cannot be negative!");
            }
            if (parsedQty < 0) {
                throw new InvalidOrderException("Quantity cannot be negative!");
            }

            
            this.price = parsedPrice;
            this.quantity = parsedQty;

            System.out.println("Details set for " + productName);
        } catch (NumberFormatException e) {
            System.out.println("Exception: Invalid number format!");
        } catch (InvalidOrderException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

   
    public double getTotalPrice() {
        return price * quantity;
    }
}
```

---

###  `Main.java`

```java
public class Main {
    public static void main(String[] args) {
        
        OrderItem item = new OrderItem("Wireless Mouse");

      
        item.setDetails("499.99", "2");      // Valid
        item.setDetails("-100", "1");        // Negative price
        item.setDetails("100", "abc");       // Invalid quantity format

        
        double total = item.getTotalPrice();
        System.out.println("Total price: ₹" + total);
    }
}
```

---

###  Expected Output:

```
Details set for Wireless Mouse
Exception: Price cannot be negative!
Exception: Invalid number format!
Total price: ₹999.98

