package com.townHelper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.townHelper.domain.InterestHelpPostDTO;
import com.townHelper.repository.InterestHelpPostRepository;

@Service
public class InterestHelpPostServiceImpl implements InterestHelpPostService {
	
	@Autowired
	InterestHelpPostRepository interestHelpPostRepository;

	@Override
	public List<InterestHelpPostDTO> getAllInterestHelpPosts(int userNo) {
		List<InterestHelpPostDTO> interestHelpPostList = interestHelpPostRepository.getAllInterestHelpPosts(userNo);
		return interestHelpPostList;
	}

	@Override
	public void setNewInterestHelpPost(InterestHelpPostDTO newInterestHelpPost) {
		interestHelpPostRepository.setNewInterestHelpPost(newInterestHelpPost);
	}

	@Override
	public void setDeleteInterestHelpPost(int userNo, int helpPostNo) {
		interestHelpPostRepository.setDeleteInterestHelpPost(userNo, helpPostNo);
	}

}
