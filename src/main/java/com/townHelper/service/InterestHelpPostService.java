package com.townHelper.service;

import java.util.List;

import com.townHelper.domain.InterestHelpPostDTO;

public interface InterestHelpPostService {

	// 사용자별 관심 게시글 목록 조회
	List<InterestHelpPostDTO> getAllInterestHelpPosts(int userNo);

	void setNewInterestHelpPost(InterestHelpPostDTO newInterestHelpPost);

	void setDeleteInterestHelpPost(int userNo, int helpPostNo);

}
