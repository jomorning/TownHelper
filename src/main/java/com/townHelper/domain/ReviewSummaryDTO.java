package com.townHelper.domain;

import java.time.LocalDateTime;

public class ReviewSummaryDTO {

	private int reviewNo;
	private String helpCategory;
	private int writerUserId;

	// Requester || helper 구분
	private String targetType;

	private int reviewStar;
	private String reviewContent;
	private LocalDateTime reviewCreatedAt;
	
	public ReviewSummaryDTO() {
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public String getHelpCategory() {
		return helpCategory;
	}

	public void setHelpCategory(String helpCategory) {
		this.helpCategory = helpCategory;
	}

	public int getWriterUserId() {
		return writerUserId;
	}

	public void setWriterUserId(int writerUserId) {
		this.writerUserId = writerUserId;
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
