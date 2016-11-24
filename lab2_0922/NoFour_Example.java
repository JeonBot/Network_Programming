// 2016_09_24
// 3-2
// Example
// lab_2
// Professor Jung
// This Program is printed out that input is given by keyboard
// Only System.out, FileInputStream
//by me
import java.io.*;

public class NoFour {
	public static void main(String[] args) {
		int n;

		try {
			File file = new File("NoThree.txt");
			FileInputStream FileIS = new FileInputStream("NoThree.txt");
			
			while((n = FileIS.read())!=-1) {
				System.out.write(n);	
			}
			// print Filelength
			System.out.println("File byte is " + file.length());
		}
		catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
	}
}

//by Professor ... 0922 ... 
