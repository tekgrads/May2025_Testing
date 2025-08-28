package ioStreams;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test7 {
public static void main(String[] args) throws IOException {
		
		DataOutputStream dos = 
				new DataOutputStream(new FileOutputStream("data.txt"));
		
		dos.writeByte(97);
		dos.writeShort(98);
		dos.writeInt(99);
		dos.writeLong(100);
		dos.writeFloat(101);
		dos.writeDouble(102);
		dos.writeChar(103);
		dos.writeBoolean(true);
		dos.writeUTF("xyz");
		
		System.out.println("data is saved");
		dos.close();
	}

}
