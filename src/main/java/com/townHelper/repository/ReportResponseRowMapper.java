package com.townHelper.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.townHelper.domain.ReportResponseDTO;

public class ReportResponseRowMapper implements RowMapper<ReportResponseDTO> {

	@Override
	public ReportResponseDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ReportResponseDTO report = new ReportResponseDTO();
		report.setReportNo(rs.getInt("report_no"));
		report.setUserNo(rs.getInt("user_no"));
		report.setUserId(rs.getString("user_id"));
		report.setReportTargetType(rs.getString("report_target_type"));
		report.setReportTargetUserId(rs.getString("report_target_user_id"));
		report.setReportReason(rs.getString("report_reason"));
		report.setReportContent(rs.getString("report_content"));
		report.setReportStatus(rs.getString("report_status"));
		report.setReportCreatedAt(rs.getTimestamp("report_created_at").toLocalDateTime());
		report.setReportProcessedAt(rs.getTimestamp("report_processed_at").toLocalDateTime());
		return report;
	}

}