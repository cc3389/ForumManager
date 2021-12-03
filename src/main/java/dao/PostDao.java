package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import entirety.Post;
import util.DBUtil;

public class PostDao {
	private DBUtil dbu;

	public PostDao() {
		dbu = new DBUtil();
	}
	public boolean addPost(Post post) {
		String sql = "insert into Post values(?,?,?,?,?,?,?,?,?)";
		Object[] parms = {
				post.getPostID(),
				post.getBlockID(),
				post.getBlockerID(),
				post.getWriter(),
				post.getTitle(),
				new Timestamp(post.getPublishTime().getTime()),
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
		String sql = "delete from post where post_id = ?";
		Object[] parms = {ID};
		int statement = dbu.excuteUpdate(sql, parms);
		if (statement == 1) {
			return true;
		} else if (statement == -1)
			System.out.print("系统异常");
		return false;
	}
	public Post queryPostByID(String ID) {
		String sql = "select * from post where post_id = ?";
		Object[] parms = {ID};
		Post post = new Post();
		ResultSet resultSet = dbu.excuteQuery(sql, parms);		
		try {
			while(resultSet.next()) {				
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
			return null;
		}
		return post;
	}
	public List<Post> queryPostByBlockID(String BlockID) {
		String sql = "select * from post where block_id = ?";
		Object[] parms = {BlockID};
		ResultSet resultSet = dbu.excuteQuery(sql, parms);
		List<Post> post = new ArrayList<>();		
		try {
			while(resultSet.next()) {
				Post addedPost = new Post();
				addedPost.setPostID(resultSet.getString("post_id"));
				addedPost.setBlockID(resultSet.getString("block_id"));
				addedPost.setBlockerID(resultSet.getString("blocker_id"));
				addedPost.setWriter(resultSet.getString("writer"));
				addedPost.setTitle(resultSet.getString("title"));
				addedPost.setPublishTime(resultSet.getTimestamp("publishtime"));
				addedPost.setPostContent(resultSet.getString("post_content"));
				addedPost.setAllowDigest(resultSet.getString("allow_digest"));
				addedPost.setAllowStick(resultSet.getString("allow_stick"));
				post.add(addedPost);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return post;
		
	}
}
