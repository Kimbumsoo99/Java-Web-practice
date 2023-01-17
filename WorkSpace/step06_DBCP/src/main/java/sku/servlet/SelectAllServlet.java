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
 * Servlet implementation class SelectAllServlet
 */
@WebServlet(urlPatterns="/select", loadOnStartup = 1)	//기본하나만 있으면 urlPatterns = "/select" 인것
public class SelectAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//dao를 호출
		MemberResultDAO memberDao = new MemberDAOimpl();
		List<MemberDTO> memberList = memberDao.selectAll(); 	//전체검색
		
		System.out.println(memberList);
		//뷰쪽에 전달할 정보 저장
		request.setAttribute("member", memberList);  //뷰에서 ${list}
		
		//이동
		request.getRequestDispatcher("memberSelect.jsp").forward(request, response);
	}

}
