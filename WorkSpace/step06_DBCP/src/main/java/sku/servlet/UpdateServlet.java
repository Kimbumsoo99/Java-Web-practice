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
 * Servlet implementation class UpdateServlet
 */
@WebServlet(urlPatterns = "/update", loadOnStartup = 1)
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.전송된 id 받기
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String addr = request.getParameter("addr");
		System.out.println(id+" "+name+" "+age+" "+addr);
		// 2. DAO 호출
		MemberResultDAO dao = new MemberDAOimpl();
		MemberDTO member = dao.selectById(id);
		member.setName(name);
		member.setAge(age);
		member.setAddr(addr);
		// 3. 호출된 결과에 따라 View 페이지 이동
		if (dao.update(member) == 0) {
			request.setAttribute("errMsg", id + "에 해당하는 회원 정보가 없습니다.");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		} else {
			response.sendRedirect("detail?id="+id);
		}
	}
}
