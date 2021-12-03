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
		dbu = new DBUtil();
	}
	/**
	 * 
	 * @return true增加成功
	 * false失败
	 */
	public boolean addUser(User user) {
		String sql = "insert into Users values(?,?,?,?,?,?,?,?)";
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
		int statement = dbu.excuteUpdate(sql, parms);
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
		String sql = "delete from Users where user_id = ?";
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
	 * @return User
	 */
	public User queryUserByName(String name) {
		String sql = "select * from Users where user_name = ?";
		Object[] parms = {name};
		ResultSet resultSet = dbu.excuteQuery(sql, parms);
		User addedUser = new User();
		try {
			if (resultSet != null && resultSet.next()) {
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
		return addedUser;
	}
	/**
	 * 通过用户名与密码查询用户，用于登录
	 * @param username
	 * @param password
	 * @return User实体
	 */
	public User queryByNameAndPass(String username,String password) {
		String sql = "select *from Users where user_name = ? and password = ?";
		Object[] parms = {username,password};
		ResultSet resultSet = dbu.excuteQuery(sql, parms);
		User addedUser = new User();
		try{
			if (!resultSet.next()) {
				addedUser.setUserID(resultSet.getString("user_id"));
				addedUser.setUserName(resultSet.getString("user_name"));
				addedUser.setPassword(resultSet.getString("password"));
				addedUser.setIdentifyID(resultSet.getString("identify_id"));
				addedUser.setRegisterDate(resultSet.getTimestamp("register_date"));//获取时间类
				addedUser.setSex(resultSet.getString("sex"));
				addedUser.setMail(resultSet.getString("mail"));
				addedUser.setAdminID(resultSet.getString("admin_id"));
				return addedUser;
			} else return null;			
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}		
	}
}
