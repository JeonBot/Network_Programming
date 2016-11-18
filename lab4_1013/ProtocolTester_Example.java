// 2016_10_13
// 3-2
// Example
// lab_5_1
// Professor Jung
// This Program is ProtocolTester.

import java.net.*;

public class ProtocolTester {
	public static void main(String[] args) {
		// hypertext transfer protocol
		testProtocol("http://www.adc.org");
		
		// secure http
		testProtocol("https://www.amazon.com/exec/obidos/order2/");
		
		// file transfer protocol
		testProtocol("ftp://ibiblio.org/pub/anguages/java/javafaq/");
		
		// Simple Mail Tranfer Protocol
		testProtocol("mailto:elharo@ibiblio.org");
		
		// telnet
		testProtocol("telnet://dibner.poly.edu/");
		
		// local file access
		testProtocol("gopher://gopher.anc.org.za/");
		
		// LightWweight Directory Access Protocol
		testProtocol("ldap://ldap.itd.umich.edu/o=University%20fo%20Michigan,c=US?postalAdderss");
		
		// JAR
		testProtocol("jar:http://cafeaulait.org/books/javaio/ioexamples/javaio.jar!" + "/com/macfaq/io/StreamCopier.class");
		
		// NFS, Network File System
		testProtocol("nfs://utopia.poly.edu/usr/tmp/");
		
		// a custom protocol for JDBC
		testProtocol("jdbc:mysql://luna.biblio.org:3306/NEWS");
		
		// rmi and JDBC is not supported in java.net
		// rmi, a custom protocol for remote method invocation
		testProtocol("rmi://ibiblio.org/RenderEngine");
		
		// custom protocols for HotJava
		testProtocol("doc:/UsersGuid/release.html");
		testProtocol("netdoc:/UsersGuide/release.html");
		testProtocol("systemresource://www.adc.org/+/index.html");
		testProtocol("verbatim:http://www.adc.org/");
	}
	private static void testProtocol(String url) {
		try {
			URL u = new URL(url);
			// URL's getProtocol
			System.out.println(u.getProtocol() + " is supported");
		// MalformedURLException
		} catch(MalformedURLException ex) {
			String protocol = url.substring(0, url.indexOf(':'));
			System.out.println(protocol + " is not supported");
		}
	}
}
