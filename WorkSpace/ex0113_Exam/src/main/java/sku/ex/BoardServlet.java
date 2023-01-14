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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		System.out.println("init 호출");
		ServletContext application = super.getServletContext();
		
		List<BoardDTO> boardList = new ArrayList<>();
		boardList.add(new BoardDTO(10,"제목", "내용"));
		boardList.add(new BoardDTO(10, "JSTL", "라이브러리"));
		boardList.add(new BoardDTO(10,  "JSP", "태그"));
		
		application.setAttribute("boardList", boardList);  
		
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
