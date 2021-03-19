package Contents;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Comment.commentDTO;

public class ContentsDao {
	private static ContentsDao instance = new ContentsDao();

	public static ContentsDao getInstance() {
		return instance;
	}

	public String getDate() {
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		String SQL = "SELECT NOW()";
		try {
			con = ConnectionProvider.getConnection();
			psmt = con.prepareStatement(SQL);
			rs = psmt.executeQuery();
			if (rs.next()) {
				return rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
	         jdbcUtil.close(rs);
	         jdbcUtil.close(psmt);
	         jdbcUtil.close(con);
	      }
		return "";
	}

	public int getNext() {
		String SQL = "select contentID from contents order by contentID desc";
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			con = ConnectionProvider.getConnection();
			psmt = con.prepareStatement(SQL);
			rs = psmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1) + 1;
			}
			return 1; //

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
	         jdbcUtil.close(rs);
	         jdbcUtil.close(psmt);
	         jdbcUtil.close(con);
	      }
		return -1;
	}

	public int write(String Title, String userID, String Content) {
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String SQL = "INSERT INtO contents (title, userId, Content) VALUES (?,?,?)";
		System.out.println(Title);
		try {
			con = ConnectionProvider.getConnection();
			psmt = con.prepareStatement(SQL);
			psmt.setString(1, Title);
			psmt.setString(2, userID);
			psmt.setString(3, Content);

			return psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
	         jdbcUtil.close(rs);
	         jdbcUtil.close(psmt);
	         jdbcUtil.close(con);
	      }
		return -1; //
	}

	public ArrayList<Content> getList(int pageNumber) {
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		int start = 1 + (pageNumber - 1) * 10;
		int end = pageNumber * 10;

		String SQL = "Select * from (Select @rownum:=@rownum+1 as num, n.* from(select * from contents order by contentID desc)n, "
				+ "(select @rownum:=0)v)num Where num.num between ? and ?";
		ArrayList<Content> list = new ArrayList<Content>();
		try {
			con = ConnectionProvider.getConnection();
			psmt = con.prepareStatement(SQL);
			psmt.setInt(1, start);
			psmt.setInt(2, end);
			rs = psmt.executeQuery();

			while (rs.next()) {
				int contentID = rs.getInt("contentID");
				String Title = rs.getString("Title");
				String userID = rs.getString("userID");
				String content = rs.getString("content");
				Date date = rs.getDate("date");
				int Available = rs.getInt("Available");
				Content ct = new Content(contentID, Title, userID, content, date, Available);
				list.add(ct);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
	         jdbcUtil.close(rs);
	         jdbcUtil.close(psmt);
	         jdbcUtil.close(con);
	      }
		return list;
	}

	public boolean nextPage(int pageNumber) {
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String SQL = "select *from contents where contentID < ? and Available =1 ";

		try {
			con = ConnectionProvider.getConnection();
//			System.out.println("GET NEXT : "+getNext()+"!!!!!!!!");
			psmt = con.prepareStatement(SQL);
			psmt.setInt(1, getNext() - (pageNumber - 1) * 10);
			rs = psmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
	         jdbcUtil.close(rs);
	         jdbcUtil.close(psmt);
	         jdbcUtil.close(con);
	      }
		return false;
	}

	// �ۺ���
	public Content getContents(int contentID) {
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String SQL = "select *from contents where contentID =?";

		try {
			con = ConnectionProvider.getConnection();
			psmt = con.prepareStatement(SQL);
			psmt.setInt(1, contentID);
			rs = psmt.executeQuery();
			if (rs.next()) {
				Content ct = new Content();
				ct.setContentID(rs.getInt(1));
				ct.setTitle(rs.getString(2));
				ct.setUserID(rs.getString(3));
				ct.setDate(rs.getDate(4));
				ct.setContent(rs.getString(5));
				ct.setAvailable(rs.getInt(6));
				return ct;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
	         jdbcUtil.close(rs);
	         jdbcUtil.close(psmt);
	         jdbcUtil.close(con);
	      }
		return null;
	}

	public int update(int ContentID, String Title, String Content) {
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		int result = 0;
		
		String SQL = "update contents set title =?, content =? where contentID=?";
		try {
			con = ConnectionProvider.getConnection();
			psmt = con.prepareStatement(SQL);
			psmt.setString(1, Title);
			psmt.setString(2, Content);
			psmt.setInt(3, ContentID);
			psmt.executeUpdate();
			result = 1;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
	         jdbcUtil.close(rs);
	         jdbcUtil.close(psmt);
	         jdbcUtil.close(con);
	      }
		return result;
	}

	public int delete(int ContentID) {
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		int result = 0;
		String SQL = "delete from contents where contentID=?";
		try {
			con = ConnectionProvider.getConnection();
			psmt = con.prepareStatement(SQL);
			psmt.setInt(1, ContentID);
			psmt.executeUpdate();
			result = 1;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
	         jdbcUtil.close(rs);
	         jdbcUtil.close(psmt);
	         jdbcUtil.close(con);
	      }
		return result;
	}

	public int getCount() {
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		int count = 0;
		
		String SQL = "Select count(num.contentID) as count from(Select @rownum:=@rownum+1 as num , "
				+ "n.* from(select * from contents)n Where (@rownum:=0)=0) num";
		try {
			con = ConnectionProvider.getConnection();
			psmt = con.prepareStatement(SQL);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				count = rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
	         jdbcUtil.close(rs);
	         jdbcUtil.close(psmt);
	         jdbcUtil.close(con);
	      }
		return count;
	}

	public ArrayList<Content> getSelectList(int pageNumber, String f, String q) {
		
		System.out.println("getSelectList 들어옴 ");
		
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		int start = 1 + (pageNumber - 1) * 10;
		int end = pageNumber * 10;
		
		String SQL = "Select * from (Select @rownum:=@rownum+1 as num, n.* "
				+ "from(select * from contents where " + f +" like '" + q + "' order by contentID desc)n, "
				+ "(select @rownum:=0)v)num Where num.num between ? and ?";

		ArrayList<Content> list = new ArrayList<Content>();
		try {
			System.out.println("쿼리문");
			con = ConnectionProvider.getConnection();
			psmt = con.prepareStatement(SQL);
			psmt.setInt(1, start);
			psmt.setInt(2, end);
			rs = psmt.executeQuery();
			
			System.out.println(SQL);
			while (rs.next()) {
				int contentID = rs.getInt("contentID");
				System.out.println("contentID : " + contentID);
				String Title = rs.getString("Title");
				String userID = rs.getString("userID");
				String content = rs.getString("content");
				Date date = rs.getDate("date");
				int Available = rs.getInt("Available");
				Content ct = new Content(contentID, Title, userID, content, date, Available);
				list.add(ct);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
	         jdbcUtil.close(rs);
	         jdbcUtil.close(psmt);
	         jdbcUtil.close(con);
	      }
		return list;
	}

	public int getSelectCount(String f, String q) {
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		int count = 0;
		
		String SQL = "Select count(num.contentID) as count from(Select @rownum:=@rownum+1 as num , "
				+ "n.* from(select * from contents where " + f + " like '" + q + "')n Where (@rownum:=0)=0) num";
		try {
			con = ConnectionProvider.getConnection();
			psmt = con.prepareStatement(SQL);
			rs = psmt.executeQuery();
			while(rs.next()) {
				count = rs.getInt("count");
				System.out.println("디비의 count : " + count);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
	         jdbcUtil.close(rs);
	         jdbcUtil.close(psmt);
	         jdbcUtil.close(con);
	      }
		return count;
	}
	
	
	
	public List<Content> getDetail(int ContentID) {
		
		List<Content> list = new ArrayList<Content>();
		
		String sql = "select * from contents where ContentID=?";
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			conn = ConnectionProvider.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, ContentID);
			rs = psmt.executeQuery();

			while (rs.next()) {
				Content cd = new Content();
				ContentID = rs.getInt("ContentID");
				String Title = rs.getString("Title");
				String userID = rs.getString("userID");
				String content = rs.getString("content");
				Date regDate = rs.getDate("Date");
				int Available = rs.getInt("Available");

				cd = new Content(ContentID, Title, userID, content, regDate, Available);
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
