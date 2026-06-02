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

import com.townHelper.domain.HelpApplyDTO;
import com.townHelper.service.HelpApplyService;
import com.townHelper.service.HelpPostService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HelpApplyController {
	
	@Autowired
	HelpApplyService helpApplyService;
	
	@Autowired
	HelpPostService helpPostService;
	
	@GetMapping("/help-posts/{helpPostNo}/help-applies")
	@ResponseBody
	public List<HelpApplyDTO> getAllHelpAppliesByPost(@PathVariable("helpPostNo") int helpPostNo) {
		List<HelpApplyDTO> helpApplyList = helpApplyService.getAllHelpAppliesByPost(helpPostNo);
		return helpApplyList;
	} 
	
	@PutMapping("/help-posts/{helpPostNo}/help-applies/{helpApplyNo}/status")
	@ResponseBody
	public List<HelpApplyDTO> submitHelpApplyStatus(@PathVariable("helpPostNo") int helpPostNo, @PathVariable("helpApplyNo") int helpApplyNo, @RequestBody HelpApplyDTO apply) {
		apply.setHelpPostNo(helpPostNo);
		helpApplyService.setApplyStatus(apply);		
		List<HelpApplyDTO> helpApplyList = helpApplyService.getAllHelpAppliesByPost(helpPostNo);
		return helpApplyList;
	}
	
	@PostMapping("/help-posts/{helpPostNo}/help-applies")
	@ResponseBody
	public List<HelpApplyDTO> submitNewHelpApply(@PathVariable("helpPostNo") int helpPostNo, @RequestBody HelpApplyDTO newApply, HttpSession session) {
		
		int loginUserNo = (Integer) session.getAttribute("loginUserNo");
		newApply.setUserNo(loginUserNo);
		helpApplyService.setNewHelpApply(newApply);
		List<HelpApplyDTO> helpApplyList = helpApplyService.getAllHelpAppliesByPost(helpPostNo);
		return helpApplyList;
	}
	
	@PutMapping("/help-posts/{helpPostNo}/help-applies/{helpApplyNo}")
	@ResponseBody
	public List<HelpApplyDTO> submitEditHelpApply(@PathVariable("helpPostNo") int helpPostNo, @RequestBody HelpApplyDTO editApply) {
		helpApplyService.setEditHelpApply(editApply);
		List<HelpApplyDTO> helpApplyList = helpApplyService.getAllHelpAppliesByPost(helpPostNo);
		return helpApplyList;
	}
	
	@DeleteMapping("/help-posts/{helpPostNo}/help-applies/{helpApplyNo}")
	@ResponseBody
	public List<HelpApplyDTO> submitDeleteHelpApply(@PathVariable("helpPostNo") int helpPostNo, @PathVariable("helpApplyNo") int helpApplyNo) {
		helpApplyService.setDeleteHelpApply(helpPostNo, helpApplyNo);
		List<HelpApplyDTO> helpApplyList = helpApplyService.getAllHelpAppliesByPost(helpPostNo);
		return helpApplyList;
	}

}	
