package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
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
		String sql = "insert into review values(?,?,?,?)";
		Object[] parms = {
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
	public boolean delReviewByUserID(String ID) {
		String sql = "delete from Review where user_id = ?";
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
		ResultSet resultSet = dbu.excuteQuery(sql, null);
		List<Review> review = new ArrayList<>();
		Review addedReview = new Review();
		try {
			while(resultSet.next()) {
				addedReview.setUserID(resultSet.getString("user_id"));
				addedReview.setPostID(resultSet.getString("post_id"));
				addedReview.setReviewTime(resultSet.getTimestamp("review_time"));
				addedReview.setContent(resultSet.getString("review_content"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
