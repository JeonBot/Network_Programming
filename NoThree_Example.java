// 2016_09_24
// 3-2
// Example
// lab_2
// Professor Jung
// This Program is printed out that input is given by keyboard
// Only System.in, FileOutputStream
// One Stream use another Stream's parameters
// Like InputStreamReader(System.in) And BufferReader(ISR)
//by me
import java.io.*;

public class NoThree {
	public static void main(String[] args) {
		int n;
		System.out.print("input your Keyboard : ");
		try {
			FileOutputStream FileOS = new FileOutputStream("NoThree.txt");
                             // Input
			while((n = System.in.read())!=-1) {
				FileOS.write(n);
			}
		}
		catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
	}
}

/*
// by Professor ... 0922
public class NoThree {
	public static void main(String[] args) {
                   // Use buffer
		byte[] linebuf = new byte[1024];
		int n;

		try(FileOutputStream outfile = new FileOutputStream("NoThreePro.txt")) {
			try {
				while((n = System.in.read(linebuf)) >= 2) {
					outfile.write(linebuf, 0, n);
				}
			}
			catch(Exception ex) {
				System.err.println(ex.getMessage());
			}
                             // Need to close
			try {
				outfile.close();
			}
			catch(Exception ex) {
				System.err.println(ex.getMessage());
			}
		} catch(Exception ex) {
				System.err.println(ex.getMessage());
		}
	}
}
*/
