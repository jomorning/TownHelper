package com.townHelper.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.townHelper.domain.HelpApplyDTO;

@Repository
public class HelpApplyRepositoryImpl implements HelpApplyRepository {

	@Autowired
	private JdbcTemplate template;

	void setJdbcTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public List<HelpApplyDTO> getAllHelpAppliesByPost(int helpPostNo) {
		String SQL = "SELECT help_apply_no, help_apply.user_no, user_id, help_post_no, suggested_pay, appeal_content, apply_status, apply_created_at, help_apply.is_deleted FROM help_apply JOIN user ON help_apply.user_no = user.user_no WHERE help_post_no = ?";
		List<HelpApplyDTO> helpApplyList = template.query(SQL, new HelpApplyRowMapper(), helpPostNo);
		return helpApplyList;
	}

	@Override
	public void setApplyStatus(HelpApplyDTO apply) {
		
		// 지원 상태 변경 (요청자)
		String SQL = "UPDATE help_apply SET apply_status = ? WHERE help_apply_no = ?";
		System.out.println(apply.getApplyStatus() + " : " + apply.getHelpPostNo());
		template.update(SQL, apply.getApplyStatus(), apply.getHelpApplyNo());
		
		// 수락된 지원 개수 반환
		String SQL_currentAcceptedCount = "SELECT COUNT(*) FROM help_apply WHERE help_post_no = ? AND apply_status = 'ACCEPTED'";
		int currentAcceptedCount = template.queryForObject(SQL_currentAcceptedCount, Integer.class, apply.getHelpPostNo());
		
		// help_post 테이블 갱신
		String SQL_update = "UPDATE help_post SET accepted_helper_count = ? WHERE help_post_no = ?";
		template.update(SQL_update, currentAcceptedCount, apply.getHelpPostNo());
		
		// 수락된 지원 수가 예상 도우미 인원에 도달 시 게시글 상태 CLOSED 변경
		String SQL_expectedApplyCount = "SELECT expected_helper_count FROM help_post WHERE help_post_no = ?";
		int expectedApplyCount = template.queryForObject(SQL_expectedApplyCount, Integer.class, apply.getHelpPostNo());
		System.out.println(expectedApplyCount);
		
		if (currentAcceptedCount == expectedApplyCount) {
			String SQL_status_update = "UPDATE help_post SET post_status = 'CLOSED' WHERE help_post_no = ?";
			template.update(SQL_status_update, apply.getHelpPostNo());
		}
		
		if (currentAcceptedCount < expectedApplyCount) {
			String SQL_status_update = "UPDATE help_post SET post_status = 'OPEN' WHERE help_post_no = ?";
			template.update(SQL_status_update, apply.getHelpPostNo());
		}
		
	}

	@Override
	public void setNewHelpApply(HelpApplyDTO newApply) {
		
		// 도우미 지원 데이터 추가
		String SQL = "INSERT INTO help_apply(user_no, help_post_no, suggested_pay, appeal_content) VALUES(?,?,?,?)";
		template.update(SQL, newApply.getUserNo(), newApply.getHelpPostNo(), newApply.getSuggestedPay(),
				newApply.getAppealContent());
		
		// 도우미 지원 개수 반환
		String SQL_currentApplyCount = "SELECT COUNT(*) FROM help_apply WHERE help_post_no = ? AND is_deleted = 'FALSE'";
		int currentApplyCount = template.queryForObject(SQL_currentApplyCount, Integer.class, newApply.getHelpPostNo());
		
		// help_post 테이블 현재 지원자 수 갱신
		String SQL_update = "UPDATE help_post SET applied_helper_count = ? WHERE help_post_no = ?";
		template.update(SQL_update, currentApplyCount, newApply.getHelpPostNo());
	}

	@Override
	public void setEditHelpApply(HelpApplyDTO editApply) {
		String SQL = "UPDATE help_apply SET suggested_pay = ?, appeal_content = ?, apply_status = 'APPLIED' WHERE help_apply_no = ?";
		template.update(SQL, editApply.getSuggestedPay(), editApply.getAppealContent(), editApply.getHelpApplyNo());
	}

	@Override
	public void setDeleteHelpApply(int helpPostNo, int helpApplyNo) {
		String SQL = "DELETE FROM help_apply WHERE help_apply_no = ?";
		template.update(SQL, helpApplyNo);
		
		// 도우미 지원 개수 반환
		String SQL_currentApplyCount = "SELECT COUNT(*) FROM help_apply WHERE help_post_no = ? AND is_deleted = 'FALSE'";
		int currentApplyCount = template.queryForObject(SQL_currentApplyCount, Integer.class, helpPostNo);
		
		// 수락된 지원 개수 반환
		String SQL_currentAcceptedCount = "SELECT COUNT(*) FROM help_apply WHERE help_post_no = ? AND apply_status = 'ACCEPTED'";
		int currentAcceptedCount = template.queryForObject(SQL_currentAcceptedCount, Integer.class, helpPostNo);
		
		// help_post 테이블 현재 지원자 수 갱신
		String SQL_update = "UPDATE help_post SET applied_helper_count = ?, accepted_helper_count = ? WHERE help_post_no = ?";
		template.update(SQL_update, currentApplyCount, currentAcceptedCount, helpPostNo);
	}

}