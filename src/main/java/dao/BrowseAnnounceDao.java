package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entirety.Announcement;
import entirety.BrowseAnnounce;
import util.DBUtil;

public class BrowseAnnounceDao {
	private DBUtil dbu;
	public BrowseAnnounceDao() {
		dbu = new DBUtil();
	}
	public boolean addBrowseAnn(BrowseAnnounce BrowseAnn) {
		String sql = "insert into Browse_Announcement valus(?,?)";
		Object[] parms = {
			BrowseAnn.getAnnouncementID(),
			BrowseAnn.getUserID(),
		};
		int statement = dbu.excuteUpdate(sql, parms);
		if(statement == 1) {
			return true;
		}else if(statement == -1) {
			System.out.println("系统异常");
		}
		return false;
	}
	public boolean delBrowseAnnByAnnID(String ID) {
		String sql = "delete from Browse_Announcement where announcement_id = ?";
		Object[] parms = {ID};
		int statement = dbu.excuteUpdate(sql, parms);
		if(statement == 1) {
			return true;
		}else if(statement == -1){
			System.out.println("系统异常");
		}
		return false;
	}
	public boolean delBrowseAnnByUserID(String ID) {
		String sql = "delete from Browse_Announcement where user_id = ?";
		Object[] parms = {ID};
		int statement = dbu.excuteUpdate(sql, parms);
		if(statement == 1) {
			return true;
		}else if(statement == -1){
			System.out.println("系统异常");
		}
		return false;
	}
	public List<BrowseAnnounce> queryAllBrowse(){
		String sql = "select * from Browse_Announcement";
		ResultSet resultSet = dbu.excuteQuery(sql, null);
		List<BrowseAnnounce> Browse = new ArrayList<>();
		BrowseAnnounce addedBrowse = new BrowseAnnounce();
		try {
			while (!resultSet.next()) {
				addedBrowse.setAnnouncementID(resultSet.getString("announcement_id"));
				addedBrowse.setUserID(resultSet.getString("user_id"));
				Browse.add(addedBrowse);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
