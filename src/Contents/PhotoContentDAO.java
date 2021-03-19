package Contents;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Comment.commentDTO;

public class PhotoContentDAO {
	// instance 생성
	private static PhotoContentDAO instance = new PhotoContentDAO();

	public static PhotoContentDAO getInstance() {
		return instance;
	}

	// 검색이 포함된 리스트
	public List<PhotoContentDTO> getPhotoList() {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		List<PhotoContentDTO> list = new ArrayList<PhotoContentDTO>();

		String sql = "select * from Pcontent";

		try {
			conn = ConnectionProvider.getConnection();
			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();

			while (rs.next()) {
				String pid = rs.getString("pid");
				String pname = rs.getString("pname");
				String content = rs.getString("content");
				String category = rs.getString("category");
				int price = rs.getInt("price");
				Date regDate = rs.getDate("regdate");
				String delFlag = rs.getString("delFlag");
				String Path = rs.getString("path");

				PhotoContentDTO pd = new PhotoContentDTO(pid, pname, content, category, price, regDate, delFlag, Path);
				list.add(pd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(psmt);
			jdbcUtil.close(conn);
		}
		return list;
	}

	public PhotoContentDTO getPhotoDetail(String id) {
		String sql = "select *from Pcontent where pid=?";
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		PhotoContentDTO pd = null;
		try {
			conn = ConnectionProvider.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();

			while (rs.next()) {
				String pid = rs.getString("pid");
				String pname = rs.getString("pname");
				String content = rs.getString("content");
				String category = rs.getString("category");
				int price = rs.getInt("price");
				Date regDate = rs.getDate("regdate");
				String delFlag = rs.getString("delFlag");
				String Path = rs.getString("path");

				pd = new PhotoContentDTO(pid, pname, content, category, price, regDate, delFlag, Path);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(psmt);
			jdbcUtil.close(conn);
		}
		return pd;
	}

	public int getcommentCount(String pid) {

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		int count = 0;

		String sql = "select count(wid)as count from comment where pid=?";

		try {
			conn = ConnectionProvider.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pid);
			rs = psmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(psmt);
			jdbcUtil.close(conn);
		}
		return count;
	}

	public List<commentDTO> getcommentList(String id) {

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		List<commentDTO> list = new ArrayList<commentDTO>();
		String sql = "select *from comment where pid=?";

		try {
			conn = ConnectionProvider.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();

			while (rs.next()) {
				int wid = rs.getInt("wid");
				String pid = rs.getString("pid");
				String comment = rs.getString("comment");
				int Score = rs.getInt("score");
				Date regDate = rs.getDate("regdate");
				String userID = rs.getString("userID");
				String delFlag = rs.getString("delFlag");

				commentDTO cd = new commentDTO(wid, pid, comment, Score, regDate, userID, delFlag);
				list.add(cd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(psmt);
			jdbcUtil.close(conn);
		}
		return list;
	}

	public int insertComment(commentDTO cd) {
		Connection conn = null;
		PreparedStatement psmt = null;
		int result = 0;
		String sql = "insert into comment(pid,comment,score,userID) values(?,?,?,?)";

		try {
			conn = ConnectionProvider.getConnection();
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, cd.getPid());
			psmt.setString(2, cd.getComment());
			psmt.setInt(3, cd.getScore());
			psmt.setString(4, cd.getUserID());
			psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			jdbcUtil.close(psmt);
			jdbcUtil.close(conn);
		}
		return result;
	}

}
