class A {
    int i;
A(int i){
    this.i = i;
    System.out.println("A's constructor with parameter: " + i);
}
A() {
    System.out.println("A's default constructor");
}
public void print() {
    System.out.println("A's print method, i: " + i);
}

{
    System.out.println("A's instance initializer block");
}
}
class B extends A {
    int j;
    B(int i, int j) {
        super(i); // calling A's constructor //super()
        this.j = j;
        System.out.println("B's constructor with parameters: " + i + ", " + j);
    }

    {
        System.out.println("B IIB");
    }
    public void printAll(){
        System.out.println(i);
        System.out.println(j);
    }
}

class Manager4{
    public static void main(String [] args){
        A a1 = new A(10);
        System.out.println("------------------");
        B b1 = new B(200, 300);
        System.out.println(a1.i);
        System.out.println(b1.i);
        System.out.println(b1.j);
    }
}