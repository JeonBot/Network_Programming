// 2016_09_29
// 3-2
// Example
// lab_3_7
// Professor Jung
// This Program is use with lab_3_8(InstanceCallbackDigestUserInterface.java).
// to know callback with instance method.
// this is sub code.

import java.io.*;
import java.security.*;

// use implements Runnable
public class InstanceCallbackDigest implements Runnable {
	private String filename;
	private InstanceCallbackDigestUserInterface callback;
	
	public InstanceCallbackDigest(String filename, InstanceCallbackDigestUserInterface callback) {
		this.filename = filename;
		this.callback = callback;
	}
	
	@Override
	public void run() {
		try {
			FileInputStream in = new FileInputStream(filename);
			MessageDigest sha = MessageDigest.getInstance("SHA-256");
			DigestInputStream din = new DigestInputStream(in, sha);
			while (din.read() != -1);
			din.close();
			byte[] digest = sha.digest();
			// callback from InstanceCallbackDigestUserInterface in receivedigest
			// callback over polling doesn't waste cpu cycle
			callback.receiveDigest(digest);
		// exception is NoSuchAlgorithmException
		} catch (IOException | NoSuchAlgorithmException ex) {
			System.err.println(ex);
		}
	}
}
