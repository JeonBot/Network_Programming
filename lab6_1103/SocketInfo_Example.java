// 2016_11_03
// 3-2
// Example
// lab_8_6
// Professor Jung
// This Program can know host's port using socket getInetAddress() and socket getPort().

import java.net.*;
import java.io.*;

public class SocketInfo {
	public static void main(String[] args) {
		for(String host : args) {
			try {
				Socket theSocket = new Socket(host, 80);
				System.out.println("Connected to " + theSocket.getInetAddress() + " on port " + theSocket.getPort() + " from port " + theSocket.getLocalPort() + " of " + theSocket.getLocalAddress());	
			} catch (UnknownHostException ex) {
				System.err.println("I can't find " + host);
			} catch (SocketException ex) {
				System.err.println("Could not connect to " + host);
			} catch (IOException ex) {
				System.err.println(ex);
			}
		}
	}
}
