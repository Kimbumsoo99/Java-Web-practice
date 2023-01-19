package sku.mvc.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import sku.mvc.dto.UserDTO;
import sku.mvc.util.DbUtil;

public class UserDAOImpl implements UserDAO {
	private Properties proFile = new Properties();

	public UserDAOImpl() {
		try {
			// dbQuery를 준비한 ~.properties파일을 로딩해서 Properties 자료구조에 저장한다.

			// 현재 프로젝트가 런타임(실행)될때, 즉 서버가 실행될때 classes폴더의 위치를
			// 동적으로 가져와서 경로를 설정해야한다.
			InputStream is = getClass().getClassLoader().getResourceAsStream("dbQuery.properties");
			proFile.load(is);

			System.out.println("query.userlogin = " + proFile.getProperty("query.userlogin"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public UserDTO loginCheck(UserDTO userDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserDTO dbDTO = null;

		String sql = proFile.getProperty("query.userlogin");// select * from users where user_id=? and pwd=?
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userDTO.getUserId());
			ps.setString(2, userDTO.getPwd());
			
			System.out.println(userDTO.getPwd()+userDTO.getPhone());
			rs = ps.executeQuery();
			if (rs.next()) {
				dbDTO = new UserDTO(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
			}

		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return dbDTO;
	}
	
	@Override
	public int joinUser(UserDTO userDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = proFile.getProperty("query.userjoin");// insert into users values(?,?,?)
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userDTO.getUserId());
			ps.setString(2, userDTO.getPwd());
			ps.setString(3, userDTO.getName());
			ps.setString(4, userDTO.getAge());
			ps.setString(5, userDTO.getPhone());
			ps.setString(6, userDTO.getAddr());

			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public UserDTO selectById(String id) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserDTO dbDTO = null;
		
		String sql = "select * from users where user_id=?";
		try {
			con = DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, id);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				dbDTO = new UserDTO(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return dbDTO;
	}

	@Override
	public int updateUser(UserDTO userDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "update users set name=?,age=?,phone=?,addr=? where user_id=?";
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, userDTO.getName());
			ps.setString(2, userDTO.getAge());
			ps.setString(3, userDTO.getPhone());
			ps.setString(4, userDTO.getAddr());
			ps.setString(5, userDTO.getUserId());
			
			result=ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

}
