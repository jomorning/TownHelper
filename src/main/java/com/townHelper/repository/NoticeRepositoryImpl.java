package com.townHelper.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.townHelper.domain.NoticeRequestDTO;
import com.townHelper.domain.NoticeResponseDTO;
import com.townHelper.domain.NoticeSummaryDTO;

@Repository
public class NoticeRepositoryImpl implements NoticeRepository {

	@Autowired
	private JdbcTemplate template;

	void setJdbcTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public List<NoticeSummaryDTO> getAllNotices() {
		String SQL = "SELECT * FROM notice ORDER BY notice_created_at DESC";
		List<NoticeSummaryDTO> noticeList = template.query(SQL, new NoticeSummaryRowMapper());
		return noticeList;
	}

	@Override
	public NoticeResponseDTO getNoticeByNo(int noticeNo) {
		String SQL = "SELECT * FROM notice WHERE notice_no = ?";
		NoticeResponseDTO notice = template.queryForObject(SQL, new NoticeResponseRowMapper(), noticeNo);
		return notice;
	}

	@Override
	public void setNewNotice(NoticeRequestDTO newNotice) {
		String SQL = "INSERT INTO notice(user_no, notice_title, notice_content) VALUES(?,?,?)";
		template.update(SQL, newNotice.getUserNo(), newNotice.getNoticeTitle(), newNotice.getNoticeContent());
	}

	@Override
	public void setEditNotice(NoticeRequestDTO editNotice) {
		String SQL = "UPDATE notice SET notice_title = ?, notice_content = ? WHERE notice_no = ?";
		template.update(SQL, editNotice.getNoticeTitle(), editNotice.getNoticeContent(), editNotice.getNoticeNo());
	}

	@Override
	public void setDeleteNotice(int noticeNo) {
		String SQL = "DELETE FROM notice WHERE notice_no = ?";
		template.update(SQL, noticeNo);
	}

}