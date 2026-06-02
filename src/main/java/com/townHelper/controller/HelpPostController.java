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

import com.townHelper.domain.CommentDTO;
import com.townHelper.domain.HelpApplyDTO;
import com.townHelper.domain.HelpPostDTO;
import com.townHelper.domain.HelpPostSummaryDTO;
import com.townHelper.service.CommentService;
import com.townHelper.service.HelpApplyService;
import com.townHelper.service.HelpPostService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HelpPostController {

	@Autowired
	HelpPostService helpPostService;

	@Autowired
	CommentService commentService;

	@Autowired
	HelpApplyService helpApplyService;

	@GetMapping("/help-posts")
	public String getHelpPosts(Model model, HttpSession session) {

		int loginUserNo = (Integer) session.getAttribute("loginUserNo");

		List<HelpPostSummaryDTO> helpPostList = helpPostService.getAllHelpPostsSummary(loginUserNo);
		model.addAttribute("helpPostList", helpPostList);
		return "helpPosts";
	}

	@GetMapping("/help-posts/{helpPostNo}")
	public String getHelpPostByNo(@PathVariable("helpPostNo") int helpPostNo, Model model, HttpSession session) {

		int loginUserNo = (Integer) session.getAttribute("loginUserNo");

		HelpPostDTO helpPost = helpPostService.getHelpPostByNo(helpPostNo);
		List<CommentDTO> commentList = commentService.getAllCommentsByPost(helpPostNo);
		model.addAttribute("helpPost", helpPost);
		model.addAttribute("commentList", commentList);

		if ("COMPLETE".equals(helpPost.getPostStatus()) && helpPost.getUserNo() == loginUserNo) {
			model.addAttribute("completedRequester", true);
		}

		List<HelpApplyDTO> applyList = helpApplyService.getAppliesByCompletedHelpPost(helpPostNo);

		for (int i = 0; i < applyList.size(); i++) {

			if (applyList.get(i).getUserNo() == loginUserNo) {
				model.addAttribute("completedHelper", true);
			}
		}

		return "helpPost";

	}

	@PutMapping("/help-posts/{helpPostNo}/complete")
	public String submitHelpPostComplete(@PathVariable("helpPostNo") int helpPostNo) {
		helpPostService.setHelpPostComplete(helpPostNo);
		return "redirect:/help-posts/" + helpPostNo;
	}

	@GetMapping("/help-posts/new")
	public String getNewHelpPost(@ModelAttribute("newHelpPost") HelpPostDTO newHelpPost) {
		return "newHelpPost";
	}

	@PostMapping("/help-posts")
	public String submitNewHelpPost(@ModelAttribute("newHelpPost") HelpPostDTO newHelpPost, HttpSession session) {

		Integer loginUserNo = (Integer) session.getAttribute("loginUserNo");
		newHelpPost.setUserNo(loginUserNo);

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
