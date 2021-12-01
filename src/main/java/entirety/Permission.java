package entirety;

public class Permission {
	private String identifyID;
	private boolean allowReview;
	private boolean allowSetRegister;
	private boolean allowOperateUser;
	private boolean allowExamine;
	private boolean allowSendPost;
	private boolean allowSetPost;
	private boolean allowSentAnnounce;
	public Permission() {
		
	}
	public String getIdentifyID() {
		return identifyID;
	}
	public void setIdentifyID(String identifyID) {
		this.identifyID = identifyID;
	}
	public boolean isAllowReview() {
		return allowReview;
	}
	public void setAllowReview(boolean allowReview) {
		this.allowReview = allowReview;
	}
	public boolean isAllowSetRegister() {
		return allowSetRegister;
	}
	public void setAllowSetRegister(boolean allowSetRegister) {
		this.allowSetRegister = allowSetRegister;
	}
	public boolean isAllowOperateUser() {
		return allowOperateUser;
	}
	public void setAllowOperateUser(boolean allowOperateUser) {
		this.allowOperateUser = allowOperateUser;
	}
	public boolean isAllowExamine() {
		return allowExamine;
	}
	public void setAllowExamine(boolean allowExamine) {
		this.allowExamine = allowExamine;
	}
	public boolean isAllowSendPost() {
		return allowSendPost;
	}
	public void setAllowSendPost(boolean allowSendPost) {
		this.allowSendPost = allowSendPost;
	}
	public boolean isAllowSetPost() {
		return allowSetPost;
	}
	public void setAllowSetPost(boolean allowSetPost) {
		this.allowSetPost = allowSetPost;
	}
	public boolean isAllowSentAnnounce() {
		return allowSentAnnounce;
	}
	public void setAllowSentAnnounce(boolean allowSentAnnounce) {
		this.allowSentAnnounce = allowSentAnnounce;
	}

}
