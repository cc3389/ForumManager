package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entirety.Announcement;
import entirety.ChangeBlock;
import entirety.Identify;
import util.DBUtil;

public class IdentifyDao {
	private DBUtil dbu;
	public IdentifyDao() {
		dbu = new DBUtil();
	}
	public Identify queryIdentifyByID(String ID) {		
		String sql = "select * from Identify where identify_id = ?";
		Object[] parms = {ID};
		ResultSet resultSet = dbu.excuteQuery(sql, parms);
		try {
			if (resultSet.next()) {
				Identify addedIdentify = new Identify();
				addedIdentify.setIdentifyID(resultSet.getString("identify_id"));
				addedIdentify.setName(resultSet.getString("name"));
				return addedIdentify;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public List<Identify> queryAllIdentify() {		
		String sql = "select * from Identify";
		Object[] parms = {};
		ResultSet resultSet = dbu.excuteQuery(sql, parms);
		List<Identify> identifies = new ArrayList<>();
		try {
			while (resultSet.next()) {
				Identify addedIdentify = new Identify();
				addedIdentify.setIdentifyID(resultSet.getString("identify_id"));
				addedIdentify.setName(resultSet.getString("name"));
				identifies.add(addedIdentify);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return identifies;
	}
//	public static void main(String[] args) {
//		IdentifyDao identifyDao = new IdentifyDao();
//		System.out.println(identifyDao.queryAllIdentify());
//	}
}
