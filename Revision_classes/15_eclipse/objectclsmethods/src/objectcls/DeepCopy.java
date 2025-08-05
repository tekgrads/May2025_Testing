package objectcls;
class A{
	int i;
	A(int i){
		this.i = i;
	}
}
class B implements Cloneable{
	A a;
	int j;
	public B(A a, int j) {
		super();
		this.a = a;
		this.j = j;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		A a1 = new A(a.i);
		B b = new B(a1, j);
		return b;
	}
	
}
public class DeepCopy {
	public static void main(String[] args) throws CloneNotSupportedException{
		A a1  =new A(123);
		B b1 = new B(a1, 234);
		System.out.println(b1.j + " ---" + b1.a.i);
		B b2 = (B)b1.clone();
		b2.a.i = 888;
		b2.j = 999;
		System.out.println(b2.j + " ---" + b2.a.i);
		System.out.println(b1.j + " ---" + b1.a.i);
	}
		



}
