package com.townHelper.domain;

import java.time.LocalDateTime;

public class CommentDTO {

	private int commentNo;
	private int userNo;
	private String userId;
	private int helpPostNo;
	private String commentContent;
	private LocalDateTime commentCreatedAt;
	private LocalDateTime commentUpdatedAt;
	private boolean isDeleted;

	public CommentDTO() {
	}

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
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

	public int getHelpPostNo() {
		return helpPostNo;
	}

	public void setHelpPostNo(int helpPostNo) {
		this.helpPostNo = helpPostNo;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public LocalDateTime getCommentCreatedAt() {
		return commentCreatedAt;
	}

	public void setCommentCreatedAt(LocalDateTime commentCreatedAt) {
		this.commentCreatedAt = commentCreatedAt;
	}

	public LocalDateTime getCommentUpdatedAt() {
		return commentUpdatedAt;
	}

	public void setCommentUpdatedAt(LocalDateTime commentUpdatedAt) {
		this.commentUpdatedAt = commentUpdatedAt;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

}
