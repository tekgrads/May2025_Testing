package supplier;

import java.util.function.Supplier;

public class Test3 {
	public static void main(String[] args) {
		Supplier<String> s = () -> {
			String pwd = "";
		Supplier<Integer> d = () -> (int)(Math.random()*10);
		String symbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZ@$#";
		Supplier<Character> c = () -> symbols.charAt((int)Math.random()*10);
		for(int i = 0; i < 8; i++) {
			if(i % 2 == 0) {
				pwd = pwd +d.get();
			}
			else {
				pwd = pwd + c.get();
			}
		}
		return pwd;
		
		
			
		};
		System.out.println(s.get());
	}

}
