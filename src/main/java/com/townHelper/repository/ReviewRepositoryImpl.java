package com.townHelper.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.townHelper.domain.ReviewRequestDTO;
import com.townHelper.domain.ReviewResponseDTO;
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
	public ReviewResponseDTO getReviewByNo(int reviewNo) {
		String SQL = "SELECT * FROM review WHERE review_no = ?";
		ReviewResponseDTO review = template.queryForObject(SQL, new ReviewResponseRowMapper(), reviewNo);
		return review;
	}

	@Override
	public void setNewReview(ReviewRequestDTO newReview) {
		String SQL = "INSERT INTO review(help_post_no, writer_user_no, target_user_no, target_type, review_star, review_content) VALUES(?,?,?,?,?,?)";
		template.update(SQL, newReview.getHelpPostNo(), newReview.getWriterUserNo(), newReview.getTargetUserNo(),
				newReview.getTargetType(), newReview.getReviewStar(), newReview.getReviewContent());
	}

}