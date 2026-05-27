package com.townHelper.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.townHelper.domain.CommentResponseDTO;

public class CommentResponseRowMapper implements RowMapper<CommentResponseDTO> {

	@Override
	public CommentResponseDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		CommentResponseDTO comment = new CommentResponseDTO();
		comment.setCommentNo(rs.getInt("comment_no"));
		comment.setUserNo(rs.getInt("user_no"));
		comment.setUserId(rs.getString("user_id"));
		comment.setCommentContent(rs.getString("comment_content"));
		comment.setCommentCreatedAt(rs.getTimestamp("comment_created_at").toLocalDateTime());
		comment.setCommentUpdatedAt(rs.getTimestamp("comment_updated_at").toLocalDateTime());
		comment.setDeleted(rs.getBoolean("is_deleted"));
		return comment;
	}

}