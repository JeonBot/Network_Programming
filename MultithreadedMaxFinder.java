// 2016_09_29
// 3-2
// Example
// lab_3_10
// Professor Jung
// This Program is main program and use with lab_3_9(FindMaxTask.java).
// this is main code.

import java.util.concurrent.*;

public class MultithreadedMaxFinder {
	public static int max(int[] data) throws InterruptedException, ExecutionException {
		if (data.length == 1) {
			return data[0];
		} else if (data.length == 0) {
			throw new IllegalArgumentException();
		}
		
		// call FindMaxTask
		// split the job into 2 pieces
		// data's start ~ half
		FindMaxTask task1 = new FindMaxTask(data, 0, data.length/2);
		// data's half ~ end
		FindMaxTask task2 = new FindMaxTask(data, data.length/2, data.length);
		
		// spawn 2 threads by ExecutorService service = Excecutors.newFixedThreadPool
		ExecutorService service = Executors.newFixedThreadPool(2);
		
		// submit callable FindMaxTask
		Future<Integer> future1 = service.submit(task1);
		Future<Integer> future2 = service.submit(task2);
		
		return Math.max(future1.get(), future2.get());
		
	}
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		int[] data = {1,2,3,4,5,6,7,8,9,10};
		System.out.println(max(data));
	}
}