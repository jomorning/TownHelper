package com.townHelper.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.townHelper.domain.HelpPostSummaryDTO;
import com.townHelper.domain.InterestHelpPostDTO;
import com.townHelper.domain.UserDTO;
import com.townHelper.service.HelpPostService;
import com.townHelper.service.InterestHelpPostService;
import com.townHelper.service.ReviewService;
import com.townHelper.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

	@Autowired
	HelpPostService helpPostService;

	@Autowired
	InterestHelpPostService interestHelpPostService;

	@Autowired
	UserService userService;

	@Autowired
	ReviewService reviewService;

	@GetMapping("/")
	public String getMain(Model model, HttpSession session,
			@RequestParam(value = "login", required = false) String isLogin, Principal principal) {

		if ("true".equals(isLogin) && !isLogin.isEmpty()) {
			String loginUserId = principal.getName();
			User userById = userService.getUserById(loginUserId);
			int loginUserNo = userById.getUserNo();

			System.out.println("현재 로그인 사용자: " + loginUserNo);
		}

		if (loginUserNo == null) {
			return "redirect:/login";
		}

		List<HelpPostSummaryDTO> helpPostList = helpPostService.getAllHelpPostsSummary(loginUserNo);
		List<InterestHelpPostDTO> interestHelpPostList = interestHelpPostService.getAllInterestHelpPosts(loginUserNo);

		model.addAttribute("loginUserNo", loginUserNo);
		model.addAttribute("helpPostList", helpPostList);
		model.addAttribute("interestHelpPostList", interestHelpPostList);

		UserDTO loginUser = userService.getUserByNo(loginUserNo);
		// int helperWorkCount = helpApplyService.getAcceptedHelpCount(loginUserNo);
		// double averageReviewStar = reviewService.getAverageReviewStar(loginUserNo);

		model.addAttribute("loginUser", loginUser);
		// model.addAttribute("helperWorkCount", helperWorkCount);
		// model.addAttribute("averageReviewStar", averageReviewStar);
		return "main";
	}

	@GetMapping("/login")
	public String getLogin() {
		return "login";
	}

}
