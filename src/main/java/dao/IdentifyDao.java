package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entirety.Announcement;
import entirety.Identify;
import util.DBUtil;

public class IdentifyDao {
	private DBUtil dbu;
	public IdentifyDao() {
		dbu = new DBUtil();
	}
	public boolean addIdentify(Identify identify) {
		String sql = "insert into Identify values(?,?,?,?,?)";		
		Object[] parms = {
				identify.getIdentifyID(),
				identify.getName()
		};
		int statement = dbu.excuteUpdate(sql, parms);
		if (statement==1) {
			return true;
		} else if (statement==-1) {
			System.out.println("系统异常");
		}
		return false;
	}
	public boolean delIdentifyByID(String ID) {
		String sql = "delete from Identify where identify_id = ?";
		Object[] parms = {ID};
		int statement = dbu.excuteUpdate(sql, parms);
		if (statement==1) {
			return true;
		} else if (statement == -1) {
			System.out.println("系统异常");
		}
		return false;	
	}
	public Identify queryIdentifyByID(String ID) {		
		String sql = "select * from Identify where identify_id = ?";
		Object[] parms = {ID};
		ResultSet resultSet = dbu.excuteQuery(sql, parms);
		Identify addedIdentify = new Identify();
		try {
			if (resultSet.next()) {
				addedIdentify.setIdentifyID(resultSet.getString("identify_id"));
				addedIdentify.setName(resultSet.getString("name"));
				return addedIdentify;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
	}
}
