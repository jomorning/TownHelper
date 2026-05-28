package com.townHelper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.townHelper.domain.HelpPostDTO;
import com.townHelper.domain.HelpPostSummaryDTO;
import com.townHelper.service.CommentService;
import com.townHelper.service.HelpPostService;

@Controller
public class HelpPostController {
	
	@Autowired
	HelpPostService helpPostService;
	
	@Autowired
	CommentService commentService;	
	
	@GetMapping("/help-posts")
	public String getHelpPosts(Model model) {
		List<HelpPostSummaryDTO> helpPostList = helpPostService.getAllHelpPostsSummary();
		model.addAttribute("helpPostList", helpPostList);
		return "helpPosts";
	}
	
	@GetMapping("/help-posts/{helpPostNo}")
	public String getHelpPostByNo(@PathVariable("helpPostNo") int helpPostNo, Model model) {
		HelpPostDTO helpPost = helpPostService.getHelpPostByNo(helpPostNo);
		model.addAttribute("helpPost", helpPost);
		return "helpPost";
	}
	
	@GetMapping("/help-posts/new")
	public String getNewHelpPost(@ModelAttribute("newHelpPost") HelpPostDTO newHelpPost) {
		return "newHelpPost";
	}
	
	@PostMapping("/help-posts")
	public String submitNewHelpPost(@ModelAttribute("newHelpPost") HelpPostDTO newHelpPost) {
		
		// 임시 작성자
		newHelpPost.setUserNo(1);
		Integer returnedPK = helpPostService.setNewHelpPost(newHelpPost);
		return "redirect:/help-posts/" + returnedPK;
	}
	
	@GetMapping("/help-posts/{helpPostNo}/edit")
	public String getEditHelpPost(@PathVariable("helpPostNo") int helpPostNo, Model model) {
		HelpPostDTO helpPost = helpPostService.getHelpPostByNo(helpPostNo);
		model.addAttribute("editHelpPost", helpPost);
		return "editHelpPost";
	}
	
	@PutMapping("/help-posts/{helpPostNo}")
	public String submitEditHelpPost(@ModelAttribute("editHelpPost") HelpPostDTO editHelpPost) {
		helpPostService.setEditHelpPost(editHelpPost);
		return "redirect:/help-posts/" + editHelpPost.getHelpPostNo();
	}
	
	@DeleteMapping("/help-posts/{helpPostNo}")
	public String submitDeleteHelpPost(@PathVariable("helpPostNo") int helpPostNo) {
		helpPostService.setDeleteHelpPost(helpPostNo);
		return "redirect:/help-posts";
	}

}
