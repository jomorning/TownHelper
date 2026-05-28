package com.townHelper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.townHelper.domain.CommentRequestDTO;
import com.townHelper.domain.CommentResponseDTO;
import com.townHelper.service.CommentService;

@Controller
public class CommentController {
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	CommentService commentService;
	
	@GetMapping("/help-posts/{helpPostNo}/comments")
	@ResponseBody
	public String getAllCommentsByPost(@ModelAttribute("newComment") CommentRequestDTO newComment, @PathVariable("helpPostNo") int helpPostNo) {
		List<CommentResponseDTO> commentList = commentService.getAllCommentsByPost(helpPostNo);
		
		String json = null;
		try {
			json = objectMapper.writeValueAsString(commentList);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}

}
