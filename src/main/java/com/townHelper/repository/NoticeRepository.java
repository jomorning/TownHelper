package com.townHelper.repository;

import java.util.List;

import com.townHelper.domain.NoticeDTO;
import com.townHelper.domain.NoticeSummaryDTO;

public interface NoticeRepository {
	
	List<NoticeSummaryDTO> getAllNotices();
	
	NoticeDTO getNoticeByNo(int noticeNo);
	
	void setNewNotice(NoticeDTO newNotice);
	
	void setEditNotice(NoticeDTO editNotice);
	
	void setDeleteNotice(int noticeNo);

}
