package com.townHelper.domain;

import java.time.LocalDateTime;

public class ReviewDTO {

	private int reviewNo;
	private int helpPostNo;
	private String helpCategory;
	private int writerUserNo;
	private String writerUserId;
	private int targetUserNo;
	private String targetUserId;

	// Requester || helper 구분
	private String targetType;

	private int reviewStar;
	private String reviewContent;
	private LocalDateTime reviewCreatedAt;
	
	public ReviewDTO() {
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

	public String getHelpCategory() {
		return helpCategory;
	}

	public void setHelpCategory(String helpCategory) {
		this.helpCategory = helpCategory;
	}

	public int getWriterUserNo() {
		return writerUserNo;
	}

	public void setWriterUserNo(int writerUserNo) {
		this.writerUserNo = writerUserNo;
	}

	public String getWriterUserId() {
		return writerUserId;
	}

	public void setWriterUserId(String writerUserId) {
		this.writerUserId = writerUserId;
	}

	public int getTargetUserNo() {
		return targetUserNo;
	}

	public void setTargetUserNo(int targetUserNo) {
		this.targetUserNo = targetUserNo;
	}

	public String getTargetUserId() {
		return targetUserId;
	}

	public void setTargetUserId(String targetUserId) {
		this.targetUserId = targetUserId;
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

	public LocalDateTime getReviewCreatedAt() {
		return reviewCreatedAt;
	}

	public void setReviewCreatedAt(LocalDateTime reviewCreatedAt) {
		this.reviewCreatedAt = reviewCreatedAt;
	}

}
