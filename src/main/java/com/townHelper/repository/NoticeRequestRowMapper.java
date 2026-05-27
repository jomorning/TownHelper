package com.townHelper.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.townHelper.domain.NoticeRequestDTO;

public class NoticeRequestRowMapper implements RowMapper<NoticeRequestDTO> {

	@Override
	public NoticeRequestDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		NoticeRequestDTO notice = new NoticeRequestDTO();
		notice.setNoticeNo(rs.getInt("notice_no"));
		notice.setUserNo(rs.getInt("user_no"));
		notice.setUserId(rs.getString("user_id"));
		notice.setNoticeTitle(rs.getString("notice_title"));
		notice.setNoticeContent(rs.getString("notice_content"));
		notice.setNoticeCreatedAt(rs.getTimestamp("notice_created_at").toLocalDateTime());
		notice.setNoticeUpdatedAt(rs.getTimestamp("notice_updated_at").toLocalDateTime());
		return notice;
	}

}