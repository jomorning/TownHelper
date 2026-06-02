package com.townHelper.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.townHelper.domain.HelpApplyDTO;

public class HelpApplyStatusRowMapper implements RowMapper<HelpApplyDTO> {

	@Override
	public HelpApplyDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		HelpApplyDTO helpApply = new HelpApplyDTO();
		helpApply.setHelpApplyNo(rs.getInt("help_apply_no"));
		helpApply.setUserNo(rs.getInt("user_no"));
		helpApply.setHelpPostNo(rs.getInt("help_post_no"));
		helpApply.setApplyStatus(rs.getString("apply_status"));		
		return helpApply;
	}

}
