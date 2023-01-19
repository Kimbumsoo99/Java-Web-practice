package sku.mvc.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import sku.mvc.dto.Electronics;
import sku.mvc.dto.Reply;
import sku.mvc.dto.UserDTO;
import sku.mvc.paging.PageCnt;
import sku.mvc.util.DbUtil;

public class ElectronicsDAOImpl implements ElectronicsDAO {
  private Properties proFile = new Properties();
	
	public ElectronicsDAOImpl() {
		try {
			//dbQuery를 준비한 ~.properties파일을 로딩해서 Properties 자료구조에 저장한다.
			
			//현재 프로젝트가 런타임(실행)될때, 즉 서버가 실행될때 classes폴더의 위치를
			//동적으로 가져와서 경로를 설정해야한다.
			InputStream is = getClass().getClassLoader().getResourceAsStream("dbQuery.properties");
			proFile.load(is);
			
			System.out.println("query.select = " +proFile.getProperty("query.select"));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Electronics> selectAll() throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Electronics> list = new ArrayList<Electronics>();
		
		String sql= proFile.getProperty("query.select");//select * from Electronics  order by writeday desc
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Electronics electonics = 
				new Electronics(rs.getString(1), rs.getString(2), rs.getInt(3),
						rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7), rs.getInt(8),
						rs.getString(9), rs.getInt(10));
				
			   list.add(electonics);
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public List<Electronics> getBoardList(int pageNo) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Electronics> list = new ArrayList<Electronics>();
		
		String sql= proFile.getProperty("query.pagingSelect");//select * from  (SELECT a.*, ROWNUM rnum FROM (SELECT * FROM Electronics ORDER BY writeday desc) a) where  rnum>=? and rnum <=? 
		try {
			
			
			con = DbUtil.getConnection();
			con.setAutoCommit(false);
			
			//전체레코드수를 구한다.
			int totalCount = this.getTotalCount(con);
			int totalPage = totalCount%PageCnt.pagesize==0 ? totalCount/PageCnt.pagesize : (totalCount/PageCnt.pagesize)+1;
			
			PageCnt pageCnt = new PageCnt();
			pageCnt.setPageCnt(totalPage);
			pageCnt.setPageNo(pageNo);
			
			ps = con.prepareStatement(sql);
			//? 2개에 set설정
			ps.setInt(1, (pageNo-1) * pageCnt.pagesize +1); //시작
			ps.setInt(2, pageNo * pageCnt.pagesize);//끝
			
			rs = ps.executeQuery();
			while(rs.next()) {
				Electronics electonics = 
				new Electronics(rs.getString(1), rs.getString(2), rs.getInt(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7),
						rs.getString(8), rs.getInt(9));
				
			   list.add(electonics);
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}
	
	
	/**
	 * 전체레코드 수 검색하기
	 * */
	private int getTotalCount(Connection con) throws SQLException{
		PreparedStatement ps=null;
		ResultSet rs=null;
		int result=0;
		String sql= proFile.getProperty("query.totalCount");//select count(*) from Electronics
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}finally {
			DbUtil.dbClose(null, ps, rs);
		}
		return result;
	}

	@Override
	public Electronics selectByModelNum(String modelNum) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Electronics electronics = null;
		
		String sql= proFile.getProperty("query.selectBymodelNum");//select * from Electronics where model_num=?
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, modelNum);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				electronics = new Electronics(rs.getString(1), rs.getString(2), rs.getInt(3),
						rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7), rs.getInt(8),
						rs.getString(9), rs.getInt(10));
				
				//댓글정보 검색!!!
				electronics.setRepliesList(this.getReply(con, modelNum));
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return electronics;
	}
	
	/**
	 * 댓글정보 가져오기 
	 * */
	private List<Reply> getReply(Connection con , String modelNum)throws SQLException{
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Reply> list = new ArrayList<Reply>();
		String sql=proFile.getProperty("query.replyByParentNum");//select * from replies where parent_model_num=?
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, modelNum);
			rs = ps.executeQuery();
			while(rs.next()) {
				Reply reply = new Reply(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				list.add(reply);
			}
			
		}finally {
			DbUtil.dbClose(null, ps, rs);
		}
		return list;
	}
	

	@Override
	public int increamentByReadnum(String modelNum) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql= proFile.getProperty("query.updateReadnum");//update Electronics set readnum=readnum+1 where model_num=?
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, modelNum);
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}
	

	@Override
	public int insert(Electronics electronics) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql= "insert into Electronics values(?,?,?,?,?,sysdate,?,0,?,?)";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, electronics.getModelNum());
			ps.setString(2, electronics.getModelName());
			ps.setInt(3, electronics.getPrice());
			ps.setString(4, electronics.getDescription());
			ps.setString(5, electronics.getPassword());
			ps.setString(6, electronics.getWriteUser());
			ps.setString(7, electronics.getFname());
			ps.setInt(8, electronics.getFsize());
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}
	

	@Override
	public int delete(String modelNum, String password) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql= proFile.getProperty("query.delete");//delete Electronics where model_num=? and password=?
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, modelNum);
			ps.setString(2, password);
			System.out.println("가나"+modelNum+password);
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int update(Electronics electronics) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql= proFile.getProperty("query.update");//update Electronics set model_name=?,price=?,description=? where model_num=? and password=?
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, electronics.getModelName());
			ps.setInt(2, electronics.getPrice());
			ps.setString(3, electronics.getDescription());
			ps.setString(4, electronics.getModelNum());
			ps.setString(5, electronics.getPassword());
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}//updateEnd
	
}//클래스끝
