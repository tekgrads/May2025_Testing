package com.tekgrads;

class G implements Cloneable{
	int i;
	int j;
	G(int i, int j){
		this.i=i;
		this.j=j;
	}
	
	public G cloneMyObj() throws CloneNotSupportedException {
		return (G)this.clone();
	}

	@Override
	public String toString() {
		return "G [i=" + i + ", j=" + j + "]";
	}

	
	
	
}
public class Example7 {

	public static void main(String[] args) throws CloneNotSupportedException {
		G g1 = new G(1,2);
		G g2 = g1.cloneMyObj();
		System.out.println(g2);
		System.out.println(g1);
		g2.i=10;
		System.out.println("After Changing g2 i value");
		System.out.println(g1);
		System.out.println(g2);
		
		G g3 = g1;
		g3.i=100;
		
		System.out.println(" After changing g3 i value");
		System.out.println(g1);
		System.out.println(g3);

	}

}
