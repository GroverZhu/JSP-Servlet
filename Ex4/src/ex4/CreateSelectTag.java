package ex4;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class CreateSelectTag extends TagSupport{
	
	/**
	 * 将原先的option做成Tag标签
	 */
	public int doStartTag() throws JspException {

		try {
			JspWriter out = pageContext.getOut();
			String outPrint = "";
			String[] colors = {"light","amber","brown","dark"};
			outPrint += "<select name='color' size='1'>";
			for (String color : colors) {
				outPrint += "<option>";
				outPrint += color;
				outPrint += "</option>";
			}
			outPrint += "</select>";
			out.print(outPrint);
		} catch (java.io.IOException e) {
			throw new JspTagException(e.getMessage());
		}
		return SKIP_BODY;
	}

}
