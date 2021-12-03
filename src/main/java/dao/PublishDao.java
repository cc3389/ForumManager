package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entirety.Identify;
import entirety.Publish;
import util.DBUtil;

public class PublishDao {
	private DBUtil dbu;
	PublishDao() {
		dbu = new DBUtil();
	}
	public boolean addPublish(Publish publish) {
		String sql = "insert into Identify values(?,?,?,?,?)";		
		Object[] parms = {
			publish.getPostID(),
			publish.getUserID()
		};
		int statement = dbu.excuteUpdate(sql, parms);
		if (statement==1) {
			return true;
		} else if (statement==-1) {
			System.out.println("系统异常");
		}
		return false;
	}
	public boolean delPublishByPostID(String ID) {
		String sql = "delete from Identify where post_id = ?";
		Object[] parms = {ID};
		int statement = dbu.excuteUpdate(sql, parms);
		if (statement==1) {
			return true;
		} else if (statement == -1) {
			System.out.println("系统异常");
		}
		return false;	
	}
	public List<Publish> queryAllPublish() {		
		String sql = "select * from Publish";
		ResultSet resultSet = dbu.excuteQuery(sql, null);
		List<Publish> publish = new ArrayList<>();
		Publish addedPublish = new Publish();
		try {
			while (resultSet.next()) {
				addedPublish.setPostID(resultSet.getString("identify_id"));
				addedPublish.setUserID(resultSet.getString("name"));
				publish.add(addedPublish);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
