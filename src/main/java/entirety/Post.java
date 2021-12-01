package entirety;

import java.util.Date;

public class Post {
	private String postID;
	private String blockID;
	private String blockerID;
	private String writer;
	private String title;
	private Date publishTime;
	private String postContent;
	private String allowDigest;//加精
	private String allowStick;//置顶
	public String getPostID() {
		return postID;
	}
	public void setPostID(String postID) {
		this.postID = postID;
	}
	public String getBlockID() {
		return blockID;
	}
	public void setBlockID(String blockID) {
		this.blockID = blockID;
	}
	public String getBlockerID() {
		return blockerID;
	}
	public void setBlockerID(String blockerID) {
		this.blockerID = blockerID;
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
	public Date getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public String getAllowDigest() {
		return allowDigest;
	}
	public void setAllowDigest(String allowDigest) {
		this.allowDigest = allowDigest;
	}
	public String getAllowStick() {
		return allowStick;
	}
	public void setAllowStick(String allowStick) {
		this.allowStick = allowStick;
	}
	public Post() {
		
	}
}
