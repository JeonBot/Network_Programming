// 2016_10_02
// 3-2
// Assignment 1(Chapter 2)
// Professor Jung
// This program is ...
// 1) Write user's input to a compressed and encrypted file.
// 2) Read a user specified file, which is compressed and encrypted file, and show on the screen.
// But I did combine 1) and 2).
// For your information.

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;

public class TotalInputCipherZip {
	public static void main(String[] args) {
		try {
			String key = "NetworkN"; // DES 8 bytes
			// Input
			System.out.print("Plz Input your Keyboard for .txt contents : ");
			// Make a txt file
			MakeFile();
			System.out.println("파일생성...");
			// Encrypt
			FileInputStream FIS = new FileInputStream("B289086_Input.txt");
			FileOutputStream FOS = new FileOutputStream("B289086_Input_to_Encrypted.txt");
			Encrypt_INPUTTXT(key, FIS, FOS);
			System.out.println("암호화완료...");
			// Zip
			Zip();
			System.out.println("압축완료...");
			System.out.println("1) Write user's input to a compressed and encrypted file. Complete.");
			// UnZip
			UnZip();
			System.out.println("압축해제...");
			// Decrypt
			FileInputStream FIS1 = new FileInputStream("B289086_Input_to_Encrypted.txt");
			FileOutputStream FOS1 = new FileOutputStream("UnZip_B289086_Input_Encrypted_to_Decrypted.txt");
			Decrypt_UNZIPTXT(key, FIS1, FOS1);
			System.out.println("복호화완료...");
			FOS1.close();
			FIS1.close();
			FOS.close();
			FIS.close();
			// PrintScreen
			PrintDecrypted();
			System.out.println("2) Read a user specified file, which is compressed and encrypted file, and show on the screen. Complete.");
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public static void MakeFile() {
		try {
			int len;
			FileOutputStream FOS = new FileOutputStream("B289086_Input.txt");
			while((len = System.in.read()) != 13) {
				FOS.write(len);
			}
			FOS.close();
		}
		catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
	}
	public static void Zip() {
		File FT = new File("B289086_Input_to_Encrypted.txt");
		File FZ = new File("B289086_Input_to_Encrypted_Zip.zip");
		try {
			ZipOutputStream ZOS = new ZipOutputStream(new FileOutputStream(FZ));
			BufferedInputStream BIS = new BufferedInputStream(new FileInputStream(FT));
			ZOS.putNextEntry(new ZipEntry(FT.toString()));

			int len;
			byte[] linebufs = new byte[1024];
			while((len = BIS.read(linebufs)) > 0) {
				ZOS.write(linebufs, 0, len);
			}
			ZOS.closeEntry();
			BIS.close();
			ZOS.close();
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
	    }
	}
	public static void UnZip() {
		File FZ = new File("B289086_Input_to_Encrypted_Zip.zip");
		try {
			FileInputStream FIS = new FileInputStream(FZ);
			ZipInputStream ZIS = new ZipInputStream(FIS);
			ZipEntry ZE = null;
			while((ZE = ZIS.getNextEntry()) != null) {
				FileOutputStream FOS = new FileOutputStream("UnZip_"+ZE.getName());
				
				int len = 0;
				while ((len = ZIS.read()) != -1) {
					FOS.write(len);
				}
			}
			ZIS.close();
			FIS.close();
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
	    }
	}
	public static void PrintDecrypted() throws IOException {
		File F = new File("UnZip_B289086_Input_Encrypted_to_Decrypted.txt");
		FileInputStream FIS;
		System.out.print("Decrypted Result : ");
		try {
			FIS = new FileInputStream(F);
			int n;
			while((n = FIS.read())!=-1) {
				System.out.write(n);
			}
			FIS.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
	}
	public static void Encrypt_INPUTTXT(String key, InputStream IS, OutputStream OS) throws Throwable {
		DESKeySpec DKS = new DESKeySpec(key.getBytes());
		SecretKeyFactory SKF = SecretKeyFactory.getInstance("DES");
		SecretKey SK = SKF.generateSecret(DKS);
		Cipher cipher = Cipher.getInstance("DES"); // DES/ECB/PKCS5Padding for SunJCE
		cipher.init(Cipher.ENCRYPT_MODE, SK);
		CipherInputStream CIS = new CipherInputStream(IS, cipher);
		CryptoWorking(CIS, OS);
	}
	public static void Decrypt_UNZIPTXT(String key, InputStream IS, OutputStream OS) throws Throwable {
		DESKeySpec DKS = new DESKeySpec(key.getBytes());
		SecretKeyFactory SKF = SecretKeyFactory.getInstance("DES");
		SecretKey SK = SKF.generateSecret(DKS);
		Cipher cipher = Cipher.getInstance("DES"); // DES/ECB/PKCS5Padding for SunJCE
		cipher.init(Cipher.DECRYPT_MODE, SK);
		CipherOutputStream COS = new CipherOutputStream(OS, cipher);
		CryptoWorking(IS, COS);
	}
	public static void CryptoWorking(InputStream IS, OutputStream OS) throws IOException {
		byte[] linebuf = new byte[1024];
		int len;
		while ((len = IS.read(linebuf)) != -1) {
			OS.write(linebuf, 0, len);
		}
		OS.flush();
		OS.close();
		IS.close();
	}
}
