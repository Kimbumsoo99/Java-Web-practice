package sku.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sku.dao.MemberDAO;
import sku.dao.MemberDAOimpl;
import sku.dao.MemberResultDAO;
import sku.dto.MemberDTO;

/**
 * 회원가입하기
 */
@WebServlet(urlPatterns = "/insert", loadOnStartup = 1)
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//전송된 데이터받기
		String id = request.getParameter("id");
		int pwd = Integer.parseInt(request.getParameter("pwd"));
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String phone = request.getParameter("phone");
		String addr = request.getParameter("addr");
		//Member생성
		MemberDTO member = new MemberDTO(id, pwd, name, age, phone, addr, null);
		
		//dao 호출
		MemberResultDAO dao = new MemberDAOimpl();
		if(dao.insert(member)==0) {
			//에러페이지 이동
			request.setAttribute("errMsg", "회원가입의 실패하셨습니다.");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		else {
			response.sendRedirect("select"); //SelectAllServlet 으로 이동
		}
		//결과에 따라 이동
	}

}
