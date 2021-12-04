package entirety;

import java.util.Date;
/**
 * 用户实体
 * @author cc3389
 * 
 *
 */
public class User {
	private String userID;
	private String userName;
	private String password;
	private String identifyID;
	private Date registerDate;
	private String sex;
	private String mail;
	private String adminID;
	public User() {
		super();
		userID = "";
		identifyID = "";
		userName = "";
		password = "";
		identifyID = "";
		sex = "";
		mail = "";
		adminID = "";
	}
	@Override
	public String toString() {
		return "User [userID=" + userID + ", userName=" + userName + ", password=" + password + ", identifyID="
				+ identifyID + ", registerDate=" + registerDate + ", sex=" + sex + ", mail=" + mail + ", adminID="
				+ adminID + "]";
	}
	public User(String userID, String userName, String password, String identifyID, Date registerDate, String sex,
			String mail) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.password = password;
		this.identifyID = identifyID;
		this.registerDate = registerDate;
		this.sex = sex;
		this.mail = mail;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIdentifyID() {
		return identifyID;
	}
	public void setIdentifyID(String identifyID) {
		this.identifyID = identifyID;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getAdminID() {
		return adminID;
	}
	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}

}
