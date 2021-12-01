package service;

import java.sql.Timestamp;
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
			user.setUserID(UUID.randomUUID().toString());//分配ID
			Timestamp ts = new Timestamp(user.getRegisterDate().getTime());
			//分配权限
		} else { //注册失败
			
		}
	}
}
