package sku.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sku.dto.MemberDTO;
import sku.util.DBUtil;

public class MemberDAOimpl implements MemberResultDAO {

	@Override
	public List<MemberDTO> selectAll() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;	//select니까 있어야함
		
		List<MemberDTO> memberlist = new ArrayList<>();
		String sql = "select * from member order by join_date desc";
		try {
			//로드
			//연결
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			//?가 있다면 set 필요하다.
			rs=ps.executeQuery();
			
			while(rs.next()) {	//커서가 앞으로 이동한다면(데이터가있다면인듯?)
				//각행의 열을 조회 (여기 적는 이름은 col 명이기때문에 DB에 이름을 넣어야한다.
				//실행
				MemberDTO member = new MemberDTO(rs.getString(1), rs.getInt("pwd"), 
						rs.getString(3), rs.getInt("AGE"), rs.getString(5), rs.getString(6),
						rs.getString("join_date"));
				
				System.out.println(member);
				memberlist.add(member);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			//닫기
			DBUtil.dbClose(con, ps, rs);
		}//메소드 끝
		return memberlist;
	}

	@Override
	public int insert(MemberDTO member) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;

		String sql = "insert into member(id,pwd,name,age,phone,addr, join_date)"
				+ "values(?,?,?,?,?,?, sysdate)";
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			//?의 개수만큼 순서대로 setXx() 설정
			ps.setString(1, member.getId());
			ps.setInt(2, member.getPwd());
			ps.setString(3, member.getName());
			ps.setInt(4, member.getAge());
			ps.setString(5, member.getPhone());
			ps.setString(6, member.getAddr());
			//실행
			result = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int delete(String id) {
		return 0;
	}

	@Override
	public MemberDTO select(String id) {
		return null;
	}

	@Override
	public List<MemberDTO> selectByFieldAndWord(String keyFiled, String keyWord) {
		return null;
	}

}
