package sku.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class RequestEventListener
 *
 */
@WebListener
public class RequestEventListener implements ServletRequestListener {

    public RequestEventListener() {
    	System.out.println("리퀘스트 생성자 호출");
    }


    public void requestDestroyed(ServletRequestEvent sre)  { 
    	System.out.println("리퀘스트 종료될때");
    }


    public void requestInitialized(ServletRequestEvent sre)  { 
    	System.out.println("리퀘스트 시작될때");
    }
	
}
