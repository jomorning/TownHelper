package com.townHelper.repository;

import java.util.List;

import com.townHelper.domain.CommentDTO;

public interface CommentRepository {

	// 게시글당 댓글 목록 조회
	List<CommentDTO> getAllCommentsByPost(int helpPostNo);
	
	// 작성한 새 댓글 가져오기 (AJAX)
	CommentDTO getReturnedNewComment(int commentNo);

	Integer setNewComment(CommentDTO newComment);

	void setEditComment(CommentDTO editComment);

	void setDeleteComment(int commentNo);
}
