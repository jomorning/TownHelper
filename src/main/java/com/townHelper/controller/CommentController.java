package com.townHelper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.townHelper.domain.CommentDTO;
import com.townHelper.service.CommentService;

@Controller
public class CommentController {

	@Autowired
	CommentService commentService;
	
	@GetMapping("/help-posts/{helpPostNo}/comments")
	@ResponseBody
	public List<CommentDTO> getAllCommentsByPost(@PathVariable("helpPostNo") int helpPostNo) {
		List<CommentDTO> commentList = commentService.getAllCommentsByPost(helpPostNo);
		return commentList;
	}
	
	@PostMapping("/help-posts/{helpPostNo}/comments")
	@ResponseBody
	public CommentDTO submitNewComment(@RequestBody CommentDTO newComment, @PathVariable("helpPostNo") int helpPostNo) {
		
		// 임시
		newComment.setUserNo(1);

		System.out.println("게시글 번호: " + newComment.getHelpPostNo());
		
		Integer returnedPK = commentService.setNewComment(newComment);
		CommentDTO comment = commentService.getReturnedNewComment(returnedPK);
		return comment;
	}

}
