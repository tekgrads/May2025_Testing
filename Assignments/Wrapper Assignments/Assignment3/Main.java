public class Main {
    public static void main(String[] args) {
        OrderItem item = new OrderItem("Wireless Mouse");

        item.setDetails("499.99", "2");       // Valid
        item.setDetails("-100", "1");         // Negative price
        item.setDetails("100", "abc");        // Invalid quantity

        double total = item.getTotalPrice();
        System.out.println("Total price: ₹" + String.format("%.2f", total));
    }
}