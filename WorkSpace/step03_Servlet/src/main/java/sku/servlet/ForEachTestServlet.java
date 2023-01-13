package sku.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sku.vo.Board;

/**
 * Servlet implementation class ForEachTestServlet
 */
@WebServlet(name = "ForEachTest", urlPatterns = { "/forEach" }, loadOnStartup=1)
public class ForEachTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ForEachTestServlet() {
    	System.out.println("foreachTest 생성자 호출");
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//List 생성 후 -> 뷰 전달
		List<Board> boardList = new ArrayList<>();
		boardList.add(new Board(10, "작성자", "제목", "내용"));
		boardList.add(new Board(10, "가나다", "JSTL", "라이브러리"));
		boardList.add(new Board(10, "라마바", "JSP", "태그"));
		boardList.add(new Board(10, "아자차", "JDK", "이게뭐지"));
		boardList.add(new Board(10, "카타파", "JAVA", "언어"));
		boardList.add(new Board(10, "하기니", "XML", "마크업"));
		boardList.add(new Board(10, "디리미", "AXAS", "비동기"));
		boardList.add(new Board(10, "비시이", "Servlet", "웹자바"));
		boardList.add(new Board(10, "지치키", "JSP", "하이"));
		boardList.add(new Board(10, "티피히", "EL", "표기"));
		boardList.add(new Board(10, "홍행홍", "Eclipse", "툴"));
		boardList.add(new Board(10, "김범수", "Oracle", "데이터베이스"));
		boardList.add(new Board(10, "안지윤", "SQL", "데이터베이스"));
		boardList.add(new Board(10, "요호호", "SQL", "헬롱"));
		
		
	}

}
