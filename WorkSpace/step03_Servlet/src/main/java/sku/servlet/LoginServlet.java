package sku.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	String dbId="Kim" , dbPwd="1234";
	public LoginServlet() {
		System.out.println("LoginServlet 생성자 호출");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("LoginServlet init() 호출");
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//브라우저에서 한글 띄우기 위해 사용(스크립트)
		res.setContentType("text/html; charset=UTF-8");
		System.out.println("서비스 호출");
		//post방식 한글 인코딩설정
		req.setCharacterEncoding("UTF-8");
		//전송된 정보를 받는다.
		String userId = req.getParameter("userId");
		String userPwd = req.getParameter("userPwd");
		String userName = req.getParameter("userName");
		
		System.out.println(userId + ", "+ userPwd +", "+ userName);
		//받은 정보가 일치하는지 확인하고 아니면 오류메시지, 맞으면 성공페이지 이동
		if(dbId.equals(userId) && dbPwd.equals(userPwd)) {
			//성공페이지 이동
			//1. redirect방식
			//res.sendRedirect("loginOk.jsp);
			//res.sendRedirect("loginOk.jsp?userName="+userName);
			//2. forward방식
			req.getRequestDispatcher("loginOk.jsp").forward(req, res);
		}else {
			//오류메시지
			PrintWriter out = res.getWriter();
			out.println("<script>");
			out.println("alert('"+ userName +"님 정보를 다시 확인해주세요!');");	
			//out.println("location.href='LoginForm.html';");
			out.println("history.back();");
			out.println("</script>");			
//			res.sendRedirect("LoginForm.html");
		}
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LoginServlet doGet 호출");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LoginServlet doPost 호출");
	}
}
