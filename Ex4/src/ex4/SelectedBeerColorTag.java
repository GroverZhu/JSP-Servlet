
package ex4;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
/**
 * 
 * @author GroverZhu
 * 打印出所有的已经选择过的beer color
 */
public class SelectedBeerColorTag extends SimpleTagSupport {
	
	//定义传值参数
	private String selectedColors;
	
	
	public void setSelectedColors(String selectedColors) {
		this.selectedColors = selectedColors;
	}
	public void doTag() throws JspException, IOException {
		try {
				System.out.println(selectedColors);
				
				// 将String转换为StringTokenizer，通过分隔符“,”来分隔字符
				StringTokenizer colors = new StringTokenizer(selectedColors, ",");
				System.out.println(colors.countTokens());
				
				// 对应每一个beer color 对应一个counter
				// 用来记住选择过相同beer color选择过的次数
				int lightCounter = 0;
				int amberCounter = 0;
				int brownCounter = 0;
				int darkCounter = 0;
				
				// 记录每次选择相同beer color的次数
				// 由于dark beer在跳转的过程中没有到DisplayItem.jsp
				// 所以dark beer 不会显示存储到string里
				while (colors.hasMoreTokens()) {
					String color = colors.nextToken();
					if (color.equals("light")) {
						lightCounter++;
						System.out.println(colors.countTokens());
					} else if (color.equals("amber")) {
						amberCounter++;
						System.out.println(colors.countTokens());
					} else if (color.equals("brown")) {
						brownCounter++;
						System.out.println(colors.countTokens());
					} else {
						darkCounter++;
						System.out.println(colors.countTokens());
					}
				}
				// 获取输出
				JspWriter out = getJspContext().getOut();
				
				// 选择的次数不为0再输出
				if (lightCounter != 0) {
					out.print("light " + lightCounter);
					out.print("<br>");
				}
				
				if (amberCounter != 0) {
					out.print("amber " + amberCounter);
					out.print("<br>");
				}
				if (brownCounter != 0) {
					out.print("brown " + brownCounter);
					out.print("<br>");
				}
				if (darkCounter != 0) {
					out.print("dark " + darkCounter);
					out.print("<br>");
				}
		} catch (NullPointerException e) {
			System.out.println("Null Pointer");
			
		}
	}
}
