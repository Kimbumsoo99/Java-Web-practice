package sku.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sku.mvc.dto.Reply;
import sku.mvc.service.ReplyService;
import sku.mvc.service.ReplyServiceImpl;

public class ReplyController implements Controller {

	private ReplyService replyService = new ReplyServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String replyWriteUser = request.getParameter("replyWriteUser");
		String modelNum=request.getParameter("modelNum");
		String replyContent=request.getParameter("replyContent");
		
		Reply reply = new Reply(0, replyContent, null, replyWriteUser, modelNum);
 		
		replyService.insert(reply);
		
		request.setAttribute("reply", reply);
		
		return new ModelAndView("front?key=elec&methodName=selectByModelNum&modelNum="+reply.getParentModelNum(),true);
	}

	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String replyWriteUser = request.getParameter("replyWriteUser");
		String modelNum=request.getParameter("modelNum");
		String replyContent=request.getParameter("replyContent");
		int replyNum = Integer.parseInt(request.getParameter("replyNum"));
		Reply reply = replyService.selectByNum(replyNum);
		replyService.delete(replyNum);	
		return new ModelAndView("front?key=elec&methodName=selectByModelNum&modelNum="+reply.getParentModelNum(),true);
	}
}
