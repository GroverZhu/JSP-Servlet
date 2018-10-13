package ex4;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
/**
 * @author GroverZhu
 * counter用来记住访问该网页的次数
 * 通过simple tag 标签
 *
 */
public class CounterSimpleTag extends SimpleTagSupport {
	
	private static int counter = 1;
	
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		out.print(this.getCounter());
		this.setCounter();
	}
	
	public void setCounter() {
		counter++;
	}
	
	public int getCounter() { 
		return counter;
	}

}
