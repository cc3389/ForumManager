package dao;

import java.beans.PersistenceDelegate;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import entirety.Permission;
import util.DBUtil;

public class PermissionDao {
	private DBUtil dbu;
	public PermissionDao() {
		dbu = new DBUtil();
	}
	public boolean addPermisson(Permission permission) {
		String sql = "insert into permisson valus(?,?,?,?,?,?,?,?)";
		Object[] parms = {
				permission.getIdentifyID(),
				permission.isAllowReview(),
				permission.isAllowSetRegister(),
				permission.isAllowOperateUser(),
				permission.isAllowExamine(),
				permission.isAllowSendPost(),
				permission.isAllowSetPost(),
				permission.isAllowSentAnnounce()
		};
		int statement = dbu.excuteUpdate(sql, parms);
		if(statement == -1) {
			return true;
		}else if(statement == -1) {
			System.out.println("系统异常");
		}
		return false;
	}
	public boolean delPermissionByID(String ID) {
		String sql = "delete from Permission where identify_id = ?";
		Object[] parms = {ID};
		int statement = dbu.excuteUpdate(sql, parms);
		if(statement == 1) {
			return true;
		}else if(statement == -1) {
			System.out.println("系统异常");
		}
		return false;
	}
	public Permission queryPermissionByID(String ID){
		String sql = "select * from Permission where identify_id = ?";
		Object[] parms = {ID};
		ResultSet resultSet = dbu.excuteQuery(sql, parms);
		Permission addedPermission = new Permission();
		try {
			if (resultSet.next()) {
				addedPermission.setIdentifyID(resultSet.getString("identify_id"));
				addedPermission.setAllowReview(resultSet.getBoolean("allow_review"));
				addedPermission.setAllowSetRegister(resultSet.getBoolean("allow_set_register"));
				addedPermission.setAllowOperateUser(resultSet.getBoolean("allow_operate_user"));
				addedPermission.setAllowExamine(resultSet.getBoolean("allow_examine"));
				addedPermission.setAllowSendPost(resultSet.getBoolean("allow_send_post"));
				addedPermission.setAllowSetPost(resultSet.getBoolean("allow_set_post"));
				addedPermission.setAllowSentAnnounce(resultSet.getBoolean("allow_send_announce"));
				return addedPermission;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}
}