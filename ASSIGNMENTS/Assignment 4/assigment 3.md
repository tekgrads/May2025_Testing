Problem Statement:
Create a Java application using inheritance where a subclass interacts with its superclass. Demonstrate the usage of:

Access Specifiers (public, protected, private, and default)
Instance Initialization Block (IIB)
Static Initialization Block (SIB)
Constructors (using super)
program 

class Animal {
    public String name;         
    protected int age;            
    String type;                 
    private double weight;        

    static {
        System.out.println("Animal SIB: Class Animal is being loaded.");
    }

    {
        System.out.println("Animal IIB: A new Animal object is being created.");
    }

    public Animal(String name, int age, String type, double weight) {
        this.name = name;
        this.age = age;
        this.type = type;
        this.weight = weight;
        System.out.println("Animal Constructor: Animal created with details.");
    }

    public double getWeight() {
        return weight;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age + " years");
        System.out.println("Type: " + type);
        System.out.println("Weight: " + weight + " kg");
    }
}

class Dog extends Animal {

    private String breed;

    static {
        System.out.println("Dog SIB: Class Dog is being loaded.");
    }

    {
        System.out.println("Dog IIB: A new Dog object is being created.");
    }

    public Dog(String name, int age, String type, double weight, String breed) {
        super(name, age, type, weight); // Calls Animal's constructor
        this.breed = breed;
        System.out.println("Dog Constructor: Dog created with breed " + breed);
    }

    public void showDogDetails() {
        System.out.println("Dog's Name (public): " + name);
        System.out.println("Dog's Age (protected): " + age);
        System.out.println("Dog's Type (default): " + type);
        // Cannot access weight directly because it's private in superclass
        System.out.println("Dog's Weight (via getter): " + getWeight());
        System.out.println("Dog's Breed: " + breed);
    }
}

public class InheritanceDemo {
    public static void main(String[] args) {
        System.out.println("Main Method: Starting program...\n");

        Dog myDog = new Dog("Buddy", 5, "Mammal", 12.5, "Golden Retriever");

        System.out.println("\n--- Displaying Animal Info ---");
        myDog.displayInfo();

        System.out.println("\n--- Displaying Dog Details ---");
        myDog.showDogDetails();
    }
}
