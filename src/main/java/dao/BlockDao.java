package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entirety.Block;
import util.DBUtil;

public class BlockDao {
	private DBUtil dbu;

	public BlockDao() {
		dbu = new DBUtil();
	}
	public boolean addBlock(Block block) {
		String sql = "insert into block values(?,?,?)";
		Object[] parms = {block.getBlockID(),block.getType(),block.getSuperAdminID()};
		int statement = dbu.excuteUpdate(sql, parms);
		if (statement == 1) {
			return true;
		} else if (statement == -1)
			System.out.print("系统异常");
		return false;
	}
	public boolean delBlockByname(String name) {
		String sql = "delete from block where name = ?";
		Object[] parms = {name};
		int statement = dbu.excuteUpdate(sql, parms);
		if (statement == 1) {
			return true;
		} else if (statement == -1)
			System.out.print("系统异常");
		return false;
	}
	public List<Block> queryAll() {
		String sql = "select * from block";
		ResultSet resultSet = dbu.excuteQuery(sql, null);
		List<Block> block = new ArrayList<>();
		Block addedBlock = new Block();
		try {
			while(resultSet.next()) {
				addedBlock.setBlockID(resultSet.getString("block_id"));
				addedBlock.setType(resultSet.getString("type"));
				addedBlock.setSuperAdminID(resultSet.getString("superadmin_id"));
				block.add(addedBlock);
			}			
		}catch(SQLException e){
				e.printStackTrace();
				return null;
			}
		return block;
	}
}
