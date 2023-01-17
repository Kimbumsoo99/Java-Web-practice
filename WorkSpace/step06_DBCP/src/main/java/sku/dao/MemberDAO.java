package sku.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sku.dto.EmpDTO;
import sku.dto.MemberDTO;
import sku.util.DBUtil;

public class MemberDAO {
	List<MemberDTO> list = new ArrayList<>();

	/**
	 * emp의 전체검색
	 */
	public List<MemberDTO> selectAll() {
		// 로드, 연결, 실행, 닫기(이미 다 했음)
		// 로드 여기서 받아놔야 finally scope에서 받을 수 있따.
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "select id, pwd, name, age, phone, addr, join_date from member";
		try {
			// 연결
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			// 쿼리에 ?가 있다면 ?의 개수만큼 순서대로 setXxx() 필요

			// 실행
			rs = ps.executeQuery();
			while (rs.next()) {
				// 열의 정보 조회
				String id = rs.getString(1);
				int pwd = rs.getInt(2);
				String name = rs.getString(3);
				int age = rs.getInt(4);
				String phone = rs.getString(5);
				String addr = rs.getString(6);
				String joinDate = rs.getString(7);

				// 자바의 객체 생성
				MemberDTO member = new MemberDTO(id, pwd, name, age, phone, addr, joinDate);

				// list에 추가
				list.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 닫기
			DBUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	public int createUser(MemberDTO member) {
		// 로드, 연결, 실행, 닫기(이미 다 했음)
		// 로드 여기서 받아놔야 finally scope에서 받을 수 있따.
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;

		String sql = "insert into member(id, pwd, name, age, phone, addr, join_date) " + "values('" + member.getId()
				+ "','" + member.getPwd() + "','" + member.getName() + "'," + member.getAge() + ",'" + member.getPhone()
				+ "','" + member.getAddr() + "',sysdate)";
		System.out.println(sql);
		try {
			// 연결
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			// list에 추가 ( 할 필요 없었음)
			list.add(member);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 닫기
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

	public int deleteUser(String id) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "DELETE FROM member WHERE id = ?";
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			System.out.println(sql);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}
}
