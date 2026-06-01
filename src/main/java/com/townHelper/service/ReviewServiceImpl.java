package com.townHelper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.townHelper.domain.ReviewDTO;
import com.townHelper.domain.ReviewSummaryDTO;
import com.townHelper.repository.ReviewRepository;
import com.townHelper.repository.UserRepository;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	ReviewRepository reviewRepository;
	
	@Autowired
	UserRepository userRepository;

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
		return returnedPK;
	}
	
	

}
