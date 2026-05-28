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

import com.townHelper.domain.UserDTO;
import com.townHelper.domain.UserProfileSummaryDTO;
import com.townHelper.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	// 관리자용 전체 사용자 조회
	@GetMapping("/users")
	public String getUsers(Model model) {
		List<UserProfileSummaryDTO> userList = userService.getAllUsersSummary();
		model.addAttribute("userList", userList);
		return "users";
	}
	
	// 타 사용자 조회
	@GetMapping("/users/{userNo}")
	public String getUserByNo(@PathVariable("userNo") int userNo, Model model) {
		UserProfileSummaryDTO user = userService.getUserSummaryByNo(userNo);
		model.addAttribute("user", user);
		return "user";
	}

	// 회원 가입
	@GetMapping("/users/register")
	public String getRegister(@ModelAttribute("newUser") UserDTO newUser) {
		return "register";
	}

	// 회원 가입 제출
	@PostMapping("/users")
	public String submitRegister(@ModelAttribute("newUser") UserDTO newUser) {
		userService.setNewUser(newUser);
		return "main";
	}

	// 회원 정보 수정
	@GetMapping("/users/{userNo}/edit")
	public String getEditUser(@PathVariable("userNo") int userNo, Model model) {
		UserDTO user = userService.getUserByNo(userNo);
		model.addAttribute("editUser", user);
		return "editUser";
	}

	// 회원 정보 수정 제출
	@PutMapping("/users/{userNo}")
	public String submitEditUser(@ModelAttribute("editUser") UserDTO editUser) {
		userService.setEditUser(editUser);
		return "redirect:/users/" + editUser.getUserNo();
	}

	// 회원 탈퇴 제출
	@DeleteMapping("/users/{userNo}")
	public String submitDeleteUser(@PathVariable("userNo") int userNo) {
		userService.setDeleteUser(userNo);
		return "redirect:/";
	}
}
