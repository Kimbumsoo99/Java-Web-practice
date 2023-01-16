package sku.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppListener implements ServletContextListener {

	public AppListener() {
		System.out.println("AppListener 생성");
	}


	/**
	 * 서버가 시작될때
	 */
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("AppListener 서버 실행");
		//서버가 시작될때 해야할 작업을 여기서 한다.
	}
	
	/**
	 * 서버가 종료될때
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("AppListener 서버 종료");
	}


}
