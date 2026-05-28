package com.townHelper.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.townHelper.domain.UserProfileSummaryDTO;

public class UserProfileSummaryRowMapper implements RowMapper<UserProfileSummaryDTO> {

	@Override
	public UserProfileSummaryDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserProfileSummaryDTO user = new UserProfileSummaryDTO();
		user.setUserNo(rs.getInt("user_no"));
		user.setUserId(rs.getString("user_id"));
		user.setUserGender(rs.getString("user_gender"));
		user.setUserBirth(rs.getDate("user_birth").toLocalDate());
		user.setUserAddrGu(rs.getString("user_addr_gu"));
		user.setUserAddrDong(rs.getString("user_addr_dong"));
		user.setUserSkill(rs.getString("user_skill"));
		user.setProfileImgName(rs.getString("profile_img_name"));
		user.setProfileImgPath(rs.getString("profile_img_path"));
		user.setMannerScore(rs.getInt("manner_score"));
		user.setRequesterCompletedCount(rs.getInt("requester_completed_count"));
		user.setHelperCompletedCount(rs.getInt("helper_completed_count"));
		user.setUserCreatedAt(rs.getTimestamp("user_created_at").toLocalDateTime());
		return user;
	}

}