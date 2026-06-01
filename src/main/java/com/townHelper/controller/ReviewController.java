package com.townHelper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.townHelper.domain.ReviewDTO;
import com.townHelper.domain.ReviewSummaryDTO;
import com.townHelper.service.ReviewService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ReviewController {
	
	@Autowired
	ReviewService reviewService;
	
	@GetMapping("/reviews/{targetUserNo}/summary")
	public String getReviewsSummary(@PathVariable("targetUserNo") int targetUserNo, Model model) {
		List<ReviewSummaryDTO> reviewList = reviewService.getReviewsSummary(targetUserNo);
		model.addAttribute("reviewList", reviewList);
		return "reviewsByUser";
	}
	
	@GetMapping("/reviews/{reviewNo}/detail")
	public String getReviewByNo(@PathVariable("reviewNo") int reviewNo, Model model) {
		ReviewDTO review = reviewService.getReviewByNo(reviewNo);
		model.addAttribute("review", review);
		return "review";
	}
	
	@GetMapping("/reviews/{targetUserNo}/new")
	public String getNewReview(@PathVariable("targetUserNo") int targetUserNo, @RequestParam("targetType") String targetType, @RequestParam("helpPostNo") int helpPostNo, @ModelAttribute("newReview") ReviewDTO newReview) {
		newReview.setTargetUserNo(targetUserNo);
		newReview.setTargetType(targetType);
		newReview.setHelpPostNo(helpPostNo);
		return "newReview";
	}
	
	@PostMapping("/reviews/{targetUserNo}")
	public String submitReview(@PathVariable("targetUserNo") int targetUserNo, @ModelAttribute("newReview") ReviewDTO newReview, HttpSession session) {
		
		Integer loginUserNo = (Integer) session.getAttribute("loginUserNo");
		newReview.setWriterUserNo(loginUserNo);
		
		newReview.setTargetUserNo(targetUserNo);
		int returnedPK = reviewService.setNewReview(newReview);
		return "redirect:/reviews/" + returnedPK + "/detail";
	}

}
