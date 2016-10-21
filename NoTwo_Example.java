// 2016_09_24
// 3-2
// Example
// lab_2
// Professor Jung
// This Program is printed out that input is given by keyboard
// Only System.in/out, BufferedReader and InputStreamReader
// User -> System.in -> InputStreamReader -> BufferedReader
// One Stream use another Stream's parameters
// Like InputStreamReader(System.in) And BufferReader(ISR)
// by me
import java.io.*;

public class NoTwo {
	public static void main(String[] args) {
		String input;
		// Request input
		System.out.print("input your Keyboard : ");
		// Use InputStreamReader, input for ISR
		InputStreamReader ISR = new InputStreamReader(System.in);
		// ISR is into Buffer, So BufferReader's name is BR
		BufferedReader BR = new BufferedReader(ISR);
		try {
			// There is input in BufferR, So use readLine in BufferR
			input = BrR.readLine();
			// Print
			System.out.println("Your Input : " + input);	
		}
		catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
	}
}
/*
// by Professor ... 0922
public class NoTwo {
	public static void main(String[] args) {
		String linebuf;
	
		try {
			BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
			while((linebuf = stdin.readLine()) != null) {
				System.out.println(linebuf);
			}
		} catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
	}
}
*/
