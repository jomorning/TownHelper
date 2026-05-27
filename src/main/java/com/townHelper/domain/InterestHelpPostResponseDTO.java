package com.townHelper.domain;

public class InterestHelpPostResponseDTO {

	private int interestHelpPost;
	private int userNo;
	private int helpPostNo;
	private String helpCategory;
	private String helpPostTitle;

	public InterestHelpPostResponseDTO() {
	}

	public int getInterestHelpPost() {
		return interestHelpPost;
	}

	public void setInterestHelpPost(int interestHelpPost) {
		this.interestHelpPost = interestHelpPost;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getHelpPostNo() {
		return helpPostNo;
	}

	public void setHelpPostNo(int helpPostNo) {
		this.helpPostNo = helpPostNo;
	}

	public String getHelpCategory() {
		return helpCategory;
	}

	public void setHelpCategory(String helpCategory) {
		this.helpCategory = helpCategory;
	}

	public String getHelpPostTitle() {
		return helpPostTitle;
	}

	public void setHelpPostTitle(String helpPostTitle) {
		this.helpPostTitle = helpPostTitle;
	}

}
