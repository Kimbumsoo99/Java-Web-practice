package sku.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * 로드, 연결, 닫기
 */
public class DBUtil {
	private static DataSource ds; // Connection과 다른곳에서도 다 쓰이기때문에 그 용도로 static과 private 줬음
	/**
	 * DBCP 로드
	 */
	static {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/myoracle");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}// 로드 끝

	/**
	 * 연결
	 * 
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}

	/**
	 * 닫기 (DDL , DML인 경우)
	 */
	public static void dbClose(Connection con, Statement st) {

		try {
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 닫기 (Select인 경우)
	 */
	public static void dbClose(Connection con, Statement st, ResultSet rs) {

		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbClose(con, st);
	}

}
