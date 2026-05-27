package com.townHelper.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.townHelper.domain.ReviewResponseDTO;

public class ReviewResponseRowMapper implements RowMapper<ReviewResponseDTO> {

	@Override
	public ReviewResponseDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ReviewResponseDTO review = new ReviewResponseDTO();
		review.setReviewNo(rs.getInt("review_no"));
		review.setHelpPostNo(rs.getInt("help_post_no"));
		review.setHelpCategory(rs.getString("help_category"));
		review.setWriterUserNo(rs.getInt("writer_user_no"));
		review.setWriterUserId(rs.getString("writer_user_id"));
		review.setTargetUserNo(rs.getInt("target_user_no"));
		review.setTargetUserId(rs.getString("target_user_id"));
		review.setTargetType(rs.getString("target_type"));
		review.setReviewStar(rs.getInt("review_star"));
		review.setReviewContent(rs.getString("review_content"));
		review.setReviewCreatedAt(rs.getTimestamp("review_created_at").toLocalDateTime());
		return review;
	}

}