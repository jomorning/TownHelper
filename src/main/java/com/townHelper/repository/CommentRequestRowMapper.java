package com.townHelper.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.townHelper.domain.CommentRequestDTO;

public class CommentRequestRowMapper implements RowMapper<CommentRequestDTO> {

	@Override
	public CommentRequestDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		CommentRequestDTO comment = new CommentRequestDTO();
		comment.setCommentNo(rs.getInt("comment_no"));
		comment.setUserNo(rs.getInt("user_no"));
		comment.setHelpPostNo(rs.getInt("help_post_no"));
		comment.setCommentContent(rs.getString("comment_content"));
		return comment;
	}

}