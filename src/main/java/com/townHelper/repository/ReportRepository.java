package com.townHelper.repository;

import java.util.List;

import com.townHelper.domain.ReportDTO;

public interface ReportRepository {
	
	// 관리자용 전체 신고 내역 조회
	List<ReportDTO> getAllReports();
	
	// 사용자당 신고한 내역 조회
	List<ReportDTO> getAllReportsByUserNo(int userNo);
	
	// 관리자용 신고 처리 상태 설정
	void setReportStatus(int reportNo, String reportStatus);
	
	void setNewReport(String reportTargetType, int reportTargetNo);

}
