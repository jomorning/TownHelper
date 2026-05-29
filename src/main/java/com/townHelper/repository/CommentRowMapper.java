package com.townHelper.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.townHelper.domain.CommentDTO;

public class CommentRowMapper implements RowMapper<CommentDTO> {

	@Override
	public CommentDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		CommentDTO comment = new CommentDTO();
		comment.setCommentNo(rs.getInt("comment_no"));
		comment.setUserNo(rs.getInt("user_no"));
		comment.setUserId(rs.getString("user_id"));
		comment.setHelpPostNo(rs.getInt("help_post_no"));
		comment.setCommentContent(rs.getString("comment_content"));
		comment.setCommentCreatedAt(rs.getTimestamp("comment_created_at").toLocalDateTime());
		
		if (rs.getTimestamp("comment_updated_at") != null) {
			comment.setCommentUpdatedAt(rs.getTimestamp("comment_updated_at").toLocalDateTime());
		}
		
		comment.setDeleted(rs.getBoolean("is_deleted"));
		return comment;
	}

}