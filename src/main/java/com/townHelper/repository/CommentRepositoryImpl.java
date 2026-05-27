package com.townHelper.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.townHelper.domain.CommentRequestDTO;
import com.townHelper.domain.CommentResponseDTO;

@Repository
public class CommentRepositoryImpl implements CommentRepository {

	@Autowired
	private JdbcTemplate template;

	void setJdbcTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public List<CommentResponseDTO> getAllCommentsByPost(int helpPostNo) {
		String SQL = "SELECT * FROM comment WHERE help_post_no = ? AND is_deleted = FALSE ORDER BY comment_created_at ASC";
		List<CommentResponseDTO> commentList = template.query(SQL, new CommentResponseRowMapper(), helpPostNo);
		return commentList;				
	}

	@Override
	public CommentResponseDTO getCommentByUserNo(int userNo) {
		String SQL = "SELECT * FROM comment WHERE user_no = ? AND is_deleted = FALSE";
		CommentResponseDTO comment = template.queryForObject(SQL, new CommentResponseRowMapper(), userNo); 
		return comment;
	}

	@Override
	public void setNewComment(CommentRequestDTO newComment) {
		String SQL = "INSERT INTO comment(user_no, help_post_no, comment_content) VALUES(?,?,?)";
		template.update(SQL, newComment.getUserNo(), newComment.getHelpPostNo(), newComment.getCommentContent());
	}

	@Override
	public void setEditComment(CommentRequestDTO editComment) {
		String SQL = "UPDATE comment SET comment_content = ? WHERE comment_no = ?";
		template.update(SQL, editComment.getCommentContent(), editComment.getCommentNo());
	}

	@Override
	public void setDeleteComment(int commentNo) {
		String SQL = "UPDATE comment SET is_deleted = TRUE WHERE comment_no = ?";
		template.update(SQL, commentNo);
	}

}