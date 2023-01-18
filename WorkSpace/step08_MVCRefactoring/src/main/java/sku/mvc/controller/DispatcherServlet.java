package sku.mvc.controller;

import java.io.IOException;
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
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String key = request.getParameter("key");
		
		System.out.println("key = " + key);
		
		Controller con = null;
		
		if(key.equals("select")) {
			//기능
			con = new SelectController();
		}else if(key.equals("update")) {
			//기능
			con = new UpdateController();
		}else if(key.equals("delete")) {
			//기능
			con= new DeleteController();
		}else if(key.equals("insert")) {
			con = new InsertController();
		}
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







