// 2016_09_24
// 3-2
// Example
// lab_2
// Professor Jung
// This Program is printed out that input is given by keyboard
// Only FileInputStream, InputStreamReader, BufferdReader, PrintWriter, OutputStreamWriter, System.out, BufferedWriter
//by me
import java.io.*;

public class NoFive {
	public static void main(String[] args) {
		// low java version is possible that method defined by 'try' right part
		try(BufferedReader infile = new BufferedReader(new InputStreamReader(new FileInputStream("NoThree.txt"), "unicode"));
				PrintWriter outfile = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out, "utf8")))) {
			String linebuf;
			while((linebuf = infile.readLine()) != null) {
				outfile.println(linebuf);
			}
		}
		catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
	}
}

//by professor
/*
public
try(bufferedreader infile = new bufferedreader(new inputstreamreader(fileinputstream(filename)',unicode'));
printwriter outfile = new printwriter(new bufferedwriter(new outputstreamwriter(system.out,"utf8")))
)
{
	string linebuf;
	while((linebuf = infile.readLine()) != null){
		outfile.println(linebuf);
	}
	catch(exceptionex){
		System.err.println(ex.getMessage());
	}
}
*/
