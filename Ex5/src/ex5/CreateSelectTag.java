package ex5;

import java.io.IOException;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

/**
 * -*- encoding:UTF-8 -*-
 * 
 * @author GroverZhu 通过simple tag 来显示option
 */
public class CreateSelectTag extends SimpleTagSupport {

	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		String outPrint = "";
		String[] color = { "light", "amber", "brown", "dark" };
		outPrint += "<select name='color' size='1'>";
		for (int i = 0; i < color.length; i++) {
			outPrint += "<option>";
			outPrint += color[i];
			outPrint += "</option>";
		}
		outPrint += "</select>";
		out.print(outPrint);
	}
}