package com.townHelper.repository;

import java.util.List;

import com.townHelper.domain.HelpApplyRequestDTO;
import com.townHelper.domain.HelpApplyResponseDTO;

public interface HelpApplyRepository {
	
	// 게시글당 지원 목록 조회
	List<HelpApplyResponseDTO> getAllHelpAppliesByPost(int helpPostNo);
	
	// helper 지원 상태 설정 (지원 / 수락 / 거절 / 취소)
	void setApplyStatus(int helpApplyNo, String applyStatus);
	
	void setNewHelpApply(HelpApplyRequestDTO newApply);
	
	void setEditHelpApply(HelpApplyRequestDTO editApply);
	
	void setDeleteHelpApply(int helpApplyNo);

}


