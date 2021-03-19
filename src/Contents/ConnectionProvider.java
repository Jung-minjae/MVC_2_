package Contents;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import user.UserDao;

//connection 관리
public class ConnectionProvider {
    public static Connection getConnection() throws ClassNotFoundException {
	Connection conn = null;
	try { 
		 String url = "jdbc:mysql://3.36.175.24:3306/mvc_2";
		 String id = "wjdalswp11";
		 String pw = "1111";
		 String driver = "com.mysql.jdbc.Driver";
		 Class.forName(driver);
		 conn = DriverManager.getConnection(url, id, pw);

	    
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return conn;
    }
}