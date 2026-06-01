package com.townHelper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.townHelper.domain.HelpPostDTO;
import com.townHelper.domain.HelpPostSummaryDTO;
import com.townHelper.domain.UserDTO;
import com.townHelper.repository.HelpPostRepository;
import com.townHelper.repository.UserRepository;

@Service
public class HelpPostServiceImpl implements HelpPostService {
	
	@Autowired
	HelpPostRepository helpPostRepository;
	
	@Autowired
	UserRepository userRepository;

	@Override
	public List<HelpPostSummaryDTO> getAllHelpPostsSummary(int loginUserNo) {
		List<HelpPostSummaryDTO> helpPostList = helpPostRepository.getAllHelpPostsSummary(loginUserNo);
		return helpPostList;
	}

	@Override
	public HelpPostDTO getHelpPostByNo(int helpPostNo) {
		HelpPostDTO helpPost = helpPostRepository.getHelpPostByNo(helpPostNo);
		UserDTO user = userRepository.getUserByNo(helpPost.getUserNo());
		helpPost.setUserId(user.getUserId());	
		return helpPost;
	}

	@Override
	public Integer setNewHelpPost(HelpPostDTO newHelpPost) {
		Integer returnedPK = helpPostRepository.setNewHelpPost(newHelpPost);
		return returnedPK;
	}

	@Override
	public void setEditHelpPost(HelpPostDTO editHelpPost) {
		
		HelpPostDTO originHelpPost = helpPostRepository.getHelpPostByNo(editHelpPost.getHelpPostNo());
		if (editHelpPost.getRequestTime() == null) {
			editHelpPost.setRequestTime(originHelpPost.getRequestTime());
		}
		
		helpPostRepository.setEditHelpPost(editHelpPost);
	}

	@Override
	public void setDeleteHelpPost(int helpPostNo) {
		helpPostRepository.setDeleteHelpPost(helpPostNo);
	}

}
