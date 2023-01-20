package sku.mvc.service;

import java.sql.SQLException;

import sku.mvc.dto.Reply;

public interface ReplyService {
	void insert(Reply reply) throws SQLException;
	
	void delete(int replyNum) throws SQLException;
	
	Reply selectByNum(int replyNum) throws SQLException;
}
