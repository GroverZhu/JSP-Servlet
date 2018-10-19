package ex5;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class CharResponseWrapper extends HttpServletResponseWrapper {
	protected CharArrayWriter charWriter;
	protected PrintWriter writer;
	protected boolean getOutputStreamCalled;
	protected boolean getWriterCalled;
	
	public CharResponseWrapper(HttpServletResponse response) {
		super(response);
		
		// 创建writer
		charWriter = new CharArrayWriter();
	}
	
	/**
	 * 重载getOutoutStream()方法
	 */
	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		// 如果getWriter()方法被调用，就不能调用getOutputStream()方法
		if (getWriterCalled) {
			throw new IllegalStateException("getWriter already called");
		}
		getOutputStreamCalled = true;
		return super.getOutputStream();
	}
	
	/**
	 * 重载getWriter()方法
	 */
	@Override
	public PrintWriter getWriter() throws IOException {
		if (writer != null) {
			return writer;
		}
		// 如果getOutputStream()方法被调用了，就不能调用getWriter()
		if (getOutputStreamCalled) {
			throw new IllegalStateException("getOutputStream already called");
		}
		getWriterCalled = true;
		writer = new PrintWriter(charWriter);
		return writer;
	}
	
	/**
	 * 将响应的数据用字符串返回
	 */
	public String toString() {
		String s = null;
		if (writer != null) {
			s = charWriter.toString();
		}
		return s;
	}
}
