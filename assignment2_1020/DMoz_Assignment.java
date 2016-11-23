// 2016_10_20
// 3-2
// Assignment 3(Chapter 7, 8)
// Professor Jung
// This program is ... search for hongik in google.
// with QueryString.

import java.io.*;
import java.net.*;

public class DMoz {
	public static void main(String[] args) {
		String target = "";
		for (int i = 0; i < args.length; i++) {
			target += args[i] + " ";
		}
		target = target.trim(); // Delete space between string
		QueryString query = new QueryString();
		query.add("q", target);
		
		try {
			URL u = new URL("https://www.google.com/" + query); // '?' + '=' is added by query
			URLConnection connection = u.openConnection();
			// adding Permission
			// by addRequestProperty(String, String)
			connection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36");
			
			try (InputStream in = new BufferedInputStream(u.openStream())) {
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

