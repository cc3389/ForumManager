package dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entirety.Announcement;
import util.DBUtil;

public class AnnouncementDao {
	private DBUtil dbu;
	AnnouncementDao() {
		dbu = new DBUtil("192.168.43.159");
	}
	public boolean addAnnon(Announcement ann) {
		String sql = "insert into Announcement values(?,?,?,?,?)";		
		Object[] parms = {ann.getAnnouncement_id(),ann.getWriter(),
				ann.getTitle(),ann.getContent(),ann.getPublishTime()};
		int statement = dbu.excuteUpdate(sql, parms);
		if (statement==1) {
			return true;
		} else if (statement==-1) {
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
		ResultSet resultSet = dbu.excuteQuery(sql, null);
		List<Announcement> ann = new ArrayList<>();
		Announcement addedAnn = new Announcement();
		try {
			while (!resultSet.next()) {
				addedAnn.setAnnouncement_id(resultSet.getString("announcement"));
				addedAnn.setWriter(resultSet.getString("writer"));
				addedAnn.setTitle(resultSet.getString("title"));
				addedAnn.setContent(resultSet.getString("announce_content"));
				addedAnn.setPublishTime(resultSet.getDate("publish_time"));
				ann.add(addedAnn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
