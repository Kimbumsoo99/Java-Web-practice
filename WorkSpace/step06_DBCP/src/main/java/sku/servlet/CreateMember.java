package sku.servlet;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sku.dao.MemberDAO;
import sku.dto.MemberDTO;

/**
 * Servlet implementation class CreateMember
 */
@WebServlet(name = "CreateMember", urlPatterns = { "/createMember" }, loadOnStartup=1)
public class CreateMember extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CreateMember() {
        super();
        // TODO Auto-generated constructor stub
    }


	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter fomatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String id = req.getParameter("id");
		int pwd = Integer.parseInt(req.getParameter("pwd"));
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		String phone = req.getParameter("phone");
		String addr = req.getParameter("addr");
		//System.out.println(now.format(fomatter));
		String joinDate =  now.format(fomatter);
		MemberDTO member = new MemberDTO(id, pwd, name, age, phone, addr, joinDate);

		MemberDAO dao = new MemberDAO();
		int dbCheck = dao.createUser(member);
		System.out.println("DB 성공 여부 = "+dbCheck);
		resp.sendRedirect("selectAll");
	}

}
