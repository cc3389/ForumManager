package entirety;
/**
 * 浏览帖子（主题）
 * @author cc3389
 *
 */
public class BrowsePost {
	private String userID;
	private String postID;
	public String getUserID() {
		return userID;
	}
	public BrowsePost() {
		
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getPostID() {
		return postID;
	}
	public void setPostID(String poseID) {
		this.postID = poseID;
	}
	public BrowsePost(String userID, String poseID) {
		super();
		this.userID = userID;
		this.postID = poseID;
	}
	
}
