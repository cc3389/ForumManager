package service;

import java.util.List;

import dao.AnnouncementDao;
import dao.UserDao;
import entirety.Announcement;
import entirety.User;

public class AnnouncementService {
	private AnnouncementDao ad;
	private UserDao ud;
	public AnnouncementService() {
		ad = new AnnouncementDao();
		ud = new UserDao();
	}
	public List<Announcement> get() {
		List<Announcement> queryAllAnnon = ad.queryAllAnnon();
		return queryAllAnnon;
	}
	public boolean add(Announcement ann,String userID) {
		User user = ud.queryByID(userID);
		ann.setWriter(user.getUserName());
		System.out.println(ann);
		boolean isAdded = ad.addAnnon(ann);
		return isAdded;
	}
	public boolean del() {
		boolean isDel = ad.delAll();
		return isDel;
	}
}
