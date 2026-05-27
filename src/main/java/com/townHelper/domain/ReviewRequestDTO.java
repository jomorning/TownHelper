package com.townHelper.domain;

public class ReviewRequestDTO {

	private int reviewNo;
	private int helpPostNo;
	private int writerUserNo;
	private int targetUserNo;

	// Requester || helper 구분
	private String targetType;

	private int reviewStar;
	private String reviewContent;
	
	public ReviewRequestDTO() {
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public int getHelpPostNo() {
		return helpPostNo;
	}

	public void setHelpPostNo(int helpPostNo) {
		this.helpPostNo = helpPostNo;
	}

	public int getWriterUserNo() {
		return writerUserNo;
	}

	public void setWriterUserNo(int writerUserNo) {
		this.writerUserNo = writerUserNo;
	}

	public int getTargetUserNo() {
		return targetUserNo;
	}

	public void setTargetUserNo(int targetUserNo) {
		this.targetUserNo = targetUserNo;
	}

	public String getTargetType() {
		return targetType;
	}

	public void setTargetType(String targetType) {
		this.targetType = targetType;
	}

	public int getReviewStar() {
		return reviewStar;
	}

	public void setReviewStar(int reviewStar) {
		this.reviewStar = reviewStar;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

}
