package entirety;

public class BrowseAnnounce {
	private String announcementID;
	private String userID;
	public String getAnnouncementID() {
		return announcementID;
	}
	public BrowseAnnounce() {
		
	}
	public void setAnnouncementID(String announcementID) {
		this.announcementID = announcementID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public BrowseAnnounce(String announcementID, String userID) {
		this.announcementID = announcementID;
		this.userID = userID;
	}
}
