class Alpha{}
interface Foo {}
class Beta extends Alpha implements Foo{}

class  Test11{
	
	static void m1(Alpha obj){ 
		System.out.println("Alpha param");
	}
	
	static void m1(Foo i1){ 
		System.out.println("Foo param");
	}

	public static void main(String[] args) {
	//	m1(new Beta());  a e 
	//	m1(null);    a e

		Alpha a1 = new Beta();
		m1(a1); // alpha

		Foo f1 = new Beta();
		m1(f1);  //foo

		m1((Alpha) new Beta());  // alpha
		m1((Foo) new Beta());   // foo
	}
}