package sku.ex;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sku.vo.BoardDTO;



/**
 * Servlet implementation class BoardServlet
 */
@WebServlet(name = "BoardServlet", urlPatterns = { "/board" }, loadOnStartup=1 )
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<BoardDTO> boardList = new ArrayList<>();


	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		System.out.println("BoardServlet init 호출");
		ServletContext application = super.getServletContext();

		boardList.add(new BoardDTO(10,"제목", "내용"));
		boardList.add(new BoardDTO(20, "JSTL", "라이브러리"));
		boardList.add(new BoardDTO(30,  "JSP", "태그"));
		
		application.setAttribute("boardList", boardList);  
		
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = super.getServletContext();
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		int gno = Integer.parseInt(request.getParameter("gno")); 
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		boardList.add(new BoardDTO(gno,subject,content));
		//application.setAttribute("boardList", boardList);	//이게 없어도 상관이없다함 왜냐면 이미 application은 board를 가리키고있으니까
		
		response.sendRedirect("center.jsp");
	}

}
