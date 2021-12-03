package service;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import dao.UserDao;
import entirety.User;

public class RegisterService {
	private boolean isSuccess = false;
	public RegisterService(User user) {
		UserDao ud = new UserDao();
		User existedUser = ud.queryUserByName(user.getUserName());
		if (!existedUser.getUserName().equals(user.getUserName())) {//用户名不冲突
			System.out.println("用户名不冲突");
			user.setUserID(UUID.randomUUID().toString());//分配ID
			user.setIdentifyID("3");
			user.setAdminID("None");
			System.out.println(user);
			boolean isAdded = ud.addUser(user);//添加用户
			if (!isAdded) {
				isSuccess = false;
			} else {
				isSuccess = true;
			}
		} else { //注册失败		
			System.out.println("用户名冲突,失败");
			isSuccess = false;
		}
	}
	/**
	 * 
	 * @return 注册成功与否
	 */
	public boolean isSuccess() {
		return isSuccess;
	}
}
