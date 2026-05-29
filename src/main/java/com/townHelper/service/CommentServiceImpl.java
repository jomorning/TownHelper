package com.townHelper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.townHelper.domain.CommentDTO;
import com.townHelper.repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentRepository commentRepository;

	@Override
	public List<CommentDTO> getAllCommentsByPost(int helpPostNo) {
		List<CommentDTO> commentList = commentRepository.getAllCommentsByPost(helpPostNo);
		return commentList;
	}

	@Override
	public CommentDTO getReturnedNewComment(int commentNo) {
		CommentDTO comment = commentRepository.getReturnedNewComment(commentNo);
		return comment;
	}

	@Override
	public Integer setNewComment(CommentDTO newComment) {
		Integer returnedPK = commentRepository.setNewComment(newComment);
		return returnedPK;
	}

	@Override
	public void setEditComment(CommentDTO editComment) {
		commentRepository.setEditComment(editComment);

	}

	@Override
	public void setDeleteComment(int commentNo) {
		commentRepository.setDeleteComment(commentNo);
	}

}
