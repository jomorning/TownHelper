package com.townHelper.domain;

public class HelpApplyRequestDTO {

	private int helpApplyNo;
	private int userNo;
	private int helpPostNo;
	private int suggestedPay;
	private String appealContent;
	private String applyStatus;

	public HelpApplyRequestDTO() {
	}

	public int getHelpApplyNo() {
		return helpApplyNo;
	}

	public void setHelpApplyNo(int helpApplyNo) {
		this.helpApplyNo = helpApplyNo;
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

}
