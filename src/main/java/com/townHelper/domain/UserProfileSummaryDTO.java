package com.townHelper.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

// 타 사용자 계정 조회용, 관리자 조회용
public class UserProfileSummaryDTO {

	private int userNo;
	private String userId;
	private String userGender;
	private LocalDate userBirth;
	private int userAge;
	private String userAddrGu;
	private String userAddrDong;
	private String userSkill;
	private String profileImgName;
	private String profileImgPath;
	private int mannerScore;
	private int requesterCompletedCount;
	private int helperCompletedCount;
	private LocalDateTime userCreatedAt;

	public UserProfileSummaryDTO() {
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

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
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

	public int getMannerScore() {
		return mannerScore;
	}

	public void setMannerScore(int mannerScore) {
		this.mannerScore = mannerScore;
	}

	public int getRequesterCompletedCount() {
		return requesterCompletedCount;
	}

	public void setRequesterCompletedCount(int requesterCompletedCount) {
		this.requesterCompletedCount = requesterCompletedCount;
	}

	public int getHelperCompletedCount() {
		return helperCompletedCount;
	}

	public void setHelperCompletedCount(int helperCompletedCount) {
		this.helperCompletedCount = helperCompletedCount;
	}

	public LocalDateTime getUserCreatedAt() {
		return userCreatedAt;
	}

	public void setUserCreatedAt(LocalDateTime userCreatedAt) {
		this.userCreatedAt = userCreatedAt;
	}
	
}
