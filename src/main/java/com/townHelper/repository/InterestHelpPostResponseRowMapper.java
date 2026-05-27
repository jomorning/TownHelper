package com.townHelper.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.townHelper.domain.InterestHelpPostResponseDTO;

public class InterestHelpPostResponseRowMapper implements RowMapper<InterestHelpPostResponseDTO> {

	@Override
	public InterestHelpPostResponseDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		InterestHelpPostResponseDTO interest = new InterestHelpPostResponseDTO();
		interest.setInterestHelpPost(rs.getInt("interest_help_post"));
		interest.setUserNo(rs.getInt("user_no"));
		interest.setHelpPostNo(rs.getInt("help_post_no"));
		interest.setHelpCategory(rs.getString("help_category"));
		interest.setHelpPostTitle(rs.getString("help_post_title"));
		return interest;
	}

}