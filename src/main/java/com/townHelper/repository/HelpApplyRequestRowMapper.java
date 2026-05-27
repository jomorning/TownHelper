package com.townHelper.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.townHelper.domain.HelpApplyRequestDTO;

public class HelpApplyRequestRowMapper implements RowMapper<HelpApplyRequestDTO> {

	@Override
	public HelpApplyRequestDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		HelpApplyRequestDTO helpApply = new HelpApplyRequestDTO();
		helpApply.setHelpApplyNo(rs.getInt("help_apply_no"));
		helpApply.setUserNo(rs.getInt("user_no"));
		helpApply.setHelpPostNo(rs.getInt("help_post_no"));
		helpApply.setSuggestedPay(rs.getInt("suggested_pay"));
		helpApply.setAppealContent(rs.getString("appeal_content"));
		helpApply.setApplyStatus(rs.getString("apply_status"));
		return helpApply;
	}

}