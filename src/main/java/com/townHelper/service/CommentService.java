package com.townHelper.service;

import java.util.List;

import com.townHelper.domain.CommentDTO;

public interface CommentService {

	// 게시글당 댓글 목록 조회
	List<CommentDTO> getAllCommentsByPost(int helpPostNo);
	
	// 댓글 단건 조회 (AJAX)
	CommentDTO getCommentByNo(int commentNo);

	Integer setNewComment(CommentDTO newComment);

	void setEditComment(CommentDTO editComment);

	void setDeleteComment(int commentNo);

}
