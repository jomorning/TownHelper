package com.townHelper.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.townHelper.domain.ReviewRequestDTO;

public class ReviewRequestRowMapper implements RowMapper<ReviewRequestDTO> {

	@Override
	public ReviewRequestDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ReviewRequestDTO review = new ReviewRequestDTO();
		review.setReviewNo(rs.getInt("review_no"));
		review.setHelpPostNo(rs.getInt("help_post_no"));
		review.setWriterUserNo(rs.getInt("writer_user_no"));
		review.setTargetUserNo(rs.getInt("target_user_no"));
		review.setTargetType(rs.getString("target_type"));
		review.setReviewStar(rs.getInt("review_star"));
		review.setReviewContent(rs.getString("review_content"));
		return review;
	}

}