package com.townHelper.repository;

import java.util.List;

import com.townHelper.domain.CommentRequestDTO;
import com.townHelper.domain.CommentResponseDTO;

public interface CommentRepository {
	
	// 게시글당 댓글 목록 조회
	List<CommentResponseDTO> getAllCommentsByPost(int helpPostNo);
	
	// 댓글 수정을 위한 원본 댓글 조회
	CommentResponseDTO getCommentByUserNo(int userNo);
	
	void setNewComment(CommentRequestDTO newComment);
	
	void setEditComment(CommentRequestDTO editComment);
	
	void setDeleteComment(int commentNo);
}
