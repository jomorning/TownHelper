package com.townHelper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.townHelper.domain.ReviewDTO;
import com.townHelper.domain.ReviewSummaryDTO;
import com.townHelper.repository.HelpApplyRepository;
import com.townHelper.repository.HelpPostRepository;
import com.townHelper.repository.ReviewRepository;
import com.townHelper.repository.UserRepository;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	ReviewRepository reviewRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	HelpPostRepository helpPostRepository;

	@Autowired
	HelpApplyRepository helpApplyRepository;

	@Autowired
	UserService userService;

	@Override
	public List<ReviewSummaryDTO> getReviewsSummary(int userNo) {
		List<ReviewSummaryDTO> reviewSummaryList = reviewRepository.getReviewsSummary(userNo);
		return reviewSummaryList;
	}

	@Override
	public ReviewDTO getReviewByNo(int reviewNo) {
		ReviewDTO review = reviewRepository.getReviewByNo(reviewNo);
		return review;
	}

	@Override
	public Integer setNewReview(ReviewDTO newReview) {

		int returnedPK = reviewRepository.setNewReview(newReview);

		if ("HELPER".equals(newReview.getTargetType())) {
			userRepository.increaseHelperCompletedCount(newReview.getTargetUserNo());
		}

		int completeCount = userRepository.getCompleteCount(newReview.getTargetUserNo());
		int totalStarCount = userRepository.getTotalReviewStarCount(newReview.getTargetUserNo());

		if (completeCount >= 5) {
			int mannerScore = totalStarCount / completeCount;
			userRepository.setUpdateMannerScore(newReview.getTargetUserNo(), mannerScore);
		}

		return returnedPK;
	}

}
