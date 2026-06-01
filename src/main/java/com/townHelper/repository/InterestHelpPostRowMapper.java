package com.townHelper.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.townHelper.domain.InterestHelpPostDTO;

public class InterestHelpPostRowMapper implements RowMapper<InterestHelpPostDTO> {

	@Override
	public InterestHelpPostDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		InterestHelpPostDTO interest = new InterestHelpPostDTO();
		interest.setInterestHelpPostNo(rs.getInt("interest_help_post_no"));
		interest.setUserNo(rs.getInt("user_no"));
		interest.setHelpPostNo(rs.getInt("help_post_no"));
		interest.setHelpCategory(rs.getString("help_category"));
		interest.setHelpPostTitle(rs.getString("post_title"));
		return interest;
	}

}