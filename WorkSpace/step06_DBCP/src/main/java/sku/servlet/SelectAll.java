package sku.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sku.dao.MemberDAO;
import sku.dto.MemberDTO;

/**
 * Servlet implementation class SelectAll
 */
@WebServlet(name = "SelectAll", urlPatterns = { "/selectAll" }, loadOnStartup=1)
public class SelectAll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO dao = new MemberDAO();
		List<MemberDTO> list = dao.selectAll();
		request.setAttribute("member", list);
		request.getRequestDispatcher("memberSelect.jsp").forward(request, response);
	}

}
