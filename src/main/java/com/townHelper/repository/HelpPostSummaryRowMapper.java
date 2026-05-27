package com.townHelper.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.townHelper.domain.HelpPostSummaryDTO;

public class HelpPostSummaryRowMapper implements RowMapper<HelpPostSummaryDTO> {

	@Override
	public HelpPostSummaryDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		HelpPostSummaryDTO post = new HelpPostSummaryDTO();
		post.setHelpPostNo(rs.getInt("help_post_no"));
		post.setUserId(rs.getString("user_id"));
		post.setHelpCategory(rs.getString("help_category"));
		post.setPostAddrGu(rs.getString("post_addr_gu"));
		post.setPostAddrDong(rs.getString("post_addr_dong"));
		post.setPostTitle(rs.getString("post_title"));
		post.setExpectedPay(rs.getInt("expected_pay"));
		post.setExpectedHelperCount(rs.getInt("expected_helper_count"));
		post.setCurrentHelperCount(rs.getInt("current_helper_count"));
		post.setRequestTime(rs.getTimestamp("request_time").toLocalDateTime());
		post.setPostStatus(rs.getString("post_status"));
		post.setPostCreatedAt(rs.getTimestamp("post_created_at").toLocalDateTime());
		post.setPostUpdatedAt(rs.getTimestamp("post_updated_at").toLocalDateTime());
		return post;
	}

}