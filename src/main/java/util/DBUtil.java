package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	private final String driver ="com.microsoft.sqlserver.jdbc.SQLServerDriver";//驱动
	private String targetURL = null;
	private String uname=null;//登录名
	private String password = null;//密码
	private Connection con = null;
	private PreparedStatement preparedStatement = null;
	/**
	 * 
	 * @param url 数据库url
	 * @param userName 数据库username
	 * @param password 数据库password
	 */
	
	public DBUtil(String url,String userName,String password) {
		uname = userName;
		this.password = password; 
		targetURL = "jdbc:sqlserver://" + url +":1433;DatabaseName=TBGL";
	}
	public DBUtil() {
		uname = "sa";
		password = "sa123";
		String myURL = "192.168.43.159";//修改这里
		targetURL = "jdbc:sqlserver://" + myURL +":1433;DatabaseName=TBGL";
	}
	public DBUtil(String url) {
		uname = "sa";
		password = "sa123";
		targetURL = "jdbc:sqlserver://" + url +":1433;DatabaseName=TBGL";
	}
	private Connection getConnection() {
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				System.out.println("驱动异常");
				e.printStackTrace();
				return null;
			}			
			try {
				con = DriverManager.getConnection(targetURL, uname, password);
			} catch (SQLException e) {
				System.out.println("数据库连接异常");				
				e.printStackTrace();
				return null;
			}
		return con;
	}
	/**
	 * 数据库的增删改
	 * @param sql
	 * @param params
	 * @return 1表示成功，0表示失败，-1表示系统异常
	 * 例：sql = "UPDATE Person SET FirstName =? WHERE LastName=? "
	 * params = {"Fred","Mike"}
	 */
	public int excuteUpdate(String sql,Object[] params) {
		Connection con = getConnection();
		if (con != null) {
			try {
				preparedStatement = con.prepareStatement(sql);
				for (int i = 0; i < params.length; ++i) {
					preparedStatement.setObject(i + 1, params[i]);
				}
				int result = preparedStatement.executeUpdate();
				return result;
			} catch (SQLException e) {
				e.printStackTrace();
				return -1;
			} finally {
				try {
					if (preparedStatement != null)
					preparedStatement.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				try {
					if (con != null) 
						con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} else {
			System.out.println("无法获取数据库连接");
			return -1;
		}

	}
	/**
	 * 
	 * @param sql
	 * @param params
	 * @return ResultSet 数据库查询列表
	 * 例：sql = "selcet Person from ? where FirstName =? and LastName=? "
	 * params = {"Fred","Mike"}
	 */
	public ResultSet excuteQuery(String sql,Object[] params) {
		Connection con = getConnection();
		try {
			if (con != null) {
				con.prepareStatement(sql);
				for (int i = 0; i < params.length; ++i) {
					preparedStatement.setObject(i + 1, params[i]);
				}
				return preparedStatement.executeQuery();				
			} else {
				System.out.println("无法获取数据库连接");
				return null;
			}			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("sql查询错误");
			return null;
		}
	}
}

