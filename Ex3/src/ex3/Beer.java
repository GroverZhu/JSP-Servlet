package ex3;

public class Beer {

	// 定义私有属性color
	private String color;

	// 定义无参构造函数
	public Beer() {
		this.color = null;
	}

	/**
	 * 有参构造函数
	 * 
	 * @param color
	 */
	public Beer(String color) {
		this.color = color;
	}

	/**
	 * 设置color的值
	 * 
	 * @param color
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * 返回color的值
	 * 
	 * @return color
	 */
	public String getColor() {
		return this.color;
	}

}
