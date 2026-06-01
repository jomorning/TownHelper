package com.townHelper.repository;

import java.util.List;

import com.townHelper.domain.HelpPostDTO;
import com.townHelper.domain.HelpPostSummaryDTO;

public interface HelpPostRepository {
	
	// 도움 요청 게시글 목록 조회
	List<HelpPostSummaryDTO> getAllHelpPostsSummary(int loginUserNo);
	
	// 도움 요청 게시글 단건 조회
	HelpPostDTO getHelpPostByNo(int helpPostNo);
	
	Integer setNewHelpPost(HelpPostDTO newHelpPost);
	
	void setEditHelpPost(HelpPostDTO editHelpPost);
	
	void setDeleteHelpPost(int helpPostNo);

}
