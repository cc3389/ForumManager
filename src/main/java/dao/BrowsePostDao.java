package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entirety.BrowseAnnounce;
import entirety.BrowsePost;
import util.DBUtil;

public class BrowsePostDao {
	private DBUtil dbu;
	public BrowsePostDao() {
		dbu = new DBUtil();
	}
	public boolean addBrowsePost(BrowsePost browsePost) {
		String sql = "insert into BrowsePost valus(?,?)";
		Object[] parms = {
			browsePost.getUserID(),
			browsePost.getPoseID()
			
		};
		int statement = dbu.excuteUpdate(sql, parms);
		if(statement == 1) {
			return true;
		}else if(statement == -1) {
			System.out.println("系统异常");
		}
		return false;
	}
	public boolean delBrowsePostByPostID(String ID) {
		String sql = "delete from Browse_Post where post_id = ?";
		Object[] parms = {ID};
		int statement = dbu.excuteUpdate(sql, parms);
		if(statement == 1) {
			return true;
		}else if(statement == -1){
			System.out.println("系统异常");
		}
		return false;
	}
	public boolean delBrowsePostByUserID(String ID) {
		String sql = "delete from Browse_Post where user_id = ?";
		Object[] parms = {ID};
		int statement = dbu.excuteUpdate(sql, parms);
		if(statement == 1) {
			return true;
		}else if(statement == -1){
			System.out.println("系统异常");
		}
		return false;
	}
	public List<BrowsePost> queryAllBrowse(){
		String sql = "select * from Browse_Post";
		ResultSet resultSet = dbu.excuteQuery(sql, null);
		List<BrowsePost> Browse = new ArrayList<>();
		BrowsePost addedBrowse = new BrowsePost();
		try {
			while (resultSet.next()) {
				addedBrowse.setPoseID(resultSet.getString("post_id"));
				addedBrowse.setUserID(resultSet.getString("user_id"));
				Browse.add(addedBrowse);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
