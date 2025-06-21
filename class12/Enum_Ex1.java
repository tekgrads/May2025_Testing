class Country {

    public static final String INDIA = "IND";
    public static final String UNITED_STATES = "US";
}

public class Enum_Ex1 {

    public static void main(String[] args) {

        String country = "IND";// "US" value getting from user input changes 

        if (country == "IND") {  // change this to "IND" to match the constant

            System.out.println("Capital is Delhi 1");
        }
            // logic repeated 
        if (country == "IND") {// change this to "IND" to match the constant
            System.out.println("India Capital is Delhi 2");
        }
         // using constant from Country class
        if(country == Country.INDIA) { // using constant from Country class
            System.out.println("Capital is Delhi 3");
        }

         if(country == Country.INDIA) { // using constant from Country class
            System.out.println("Capital is Delhi 4");
        }
         if(country == Country.UNITED_STATES) { // using constant from Country class
            System.out.println("United States Capital is Washiton DC");
        }



    }
}
