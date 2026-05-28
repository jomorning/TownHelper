package com.townHelper.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.townHelper.domain.UserDTO;
import com.townHelper.domain.UserProfileSummaryDTO;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	private JdbcTemplate template;

	void setJdbcTemplate(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}

	@Override
	public List<UserProfileSummaryDTO> getAllUsersSummary() {
		String SQL = "SELECT * FROM user";
		List<UserProfileSummaryDTO> userList = template.query(SQL, new UserProfileSummaryRowMapper());
		return userList;
	}

	@Override
	public UserProfileSummaryDTO getUserSummaryByNo(int userNo) {
		String SQL = "SELECT * FROM user WHERE user_no = ?";
		UserProfileSummaryDTO user = template.queryForObject(SQL, new UserProfileSummaryRowMapper(), userNo);
		return user;
	}

	@Override
	public UserDTO getUserByNo(int userNo) {
		String SQL = "SELECT * FROM user WHERE user_no = ?";
		UserDTO user = template.queryForObject(SQL, new UserRowMapper(), userNo);
		return user;
	}

	@Override
	public void setNewUser(UserDTO newUser) {
		String SQL = "INSERT INTO user(user_id, user_pw, user_name, user_gender, user_birth, user_addr_gu, user_addr_dong, user_skill, profile_img_name, profile_img_path) VALUES(?,?,?,?,?,?,?,?,?,?)";
		template.update(SQL, newUser.getUserId(), newUser.getUserPw(), newUser.getUserName(), newUser.getUserGender(),
				newUser.getUserBirth(), newUser.getUserAddrGu(), newUser.getUserAddrDong(), newUser.getUserSkill(),
				newUser.getProfileImgName(), newUser.getProfileImgPath());
	}

	@Override
	public void setEditUser(UserDTO editUser) {
		String SQL = "UPDATE user SET user_id = ?, user_pw = ?, user_name = ?, user_addr_gu = ?, user_addr_dong = ?, user_skill = ?, profile_img_name = ?, profile_img_path = ? WHERE user_no = ?";
		template.update(SQL, editUser.getUserId(), editUser.getUserPw(), editUser.getUserName(),
				editUser.getUserAddrGu(), editUser.getUserAddrDong(), editUser.getUserSkill(),
				editUser.getProfileImgName(), editUser.getProfileImgPath(), editUser.getUserNo());
	}

	@Override
	public void setDeleteUser(int userNo) {
		String SQL = "DELETE FROM user WHERE user_no=?";
		template.update(SQL, userNo);
	}
}
