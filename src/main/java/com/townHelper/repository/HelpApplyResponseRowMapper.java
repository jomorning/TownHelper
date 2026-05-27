package com.townHelper.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.townHelper.domain.HelpApplyResponseDTO;

public class HelpApplyResponseRowMapper implements RowMapper<HelpApplyResponseDTO> {

	@Override
	public HelpApplyResponseDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		HelpApplyResponseDTO helpApply = new HelpApplyResponseDTO();
		helpApply.setHelpApplyNo(rs.getInt("help_apply_no"));
		helpApply.setUserId(rs.getString("user_id"));
		helpApply.setSuggestedPay(rs.getInt("suggested_pay"));
		helpApply.setAppealContent(rs.getString("appeal_content"));
		helpApply.setApplyStatus(rs.getString("apply_status"));
		helpApply.setApplyCreatedAt(rs.getTimestamp("apply_created_at").toLocalDateTime());
		return helpApply;
	}

}