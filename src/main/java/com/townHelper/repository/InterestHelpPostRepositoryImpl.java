package com.townHelper.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.townHelper.domain.InterestHelpPostDTO;

@Repository
public class InterestHelpPostRepositoryImpl implements InterestHelpPostRepository {

	@Autowired
	private JdbcTemplate template;

	void setJdbcTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public List<InterestHelpPostDTO> getAllInterestHelpPosts(int userNo) {
		String SQL = "SELECT interest_help_post_no, interest_help_post.user_no, interest_help_post.help_post_no, help_post.help_category, help_post.post_title FROM interest_help_post JOIN help_post ON interest_help_post.help_post_no = help_post.help_post_no WHERE interest_help_post.user_no = ?";
		return template.query(SQL, new InterestHelpPostRowMapper(), userNo);
	}

	@Override
	public void setNewInterestHelpPost(InterestHelpPostDTO newInterestHelpPost) {
		String SQL = "INSERT INTO interest_help_post(user_no, help_post_no) VALUES(?,?)";
		template.update(SQL, newInterestHelpPost.getUserNo(), newInterestHelpPost.getHelpPostNo());
	}

	@Override
	public void setDeleteInterestHelpPost(int userNo, int helpPostNo) {
		String SQL = "DELETE FROM interest_help_post WHERE user_no = ? AND help_post_no = ?";
		template.update(SQL, userNo, helpPostNo);
	}

}