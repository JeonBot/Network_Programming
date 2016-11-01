// 2016_10_06
// 3-2
// Example
// lab_4_11
// Professor Jung
// This Program is sub program and use with lab_4_12(PooledWeblog.java).
// this is sub code.

import java.net.*;
import java.util.concurrent.Callable;

public class LookupTask implements Callable <String> {
	private String line;
	public LookupTask(String line) {
		this.line = line;
	}
	
	public String call() {
		try {
			int index = line.indexOf(' ');
			String address = line.substring(0, index);
			String theRest = line.substring(index);
			// address name's hostname is spawned
			String hostname = InetAddress.getByName(address).getHostName();
			return hostname + " " + theRest;
		} catch (Exception ex) {
			return line;
		}
	}
}