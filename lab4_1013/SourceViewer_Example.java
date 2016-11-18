// 2016_10_13
// 3-2
// Example
// lab_5_2
// Professor Jung
// This Program is source viewer.

// http://sejong-help.hongik.ac.kr/
// http://www.hongik.ac.kr/index.do
// https://www.google.co.kr/?gfe_rd=cr&ei=qRD_V9vRMuTN8gekmaqQCw
import java.io.*;
import java.net.*;

public class SourceViewer {
	public static void main(String[] args) {
		if (args.length > 0) {
			InputStream in = null;
			try {
				// Open the URL for reading
				// use openStream
				URL u = new URL(args[0]);
				in = u.openStream();
				// buffer the input to increase performance
				// in = new BufferedInputSream(in);
				// new InputStreamReader(in) == new InputStreamReader(new BufferedInputStream(u.openStream()));
				// InputStreamReader - BufferedInputStream - openStream
				Reader r = new InputStreamReader(new BufferedInputStream(u.openStream()));
				int c;
				while((c = r.read()) != -1) {
					System.out.print((char) c);
				}
			} catch (MalformedURLException ex) {
				System.err.println(args[0] + " is not a arseable URL");
			} catch (IOException ex) {
				System.err.println(ex);
			} finally {
				if (in != null) {
					try {
						in.close();
					} catch (IOException e) {
						// ignore
					}
				}
			}
		}
	}
}
