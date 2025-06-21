enum Country {
    INDIA("IND", "BHRARAT"),
    UNITED_STATES("US", "United States"),
    UNITED_KINGDOM("GB", "United Kingdom"),
    CANADA("CA", "Canada"),
    AUSTRALIA("AU", "Australia"),
    GERMANY("DE", "Germany"),
    FRANCE("FR", "France"),
    JAPAN("JP", "Japan"),
    CHINA("CN", "China"),
    BRAZIL("BR", "Brazil");

    private final String code;
    private final String name;

    Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

}

public class Enum_Ex2 {

    public static void main(String[] args) {


       

    //     int numbers [] = new int[10]; // Array to store numbers
    //     numbers[0] = 1; // Initialize first element
    //     numbers[1] = 2; // Initialize second element
    //     numbers[2] = 3; // Initialize third element
    //     numbers[3] = 4;
    //     numbers[4] = 5;
    //     numbers[5] = 6;
    //     numbers[6] = 7;
    //     numbers[7] = 8;
    //     numbers[8] = 9;
    //     numbers[9] = 10;
        
    //     // Initialize remaining elements
    //     int[] numbers_init = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    //    for(int i =0; i< 10;i++){
    //         System.out.println("numbers["+i+"] = " + numbers[i]);
    //    }

       
    //    for(int i =0; i< 10;i++){
    //         System.out.println("numbers_init["+i+"] = " + numbers_init[i]);
    //    }

    //    for(int n : numbers) {
    //         System.out.println("Number: " + n);
    //     }

    //  Country country [] = Country.values(); // Get all enum constants
    //         for(Country c : country) {
    //             System.out.println("Country Code: " + c.getCode() + ", Country Name: " + c.getName());
    //         }

            String userInput = "IND"; // Simulating user input
            if(userInput == Country.INDIA.getCode()) { // Check if user input matches "IN"
                System.out.println(Country.INDIA.getName() + " Capital is New Delhi");
            } else if(userInput == Country.UNITED_STATES.getCode()) {
                System.out.println(Country.UNITED_STATES.getName() + " Capital is Washington, D.C.");
            }
    }
    
}
