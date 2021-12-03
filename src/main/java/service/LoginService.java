package service;

import java.util.List;

import dao.IdentifyDao;
import dao.PermissionDao;
import dao.UserDao;
import entirety.Identify;
import entirety.Permission;
import entirety.User;
import util.MD5Util;

public class LoginService {
	private boolean isSuccess = false;
	private String username;
	private String password;
	private UserDao userDao;
	private User user;
	private Identify identify;
	public LoginService(String username,String password) {
	//先查询是否匹配，然后查询权限，分配权限	
		this.username = username;
		this.password = password;
		userDao = new UserDao();
		user = userDao.queryUserByName(username);
		System.out.println("用户发起登录请求，信息如下：\n"+user);
	}
	public void LoginByMD5() {		
		System.out.println("LoginByMD5...");
		if (user.getUserID() != null && user.getUserID() != "") {
			String md5pass = MD5Util.md5(user.getPassword());
			if (md5pass.equals(password)) {//匹配登录成功
				System.out.println("匹配登录成功");
				isSuccess = true;
			}
		}
	}
	public void LoginByPass() {
		System.out.println("LoginByPass...");
		if (user.getUserID() != null && user.getUserID() != "") {
			String pass = user.getPassword();
			if (pass.equals(password)) {//匹配登录成功
				System.out.println("匹配登录成功");
				isSuccess = true;
			}
		}
	}
	public boolean isSuccess() {
		return isSuccess;
	}
	public User getUser() {
		if (isSuccess) {
			return user;
		} else return null;
	}
	public String getIdentifyName() {
		IdentifyDao identyDao = new IdentifyDao();
		identify = identyDao.queryIdentifyByID(user.getIdentifyID());
		return identify.getName();
	}
	public Permission getPermission() {
		if (isSuccess) {		
			PermissionDao permissionDao = new PermissionDao();
			Permission permission = permissionDao.queryPermissionByID(identify.getIdentifyID());
			return permission;
		}
		return null;
	}
}
