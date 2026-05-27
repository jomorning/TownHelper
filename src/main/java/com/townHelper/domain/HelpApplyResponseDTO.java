package com.townHelper.domain;

import java.time.LocalDateTime;

public class HelpApplyResponseDTO {

	private int helpApplyNo;
	private String userId;
	private int suggestedPay;
	private String appealContent;
	private String applyStatus;
	private LocalDateTime applyCreatedAt;

	public HelpApplyResponseDTO() {
	}

	public int getHelpApplyNo() {
		return helpApplyNo;
	}

	public void setHelpApplyNo(int helpApplyNo) {
		this.helpApplyNo = helpApplyNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getSuggestedPay() {
		return suggestedPay;
	}

	public void setSuggestedPay(int suggestedPay) {
		this.suggestedPay = suggestedPay;
	}

	public String getAppealContent() {
		return appealContent;
	}

	public void setAppealContent(String appealContent) {
		this.appealContent = appealContent;
	}

	public String getApplyStatus() {
		return applyStatus;
	}

	public void setApplyStatus(String applyStatus) {
		this.applyStatus = applyStatus;
	}

	public LocalDateTime getApplyCreatedAt() {
		return applyCreatedAt;
	}

	public void setApplyCreatedAt(LocalDateTime applyCreatedAt) {
		this.applyCreatedAt = applyCreatedAt;
	}

}
