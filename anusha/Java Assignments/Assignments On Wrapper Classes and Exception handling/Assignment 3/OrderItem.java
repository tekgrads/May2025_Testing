// Class to store and validate order item details
public class OrderItem {
    private String productName;
    private Double price = 0.0;
    private Integer quantity = 0;

    public OrderItem(String productName) {
        this.productName = productName;
    }

    // Method to set and validate price and quantity
    public void setDetails(String priceStr, String qtyStr) {
        try {
            price = parseAndValidatePrice(priceStr);
            quantity = parseAndValidateQuantity(qtyStr);
        } catch (InvalidOrderException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    // Helper to parse and validate price
    private Double parseAndValidatePrice(String str) throws InvalidOrderException {
        try {
            double parsedPrice = Double.parseDouble(str);
            if (parsedPrice < 0) {
                throw new InvalidOrderException("Price cannot be negative!");
            }
            return parsedPrice;
        } catch (NumberFormatException e) {
            throw new InvalidOrderException("Invalid price format!");
        }
    }

    // Helper to parse and validate quantity
    private Integer parseAndValidateQuantity(String str) throws InvalidOrderException {
        try {
            int parsedQty = Integer.parseInt(str);
            if (parsedQty < 0) {
                throw new InvalidOrderException("Quantity cannot be negative!");
            }
            return parsedQty;
        } catch (NumberFormatException e) {
            throw new InvalidOrderException("Invalid quantity format!");
        }
    }

    // Calculates total price
    public double getTotalPrice() {
        return price * quantity;
    }
}
