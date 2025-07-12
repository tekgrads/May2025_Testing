

### **2. Voter Application Program (Exception for wrong age)**


## Code:

```java
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class VoterApp {
    public static void checkEligibility(int age) throws InvalidAgeException {
        if (age >= 18 && age <= 100) {
            System.out.println("Collect voter card after 30 days.");
        } else {
            throw new InvalidAgeException("Invalid age! Age must be between 18 and 100.");
        }
    }

    public static void main(String[] args) {
        try {
            checkEligibility(25);  // valid
            checkEligibility(16);  // invalid
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }
    }
}
