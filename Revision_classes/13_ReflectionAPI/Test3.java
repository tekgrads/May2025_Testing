//  Instantiating Using Constructor
import java.lang.reflect.*;
import java.lang.annotation.*;
class Test3
{
	public static void main(String[] args) throws Exception
	{
		Class<?> cls = Class.forName("A");
		Constructor<?> con = cls.getDeclaredConstructor();
		Object obj1 = con.newInstance();
		Object obj2 = con.newInstance();
		
		Constructor<?> con1 = cls.getDeclaredConstructor(int.class);
		Object obj3 = con1.newInstance(50);
		Object obj4 = con1.newInstance(70);
		
		A a1 = (A)obj1;
		A a2 = (A)obj2;
		A a3 = (A)obj3;
		A a4 = (A)obj4;
		System.out.println("a1.x: " + a1.x);
		System.out.println("a2.x: " + a2.x);
		System.out.println("a3.x: " + a3.x);
		System.out.println("a4.x: " + a4.x);
	}
}
