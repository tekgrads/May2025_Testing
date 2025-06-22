
public class Example3 {

    static void test(String ... strings) {
        for (String s : strings) {
            System.out.println("String: " + s);
        }
    }
    public  static void main(String[] args) {
        test("Hello", "World","Java", "Programming");
    }  
}
