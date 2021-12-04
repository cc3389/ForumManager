package service;

import java.util.List;

import dao.PostDao;
import entirety.Post;

public class PostsService {
	private boolean isFind = false;
	private String blockID;
	private List<Post> posts;
	public PostsService(String blockID) {
		this.blockID = blockID;
		PostDao postDao = new PostDao();
		posts = postDao.queryPostByBlockID(blockID);
		if (posts != null) {
			isFind = true;
		}
	}
	public List<Post> getPosts() {
		if (isFind) {
			return posts;
		}
		return null;
	}
}
