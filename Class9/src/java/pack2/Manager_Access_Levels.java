package pack2;

// import pack1.Test;

class Manager_Access_Levels extends Test2{
   
    public static void main(String [] args) {
        Test2 t2 = new Test2();
       Test2.printIValueInTest2();
       t2.printJValueInTest2();
	//    //Test.i =100;
	   System.out.println("I value outside pack1 in pack2 is "+i);
	   System.out.println("J value outside pack1 in pack2 is "+j);
    }
}

