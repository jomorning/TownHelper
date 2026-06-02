package com.townHelper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.townHelper.domain.HelpApplyDTO;
import com.townHelper.domain.HelpPostDTO;
import com.townHelper.repository.HelpApplyRepository;
import com.townHelper.repository.HelpPostRepository;

@Service
public class HelpApplyServiceImpl implements HelpApplyService {

	@Autowired
	HelpApplyRepository helpApplyRepository;

	@Autowired
	HelpPostRepository helpPostRepository;

	@Override
	public List<HelpApplyDTO> getAllHelpAppliesByPost(int helpPostNo) {
		List<HelpApplyDTO> helpApplyList = helpApplyRepository.getAllHelpAppliesByPost(helpPostNo);
		return helpApplyList;
	}

	@Override
	public void setApplyStatus(HelpApplyDTO apply) {

		HelpPostDTO helpPost = helpPostRepository.getHelpPostByNo(apply.getHelpPostNo());
		switch (apply.getApplyStatus()) {
		case "ACCEPTED":

			if (helpPost.getAcceptedHelperCount() < helpPost.getExpectedHelperCount()) {
				helpApplyRepository.setApplyStatus(apply);
			}
			break;

		case "REJECTED":
			helpApplyRepository.setApplyStatus(apply);
			break;
		}
	}

	@Override
	public List<HelpApplyDTO> getAppliesByCompletedHelpPost(int helpPostNo) {
		List<HelpApplyDTO> applyList = helpApplyRepository.getAppliesByCompletedHelpPost(helpPostNo);
		return applyList;
	}

	@Override
	public void setNewHelpApply(HelpApplyDTO newApply) {
		HelpPostDTO helpPost = helpPostRepository.getHelpPostByNo(newApply.getHelpPostNo());

		if (helpPost.getAcceptedHelperCount() < helpPost.getExpectedHelperCount()) {
			helpApplyRepository.setNewHelpApply(newApply);
		}
	}

	@Override
	public void setEditHelpApply(HelpApplyDTO editApply) {
		helpApplyRepository.setEditHelpApply(editApply);
	}

	@Override
	public void setDeleteHelpApply(int helpPostNo, int helpApplyNo) {
		helpApplyRepository.setDeleteHelpApply(helpPostNo, helpApplyNo);
	}

}
