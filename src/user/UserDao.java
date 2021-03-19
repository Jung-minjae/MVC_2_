package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import Contents.jdbcUtil;

import Contents.ConnectionProvider;
import Contents.Content;

public class UserDao {
	private static UserDao instance = new UserDao();

	public static UserDao getInstance() {
		return instance;
	}

	public int login(String userID, String userPass) { // login
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		String SQL = "SELECT userPass FROM user WHERE userID = ? ";

		try {
			conn=ConnectionProvider.getConnection();
			psmt = conn.prepareStatement(SQL);
			psmt.setString(1, userID);

			rs = psmt.executeQuery();
			if (rs.next()) {
				if (rs.getString(1).equals(userPass)) {
					return 1; //
				} else {
					return 0; //
				}
			}
			return -1; //
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(psmt);
			jdbcUtil.close(conn);
		}
		return -2; //
	}

	public int join(User user) {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String SQL = "INSERT INTO user VALUES(?,?,?,?,?,?)";
		try {
			conn=ConnectionProvider.getConnection();
			psmt = conn.prepareStatement(SQL);	
			psmt.setString(1, user.getUserID());
			psmt.setString(2, user.getUserPass());
			psmt.setString(3, user.getUserName());
			psmt.setString(4, user.getUserGender());
			psmt.setString(5, user.getUserEmail());
			psmt.setString(6, user.getUserPhone());
			return psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();

		
	} finally {
		jdbcUtil.close(rs);
		jdbcUtil.close(psmt);
		jdbcUtil.close(conn);
	}
		return -1;
	}

	public int idCheck(String userID) {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		int value = 0;

		try {
			String sql = "select userID from user where userID = ?";
		
			conn = ConnectionProvider.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userID);
			System.out.println(psmt);
			rs = psmt.executeQuery();

			if (rs.next())
				value = 1;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(psmt);
			jdbcUtil.close(conn);
		}
		return value;
	}
}
