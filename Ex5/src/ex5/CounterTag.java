package ex5;

import java.io.IOException;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

/**
 * -*- encoding:UTF-8 -*-
 * 
 * @author GroverZhu 使用simple tag来记住访问该页面的次数
 */
public class CounterTag extends SimpleTagSupport {

	private static int counter = 1;

	public void doTag() throws JspException, IOException {
		getJspContext().getOut().print(counter);
		counter++;
	}
}