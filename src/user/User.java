package user;

import java.util.Date;

public class User {
	private String userID;
	private String userPass;
	private String userName;
	private String userPhone;
	private String userGender;
	private String userEmail;

	public User() {
		
	}

	public User(String userID, String userPass, String userName, String userPhone, String userGender,
			String userEmail) {
		this.userID = userID;
		this.userPass = userPass;
		this.userName = userName;
		this.userPhone = userPhone;
		this.userGender = userGender;
		this.userEmail = userEmail;
	}



	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	


}
