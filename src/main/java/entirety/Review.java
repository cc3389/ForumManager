package entirety;

import java.util.Date;
/**
 * 评论实体
 * @author cc3389
 *
 */
public class Review {
	private String ReviewID;
	private String userID;
	private String postID;
	private Date reviewTime;
	private String content;
	
	public String getReviewID() {
		return ReviewID;
	}
	public void setReviewID(String reviewID) {
		ReviewID = reviewID;
	}
	public Review() {
		super();
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getPostID() {
		return postID;
	}
	public void setPostID(String postID) {
		this.postID = postID;
	}
	public Date getReviewTime() {
		return reviewTime;
	}
	public void setReviewTime(Date reviewTime) {
		this.reviewTime = reviewTime;
	}
}
