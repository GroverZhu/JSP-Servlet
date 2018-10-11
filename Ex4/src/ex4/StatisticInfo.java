package ex4;

public class StatisticInfo {

	public static int count = 0;
	
	public static synchronized int getCount() {
		count++;
		return count;
	}
}
