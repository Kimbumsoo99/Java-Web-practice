package sku.mvc.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 모든 사용자 요청을 처리할 진입점 Controller의 역할
 */
@WebServlet(urlPatterns = "/front" , loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Map<String, Controller> map;
	
	@Override
	public void init() throws ServletException {
		ServletContext application = super.getServletContext();
		map = (Map<String, Controller>)application.getAttribute("map");
	}
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String key = request.getParameter("key");
		System.out.println("key = " + key);
		Controller con = map.get(key);
		
		/////////////////////////////////////////////////////////
		//호출
		ModelAndView mv = con.handleRequest(request, response);
		if(mv.isRedirect()) {
			response.sendRedirect( mv.getViewName() );
		}else {
			request.getRequestDispatcher(mv.getViewName()).forward(request, response);
		}
		
	}//service끝

}







