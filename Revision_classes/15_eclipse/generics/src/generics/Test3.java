package generics;
	import java.util.ArrayList;

	// generic wild card character( ? )
	public class Test3 {
		static void m1(ArrayList<String> l) {  
			l.add("A");
			l.add(null);
			//l.add(10);
		}
		
	  static void  m2(ArrayList<?> l) {
		//  l.add(10.5); // can not add anything except null within the method bcoz we dont know the type
		//  l.add("A");
		  l.add(null);
	  }
	 
	
}
