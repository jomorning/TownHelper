package com.townHelper.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.townHelper.domain.HelpApplyDTO;

public class HelpApplyRowMapper implements RowMapper<HelpApplyDTO> {

	@Override
	public HelpApplyDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		HelpApplyDTO helpApply = new HelpApplyDTO();
		helpApply.setHelpApplyNo(rs.getInt("help_apply_no"));
		helpApply.setUserNo(rs.getInt("user_no"));
		helpApply.setUserId(rs.getString("user_id"));
		helpApply.setHelpPostNo(rs.getInt("help_post_no"));
		helpApply.setSuggestedPay(rs.getInt("suggested_pay"));
		helpApply.setAppealContent(rs.getString("appeal_content"));
		helpApply.setApplyStatus(rs.getString("apply_status"));
		helpApply.setApplyCreatedAt(rs.getTimestamp("apply_created_at").toLocalDateTime());
		return helpApply;
	}

}