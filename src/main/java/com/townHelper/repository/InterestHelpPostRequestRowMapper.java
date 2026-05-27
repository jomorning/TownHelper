package com.townHelper.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.townHelper.domain.InterestHelpPostRequestDTO;

public class InterestHelpPostRequestRowMapper implements RowMapper<InterestHelpPostRequestDTO> {

	@Override
	public InterestHelpPostRequestDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		InterestHelpPostRequestDTO interest = new InterestHelpPostRequestDTO();
		interest.setInterestHelpPostNo(rs.getInt("interest_help_post_no"));
		interest.setUserNo(rs.getInt("user_no"));
		interest.setHelpPostNo(rs.getInt("help_post_no"));
		return interest;
	}

}