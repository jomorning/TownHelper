package com.townHelper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.townHelper.domain.InterestHelpPostDTO;
import com.townHelper.service.InterestHelpPostService;

import jakarta.servlet.http.HttpSession;

@Controller
public class InterestHelpPostController {
	
	@Autowired
	InterestHelpPostService interestHelpPostService;
	
	@GetMapping("/users/{userNo}/interestHelpPosts")
	public String getInterestHelpPosts(@PathVariable("userNo") int userNo, Model model, HttpSession session) {
		
		int loginUserNo = (Integer) session.getAttribute("loginUserNo");
		
		List<InterestHelpPostDTO> interestHelpPostList =  interestHelpPostService.getAllInterestHelpPosts(userNo);
		model.addAttribute("interestHelpPostList", interestHelpPostList);
		model.addAttribute("loginUserNo", loginUserNo);
		return "interestHelpPosts";
	}
	
	@PostMapping("/users/{userNo}/interestHelpPosts")
	@ResponseBody
	public List<InterestHelpPostDTO> submitNewInterestHelpPost(@PathVariable("userNo") int userNo, @RequestBody InterestHelpPostDTO newInterestHelpPost) {
		interestHelpPostService.setNewInterestHelpPost(newInterestHelpPost);
		List<InterestHelpPostDTO> interestHelpPostList =  interestHelpPostService.getAllInterestHelpPosts(userNo);
		return interestHelpPostList; 
	}
	
	@DeleteMapping("/users/{userNo}/interestHelpPosts/{helpPostNo}")
	@ResponseBody
	public List<InterestHelpPostDTO> submitDeleteInterestHelpPost(@PathVariable("userNo") int userNo, @PathVariable("helpPostNo") int helpPostNo) {
		interestHelpPostService.setDeleteInterestHelpPost(userNo, helpPostNo);
		List<InterestHelpPostDTO> interestHelpPostList =  interestHelpPostService.getAllInterestHelpPosts(userNo);
		return interestHelpPostList; 
	}
	
}
