package com.townHelper.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.townHelper.domain.ReportResponseDTO;

@Repository
public class ReportRepositoryImpl implements ReportRepository {

	@Autowired
	private JdbcTemplate template;

	void setJdbcTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public List<ReportResponseDTO> getAllReports() {
		String SQL = "SELECT * FROM report ORDER BY report_created_at DESC";
		List<ReportResponseDTO> reportList = template.query(SQL, new ReportResponseRowMapper());
		return reportList;
	}

	@Override
	public List<ReportResponseDTO> getAllReportsByUserNo(int userNo) {
		String SQL = "SELECT * FROM report WHERE user_no = ? ORDER BY report_created_at DESC";
		List<ReportResponseDTO> reportList = template.query(SQL, new ReportResponseRowMapper(), userNo);
		return reportList;
	}

	@Override
	public void setReportStatus(int reportNo, String reportStatus) {
		String SQL = "UPDATE report SET report_status = ? WHERE report_no = ?";
		template.update(SQL, reportStatus, reportNo);
	}

	@Override
	public void setNewReport(String reportTargetType, int reportTargetNo) {
		String SQL = "INSERT INTO report(report_target_type, report_target_no) VALUES(?,?)";
		template.update(SQL, reportTargetType, reportTargetNo);
	}

}