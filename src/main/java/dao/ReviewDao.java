package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.print.DocFlavor.READER;

import entirety.Review;
import util.DBUtil;

public class ReviewDao {
	private DBUtil dbu;
	public ReviewDao() {
		dbu = new DBUtil();
	}
	public boolean addReview(Review review) {
		String sql = "insert into review values(?,?,?,?,?)";
		Object[] parms = {
			review.getReviewID(),
			review.getUserID(),
			review.getPostID(),
			new Timestamp(review.getReviewTime().getTime()),
			review.getContent()
		};
		int statement = dbu.excuteUpdate(sql, parms);
		if(statement == 1) {
			return true;
		}else if(statement == -1) {
			System.out.println("系统异常");
		}
		return false;
	}
	public boolean delReviewByReviewID(String ID) {
		String sql = "delete from Review where review_id = ?";
		Object[] parms = {ID};
		int statement = dbu.excuteUpdate(sql, parms);
		if (statement==1) {
			return true;
		} else if (statement == -1) {
			System.out.println("系统异常");
		}
		return false;	
	}
	public List<Review> queryReivewByPostID(String ID) {
		String sql = "select * from Review";
		Object[] parms = {};
		ResultSet resultSet = dbu.excuteQuery(sql, parms);
		List<Review> review = new ArrayList<>();
		try {
			while(resultSet.next()) {
				Review addedReview = new Review();
				addedReview.setUserID(resultSet.getString("user_id"));
				addedReview.setPostID(resultSet.getString("post_id"));
				addedReview.setReviewTime(resultSet.getTimestamp("review_time"));
				addedReview.setContent(resultSet.getString("review_content"));
				review.add(addedReview);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return review;
	}
//	public static void main(String[] args) {
//		ReviewDao reviewDao = new ReviewDao();
//		Review test = new Review("1", "123", "1", new Date(), "good");
//		System.out.println(reviewDao.addReview(test));
//		System.out.println(reviewDao.delReviewByReviewID("1"));
//		System.out.println(reviewDao.queryReivewByPostID("1"));
//	}
}
