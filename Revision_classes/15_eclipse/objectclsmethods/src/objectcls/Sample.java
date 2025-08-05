package objectcls;

import java.util.Objects;

public class Sample {
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
	@Override
	public String toString() {
		return "Sample [x=" + x + ", y=" + y + "]";
	}
	public Sample() {
		
	}
	public Sample(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int hashCode() {
		return x + y;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Sample) {
		Sample s = (Sample)obj;
		return this.x == s.x && this.y == s.y;
		}
		return false;
	}
	public static void main(String[] args) {
		Sample s1 = new Sample(5, 6);
		System.out.println(s1);
		System.out.println(s1.hashCode());
		Sample s2 = new Sample(5, 6);
		System.out.println(s2);
		System.out.println(s2.hashCode());
		Sample s3 = new Sample(6, 5);
		System.out.println(s3);
		System.out.println(s3.hashCode());
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		System.out.println(s2.equals(s3));
		System.out.println(System.identityHashCode(s2));
	}

}
