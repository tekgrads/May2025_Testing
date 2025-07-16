interface Foo {  }

class Alpha implements Foo {}

class Beta extends Alpha {}

class Delta extends Beta {  }
class Test4
{
public static void main(String[] args) {

Beta x = new Beta();
// insert code here

}

}
/*
Which code, inserted that  will cause a java.lang.ClassCastException?

A. Alpha a = x;
B. Foo f = (Delta)x;
C. Foo f = (Alpha)x;
D. Beta b = (Beta)(Alpha)x;

*/
