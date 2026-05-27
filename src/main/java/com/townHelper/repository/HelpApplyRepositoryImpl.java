package com.townHelper.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.townHelper.domain.HelpApplyRequestDTO;
import com.townHelper.domain.HelpApplyResponseDTO;

@Repository
public class HelpApplyRepositoryImpl implements HelpApplyRepository {

	@Autowired
	private JdbcTemplate template;

	void setJdbcTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public List<HelpApplyResponseDTO> getAllHelpAppliesByPost(int helpPostNo) {
		String SQL = "SELECT * FROM help_apply WHERE help_post_no = ? ORDER BY apply_created_at DESC";
		List<HelpApplyResponseDTO> helpApplyList = template.query(SQL, new HelpApplyResponseRowMapper(), helpPostNo);
		return helpApplyList;
	}

	@Override
	public void setApplyStatus(int helpApplyNo, String applyStatus) {
		String SQL = "UPDATE help_apply SET apply_status = ? WHERE help_apply_no = ?";
		template.update(SQL, applyStatus, helpApplyNo);
	}

	@Override
	public void setNewHelpApply(HelpApplyRequestDTO newApply) {
		String SQL = "INSERT INTO help_apply(user_no, help_post_no, suggested_pay, appeal_content, apply_status) VALUES(?,?,?,?,?)";
		template.update(SQL, newApply.getUserNo(), newApply.getHelpPostNo(), newApply.getSuggestedPay(),
				newApply.getAppealContent(), newApply.getApplyStatus());
	}

	@Override
	public void setEditHelpApply(HelpApplyRequestDTO editApply) {
		String SQL = "UPDATE help_apply SET suggested_pay = ?, appeal_content = ?, apply_status = ? WHERE help_apply_no = ?";
		template.update(SQL, editApply.getSuggestedPay(), editApply.getAppealContent(), editApply.getApplyStatus(),
				editApply.getHelpApplyNo());
	}

	@Override
	public void setDeleteHelpApply(int helpApplyNo) {
		String SQL = "DELETE FROM help_apply WHERE help_apply_no = ?";
		template.update(SQL, helpApplyNo);
	}

}