public class L {

    int i ;

    public static void main(String[] args) {        
        L l1 = new L();
        System.out.println("Hello Workd from L!");
        System.out.println("Value of i from class L for l1: " + l1.i);
        l1.i = 10;
        System.out.println("Value of i from class L after assignment: " + l1.i);

        L l2 = new L();
        l2.i = 20;
        System.out.println("Value of i from class L after assignment in l2: " + l2.i);
        L l3 = new L();
        l3.i = 30;
        System.out.println("Value of i from class L after assignment in l3: " + l3.i);

    }
    
}
