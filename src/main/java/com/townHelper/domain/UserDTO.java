package com.townHelper.domain;

import java.time.LocalDate;

// 회원 가입용, 회원 정보 수정용
public class UserDTO {
	
	private int userNo;
	private String userId;
	private String userPw;
	private String userName;
	private String userGender;
	private LocalDate userBirth;
	private String userAddrGu;
	private String userAddrDong;
	private String userSkill;
	private String userRole;
	private String profileImgName;
	private String profileImgPath;
	
	public UserDTO() {
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public LocalDate getUserBirth() {
		return userBirth;
	}

	public void setUserBirth(LocalDate userBirth) {
		this.userBirth = userBirth;
	}

	public String getUserAddrGu() {
		return userAddrGu;
	}

	public void setUserAddrGu(String userAddrGu) {
		this.userAddrGu = userAddrGu;
	}

	public String getUserAddrDong() {
		return userAddrDong;
	}

	public void setUserAddrDong(String userAddrDong) {
		this.userAddrDong = userAddrDong;
	}

	public String getUserSkill() {
		return userSkill;
	}

	public void setUserSkill(String userSkill) {
		this.userSkill = userSkill;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getProfileImgName() {
		return profileImgName;
	}

	public void setProfileImgName(String profileImgName) {
		this.profileImgName = profileImgName;
	}

	public String getProfileImgPath() {
		return profileImgPath;
	}

	public void setProfileImgPath(String profileImgPath) {
		this.profileImgPath = profileImgPath;
	}

}
