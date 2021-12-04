package service;

import java.util.List;

import dao.ReviewDao;
import entirety.Review;

public class ReviewService {
	public ReviewService() {
		
	}
	public List<Review> getReview(String postID) {
		ReviewDao rd = new ReviewDao();
		List<Review> reviews = rd.queryReivewByPostID(postID);
		return reviews;
	}
	public boolean addReview(Review review) {
		ReviewDao rd = new ReviewDao();
		boolean addReview = rd.addReview(review);
		return addReview;		
	}
}
