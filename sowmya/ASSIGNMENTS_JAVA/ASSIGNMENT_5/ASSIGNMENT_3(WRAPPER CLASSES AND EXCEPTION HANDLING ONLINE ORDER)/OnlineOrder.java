// Custom exception class
class InvalidOrderException extends Exception {
    public InvalidOrderException(String message) {
        super(message);
    }
}

// OrderItem class
class OrderItem {
    String productName;
    double price;
    int quantity;

    public OrderItem(String productName) {
        this.productName = productName;
    }

    public void setDetails(String priceStr, String qtyStr) {
        try {
            price = Double.parseDouble(priceStr);
            quantity = Integer.parseInt(qtyStr);

            if (price < 0 || quantity < 0) {
                throw new InvalidOrderException("Exception Price cannot be negative.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Exception Invalid input format.");
        } catch (InvalidOrderException e) {
            System.out.println(e.getMessage());
        }
    }

    public double getTotalPrice() {
        return price * quantity;
    }
}

// Main class
public class OnlineOrder {
    public static void main(String[] args) {
        OrderItem item = new OrderItem("Wireless Mouse");

        item.setDetails("499.99", "2");    // Valid
        System.out.println("Total price: rs:" + item.getTotalPrice());

        item.setDetails("-100", "1");      // Negative price
        item.setDetails("100", "abc");     // Invalid quantity
    }
}
