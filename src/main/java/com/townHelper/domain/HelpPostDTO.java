package com.townHelper.domain;

import java.time.LocalDateTime;

// 게시글 단건 조회용
public class HelpPostDTO {

	private int helpPostNo;
	private int userNo;
	private String userId;
	private String helpCategory;
	private String postAddrGu;
	private String postAddrDong;
	private String postTitle;
	private String postContent;
	private int expectedPay;
	private int finalPay;
	private int expectedHelperCount;
	private int appliedHelperCount;
	private int acceptedHelperCount;
	private String wantedSkill;
	private LocalDateTime requestTime;
	private String postStatus;
	private LocalDateTime postCreatedAt;
	private LocalDateTime postUpdatedAt;
	private boolean isDeleted;

	public HelpPostDTO() {
	}

	public int getHelpPostNo() {
		return helpPostNo;
	}

	public void setHelpPostNo(int helpPostNo) {
		this.helpPostNo = helpPostNo;
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

	public String getHelpCategory() {
		return helpCategory;
	}

	public void setHelpCategory(String helpCategory) {
		this.helpCategory = helpCategory;
	}

	public String getPostAddrGu() {
		return postAddrGu;
	}

	public void setPostAddrGu(String postAddrGu) {
		this.postAddrGu = postAddrGu;
	}

	public String getPostAddrDong() {
		return postAddrDong;
	}

	public void setPostAddrDong(String postAddrDong) {
		this.postAddrDong = postAddrDong;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public int getExpectedPay() {
		return expectedPay;
	}

	public void setExpectedPay(int expectedPay) {
		this.expectedPay = expectedPay;
	}

	public int getFinalPay() {
		return finalPay;
	}

	public void setFinalPay(int finalPay) {
		this.finalPay = finalPay;
	}

	public int getExpectedHelperCount() {
		return expectedHelperCount;
	}

	public void setExpectedHelperCount(int expectedHelperCount) {
		this.expectedHelperCount = expectedHelperCount;
	}

	public int getAppliedHelperCount() {
		return appliedHelperCount;
	}

	public void setAppliedHelperCount(int appliedHelperCount) {
		this.appliedHelperCount = appliedHelperCount;
	}

	public int getAcceptedHelperCount() {
		return acceptedHelperCount;
	}

	public void setAcceptedHelperCount(int acceptedHelperCount) {
		this.acceptedHelperCount = acceptedHelperCount;
	}

	public String getWantedSkill() {
		return wantedSkill;
	}

	public void setWantedSkill(String wantedSkill) {
		this.wantedSkill = wantedSkill;
	}

	public LocalDateTime getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(LocalDateTime requestTime) {
		this.requestTime = requestTime;
	}

	public String getPostStatus() {
		return postStatus;
	}

	public void setPostStatus(String postStatus) {
		this.postStatus = postStatus;
	}

	public LocalDateTime getPostCreatedAt() {
		return postCreatedAt;
	}

	public void setPostCreatedAt(LocalDateTime postCreatedAt) {
		this.postCreatedAt = postCreatedAt;
	}

	public LocalDateTime getPostUpdatedAt() {
		return postUpdatedAt;
	}

	public void setPostUpdatedAt(LocalDateTime postUpdatedAt) {
		this.postUpdatedAt = postUpdatedAt;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

}
