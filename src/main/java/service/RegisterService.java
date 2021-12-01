package service;

import java.util.List;
import java.util.UUID;

import dao.UserDao;
import entirety.User;

public class RegisterService {
	private boolean isSucess = false;
	public RegisterService(User user) {
		UserDao ud = new UserDao();
		List<User> users = ud.queryUserByName(user.getUserName());
		if (users.size() == 0) {//注册成功
			user.setUserID(UUID.randomUUID().toString());
		} else { //注册失败
			
		}
	}
}
