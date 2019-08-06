package com.brainmentors.todolist.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionCount
 *
 */
@WebListener
public class SessionCount implements HttpSessionListener {
	public static int usercount;

    /**
     * Default constructor. 
     */
    public SessionCount() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    	usercount++;
    	System.out.println("Session created "+usercount);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    	usercount--;
    	System.out.println("Session destroyed "+usercount);
    }
	
}
