package ex3;

public class StasticInfo {
	
	//声明静态类变量
	//用来计算访问该网页的次数
	private static int count = 0;
	
	//加上同步锁，强制为串行化执行
	public static synchronized int getCount() {
		count++;
		return count;
	}
}
