package com.townHelper.domain;

import java.time.LocalDateTime;

public class ReportResponseDTO {

	private int reportNo;
	private int userNo;
	private String userId;
	private String reportTargetType;
	private String reportTargetUserId;
	private String reportReason;
	private String reportContent;
	private String reportStatus;
	private LocalDateTime reportCreatedAt;
	private LocalDateTime reportProcessedAt;

	public ReportResponseDTO() {
	}

	public int getReportNo() {
		return reportNo;
	}

	public void setReportNo(int reportNo) {
		this.reportNo = reportNo;
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

	public String getReportTargetType() {
		return reportTargetType;
	}

	public void setReportTargetType(String reportTargetType) {
		this.reportTargetType = reportTargetType;
	}

	public String getReportTargetUserId() {
		return reportTargetUserId;
	}

	public void setReportTargetUserId(String reportTargetUserId) {
		this.reportTargetUserId = reportTargetUserId;
	}

	public String getReportReason() {
		return reportReason;
	}

	public void setReportReason(String reportReason) {
		this.reportReason = reportReason;
	}

	public String getReportContent() {
		return reportContent;
	}

	public void setReportContent(String reportContent) {
		this.reportContent = reportContent;
	}

	public String getReportStatus() {
		return reportStatus;
	}

	public void setReportStatus(String reportStatus) {
		this.reportStatus = reportStatus;
	}

	public LocalDateTime getReportCreatedAt() {
		return reportCreatedAt;
	}

	public void setReportCreatedAt(LocalDateTime reportCreatedAt) {
		this.reportCreatedAt = reportCreatedAt;
	}

	public LocalDateTime getReportProcessedAt() {
		return reportProcessedAt;
	}

	public void setReportProcessedAt(LocalDateTime reportProcessedAt) {
		this.reportProcessedAt = reportProcessedAt;
	}

}
