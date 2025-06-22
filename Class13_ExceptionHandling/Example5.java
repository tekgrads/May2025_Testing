import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Example5 {
    public static void main(String[] args) {

       

        try {
             Thread.sleep(1000); 
           // InterruptedException: still a checked exception in Java 24
        } catch (InterruptedException e) {
            System.out.println("Sleep interrupted!");
        }
    }
}
