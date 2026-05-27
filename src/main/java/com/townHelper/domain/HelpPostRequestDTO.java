package com.townHelper.domain;

import java.time.LocalDateTime;

// 게시글 작성, 수정용
public class HelpPostRequestDTO {

	private int helpPostNo;
	private int userNo;
	private String helpCategory;
	private String postAddrGu;
	private String postAddrDong;
	private String postTitle;
	private String postContent;
	private int expectedPay;
	private int expectedHelperCount;
	private String wantedSkill;
	private LocalDateTime requestTime;
	private String postStatus; 

	public HelpPostRequestDTO() {
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

	public int getExpectedHelperCount() {
		return expectedHelperCount;
	}

	public void setExpectedHelperCount(int expectedHelperCount) {
		this.expectedHelperCount = expectedHelperCount;
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

}
