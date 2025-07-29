// accessing private members
import java.lang.reflect.*;
import java.lang.annotation.*;
class  Test6
{
	public static void main(String[] args) throws Exception
	{
		Class<?> cls  = Class.forName("P");
		Constructor<?> con = cls.getDeclaredConstructor();
		con.setAccessible(true);
		Object obj = con.newInstance();
		Field fx = cls.getDeclaredField("x");
		fx.setAccessible(true);
		System.out.println("Private variable is getting accessed " + fx.get(obj));
		Method m = cls.getDeclaredMethod("m1");
		m.setAccessible(true);
		m.invoke(obj);

	}
}
