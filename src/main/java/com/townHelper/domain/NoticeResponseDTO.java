package com.townHelper.domain;

import java.time.LocalDateTime;

public class NoticeResponseDTO {

	private int noticeNo;
	private String userId;
	private String noticeTitle;
	private String noticeContent;
	private LocalDateTime noticeCreatedAt;
	private LocalDateTime noticeUpdatedAt;

	public NoticeResponseDTO() {
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public LocalDateTime getNoticeCreatedAt() {
		return noticeCreatedAt;
	}

	public void setNoticeCreatedAt(LocalDateTime noticeCreatedAt) {
		this.noticeCreatedAt = noticeCreatedAt;
	}

	public LocalDateTime getNoticeUpdatedAt() {
		return noticeUpdatedAt;
	}

	public void setNoticeUpdatedAt(LocalDateTime noticeUpdatedAt) {
		this.noticeUpdatedAt = noticeUpdatedAt;
	}

}
