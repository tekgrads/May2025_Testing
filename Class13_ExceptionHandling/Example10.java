class AgeInvalidException extends Exception{
    public AgeInvalidException(){

    }

    public AgeInvalidException(String message){
        super(message);
    }
}


public class Example10 {

    public static void main(String [] args) throws AgeInvalidException {
            int age = 17;
            if(age<18){
                //throw new ArithmeticException();
                throw new AgeInvalidException("Age is less than 18, not elligible for voting");
            } else {
                System.out.println("You are elligible for Voting");
            }
    }
    
}
