package com.townHelper.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.townHelper.domain.ReportRequestDTO;

public class ReportRequestRowMapper implements RowMapper<ReportRequestDTO> {

	@Override
	public ReportRequestDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ReportRequestDTO report = new ReportRequestDTO();
		report.setReportNo(rs.getInt("report_no"));
		report.setUserNo(rs.getInt("user_no"));
		report.setReportTargetType(rs.getString("report_target_type"));
		report.setReportTargetNo(rs.getInt("report_target_no"));
		report.setReportReason(rs.getString("report_reason"));
		report.setReportContent(rs.getString("report_content"));
		report.setReportStatus(rs.getString("report_status"));
		report.setReportProcessedAt(rs.getTimestamp("report_processed_at").toLocalDateTime());
		return report;
	}

}