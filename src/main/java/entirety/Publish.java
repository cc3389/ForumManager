package entirety;
/**
 * 发表帖子（主题） 实体
 * @author cc3389
 *
 */
public class Publish {
	private String postID;
	private String userID;
	public String getPostID() {
		return postID;
	}
	public void setPostID(String postID) {
		this.postID = postID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public Publish() {
		
	}
	public Publish(String postID, String userID) {
		this.postID = postID;
		this.userID = userID;
	}
}
