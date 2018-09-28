

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
     */
    public void attributeAdded(HttpSessionBindingEvent event)  { 
    	String name = event.getName();
    	Object value = event.getValue();
    	System.out.println("Attribute added: " + name + ":" + value);
    	
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent event)  { 
    	String name = event.getName();
    	Object value = event.getValue();
    	System.out.println("Attribute removed: " + name + ":" + value);
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent event)  { 
    	HttpSession session = event.getSession();
    	Object value = session.getAttribute("itemCount");
    	System.out.println("Attribute replaced: itemCount" + ":" + value);
    }
	
}
