package sku.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sku.dto.EmpDTO;
import sku.util.DBUtil;

public class TestDAO {
	/**
	 * emp의 전체검색
	 */
	public List<EmpDTO> selectAll() {
		// 로드, 연결, 실행, 닫기(이미 다 했음)
		// 로드 여기서 받아놔야 finally scope에서 받을 수 있따.
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<EmpDTO> list = new ArrayList<>();
		String sql = "select empno, ename, job, hiredate, sal from emp";
		try {
			// 연결
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			// 쿼리에 ?가 있다면 ?의 개수만큼 순서대로 setXxx() 필요

			// 실행
			rs = ps.executeQuery();
			while (rs.next()) {
				// 열의 정보 조회
				int empno = rs.getInt(1);
				String ename = rs.getString(2);
				String job = rs.getString(3);
				String hiredate = rs.getString(4);
				int sal = rs.getInt(5);
				
				//자바의 객체 생성
				EmpDTO emp = new EmpDTO(empno, ename, job, hiredate, sal);
				
				//list에 추가
				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 닫기
			DBUtil.dbClose(con, ps, rs);
		}
		return list;
	}
}
