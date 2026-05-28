package com.townHelper.service;

import java.util.List;

import com.townHelper.domain.CommentRequestDTO;
import com.townHelper.domain.CommentResponseDTO;

public interface CommentService {

	// 게시글당 댓글 목록 조회
	List<CommentResponseDTO> getAllCommentsByPost(int helpPostNo);

	void setNewComment(CommentRequestDTO newComment);

	void setEditComment(CommentRequestDTO editComment);

	void setDeleteComment(int commentNo);

}
