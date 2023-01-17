package sku.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sku.dao.MemberDAOimpl;
import sku.dao.MemberResultDAO;
import sku.dto.MemberDTO;

/**
 * Servlet implementation class SearchByServlet
 */
@WebServlet(urlPatterns = "/searchBy",loadOnStartup = 1)
public class SearchByServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//전송된 데이터 2개 받기
		String keyField = request.getParameter("keyField");
		String keyWord = request.getParameter("keyWord");
		
		MemberResultDAO dao = new MemberDAOimpl();
		List<MemberDTO> list = dao.selectByFieldAndWord(keyField, keyWord);
		
		//뷰쪽에 전달될 값
		request.setAttribute("member", list);
		//이동
		request.getRequestDispatcher("memberSelect.jsp").forward(request, response);
	}

}
