package com.townHelper.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.townHelper.domain.ReviewDTO;
import com.townHelper.domain.ReviewSummaryDTO;

@Repository
public class ReviewRepositoryImpl implements ReviewRepository {

	@Autowired
	private JdbcTemplate template;

	void setJdbcTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public List<ReviewSummaryDTO> getReviewsSummary(int userNo) {
		String SQL = "SELECT * FROM review WHERE target_user_no = ? ORDER BY review_created_at DESC";
		List<ReviewSummaryDTO> reviewSummaryList = template.query(SQL, new ReviewSummaryRowMapper(), userNo);
		return reviewSummaryList;
	}

	@Override
	public ReviewDTO getReviewByNo(int reviewNo) {
		String SQL = "SELECT r.review_no, r.help_post_no, hp.help_category, writer.user_id AS writer_user_id, target.user_id AS target_user_id, r.target_type, r.review_star, r.review_content, r.review_created_at FROM review r JOIN user writer ON r.writer_user_no = writer.user_no JOIN user target ON r.target_user_no = target.user_no JOIN help_post hp ON r.help_post_no = hp.help_post_no WHERE r.review_no = ?";
		ReviewDTO review = template.queryForObject(SQL, new ReviewRowMapper(), reviewNo);
		return review;
	}

	@Override
	public Integer setNewReview(ReviewDTO newReview) {
		String SQL = "INSERT INTO review(help_post_no, writer_user_no, target_user_no, target_type, review_star, review_content) VALUES(?,?,?,?,?,?)";
		template.update(SQL, newReview.getHelpPostNo(), newReview.getWriterUserNo(), newReview.getTargetUserNo(),
				newReview.getTargetType(), newReview.getReviewStar(), newReview.getReviewContent());

		String SQL_return = "SELECT LAST_INSERT_ID()";
		Integer returnedPK = template.queryForObject(SQL_return, Integer.class);
		return returnedPK;
	}

}