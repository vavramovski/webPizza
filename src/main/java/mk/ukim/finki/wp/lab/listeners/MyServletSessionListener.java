package mk.ukim.finki.wp.lab.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashMap;

@WebListener
public class MyServletSessionListener implements HttpSessionListener {
    public static HashMap<String, HttpSession>sessionHashMap = new HashMap<>();
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("[WP-log] sessionCreated ID = "+ se.getSession().getId());
        sessionHashMap.putIfAbsent(se.getSession().getId(),se.getSession());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("[WP-log] sessionDestroyed");
    }
}