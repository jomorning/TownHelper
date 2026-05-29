package com.townHelper.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.townHelper.domain.CommentDTO;

@Repository
public class CommentRepositoryImpl implements CommentRepository {

	@Autowired
	private JdbcTemplate template;

	void setJdbcTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public List<CommentDTO> getAllCommentsByPost(int helpPostNo) {
		String SQL = "SELECT comment.comment_no, comment.user_no, user.user_id, comment.help_post_no, comment.comment_content, comment.comment_created_at, comment.comment_updated_at, comment.is_deleted FROM comment JOIN user ON comment.user_no = user.user_no WHERE help_post_no = ? AND comment.is_deleted = 'FALSE' ORDER BY comment_created_at ASC";
		List<CommentDTO> commentList = template.query(SQL, new CommentRowMapper(), helpPostNo);
		return commentList;				
	}

	@Override
	public CommentDTO getReturnedNewComment(int commentNo) {
		String SQL = "SELECT comment.comment_no, comment.user_no, user.user_id, comment.help_post_no, comment.comment_content, comment.comment_created_at, comment.comment_updated_at, comment.is_deleted FROM comment JOIN user ON comment.user_no = user.user_no WHERE comment_no = ? AND comment.is_deleted = 'FALSE'";
		CommentDTO comment = template.queryForObject(SQL, new CommentRowMapper(), commentNo);
		return comment;
	}

	@Override
	public Integer setNewComment(CommentDTO newComment) {
		String SQL = "INSERT INTO comment(user_no, help_post_no, comment_content) VALUES(?,?,?)";
		template.update(SQL, newComment.getUserNo(), newComment.getHelpPostNo(), newComment.getCommentContent());
		String SQL_return =  "SELECT LAST_INSERT_ID()";
		Integer returnedPK = template.queryForObject(SQL_return, Integer.class);
		return returnedPK;
	}

	@Override
	public void setEditComment(CommentDTO editComment) {
		String SQL = "UPDATE comment SET comment_content = ? WHERE comment_no = ?";
		template.update(SQL, editComment.getCommentContent(), editComment.getCommentNo());
	}

	@Override
	public void setDeleteComment(int commentNo) {
		String SQL = "UPDATE comment SET is_deleted = TRUE WHERE comment_no = ?";
		template.update(SQL, commentNo);
	}

}