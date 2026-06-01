package com.townHelper.domain;

public class InterestHelpPostDTO {

	private int interestHelpPostNo;
	private int userNo;
	private int helpPostNo;
	private String helpCategory;
	private String helpPostTitle;

	public InterestHelpPostDTO() {
	}

	public int getInterestHelpPostNo() {
		return interestHelpPostNo;
	}

	public void setInterestHelpPostNo(int interestHelpPostNo) {
		this.interestHelpPostNo = interestHelpPostNo;
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
