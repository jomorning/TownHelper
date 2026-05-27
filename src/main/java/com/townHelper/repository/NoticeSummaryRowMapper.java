package com.townHelper.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.townHelper.domain.NoticeSummaryDTO;

public class NoticeSummaryRowMapper implements RowMapper<NoticeSummaryDTO> {

	@Override
	public NoticeSummaryDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		NoticeSummaryDTO notice = new NoticeSummaryDTO();
		notice.setNoticeNo(rs.getInt("notice_no"));
		notice.setUserId(rs.getString("user_id"));
		notice.setNoticeTitle(rs.getString("notice_title"));
		notice.setNoticeCreatedAt(rs.getTimestamp("notice_created_at").toLocalDateTime());
		notice.setNoticeUpdatedAt(rs.getTimestamp("notice_updated_at").toLocalDateTime());
		return notice;
	}

}