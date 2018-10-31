package ex6;

/**
 * 对应数据库中的beer表
 * 
 * @author GroverZhu
 *
 */
public class Beer {

	private int id; // Beer ID
	private String name; // Beer name
	private String manufacture; // Beer manufacture
	private String color; // Beer color
	private int count = 1; // total number of selected beer

	/**
	 * initial the beer information
	 * 
	 * @param id
	 * @param name
	 * @param manufacture
	 * @param color
	 */
	public Beer(int id, String name, String manufacture, String color, int count) {
		this.id = id;
		this.name = name;
		this.manufacture = manufacture;
		this.color = color;
		this.count = count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getCount() {
		return this.count;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getColor() {
		return this.color;
	}

	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}

	public String getManufacture() {
		return this.manufacture;
	}
}
