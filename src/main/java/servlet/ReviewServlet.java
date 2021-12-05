package servlet;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entirety.Review;
import entirety.User;
import service.ReviewService;


public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String content = request.getParameter("content");
		String postID = (String)request.getParameter("postID");
		System.out.println("content:"+content);
		System.out.println("postID"+postID);
		ReviewService rs = new ReviewService();
		Review review = new Review();
		review.setContent(content);
		review.setPostID(postID);
		review.setReviewTime(new Date());
		User user = (User)request.getSession().getAttribute("user");
		review.setUserID(user.getUserID());
		review.setReviewID(UUID.randomUUID().toString());
		boolean isAdded = rs.addReview(review);
		if (isAdded) {
			System.out.println("评论成功");
			response.sendRedirect("Posts/content.jsp?id="+postID);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
