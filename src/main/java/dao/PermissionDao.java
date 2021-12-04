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
		}
		return null;
	}
	public static void main(String[] args) {
		PermissionDao permissionDao = new PermissionDao();
		System.out.println(permissionDao.queryPermissionByID("1"));
	}
}