package com.townHelper.domain;

import java.time.LocalDateTime;

public class ReportRequestDTO {

	private int reportNo;
	private int userNo;
	private String reportTargetType;
	private int reportTargetNo;
	private String reportReason;
	private String reportContent;
	private String reportStatus;
	private LocalDateTime reportProcessedAt;

	public ReportRequestDTO() {
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

	public String getReportTargetType() {
		return reportTargetType;
	}

	public void setReportTargetType(String reportTargetType) {
		this.reportTargetType = reportTargetType;
	}

	public int getReportTargetNo() {
		return reportTargetNo;
	}

	public void setReportTargetNo(int reportTargetNo) {
		this.reportTargetNo = reportTargetNo;
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

	public LocalDateTime getReportProcessedAt() {
		return reportProcessedAt;
	}

	public void setReportProcessedAt(LocalDateTime reportProcessedAt) {
		this.reportProcessedAt = reportProcessedAt;
	}

}
