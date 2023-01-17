package sku.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sku.dao.MemberDAOimpl;
import sku.dao.MemberResultDAO;
import sku.dto.MemberDTO;

/**
 * Servlet implementation class UpdateFomServlet
 */
@WebServlet(urlPatterns = "/updateForm",loadOnStartup = 1)
public class UpdateFomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		//1.전송된 id 받기
			String id = request.getParameter("id");
			
			//2. DAO 호출
			MemberResultDAO dao = new MemberDAOimpl();
			MemberDTO member = dao.selectById(id);
			
			//3. 호출된 결과에 따라 View 페이지 이동
			String url="error.jsp";
			if(member==null) {
				request.setAttribute("errMsg", id+"에 해당하는 회원 정보가 없습니다.");
			}else {
				request.setAttribute("member", member);
				url="userUpdateForm.jsp";
			}
			request.getRequestDispatcher(url).forward(request, response);
    	}

}
