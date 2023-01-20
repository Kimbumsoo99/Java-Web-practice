package sku.mvc.service;

import java.sql.SQLException;

import sku.mvc.dao.ReplyDAO;
import sku.mvc.dao.ReplyDAOImpl;
import sku.mvc.dto.Reply;

public class ReplyServiceImpl implements ReplyService {
	private ReplyDAO replyDAO = new ReplyDAOImpl();
	
	@Override
	public void insert(Reply reply) throws SQLException {
		// TODO Auto-generated method stub
		int result=replyDAO.insert(reply);
		if(result==0)throw new SQLException("댓글 등록 오류");
	}

	@Override
	public void delete(int replyNum) throws SQLException {
		// TODO Auto-generated method stub
		int result=replyDAO.delete(replyNum);
		if(result==0)throw new SQLException("댓글 삭제 오류");
	}

	@Override
	public Reply selectByNum(int replyNum) throws SQLException {
		Reply reply = replyDAO.selectByNumber(replyNum);
		if(reply==null)
			throw new SQLException("찾는 댓글이 없습니다.");
		return reply;
	}
	
	
}
