// 2016_09_24
// 3-2
// Example
// lab_2
// Professor Jung
// This Program is printed out that input is given by keyboard
// Only System.in/out
// But I use a few STREAM
// by me
import java.io.*;

public class NoOne {
	public static void main(String[] args) throws IOException {
		String input;
		// input
		System.out.print("input your Keyboard : ");
		InputStreamReader ISR = new InputStreamReader(System.in);
		BufferedReader BR = new BufferedReader(ISR);
		input = BR.readLine();
		System.out.println("Your Input : " + input);	
	}
}

/*
// by Professor ... 0922
public class JavaStreams {
	public static void main(String[] args){
		byte[] linebuf = new byte[1024];
		int n;
		try {
			while((n = System.in.read(linebuf)) >= 0) {
				System.out.write(linebuf,0,n);
			}
		}
		catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
	}
}
*/
