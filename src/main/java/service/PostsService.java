package service;

import java.util.List;

import dao.BlockDao;
import dao.PostDao;
import dao.PublishDao;
import dao.ReviewDao;
import dao.UserDao;
import entirety.Block;
import entirety.Post;
import entirety.Publish;
import entirety.User;

public class PostsService {
	private PostDao postDao;
	private PublishDao publishDao;
	private UserDao ud;	
	private ReviewDao rd;
	public PostsService() {
		postDao = new PostDao();
		ud = new UserDao();
		publishDao = new PublishDao();
		rd = new ReviewDao();
	}
	public Post getPost(String postID) {		
		Post post = postDao.queryPostByID(postID);		
		return post;
	}
	public List<Post> getPosts(String blockID) {
		List<Post> posts = postDao.queryPostByBlockID(blockID);
		return posts;
	}
	public User getPostWriter(Post post) {		 
		User user = ud.queryUserByName(post.getWriter());
		return user;
	}
	public boolean delPost(String id) {
		boolean isD = publishDao.delPublishByPostID(id);
		boolean isDel = rd.delByPostID(id);
		boolean isDeled = postDao.delPostByID(id);		
		if (isDeled && isDel && isD) {
			return true;
		}
		return false;
	}
	public boolean addPost(Post post,Publish publish) {	
		boolean addPost = postDao.addPost(post);		
		boolean addPublish = publishDao.addPublish(publish);
		if (addPost && addPublish) {
			return true;
		} else return false;
	}
}
