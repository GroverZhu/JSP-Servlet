package ex3;

public class StasticInfo {
	private static int count = 0;
	
	public static synchronized int getCount() {
		count++;
		return count;
	}
}
