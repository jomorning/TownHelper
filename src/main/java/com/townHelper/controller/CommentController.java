package com.townHelper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.townHelper.domain.CommentDTO;
import com.townHelper.service.CommentService;

import jakarta.servlet.http.HttpSession;

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
	public CommentDTO submitNewComment(@RequestBody CommentDTO newComment, @PathVariable("helpPostNo") int helpPostNo, HttpSession session) {
		
		Integer loginUserNo = (Integer) session.getAttribute("loginUserNo");
		newComment.setUserNo(loginUserNo);
		
		Integer returnedPK = commentService.setNewComment(newComment);
		CommentDTO comment = commentService.getCommentByNo(returnedPK);
		return comment;
	}
	
	@PutMapping("/help-posts/{helpPostNo}/comments/{commentNo}")
	@ResponseBody
	public CommentDTO submitEditComment(@RequestBody CommentDTO editComment, @PathVariable("helpPostNo") int helpPostNo, @PathVariable("commentNo") int commentNo) {
		commentService.setEditComment(editComment);
		CommentDTO comment = commentService.getCommentByNo(commentNo);
		return comment;
	}
	
	// 댓글 삭제 처리, @ResponseBody + return 문자열 "success" ???
	@DeleteMapping("/help-posts/{helpPostNo}/comments/{commentNo}")
	@ResponseBody
	public String submitDeleteComment(@PathVariable("helpPostNo") int helpPostNo, @PathVariable("commentNo") int commentNo) {
		commentService.setDeleteComment(commentNo);
		return "success";
	}

}
