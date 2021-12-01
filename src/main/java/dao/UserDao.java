package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import entirety.User;
import util.DBUtil;

public class UserDao {
	private DBUtil dbu;
	public UserDao() {
		dbu = new DBUtil("192.168.43.159");
	}
	/**
	 * 
	 * @return true增加成功
	 * false失败
	 */
	public boolean addUser(User user) {
		String sql = "insert into User values(?,?,?,?,?,?,?,?)";
		Object[] parms  = {
				user.getUserID(),
				user.getUserName(),
				user.getPassword(),
				user.getIdentifyID(),
				new Timestamp(user.getRegisterDate().getTime()), //使用Timestamp类
				user.getSex(),
				user.getMail(),
				user.getAdminID()
		};
		int statement = dbu.excuteUpdate(null, parms);
		if (statement == 1) {
			return true;
		} else if (statement == -1)
			System.out.print("系统异常");
		return false;		
	}
	/**
	 * 
	 * @return true删除成功
	 * false失败
	 */
	public boolean delUserByID(String ID) {
		String sql = "delete from User where userID = ?";
		Object[] parms = {ID};
		 int statement = dbu.excuteUpdate(sql,parms);
		 if (statement == 1) {
			 return true;
		 } else if (statement == -1) {
			 System.out.println("系统异常");
		 } 
		 return false; 
	}
	/**
	 * 
	 * @param name 用户名
	 * @return User数组
	 */
	public List<User> queryUserByName(String name) {
		String sql = "select * from User where name = ?";
		Object[] parms = {name};
		ResultSet resultSet = dbu.excuteQuery(sql, parms);
		List<User> users = new ArrayList<>();
		User addedUser = new User();
		try {
			while (resultSet.next()) {
				addedUser.setUserID(resultSet.getString("user_id"));
				addedUser.setUserName(resultSet.getString("user_name"));
				addedUser.setPassword(resultSet.getString("password"));
				addedUser.setIdentifyID(resultSet.getString("identify_id"));
				addedUser.setRegisterDate(resultSet.getTimestamp("register_date"));//获取时间类
				addedUser.setSex(resultSet.getString("sex"));
				addedUser.setMail(resultSet.getString("mail"));
				addedUser.setAdminID(resultSet.getString("admin_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return users;
	}
//	public boolean updateUserByID(String id) {
//		String sql = "update User"
//	}
}
