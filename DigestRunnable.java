// 2016_09_29
// 3-2
// Example
// lab_3_2
// Professor Jung
// This Program is similar to DigestThread.java.
// but this source code is use implements Runnable.

import java.io.*;
import java.security.*;
import javax.xml.bind.*;

// this is DigestRunnable and implements Runnable
public class DigestRunnable implements Runnable{
	private String filename;
	
	public DigestRunnable(String filename) {
		this.filename = filename;
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
			
			StringBuilder result = new StringBuilder(filename);
			result.append(" : ");
			result.append(DatatypeConverter.printHexBinary(digest));
			// add println
			System.out.println(result);
		} catch (IOException ex) {
			System.err.println(ex);
		// exception is NoSuchAlgorithmException
		} catch (NoSuchAlgorithmException ex) {
			System.err.println(ex);
		}
	}
	
	public static void main(String[] args) {
		for (String filename : args) {
			// use DigestRunnable
			DigestRunnable dr = new DigestRunnable(filename);
			// use Thread by dr instead of Digest-
			Thread t = new Thread(dr);
			t.start();
		}
	}
}