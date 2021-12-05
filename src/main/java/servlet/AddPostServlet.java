package servlet;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entirety.Post;
import entirety.Publish;
import entirety.User;
import service.PostsService;

/**
 * Servlet implementation class AddPostServlet
 */
public class AddPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String blockID = request.getParameter("blockID");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		User user = (User)request.getSession().getAttribute("user");
		Post post = new Post();
		post.setAllowDigest("否");
		post.setAllowStick("否");
		post.setBlockID(blockID);
		post.setPostContent(content);
		post.setPostID(UUID.randomUUID().toString());
		post.setPublishTime(new Date());
		post.setTitle(title);
		post.setWriter(user.getUserName());
		post.setBlockerID("None");
		System.out.println("发表的帖子信息如下："+post);
		Publish publish = new Publish();
		publish.setPostID(post.getPostID());
		publish.setUserID(user.getUserID());
		PostsService ps = new PostsService();
		boolean isAddPost = ps.addPost(post,publish);
		if (isAddPost) {	
			System.out.println("发帖成功");
		} else {
			System.out.println("发帖失败");
		}
		response.sendRedirect("Posts/index.jsp?id="+blockID);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
