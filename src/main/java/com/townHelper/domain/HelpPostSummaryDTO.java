package com.townHelper.domain;

import java.time.LocalDateTime;

// 게시글 목록 조회용
public class HelpPostSummaryDTO {

	private int helpPostNo;
	private String userId;
	private String helpCategory;
	private String postAddrGu;
	private String postAddrDong;
	private String postTitle;
	private int expectedPay;
	private int expectedHelperCount;
	private int currentHelperCount;
	private LocalDateTime requestTime;
	private String postStatus;
	private LocalDateTime postCreatedAt;
	private LocalDateTime postUpdatedAt;

	public HelpPostSummaryDTO() {
	}

	public int getHelpPostNo() {
		return helpPostNo;
	}

	public void setHelpPostNo(int helpPostNo) {
		this.helpPostNo = helpPostNo;
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

	public int getExpectedPay() {
		return expectedPay;
	}

	public void setExpectedPay(int expectedPay) {
		this.expectedPay = expectedPay;
	}

	public int getExpectedHelperCount() {
		return expectedHelperCount;
	}

	public void setExpectedHelperCount(int expectedHelperCount) {
		this.expectedHelperCount = expectedHelperCount;
	}

	public int getCurrentHelperCount() {
		return currentHelperCount;
	}

	public void setCurrentHelperCount(int currentHelperCount) {
		this.currentHelperCount = currentHelperCount;
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

}
