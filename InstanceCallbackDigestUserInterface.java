// 2016_09_29
// 3-2
// Example
// lab_3_8
// Professor Jung
// This Program is main program and use with lab_3_7(InstanceCallbackDigest.java).
// to know callback with instance method.
// this is main code.

import javax.xml.bind.*;

public class InstanceCallbackDigestUserInterface {
	private String filename;
	private byte[] digest;
	
	public InstanceCallbackDigestUserInterface(String filename) {
		this.filename = filename;
	}
	
	public void calculateDigest() {
		// called by InstanceCallbackDigest.java
		InstanceCallbackDigest cb = new InstanceCallbackDigest(filename, this);
		// start threads
		Thread t = new Thread(cb);
		t.start();
	}
	
	void receiveDigest(byte[] digest) {
		this.digest = digest;
		System.out.println(this);
	}
	
	@Override
	public String toString() {
		String result = filename + " : ";
		if (digest != null) {
			result += DatatypeConverter.printHexBinary(digest);
		} else {
			result += "digest not available";
		}
		return result;
	}
	
	public static void main(String[] args) {
		for (String filename : args) {
			InstanceCallbackDigestUserInterface d = new InstanceCallbackDigestUserInterface(filename);
			d.calculateDigest();
		}
	}
}