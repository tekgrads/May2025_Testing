import java.util.Scanner;
import java.lang.reflect.*;
import java.lang.annotation.*;
/*class Test {
	public static void main(String[] args){
		Object obj = new A();
		System.out.println(obj);
	}
}
*/
class Test
{
	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter class name");
		String clsName = scn.next();
	/*	Class  cls = Class.forName(clsName);
		Object obj = cls.newInstance();
		*/
		Class<?>  cls = Class.forName(clsName);
		Object obj = cls.getDeclaredConstructor().newInstance();
		
		System.out.println(obj);
	}
}