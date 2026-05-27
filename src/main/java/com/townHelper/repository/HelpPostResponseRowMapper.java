package com.townHelper.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.townHelper.domain.HelpPostResponseDTO;

public class HelpPostResponseRowMapper implements RowMapper<HelpPostResponseDTO> {

	@Override
	public HelpPostResponseDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		HelpPostResponseDTO post = new HelpPostResponseDTO();
		post.setHelpPostNo(rs.getInt("help_post_no"));
		post.setUserNo(rs.getInt("user_no"));
		post.setUserId(rs.getString("user_id"));
		post.setHelpCategory(rs.getString("help_category"));
		post.setPostAddrGu(rs.getString("post_addr_gu"));
		post.setPostAddrDong(rs.getString("post_addr_dong"));
		post.setPostTitle(rs.getString("post_title"));
		post.setPostContent(rs.getString("post_content"));
		post.setExpectedPay(rs.getInt("expected_pay"));
		post.setFinalPay(rs.getInt("final_pay"));
		post.setExpectedHelperCount(rs.getInt("expected_helper_count"));
		post.setAppliedHelperCount(rs.getInt("applied_helper_count"));
		post.setAcceptedHelperCount(rs.getInt("accepted_helper_count"));
		post.setWantedSkill(rs.getString("wanted_skill"));
		post.setRequestTime(rs.getTimestamp("request_time").toLocalDateTime());
		post.setPostStatus(rs.getString("post_status"));
		post.setPostCreatedAt(rs.getTimestamp("post_created_at").toLocalDateTime());
		post.setPostUpdatedAt(rs.getTimestamp("post_updated_at").toLocalDateTime());
		post.setDeleted(rs.getBoolean("is_deleted"));
		return post;
	}

}