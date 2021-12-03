package service;

import java.util.List;

import dao.PostDao;
import entirety.Post;

public class PostsService {
	private boolean isFind = false;
	private String blockID;
	public PostsService(String blockID) {
		this.blockID = blockID;
		PostDao postDao = new PostDao();
		List<Post> posts = postDao.queryPostByBlockID(blockID);
		if (posts != null) {
			isFind = true;
		}
	}
}
