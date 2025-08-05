package objectcls;

public class Test_clone implements Cloneable{
	private int x;
	private int y;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public Test_clone() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Test_clone(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	public static void main(String[] args)throws CloneNotSupportedException {
		Test_clone t1 = new Test_clone();
		System.out.println(t1.x + "---" + t1.y);
		Test_clone t2 = new Test_clone(10, 20);
		System.out.println(t2.x + "---" + t2.y);
		Test_clone t3 = (Test_clone)t2.clone();
		System.out.println(t3.x + "---" + t3.y);
		t2.setX(21);
		t2.setY(22);
		System.out.println(t2.x + "---" + t2.y);
		System.out.println(t3.x + "---" + t3.y);
		t3.setX(31);
		t3.setY(32);
		System.out.println(t2.x + "---" + t2.y);
		System.out.println(t3.x + "---" + t3.y);
	}
	

}
