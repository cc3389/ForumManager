package service;

import java.util.List;

import dao.PostDao;
import entirety.Post;

public class PostsService {
	public static Post getPost(String postID) {
		PostDao postDao = new PostDao();
		return postDao.queryPostByID(postID);		
	}
	public static List<Post> getPosts(String blockID) {
		PostDao postDao = new PostDao();
		return postDao.queryPostByBlockID(blockID);
	}
}
