package sku.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sku.dao.MemberDAOimpl;
import sku.dao.MemberResultDAO;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet(urlPatterns = "/delete", loadOnStartup = 1)
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		
		MemberResultDAO dao = new MemberDAOimpl();
		if(dao.delete(id)==0) {
			req.setAttribute("errMsg", id+"회원 삭제되지 않았습니다.");
			req.getRequestDispatcher("error.jsp").forward(req, resp);
		}
		else {
			resp.sendRedirect("select");
		}
		
		
	}
}
