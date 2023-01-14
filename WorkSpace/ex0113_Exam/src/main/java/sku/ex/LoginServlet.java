package sku.ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

		//SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		
		HttpSession session = request.getSession();
		System.out.println("서비스 호출");
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		
		if(dbId.equals(userId) && dbPwd.equals(userPwd)) {
			session.setAttribute("userId", userId);
			session.setAttribute("userPwd", userPwd);
			
			long loginTime = session.getLastAccessedTime(); 
			SimpleDateFormat sf1 = new SimpleDateFormat("yyyy. M. d.");
			SimpleDateFormat sf2 = new SimpleDateFormat("a h:m:s");			
			String date = sf1.format(new Date(loginTime));
			String time = sf2.format(new Date(loginTime));
			session.setAttribute("date", date);
			session.setAttribute("time", time);
			response.sendRedirect("left.jsp");
			//request.getRequestDispatcher("center.jsp").forward(request, response);
			//request.getRequestDispatcher("left.jsp").forward(request, response);
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
