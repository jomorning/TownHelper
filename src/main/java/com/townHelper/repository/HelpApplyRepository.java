package com.townHelper.repository;

import java.util.List;

import com.townHelper.domain.HelpApplyDTO;

public interface HelpApplyRepository {

	// 게시글당 지원 목록 조회
	List<HelpApplyDTO> getAllHelpAppliesByPost(int helpPostNo);

	// helper 지원 상태 설정 (지원 / 수락 / 거절 / 취소)
	void setApplyStatus(HelpApplyDTO apply);
	
	// COMPLETE 된 도움 요청 게시글의 수락 지원자 반환
	List<HelpApplyDTO> getAppliesByCompletedHelpPost(int helpPostNo);

	void setNewHelpApply(HelpApplyDTO newApply);

	void setEditHelpApply(HelpApplyDTO editApply);

	void setDeleteHelpApply(int helpPostNo, int helpApplyNo);

}
