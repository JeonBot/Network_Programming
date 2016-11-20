// 2016_10_20
// 3-2
// Example
// lab_5_10
// Professor Jung
// This Program is main program and use with lab_5_8(QueryString.java).
// This Program is ask for web that i want to query.
// this is main code.

import java.io.*;
import java.net.*;

public class DMoz {
	public static void main(String[] args) {
		String target = "";
		for (int i = 0; i < args.length; i++) {
			target += args[i] + " ";
		}
		// void space remove
		target = target.trim();
		QueryString query = new QueryString();
		query.add("q", target);
		
		try {
			// any url is possible
			URL u = new URL("https://www.google.com/" + query);
			try (InputStream in = new BufferedInputStream(u.openStream())) {
				// == InputStreamReader the HTMl = new InputStreamReader(new BufferedInputStream(u.openStream()))
				InputStreamReader theHTML = new InputStreamReader(in);
				int c;
				while ((c = theHTML.read()) != -1) {
					System.out.print((char) c);
				}
			}
		} catch (MalformedURLException ex) {
			System.err.println(ex);
		} catch (IOException ex) {
			System.err.println(ex);
		}	
	}
}
