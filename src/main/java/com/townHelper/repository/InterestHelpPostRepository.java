package com.townHelper.repository;

import java.util.List;

import com.townHelper.domain.InterestHelpPostRequestDTO;
import com.townHelper.domain.InterestHelpPostResponseDTO;

public interface InterestHelpPostRepository {
	
	// 사용자별 관심 게시글 목록 조회
	List<InterestHelpPostResponseDTO> getAllInterestHelpPosts(int userNo);
	
	void setNewInterestHelpPost(InterestHelpPostRequestDTO newInterestHelpPost);
	
	void setDeleteInterestHelpPost(int userNo, int helpPostNo);

}
