// 2016_10_20
// 3-2
// Example
// lab_5_6
// Professor Jung
// This Program is URI Splitter.

// http://www.xml.com/pub/a/2003/09/17/stax.html#id=_hbc
import java.net.*;

public class URISplitter {
	public static void main(String args[]) {
		for (int i = 0; i < args.length; i++) {
			try {
				URI u = new URI(args[i]);
				System.out.println("The URI is "+ u);
				// is this non-hierarchical?
				if (u.isOpaque()) {
					System.out.println("This is an opaque URI.");
					System.out.println("The scheme is " + u.getScheme());
					System.out.println("The scheme specific part is " + u.getSchemeSpecificPart());
				// is this hierarchical?
				} else {
					System.out.println("This is a hierarchical URI.");
					// getScheme == getProtocol
					System.out.println("The scheme is " + u.getScheme());
				}
				try {
					// u.parseServerAuthority
					u = u.parseServerAuthority();
					System.out.println("The host is " + u.getHost());
					System.out.println("The user info is " + u.getUserInfo());
					System.out.println("The port is " + u.getPort());
				} catch (URISyntaxException ex) {
					// Must be a registry based authority
					System.out.println("The authority is " + u.getAuthority());
				}
				System.out.println("The path is " + u.getPath());
				System.out.println("The query string is " + u.getQuery());
				System.out.println("The fragment ID is " + u.getFragment());
			// URISyntaxException
			} catch (URISyntaxException ex) {
				System.err.println(args[i] + " does not seem to be a URI.");
			}
			System.out.println();
		}
	}
}
