// 2016_10_06
// 3-2
// Example
// lab_4_9
// Professor Jung
// This Program is Spamchecked by sbl.spamhaus.org.

import java.net.*;

public class SpamCheck {
	public static final String BLACKHOLE = "sbl.spamhaus.org";
	public static void main(String[] args) throws UnknownHostException {
		for (String arg: args) {
			if (isSpammer(arg)) {
				System.out.println(arg + " is a known spammer.");
			} else {
				System.out.println(arg + " apperars legitimate.");
			}
		}
	}
	private static boolean isSpammer(String arg) {
		try {
			// don't use new in InetAddress
			// address is stored arg's name by getByName
			InetAddress address = InetAddress.getByName(arg);
			// quad range is -127 ~ 128
			// only integer by getaddress
			byte[] quad = address.getAddress();
			String query = BLACKHOLE;
			
			// if quad is null, then for is end
			// if octet is minus, then octet is +256 and stored in unsignedByte
			// e.g. 127.0.0.1, quad is 127, return is false
			// e.g. 254.0.0.1, quad is 254 - 256, return is true, so return -2 + 256 = 254
			// e.g. 192.0.0.1, quad is 192 - 256, return is true, so return -64 + 256 = 192
			for (byte octet : quad) {
				int unsignedByte = octet < 0 ? octet + 256 : octet;
				query = unsignedByte + "." + query;
			}
			System.out.println(query);
			InetAddress.getByName(query);
			return true;
		// UnknownHostException
		} catch (UnknownHostException e) {
			return false;
		}
	}
}
// from book
/*
$ java SpamCheck 207.34.56.23 125.12.32.4 130.130.130.130
207.34.56.23 appears legitimate.
125.12.32.4 appears legitimate.
130.130.130.130 appears legitimate.
*/