

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Application Lifecycle Listener implementation class BookAddedListener
 *
 */
public class BookAddedListener implements HttpSessionAttributeListener {

    /**
     * Default constructor. 
     */
    public BookAddedListener() {
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     * 监听器在监听seesion发生add事件后，就输出添加的值
     */
    public void attributeAdded(HttpSessionBindingEvent event)  { 
    	String name = event.getName();
    	Object value = event.getValue();
    	System.out.println("Attribute added: " + name + ":" + value);
    	
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     * 监听器在监听seesion发生remove事件后，就输出添加的值
     */
    public void attributeRemoved(HttpSessionBindingEvent event)  { 
    	String name = event.getName();
    	Object value = event.getValue();
    	System.out.println("Attribute removed: " + name + ":" + value);
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     * 监听器在监听seesion发生replaced事件后，就输出添加的值
     */
    public void attributeReplaced(HttpSessionBindingEvent event)  { 
    	//此处默认方法中返回的是旧值
    	//要获取到被更改后的属性值，需要重新获得session
    	HttpSession session = event.getSession();
    	Object value = session.getAttribute("itemCount");
    	System.out.println("Attribute replaced: itemCount" + ":" + value);
    }
	
}
