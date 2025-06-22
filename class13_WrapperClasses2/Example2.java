
public class Example2 {

    // static void test(int d) {
    //     System.out.println("int: " + d);
    // }

    static void test(Integer d) {
        System.out.println("Integer: " + d);
    }

    //  static void test(Byte d) {
    //     System.out.println("Byte: " + d);
    // }

    //  static void test(Number d) {
    //     System.out.println("Number: " + d);
    // }

    // static void test(Object d) {
    //     System.out.println("Object: " + d);
    // }

    static void test(byte ...  d) {
        System.out.println("varargs byte: " + d);
    }

    // static void test(byte   d) {
    //     System.out.println("byte: " + d);
    // }

    public static void main(String[] args) {
      byte b = 10;
      test(b);
    }
    
}
