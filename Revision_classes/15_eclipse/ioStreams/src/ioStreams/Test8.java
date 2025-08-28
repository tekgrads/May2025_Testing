package ioStreams;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Test8 {
public static void main(String[] args) throws IOException {
		
		DataInputStream dis = 
				new DataInputStream(new FileInputStream("data.txt"));
		
		byte 	b1 	= dis.readByte();
		short 	s1 	= dis.readShort();
		int 	i1 	= dis.readInt();
		long 	l1 	= dis.readLong();
		float 	f1 	= dis.readFloat();
		double 	d1 	= dis.readDouble();
	//	float 	f1 	= dis.readFloat(); // changing order
		char 	c1 	= dis.readChar();
		boolean bo 	= dis.readBoolean();
		String  st 	= dis.readUTF();
		
		System.out.println(b1);
		System.out.println(s1);
		System.out.println(i1);
		System.out.println(l1);
		System.out.println(f1);
		System.out.println(d1);
		System.out.println(c1);
		System.out.println(bo);
		System.out.println(st);
		
		dis.close();
}

}
