package objectcls;

public class Test_getCls {
		public static void main(String[] args) {
			String s1 = "a";
			Class cls = s1.getClass();
			System.out.println(cls.getName());
			System.out.println(cls.getPackageName());
			System.out.println(cls.getModule());
			System.out.println();
			
			Example e1 = new Example(10, 20);
			Class cls1 = e1.getClass();
			System.out.println(cls1.getName());
			System.out.println(cls1.getSuperclass());
			System.out.println(cls1.getPackageName());
			System.out.println(cls1.getConstructors());
			
			
		}

	}



