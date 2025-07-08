public class OrderItem {
    String productName;
    Double price;
    Integer quantity;

    
    public OrderItem(String productName) {
        this.productName = productName;
    }


    public void setDetails(String priceStr, String qtyStr) {
        try {
            price = Double.parseDouble(priceStr); // Wrapper class for double
            quantity = Integer.parseInt(qtyStr);  // Wrapper class for int

            if (price < 0) {
                throw new InvalidOrderException("Price cannot be negative!");
            }
            if (quantity < 0) {
                throw new InvalidOrderException("Quantity cannot be negative!");
            }

        } catch (NumberFormatException e) {
            if (!isNumeric(priceStr)) {
                System.out.println("Exception: Invalid price format!");
            } else {
                System.out.println("Exception: Invalid quantity format!");
            }
        } catch (InvalidOrderException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    
    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public double getTotalPrice() {
        if (price != null && quantity != null) {
            return price * quantity;
        }
        return 0.0;
    }
}
