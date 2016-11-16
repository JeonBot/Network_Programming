// 2016_09_29
// 3-2
// Example
// lab_3_9
// Professor Jung
// This Program is sub program and use with lab_3_10(MultithreadedMaxFinder.java).
// this is sub code.

import java.util.concurrent.Callable;

class FindMaxTask implements Callable<Integer> {
	private int[] data;
	private int start;		
	private int end;
	
	FindMaxTask(int[] data, int start, int end) {
		this.data = data;			
		this.start = start;
		this.end = end;
	}
		
	public Integer call() {
		int max = Integer.MIN_VALUE;
		for(int i = start; i < end; i++) {
			if (data[i] > max) max = data[i];
		}
		return max;
	}
}
