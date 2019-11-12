package mk.ukim.finki.wp.lab.listeners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class RequestListener implements ServletRequestListener {
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();

        System.out.println("[WP-Log] path: " + request.getRequestURI() + " method= " + request.getMethod());
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {

    }
}
