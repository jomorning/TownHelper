package com.townHelper.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.townHelper.domain.ReviewSummaryDTO;

public class ReviewSummaryRowMapper implements RowMapper<ReviewSummaryDTO> {

	@Override
	public ReviewSummaryDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ReviewSummaryDTO review = new ReviewSummaryDTO();
		review.setReviewNo(rs.getInt("review_no"));
		review.setHelpCategory(rs.getString("help_category"));
		review.setWriterUserId(rs.getInt("writer_user_id"));
		review.setTargetType(rs.getString("target_type"));
		review.setReviewStar(rs.getInt("review_star"));
		review.setReviewContent(rs.getString("review_content"));
		review.setReviewCreatedAt(rs.getTimestamp("review_created_at").toLocalDateTime());
		return review;
	}

}