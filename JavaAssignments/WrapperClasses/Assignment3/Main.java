public class Main 
{
public static void main(String[] args) 
{
OrderItem item = new OrderItem("Wireless Mouse");

// Test Case 1 - Valid input
item.setDetails("499.99", "2");
 
// Total after valid input
double total = item.getTotalPrice();
System.out.println("Total price: ₹" + String.format("%.2f", total));

// Test Case 2 - Negative price
item.setDetails("-100", "1"); // should throw exception

// Test Case 3 - Invalid quantity
item.setDetails("100", "abc"); // should throw exception
}
}
