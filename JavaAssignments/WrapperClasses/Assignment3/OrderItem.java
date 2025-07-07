public class OrderItem 
{
String productName;
Double price;
Integer quantity;

// Constructor 

public OrderItem(String productName) 
{
this.productName = productName;
}

// Method 

public void setDetails(String priceStr, String qtyStr) 
{
try 
{
price = Double.parseDouble(priceStr);
quantity = Integer.parseInt(qtyStr);

if (price < 0) 
{
throw new InvalidOrderException("Price cannot be negative!");
}

if (quantity < 0) 
{
throw new InvalidOrderException("Quantity cannot be negative!");
}

System.out.println("Order set successfully for: " + productName);

} catch (InvalidOrderException e) 
{
System.out.println("Exception: " + e.getMessage());
} catch (NumberFormatException e) 
{
if (!isNumeric(priceStr)) 
{
System.out.println("Exception: Invalid price format!");
} else 
{
System.out.println("Exception: Invalid quantity format!");
}
}
}

// Calculate total price

public double getTotalPrice() 
{
return price * quantity;
}

// Helper method to check if string is numeric

private boolean isNumeric(String str) {
try {
Double.parseDouble(str);
return true;
} catch (NumberFormatException e) {
return false;
}
}
}
