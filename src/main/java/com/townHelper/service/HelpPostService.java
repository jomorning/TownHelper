package com.townHelper.service;

import java.util.List;

import com.townHelper.domain.HelpPostDTO;
import com.townHelper.domain.HelpPostSummaryDTO;

public interface HelpPostService {

	// 도움 요청 게시글 목록 조회
	List<HelpPostSummaryDTO> getAllHelpPostsSummary(int loginUserNo);

	// 도움 요청 게시글 단건 조회
	HelpPostDTO getHelpPostByNo(int helpPostNo);
	
	// 도움 요청 게시글 상태 변경
	void setHelpPostComplete(int helpPostNo);

	Integer setNewHelpPost(HelpPostDTO newHelpPost);

	void setEditHelpPost(HelpPostDTO editHelpPost);

	void setDeleteHelpPost(int helpPostNo);

}
