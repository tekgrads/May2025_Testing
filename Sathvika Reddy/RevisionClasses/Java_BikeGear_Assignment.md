# Bike Gear Program in Java


## Code:

```java
public class Bike {
    private int gear;

    public void setGear(int gear) {
        if (gear >= 1 && gear <= 5) {
            this.gear = gear;
            System.out.println("Bike is running on gear " + gear);
        } else {
            System.out.println("Invalid gear! Please set gear between 1 to 5.");
        }
    }

    public static void main(String[] args) {
        Bike b = new Bike();

        // Test cases
        b.setGear(3);  // valid
        b.setGear(6);  // invalid
    }
}
