package entirety;

import java.util.Date;

public class Announcement {
	private String announcement_id;
	private String writer;
	private String title;
	private String content;
	private Date publishTime;
	public Announcement() {
	}
	public Announcement(String announcement_id, String writer, String title, String content, Date publishTime) {
		this.announcement_id = announcement_id;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.publishTime = publishTime;
	}
	public String getAnnouncement_id() {
		return announcement_id;
	}
	public void setAnnouncement_id(String announcement_id) {
		this.announcement_id = announcement_id;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
}
