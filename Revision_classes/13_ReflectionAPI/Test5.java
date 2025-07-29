// invoking methods
import java.lang.reflect.*;
import java.lang.annotation.*;
class  Test5
{
	public static void main(String[] args) throws Exception
	{
		Class<?> cls = Class.forName("A");
		Object obj = cls.getDeclaredConstructor().newInstance();   // A a1 = new A();
		Method m1 = cls.getDeclaredMethod("m3");
		Object rv = m1.invoke(obj);   // a1.m3()
		
		Method m2 = cls.getDeclaredMethod("m4");
		rv = m2.invoke(obj);
		
		Method m3 = cls.getDeclaredMethod("m3", int.class);
		rv = m3.invoke(obj, 56);
		
		Method m4 = cls.getDeclaredMethod("m4", String.class);
		rv = m4.invoke(obj, "Abc");
		
	}
}
