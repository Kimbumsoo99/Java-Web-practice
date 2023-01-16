package sku.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionEvnetListener
 *
 */
@WebListener
public class SessionEvnetListener implements HttpSessionListener {


    public SessionEvnetListener() {
    	System.out.println("SeesionEventListener 생성자 호출");
    }

    /**
     * 세션이 시작될 때
     * */   
    public void sessionCreated(HttpSessionEvent se)  { 
    	System.out.println("SeesionEventListener 시작 호출");
    }

    /**
     * 세션이 종료될 때
     * 1) session-timeout 일때
     * 2) session.invaildate() 호출
     * 3) 주의 : 브라우져의 x를 클릭하면 호출안된다.
     * */
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	System.out.println("SeesionEventListener 종료 호출");
    }
	
}
