package dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import entirety.Announcement;
import util.DBUtil;

public class AnnouncementDao {
	private DBUtil dbu;
	public AnnouncementDao() {
		dbu = new DBUtil();
	}
	public boolean addAnnon(Announcement ann) {
		String sql = "insert into Announcement values(?,?,?,?,?)";		
		Object[] parms = {ann.getAnnouncement_id(),ann.getWriter(),
				ann.getTitle(),ann.getContent(),
				new Timestamp(ann.getPublishTime().getTime())};
		int statement = dbu.excuteUpdate(sql, parms);
		if (statement==1) {
			return true;
		} else if (statement==-1) {
			System.out.println("系统异常");
		}
		return false;
	}
	public boolean delAll() {
		String sql = "delete from Announcement";
		Object[] parms = {};
		int statement = dbu.excuteUpdate(sql, parms);
		if (statement == 1) {
			return true;
		} else if (statement == -1) {
			System.out.println("系统异常");
		}
		return false;
	}
	public boolean delAnnonByID(String ID) {
		String sql = "delete from Announcement where announcement_id = ?";
		Object[] parms = {ID};
		int statement = dbu.excuteUpdate(sql, parms);
		if (statement==1) {
			return true;
		} else if (statement == -1) {
			System.out.println("系统异常");
		}
		return false;	
	}
	public List<Announcement> queryAllAnnon() {		
		String sql = "select * from Announcement";
		Object[] parms = {};
		ResultSet resultSet = dbu.excuteQuery(sql, parms);
		List<Announcement> ann = new ArrayList<>();
		try {
			while (resultSet.next()) {
				Announcement addedAnn = new Announcement();
				addedAnn.setAnnouncement_id(resultSet.getString("announcement_id"));
				addedAnn.setWriter(resultSet.getString("writer"));
				addedAnn.setTitle(resultSet.getString("title"));
				addedAnn.setContent(resultSet.getString("announce_content"));
				addedAnn.setPublishTime(resultSet.getTimestamp("publish_time"));
				ann.add(addedAnn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return ann;
	}
	public static void main(String[] args) {
		AnnouncementDao ad = new AnnouncementDao();
		boolean delAll = ad.delAll();
		
		
	}
}
