package sku.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sku.dao.MemberDAO;

/**
 * Servlet implementation class DeleteMember
 */

@WebServlet(name = "DeleteMember", urlPatterns = { "/deleteMember" }, loadOnStartup = 1)
public class DeleteMember extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteMember() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		System.out.println(id);
		MemberDAO dao = new MemberDAO();
		int dbCheck = dao.deleteUser(id);
		System.out.println("DB 성공 여부 = "+dbCheck);
		resp.sendRedirect("select");
	}

}
