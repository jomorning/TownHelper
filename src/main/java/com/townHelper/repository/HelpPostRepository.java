package com.townHelper.repository;

import java.util.List;

import com.townHelper.domain.HelpPostRequestDTO;
import com.townHelper.domain.HelpPostResponseDTO;
import com.townHelper.domain.HelpPostSummaryDTO;

public interface HelpPostRepository {
	
	// 도움 요청 게시글 목록 조회
	List<HelpPostSummaryDTO> getAllHelpPostsSummary();
	
	// 도움 요청 게시글 단건 조회
	HelpPostResponseDTO getHelpPostByNo(int helpPostNo);
	
	void setNewHelpPost(HelpPostRequestDTO newHelpPost);
	
	void setEditHelpPost(HelpPostRequestDTO editHelpPost);
	
	void setDeleteHelpPost(int helpPostNo);

}
