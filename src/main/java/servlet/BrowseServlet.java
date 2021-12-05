package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entirety.Post;
import entirety.Review;
import entirety.User;
import service.PostsService;
import service.ReviewService;

/**
 * Servlet implementation class BrowseServlet
 */
public class BrowseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//查找帖子与对应评论
		String postID = request.getParameter("id");
		ReviewService rs = new ReviewService();
		PostsService ps = new PostsService();
		List<Review> reviews = rs.getReview(postID);
		System.out.println("该帖子的评论："+reviews);
		Post post = ps.getPost(postID);
		User postWriter = ps.getPostWriter(post);
		List<String> reviewers = rs.getReviewer(reviews);
		if (post != null) {
			System.out.println("帖子已找到..."+post);
			request.setAttribute("reviews", reviews);
			request.setAttribute("post", post);
			request.setAttribute("writerID", postWriter.getUserID());
			request.setAttribute("reviewers", reviewers);
			request.getRequestDispatcher("Posts/content.jsp?id="+postID).forward(request, response);
		} else {
			System.out.println("未找到帖子！");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
