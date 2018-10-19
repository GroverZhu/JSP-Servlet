package ex5;

/**
 * -*- encoding:UTF-8 -*-
 * 
 * @author GroverZhu 使用count实现访问界面的次数
 */
public class StatisticInfo {

	private static int count = 1;

	public static synchronized int getCount() {

		return count++;
	}

}