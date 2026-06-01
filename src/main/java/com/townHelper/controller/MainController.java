package com.townHelper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.townHelper.domain.HelpPostSummaryDTO;
import com.townHelper.service.HelpPostService;

@Controller
public class MainController {

	@Autowired
	HelpPostService helpPostService;

	@GetMapping("/")
	public String getMain(Model model) {
		List<HelpPostSummaryDTO> helpPostList = helpPostService.getAllHelpPostsSummary();
		model.addAttribute("helpPostList", helpPostList);
		
		System.out.println(helpPostList.get(0).getPostTitle());
		
		return "main";
	}

	@GetMapping("/login")
	public String getLogin() {
		return "login";
	}

}
