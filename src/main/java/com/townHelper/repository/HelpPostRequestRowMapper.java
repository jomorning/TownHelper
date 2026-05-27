package com.townHelper.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.townHelper.domain.HelpPostRequestDTO;

public class HelpPostRequestRowMapper implements RowMapper<HelpPostRequestDTO> {

	@Override
	public HelpPostRequestDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		HelpPostRequestDTO post = new HelpPostRequestDTO();
		post.setHelpPostNo(rs.getInt("help_post_no"));
		post.setUserNo(rs.getInt("user_no"));
		post.setHelpCategory(rs.getString("help_category"));
		post.setPostAddrGu(rs.getString("post_addr_gu"));
		post.setPostAddrDong(rs.getString("post_addr_dong"));
		post.setPostTitle(rs.getString("post_title"));
		post.setPostContent(rs.getString("post_content"));
		post.setExpectedPay(rs.getInt("expected_pay"));
		post.setExpectedHelperCount(rs.getInt("expected_helper_count"));
		post.setWantedSkill(rs.getString("wanted_skill"));
		post.setRequestTime(rs.getTimestamp("request_time").toLocalDateTime());
		post.setPostStatus(rs.getString("post_status"));
		return post;
	}

}