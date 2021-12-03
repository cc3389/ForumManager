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
		if (existedUser == null) {//用户名不冲突
			user.setUserID(UUID.randomUUID().toString());//分配ID
			user.setIdentifyID("3");
			boolean isAdded = ud.addUser(user);//添加用户
			if (!isAdded) {
				isSuccess = true;
			}
		} else { //注册失败		
			isSuccess = true;
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
