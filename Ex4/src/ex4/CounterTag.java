package ex4;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
/**
 * @author GroverZhu
 * 通过counter来记住访问界面的次数
 * 使用classic tag在jsp界面上使用 
 *
 */
public class CounterTag extends TagSupport {
	private static int counter = 1;
	 
	/**
	 * 对访问该页面的计数
	 * @return SKIP_BODY
	 */
	public int doStartTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();
			out.print(counter);
			setCounter();
		} catch (java.io.IOException e) {
			throw new JspTagException(e.getMessage());
		}
		return SKIP_BODY;
		
	}
	
	public int getCounter() {
		return counter;
	}
	
	public void setCounter() {
		counter++;
	}

}
