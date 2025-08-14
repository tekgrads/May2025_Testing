package generics;
/*
public class Test2<T> {
    public static void main(String[] args) {
	
   Test2<Integer> t1 = new Test2<Integer>();
   Test2<String> t2 = new Test2<String>();
    }
}

//public class Test2<T extends X>{  // x can be class or interface
//
//}
*/
 import java.util.HashMap;

class Test2<T extends Number>{
	

  Test2<Integer> t1 = new Test2<Integer>();
  //Test2<String> t2 = new Test2<String>();
   HashMap<Integer, Character> hm = new HashMap<Integer, Character>();
}

