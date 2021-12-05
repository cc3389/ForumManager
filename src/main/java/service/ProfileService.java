package service;

import dao.IdentifyDao;
import dao.UserDao;
import entirety.Identify;
import entirety.User;

public class ProfileService {
	private UserDao ud;
	private IdentifyDao idDao;
	public ProfileService() {
		ud = new UserDao();
		idDao = new IdentifyDao();
	}
	public User getUser(String id) {
		User user = ud.queryByID(id);
		return user;
	}
	public String getIdentify(String identifyID) {
		Identify identify = idDao.queryIdentifyByID(identifyID);
		if (identify != null)
			return identify.getName();
		else
			return null;
	}
}
