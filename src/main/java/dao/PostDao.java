package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import entirety.Post;
import util.DBUtil;

public class PostDao {
	private DBUtil dbu;

	public PostDao() {
		dbu = new DBUtil("192.168.43.159");
	}
	public boolean addPost(Post post) {
		String sql = "insert into Post values(?,?,?,?,?,?,?,?,?)";
		Object[] parms = {
				post.getPostID(),
				post.getBlockID(),
				post.getBlockerID(),
				post.getWriter(),
				post.getTitle(),
				post.getPublishTime(),
				post.getPostContent(),
				post.getAllowDigest(),
				post.getAllowStick()
		};
		int statement = dbu.excuteUpdate(sql, parms);
		if (statement == 1) {
			return true;
		} else if (statement == -1)
			System.out.print("系统异常");
		return false;		
	}
	public boolean delPostByID(String ID) {
		String sql = "delete from post where id = ?";
		Object[] parms = {ID};
		int statement = dbu.excuteUpdate(sql, parms);
		if (statement == 1) {
			return true;
		} else if (statement == -1)
			System.out.print("系统异常");
		return false;
	}
	public Post queryPostByID(String ID) {
		String sql = "select * from post where id = ?";
		Object[] parms = {ID};
		ResultSet resultSet = dbu.excuteQuery(sql, parms);
		Post post = new Post();
		try {
			while(!resultSet.next()) {
				post.setPostID(resultSet.getString("post_id"));
				post.setBlockID(resultSet.getString("block_id"));
				post.setBlockerID(resultSet.getString("blocker_id"));
				post.setWriter(resultSet.getString("writer"));
				post.setTitle(resultSet.getString("title"));
				post.setPublishTime(resultSet.getDate("publishtime"));
				post.setPostContent(resultSet.getString("post_content"));
				post.setAllowDigest(resultSet.getString("allow_digest"));
				post.setAllowStick(resultSet.getString("allow_stick"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<Post> queryPostByBlockID(String BlockID) {
		String sql = "select * from post where BlockID = ?";
		Object[] parms = {BlockID};
		ResultSet resultSet = dbu.excuteQuery(sql, parms);
		Post post = new Post();
		try {
			while(!resultSet.next()) {
				post.setPostID(resultSet.getString("post_id"));
				post.setBlockID(resultSet.getString("block_id"));
				post.setBlockerID(resultSet.getString("blocker_id"));
				post.setWriter(resultSet.getString("writer"));
				post.setTitle(resultSet.getString("title"));
				post.setPublishTime(resultSet.getDate("publishtime"));
				post.setPostContent(resultSet.getString("post_content"));
				post.setAllowDigest(resultSet.getString("allow_digest"));
				post.setAllowStick(resultSet.getString("allow_stick"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
