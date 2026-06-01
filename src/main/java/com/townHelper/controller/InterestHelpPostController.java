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
	
	@GetMapping("/interestHelpPosts")
	public String getInterestHelpPosts(Model model, HttpSession session) {
		
		int loginUserNo = (Integer) session.getAttribute("loginUserNo");
		
		List<InterestHelpPostDTO> interestHelpPostList =  interestHelpPostService.getAllInterestHelpPosts(loginUserNo);
		model.addAttribute("interestHelpPostList", interestHelpPostList);
		model.addAttribute("loginUserNo", loginUserNo);
		return "interestHelpPosts";
	}
	
	@PostMapping("/interestHelpPosts")
	@ResponseBody
	public List<InterestHelpPostDTO> submitNewInterestHelpPost(@RequestBody InterestHelpPostDTO newInterestHelpPost, HttpSession session) {
		int loginUserNo = (Integer) session.getAttribute("loginUserNo");
		newInterestHelpPost.setUserNo(loginUserNo);
		interestHelpPostService.setNewInterestHelpPost(newInterestHelpPost);
		List<InterestHelpPostDTO> interestHelpPostList =  interestHelpPostService.getAllInterestHelpPosts(loginUserNo);
		return interestHelpPostList;
	}
	
	@DeleteMapping("/interestHelpPosts/{helpPostNo}")
	@ResponseBody
	public List<InterestHelpPostDTO> submitDeleteInterestHelpPost(@PathVariable("helpPostNo") int helpPostNo, HttpSession session) {
		int loginUserNo = (Integer) session.getAttribute("loginUserNo");
		interestHelpPostService.setDeleteInterestHelpPost(loginUserNo, helpPostNo);
		List<InterestHelpPostDTO> interestHelpPostList =  interestHelpPostService.getAllInterestHelpPosts(loginUserNo);
		return interestHelpPostList; 
	}
	
}
