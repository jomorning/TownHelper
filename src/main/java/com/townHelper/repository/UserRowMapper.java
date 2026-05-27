package com.townHelper.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.townHelper.domain.UserDTO;

public class UserRowMapper implements RowMapper<UserDTO> {

	@Override
	public UserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserDTO user = new UserDTO();
		user.setUserNo(rs.getInt("user_no"));
		user.setUserId(rs.getString("user_id"));
		user.setUserPw(rs.getString("user_pw"));
		user.setUserName(rs.getString("user_name"));
		user.setUserGender(rs.getString("user_gender"));
		user.setUserBirth(rs.getDate("user_birth").toLocalDate());
		user.setUserAddrGu(rs.getString("user_addr_gu"));
		user.setUserAddrDong(rs.getString("user_addr_dong"));
		user.setUserSkill(rs.getString("user_skill"));
		user.setUserRole(rs.getString("user_role"));
		user.setProfileImgName(rs.getString("profile_img_name"));
		user.setProfileImgPath(rs.getString("profile_img_path"));
		return user;
	}

}
