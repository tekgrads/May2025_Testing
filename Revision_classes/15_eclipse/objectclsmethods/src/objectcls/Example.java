package objectcls;

public class Example {
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
	public Example(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public Example() {
		
	}
	
	@Override
	public String toString() {
		return "Example [x=" + x + ", y=" + y + "]";
	}
	public static void main(String[] args) {
		Example e1 = new Example();
		System.out.println(e1);
		Example e2 = new Example(5,6);
		System.out.println(e2);
		Example e3 = new Example(5,6);
		System.out.println(e3);
		System.out.println(e1.hashCode());
		System.out.println(e2.hashCode());
		System.out.println(e3.hashCode());
		String s1 = new String("a");
		System.out.println(s1);
		
	}

}
