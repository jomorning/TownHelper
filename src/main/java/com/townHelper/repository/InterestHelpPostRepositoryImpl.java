package com.townHelper.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.townHelper.domain.InterestHelpPostRequestDTO;
import com.townHelper.domain.InterestHelpPostResponseDTO;

@Repository
public class InterestHelpPostRepositoryImpl implements InterestHelpPostRepository {

	@Autowired
	private JdbcTemplate template;

	void setJdbcTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public List<InterestHelpPostResponseDTO> getAllInterestHelpPosts(int userNo) {
		String SQL = "SELECT * FROM interest_help_post WHERE user_no = ?";
		return template.query(SQL, new InterestHelpPostResponseRowMapper(), userNo);
	}

	@Override
	public void setNewInterestHelpPost(InterestHelpPostRequestDTO newInterestHelpPost) {
		String SQL = "INSERT INTO interest_help_post(user_no, help_post_no) VALUES(?,?)";
		template.update(SQL, newInterestHelpPost.getUserNo(), newInterestHelpPost.getHelpPostNo());
	}

	@Override
	public void setDeleteInterestHelpPost(int userNo, int helpPostNo) {
		String SQL = "DELETE FROM interest_help_post WHERE user_no = ? AND help_post_no = ?";
		template.update(SQL, userNo, helpPostNo);
	}

}