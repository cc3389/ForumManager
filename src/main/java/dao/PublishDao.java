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
	public PublishDao() {
		dbu = new DBUtil();
	}
	public boolean addPublish(Publish publish) {
		String sql = "insert into Publish values(?,?)";		
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
		String sql = "delete from Publish where post_id = ?";
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
		Object[] parms = {};
		ResultSet resultSet = dbu.excuteQuery(sql, parms);
		List<Publish> publish = new ArrayList<>();
		try {
			while (resultSet.next()) {
				Publish addedPublish = new Publish();
				addedPublish.setPostID(resultSet.getString("post_id"));
				addedPublish.setUserID(resultSet.getString("user_id"));
				publish.add(addedPublish);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return publish;
	}
//	public static void main(String[] args) {
//		PublishDao publishDao = new PublishDao();
//		Publish test = new Publish("3", "4");
////		System.out.println(publishDao.addPublish(test));
////		System.out.println(publishDao.delPublishByPostID("3"));
//		System.out.println(publishDao.queryAllPublish());
//	}
}
