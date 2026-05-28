package com.townHelper.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.townHelper.domain.HelpPostRequestDTO;
import com.townHelper.domain.HelpPostResponseDTO;
import com.townHelper.domain.HelpPostSummaryDTO;

@Repository
public class HelpPostRepositoryImpl implements HelpPostRepository {

	@Autowired
	private JdbcTemplate template;

	void setJdbcTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public List<HelpPostSummaryDTO> getAllHelpPostsSummary() {
		String SQL = "SELECT * FROM help_post WHERE is_deleted = FALSE ORDER BY post_created_at DESC";
		List<HelpPostSummaryDTO> helpPostList = template.query(SQL, new HelpPostSummaryRowMapper());
		return helpPostList;
	}

	@Override
	public HelpPostResponseDTO getHelpPostByNo(int helpPostNo) {
		String SQL = "SELECT * FROM help_post WHERE help_post_no = ? AND is_deleted = 'FALSE'";
		HelpPostResponseDTO helpPost = template.queryForObject(SQL, new HelpPostResponseRowMapper(), helpPostNo);
		return helpPost;
	}

	@Override
	public Integer setNewHelpPost(HelpPostRequestDTO newHelpPost) {
		String SQL = "INSERT INTO help_post(user_no, help_category, post_addr_gu, post_addr_dong, post_title, post_content, expected_pay, expected_helper_count, wanted_skill, request_time) VALUES(?,?,?,?,?,?,?,?,?,?)";
		template.update(SQL, newHelpPost.getUserNo(), newHelpPost.getHelpCategory(), newHelpPost.getPostAddrGu(),
				newHelpPost.getPostAddrDong(), newHelpPost.getPostTitle(), newHelpPost.getPostContent(),
				newHelpPost.getExpectedPay(), newHelpPost.getExpectedHelperCount(), newHelpPost.getWantedSkill(),
				newHelpPost.getRequestTime());
		String SQL_return =  "SELECT LAST_INSERT_ID()";
		Integer returnedPK = template.queryForObject(SQL_return, Integer.class);
		return returnedPK;
		
	}

	@Override
	public void setEditHelpPost(HelpPostRequestDTO editHelpPost) {
		String SQL = "UPDATE help_post SET post_title = ?, post_content = ?, expected_pay = ?, expected_helper_count = ?, wanted_skill = ?, request_time = ?, post_status = ? WHERE help_post_no = ?";
		template.update(SQL, editHelpPost.getPostTitle(), editHelpPost.getPostContent(), editHelpPost.getExpectedPay(),
				editHelpPost.getExpectedHelperCount(), editHelpPost.getWantedSkill(), editHelpPost.getRequestTime(),
				editHelpPost.getPostStatus(), editHelpPost.getHelpPostNo());
	}

	@Override
	public void setDeleteHelpPost(int helpPostNo) {
		String SQL = "UPDATE help_post SET is_deleted = TRUE WHERE help_post_no=?";
		template.update(SQL, helpPostNo);
	}

}