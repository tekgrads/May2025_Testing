// Instantiating
import java.util.Scanner;
import java.lang.reflect.*;
import java.lang.annotation.*;
class Test1 
{
	public static void main(String[] args) throws Exception
	{
		Scanner scn  = new Scanner(System.in);
		
		System.out.println("Enter class name");
		String clsName = scn.next();
		Class<?> cls = Class.forName(clsName);
//		Constructor<?> con = cls.getConstructor();          //returns only if constuctor is public
		Constructor<?> con = cls.getDeclaredConstructor();   //returns  if constuctor is public,default,protected and even private
		Object obj1 = con.newInstance();
		
		System.out.println(obj1);
		System.out.println();
		
		Constructor<?> con1 = cls.getDeclaredConstructor(int.class);
		Object obj2 = con1.newInstance(10);
		System.out.println(obj2);
		System.out.println();
		
		Constructor<?> con2 = cls.getDeclaredConstructor(String.class);
		Object obj3 = con2.newInstance("Abc");
		System.out.println(obj3);
		
	}
}
