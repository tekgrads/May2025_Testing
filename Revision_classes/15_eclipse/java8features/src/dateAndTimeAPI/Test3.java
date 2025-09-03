package dateAndTimeAPI;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Test3 {
	public static void main(String[] args) {
		ZoneId zone = ZoneId.systemDefault();
		System.out.println(zone);
		
		ZonedDateTime dt = ZonedDateTime.now(zone);
		System.out.println(dt);
	}

}
