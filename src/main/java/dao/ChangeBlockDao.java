package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entirety.Announcement;
import entirety.ChangeBlock;
import util.DBUtil;

public class ChangeBlockDao {
	private DBUtil dbu;
	ChangeBlockDao() {
		dbu = new DBUtil();
	}
	public boolean addChange(ChangeBlock change) {
		String sql = "insert into ChangeBlock values(?,?,?,?,?)";		
		Object[] parms = {
				change.getAdminID(),
				change.getBlockID()
		};
		int statement = dbu.excuteUpdate(sql, parms);
		if (statement==1) {
			return true;
		} else if (statement==-1) {
			System.out.println("系统异常");
		}
		return false;
	}
	public List<ChangeBlock> queryAllChange() {		
		String sql = "select * from ChangeBlock";
		Object[] parms = {};
		ResultSet resultSet = dbu.excuteQuery(sql, parms);
		List<ChangeBlock> Change = new ArrayList<>();		
		try {
			while (resultSet.next()) {
				ChangeBlock addedChange = new ChangeBlock();
				addedChange.setAdminID(resultSet.getString("admin_id"));
				addedChange.setBlockID(resultSet.getString("block_id"));
				Change.add(addedChange);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
