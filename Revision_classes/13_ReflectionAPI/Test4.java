//  Reading, Storing, Modifying values
import java.lang.reflect.*;
import java.lang.annotation.*;
class Test4 
{
	public static void main(String[] args) throws Exception
	{
		Class<?> cls = Class.forName("A");
		Object obj = cls.getDeclaredConstructor().newInstance();
		Field fa = cls.getDeclaredField("a");
		System.out.println("fa: " + fa);
		
		Field fx = cls.getDeclaredField("x");
		System.out.println("fx: " + fx);
		
		Object aValue = fa.get(obj);
		Object xValue = fx.get(obj);
		System.out.println("aValue: " + aValue);
		System.out.println("xValue: " + xValue);
		fa.set(obj, 15);
		fx.set(obj, 16);
		 aValue = fa.get(obj);
		 xValue = fx.get(obj);
		System.out.println("aValue: " + aValue);
		System.out.println("xValue: " + xValue);
	}
}
