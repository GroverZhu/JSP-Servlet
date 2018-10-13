package ex4;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;;
/**
 * 
 * @author GroverZhu
 * 使用simple tag 将option通过标签的方法显示
 * 
 */
public class CreateSelectSimpleTag extends SimpleTagSupport {
	/**
	 * 将html中的option做成simple tag
	 * 
	 */
	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		String outPrint = "";
		String[] colors = { "light", "amber", "brown", "dark" };
		outPrint += "<select name='color' size='1'>";
		for (String color : colors) {
			outPrint += "<option>";
			outPrint += color;
			outPrint += "</option>";
		}
		outPrint += "</select>";
		out.print(outPrint);
	}

}
