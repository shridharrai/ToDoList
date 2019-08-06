package com.brainmentors.todolist.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ServerStartAndDownListener
 *
 */
@WebListener
public class ServerStartAndDownListener 
implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ServerStartAndDownListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent
    		arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("Server Down");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(
    		ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	for(int i =1;i<=100; ++i) {
    		System.out.println("Caching "+i);
//    		try {
//				Thread.sleep(350);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
    	}
    }
	
}
