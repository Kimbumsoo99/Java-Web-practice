package sku.mvc.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import sku.mvc.dto.Reply;
import sku.mvc.util.DbUtil;

public class ReplyDAOImpl implements ReplyDAO {
	private Properties proFile = new Properties();

	public ReplyDAOImpl() {
		try {
			InputStream is = getClass().getClassLoader().getResourceAsStream("dbQuery.properties");
			proFile.load(is);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insert(Reply reply) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "insert into replies values(replies_num_seq.nextval , ?, sysdate ,?, ?)";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, reply.getReplyContent());
			ps.setString(2, reply.getReplyWriteUser());
			ps.setString(3, reply.getParentModelNum());
			System.out.println("reply.getReplyContent() : " + reply.getReplyContent());
			System.out.println("reply.getReplyWriteUser() : " + reply.getReplyWriteUser());
			System.out.println("reply.getParentModelNum() : " + reply.getParentModelNum());

			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int delete(int replyNum) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "delete replies where reply_num=?";
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1, replyNum);
			result=ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public Reply selectByNumber(int replyNum) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Reply reply = null;
		String sql = "select * from replies where reply_num=?";
		try {
			con = DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1, replyNum);
			rs=ps.executeQuery();
			if(rs.next()) {
				reply = new Reply(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return reply;
	}

}
