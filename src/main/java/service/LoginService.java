package service;

public class LoginService {
	private boolean isSucess = false;
	private String username;
	private String password;
	public LoginService(String username,String password) {
	//先查询是否匹配，然后查询权限，分配权限	
		this.username = username;
		this.password = password;
		boolean isExist = isEqual();
		if (isExist) {
			isSucess = true;
		} else {
			//登录失败
		}
	}
	public boolean isSucess() {
		return isSucess;
	}
	public void getPermission() {
		
	}
	private boolean isEqual()  {
		return false;
		
	}
}
