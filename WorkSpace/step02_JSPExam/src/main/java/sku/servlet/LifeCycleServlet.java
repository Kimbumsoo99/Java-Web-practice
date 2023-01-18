package sku.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet 작성법
 *   - 반드시 public class
 *   - HttpServlet 상속
 *   - 필요한 메소드 재정의한다.
 *   
 *   - 중요
 *     : 작성된 서블릿 생서 + 브라우저에서 요청됐을때 실행될 수 있도록 실행필요
 *     : 방법
 *       1) web.xml문서에 설정
 *       2) @annotation으로 설정
 * */
public class LifeCycleServlet extends HttpServlet {
	
	public LifeCycleServlet() {
		System.out.println("LifeCycleServlet의 생성자..");
	}
	
	
	@Override
	public void init() throws ServletException {
		System.out.println("LifeCycleServlet init() call...");
	}
	
	/*@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LifeCycleServlet의 service 호출..");
	}*/

	/*@Overridepage language="java" contentType="text/html; charset=UTF-8"
		    pageEncoding="UTF-8"*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		System.out.println("LifeCycleServlet의 doGet 호출..");
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>Servlet연습중</title></head>");
		out.println("<body>");
		
		out.println("<h1>Have a nice day!!</h1>");
		out.println("<hr color='red'>");
		out.println("<h4 style='color:blue'>서블릿은 화면구성하기 불편해요.</h4>");
		out.println("<script>");
		out.println("alert('쉬고 싶지요??')");
		out.println("</script>");
		out.println("</body>");
		out.println("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LifeCycleServlet의 doPost 호출..");
	}



	@Override
	public void destroy() {
		System.out.println("LifeCycleServlet의 destroy 호출");
	}
	
}
