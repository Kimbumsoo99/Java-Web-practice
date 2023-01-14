package sku.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "LoginServlet", urlPatterns = { "/login" }, loadOnStartup=1 )
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String dbId="Kim" , dbPwd="1234";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        System.out.println("LoginServlet 생성자 호출");
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		System.out.println("서비스 호출");
		
		String userId = request.getParameter(dbId);
		String userPwd = request.getParameter(dbPwd);
		
		if(dbId.equals(userId) && dbPwd.equals(userPwd)) {
			request.getRequestDispatcher("left.jsp").forward(request, response);
			
		}
		else {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('확인되지 않은 유저입니다!');");
			out.println("history.back();");
			out.println("</script>");
			
		}
		
	}

}
