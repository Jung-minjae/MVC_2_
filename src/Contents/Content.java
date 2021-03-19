package Contents;

import java.util.Date;

public class Content {
	private int contentID;
	private String Title;
	private String userID;
	private String content;
	private Date date;
	private int Available;

	public Content() {

	}
	public Content(int contentID, String title, String userID, String content, Date date, int available) {
		
		this.contentID = contentID;
		Title = title;
		this.userID = userID;
		this.content = content;
		this.date = date;
		Available = available;
	}

	public int getContentID() {
		return contentID;
	}

	public void setContentID(int contentID) {
		this.contentID = contentID;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getAvailable() {
		return Available;
	}

	public void setAvailable(int available) {
		Available = available;
	}



}