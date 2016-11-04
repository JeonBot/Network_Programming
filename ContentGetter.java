// 2016_10_13
// 3-2
// Example
// lab_5_3
// Professor Jung
// This Program is use getContent() and get a canonicalname.

import java.io.*;
import java.net.*;

public class ContentGetter {
	public static void main(String[] args) {
		if (args.length > 0) {
			// Open the URL for reading
			try {
				URL u = new URL(args[0]);
				
				// getContent is sun.net.www.protocol.http.HttpURLConnection$HttpInputStream@7e7d611f
				Object o = u.getContent();
				// getClass().getCanonicalName() is front of @
				System.out.println("I got a " + o.getClass().getCanonicalName());
			} catch (MalformedURLException ex) {
				System.err.println(args[0] + " is not a parseable URL");
			} catch (IOException ex) {
				System.err.println(ex);
			}
		}
	}
}

// WAN (Internet)
// -------------- HIGHER
// Data-Center (FatTree) 
// -------------- // Data-Center and Cluster Network ' s purpose is speed up
// Cluster Network (3D too)
// --------------
// LAN
// -------------- LOWER
// Network on Chip