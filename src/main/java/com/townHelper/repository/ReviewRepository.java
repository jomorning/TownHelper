package com.townHelper.repository;

import java.util.List;

import com.townHelper.domain.ReviewDTO;
import com.townHelper.domain.ReviewSummaryDTO;

public interface ReviewRepository {

	// 사용자에게 등록된 후기 요약 목록 조회
	List<ReviewSummaryDTO> getReviewsSummary(int userNo);

	// 후기 상세 조회
	ReviewDTO getReviewByNo(int reviewNo);

	Integer setNewReview(ReviewDTO newReview);

}
