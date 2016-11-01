// 2016_10_06
// 3-2
// Example
// lab_4_12
// Professor Jung
// This Program is main program and use with lab_4_11(LookupTask.java).
// this is main code.

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

// Requires Java 7 for try-with-resources and multi-catch
public class PooledWeblog {
	// NUM_THREADS is changeable
	// many threads are up to speed
	private final static int NUM_THREADS = 16;
	public static void main(String[] args) throws IOException {
		// executor is produce threadpool
		ExecutorService executor = Executors.newFixedThreadPool((NUM_THREADS));
		Queue<LogEntry> results = new LinkedList<LogEntry>();
		
		// FileInputStream - InputStreamReader - BufferedReader
		try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(args[0]), "UTF-8"));) {
			for (String entry = in.readLine(); entry != null; entry = in.readLine()) {
				LookupTask task = new LookupTask(entry);
				Future<String> future = executor.submit(task);
				LogEntry result = new LogEntry(entry, future);
				results.add(result);
			}
		} catch (IOException exx) {
			System.out.println("error");
		}
		
		// Start printing the results. This blocks each time a result isn't ready.
		for (LogEntry result : results) {
			try {
				System.out.println(result.future.get());
			} catch (InterruptedException | ExecutionException ex) {
				System.out.println(result.original);
			}
		}
		System.out.println("--------------------------------------theee eeend----------------------------------------------------------------------------------------");
		// CPU specification i7 3770 quad
		// sample.log 8 line
		// thread 1ea 77sec
		// thread 4ea 18sec 
		// thread 8ea 12sec
		// thread 16ea 10sec
		// thread 20ea 6sec
		// thread 32ea 1sec
		executor.shutdown();
	}
	
	private static class LogEntry {
		String original;
		Future<String> future;
		
		LogEntry(String original, Future<String> future) {
			this.original = original;
			this.future = future;
		}
	}
}
