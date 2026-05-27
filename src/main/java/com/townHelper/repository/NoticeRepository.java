package com.townHelper.repository;

import java.util.List;

import com.townHelper.domain.NoticeRequestDTO;
import com.townHelper.domain.NoticeResponseDTO;
import com.townHelper.domain.NoticeSummaryDTO;

public interface NoticeRepository {
	
	List<NoticeSummaryDTO> getAllNotices();
	
	NoticeResponseDTO getNoticeByNo(int noticeNo);
	
	void setNewNotice(NoticeRequestDTO newNotice);
	
	void setEditNotice(NoticeRequestDTO editNotice);
	
	void setDeleteNotice(int noticeNo);

}
