package service;

import java.util.ArrayList;
import java.util.List;

import dao.PostDao;
import dao.ReviewDao;
import dao.UserDao;
import entirety.Review;
import entirety.User;

public class ReviewService {
	private ReviewDao rd;
	private UserDao ud;
	public ReviewService() {
		rd = new ReviewDao();
		ud = new UserDao();
	}
	public List<Review> getReview(String postID) {
		
		List<Review> reviews = rd.queryReivewByPostID(postID);
		return reviews;
	}
	public List<String> getReviewer(List<Review> reviews) {
		List<String> reviewers = new ArrayList<String>();
		for (int i = 0; i < reviews.size(); ++i) {
			String userID = reviews.get(i).getUserID();
			User user = ud.queryByID(userID);
			reviewers.add(user.getUserName());			
		}
		return reviewers;
	}
	public boolean delReivew(String id) {
		boolean isdel = rd.delReviewByReviewID(id);
		return isdel;
	}
	public boolean addReview(Review review) {
		boolean addReview = rd.addReview(review);
		return addReview;		
	}
}
