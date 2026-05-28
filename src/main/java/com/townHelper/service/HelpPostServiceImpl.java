package com.townHelper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.townHelper.domain.HelpPostRequestDTO;
import com.townHelper.domain.HelpPostResponseDTO;
import com.townHelper.domain.HelpPostSummaryDTO;
import com.townHelper.repository.HelpPostRepository;

@Service
public class HelpPostServiceImpl implements HelpPostService {
	
	@Autowired
	HelpPostRepository helpPostRepository;

	@Override
	public List<HelpPostSummaryDTO> getAllHelpPostsSummary() {
		List<HelpPostSummaryDTO> helpPostList = helpPostRepository.getAllHelpPostsSummary();
		return helpPostList;
	}

	@Override
	public HelpPostResponseDTO getHelpPostByNo(int helpPostNo) {
		HelpPostResponseDTO helpPost = helpPostRepository.getHelpPostByNo(helpPostNo);
		return helpPost;
	}

	@Override
	public Integer setNewHelpPost(HelpPostRequestDTO newHelpPost) {
		Integer returnedPK = helpPostRepository.setNewHelpPost(newHelpPost);
		return returnedPK;
	}

	@Override
	public void setEditHelpPost(HelpPostRequestDTO editHelpPost) {
		helpPostRepository.setEditHelpPost(editHelpPost);
	}

	@Override
	public void setDeleteHelpPost(int helpPostNo) {
		helpPostRepository.setDeleteHelpPost(helpPostNo);
	}

}
