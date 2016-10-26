// 2016_09_29
// 3-2
// Example
// lab_3_1
// Professor Jung
// This Program is printed that contented text file is called.
// MessegeDigest is setting secure method to SHA-256 and written by DigestInputStream(text file, secure method) and saved by array digest
// : is added plus content is added by DatatypeConverter's printHexBinary too and print

import java.io.*;
import java.security.*;
import javax.xml.bind.*;

// this is DigetstThread
public class DigestThread extends Thread {
	private String filename;
	
	public DigestThread(String filename) {
		this.filename = filename;
	}
	
	@Override
	public void run() {
		try {
			// No3-12.txt call itself
			FileInputStream in = new FileInputStream(filename);
			// MessageDigetst.getInstance is set integrity method(¹«°á¼º)
			// new is always produce object
			// but getInstance is caching(just call once. - singleton pattern)
			MessageDigest sha = MessageDigest.getInstance("SHA-256");
			// DigestInputStream's parameters are use called file and MD
			DigestInputStream din = new DigestInputStream(in, sha);
			
			// write
			while (din.read() != -1);
			din.close();
			// sha digest method is stored in digest array
			byte[] digest = sha.digest();
			
			StringBuilder result = new StringBuilder(filename);
			
			// add to result. : and DatatypeConverter.printHexBinary(array)
			result.append(" : ");
			// use DatatypeConverter. print to HexBinary
			result.append(DatatypeConverter.printHexBinary(digest));
			// print
			System.out.println(result);
		} catch (IOException ex) {
			System.err.println(ex);
		} catch (NoSuchAlgorithmException ex) {
			System.err.println(ex);
		}
	}
	
	public static void main(String[] args) {
		// filename is *.txt
		for (String filename : args) {
			// Thread t is produced by DigestThread method with filename
			Thread t = new DigestThread(filename);
			// t.start is running run method
			t.start();
		}
	}
}
