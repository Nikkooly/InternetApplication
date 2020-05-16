package listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class L2 implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(final HttpSessionBindingEvent event) {
        System.out.println("SessionListener: attributeAdded: attributeID = " + event.getSession().getId());
        System.out.println("SessionListener: attributeAdded: attributeName = " + event.getName());
        System.out.println("SessionListener: attributeAdded: attributeValue = " + event.getValue());
    }

    @Override
    public void attributeRemoved(final HttpSessionBindingEvent event) {
        System.out.println("SessionListener: attributeRemoved: attributeID = " + event.getSession().getId());
        System.out.println("SessionListener: attributeRemoved: attributeName = " + event.getName());
        System.out.println("SessionListener: attributeRemoved: attributeValue = " + event.getValue());
    }

    @Override
    public void attributeReplaced(final HttpSessionBindingEvent event) {
        System.out.println("SessionListener: attributeReplaced: attributeID = " + event.getSession().getId());
        System.out.println("SessionListener: attributeReplaced: attributeName = " + event.getName());
        System.out.println("SessionListener: attributeReplaced: attributeValue = " + event.getValue());
    }
}
