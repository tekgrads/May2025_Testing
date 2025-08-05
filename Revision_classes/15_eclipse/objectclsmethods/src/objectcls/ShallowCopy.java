package objectcls;

class E{
	 int j;
	public E(int j) {
		this.j = j;
	}
	   
}

class Sa implements Cloneable {
	 int x;
	 E e;
	
  public Sa(int x, E e) {
		super();
		this.x = x;
		this.e = e;
	}
 
	@Override
	public String toString() {
		return "Sa [x=" + x + ", e=" + e + "]";
	}
   @Override
 protected Object clone() throws CloneNotSupportedException {
 	return super.clone();
 }
}
public class ShallowCopy implements Cloneable{
	public static void main(String[] args) throws CloneNotSupportedException  
	{
		E e1 = new E(21);
		Sa s1 = new Sa(22,e1);
		System.out.println(s1.x + "---" + s1.e.j);
		Sa s2 = (Sa)s1.clone();
		s2.x = 888;
		s2.e.j = 999;
		System.out.println(s2.x + "---" + s2.e.j);
		System.out.println(s1.x + "---" + s1.e.j);
	}


}
