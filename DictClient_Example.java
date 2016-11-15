// 2016_11_03
// 3-2
// Example
// lab_8_4
// Professor Jung
// This Program is fd-eng-lat type searching dic.

import java.io.*;
import java.net.Socket;
import java.io.*;

public class DictClient {
	public static final String SERVER = "dict.org";
	public static final int PORT = 2628;
	public static final int TIMEOUT = 15000;

	public static void main(String[] args) {
		Socket socket = null;
		try {
			socket = new Socket(SERVER, PORT);
			socket.setSoTimeout(TIMEOUT);
			OutputStream out = socket.getOutputStream();
			Writer writer = new OutputStreamWriter(out,"UTF-8");
			writer = new BufferedWriter(writer);
			InputStream in = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
			
			for (String word : args) {
				define(word, writer, reader);
			}
			writer.write("quit\r\n");
			writer.flush();
		} catch (IOException ex) {
			System.err.println(ex);
		} finally { // dispose
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException ex) {
					// ignore
				}
			}
		}
	}
	
	static void define(String word, Writer writer, BufferedReader reader) throws IOException, UnsupportedEncodingException {
		writer.write("DEFINE fd-eng-lat " + word + "\r\n"); // eng-lat to fd-eng-lat
		writer.flush();
		
		for (String line = reader.readLine(); line != null; line = reader.readLine()) {
			if (line.startsWith("250 ")) { // ok
				return;
			} else if (line.startsWith("552 ")) { // no match
				System.out.println("\nNo definition found for " + word + "\n");
				return;
			}
			else if (line.matches("\\d\\d\\d .*")) continue;
			else if (line.trim().equals(".")) continue;
			else System.out.println(line);
		}
	}
}