package entirety;
/**
 * 浏览帖子（主题）
 * @author cc3389
 *
 */
public class BrowsePost {
	private String userID;
	private String poseID;
	public String getUserID() {
		return userID;
	}
	public BrowsePost() {
		
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getPoseID() {
		return poseID;
	}
	public void setPoseID(String poseID) {
		this.poseID = poseID;
	}
	public BrowsePost(String userID, String poseID) {
		super();
		this.userID = userID;
		this.poseID = poseID;
	}
	
}
