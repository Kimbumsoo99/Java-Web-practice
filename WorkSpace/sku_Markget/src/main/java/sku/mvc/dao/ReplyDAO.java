package sku.mvc.dao;

import java.sql.SQLException;

import sku.mvc.dto.Reply;

public interface ReplyDAO {
	int insert(Reply reply) throws SQLException;
	int delete(int replyNum) throws SQLException;
	Reply selectByNumber(int replyNum)throws SQLException;
}
