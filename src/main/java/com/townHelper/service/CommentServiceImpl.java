package com.townHelper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.townHelper.domain.CommentRequestDTO;
import com.townHelper.domain.CommentResponseDTO;
import com.townHelper.repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentRepository commentRepository;

	@Override
	public List<CommentResponseDTO> getAllCommentsByPost(int helpPostNo) {
		List<CommentResponseDTO> commentList = commentRepository.getAllCommentsByPost(helpPostNo);
		return commentList;
	}

	@Override
	public void setNewComment(CommentRequestDTO newComment) {
		commentRepository.setNewComment(newComment);
	}

	@Override
	public void setEditComment(CommentRequestDTO editComment) {
		commentRepository.setEditComment(editComment);

	}

	@Override
	public void setDeleteComment(int commentNo) {
		commentRepository.setDeleteComment(commentNo);
	}

}
