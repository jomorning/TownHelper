package com.townHelper.repository;

import java.util.List;

import com.townHelper.domain.UserDTO;
import com.townHelper.domain.UserProfileSummaryDTO;

public interface UserRepository {
	
	// 관리자용 전체 사용자 조회 
	List<UserProfileSummaryDTO> getAllUsersSummary();
	
	// 타 사용자 조회
	UserProfileSummaryDTO getUserSummaryByNo(int userNo);
	
	// 마이페이지 사용자 정보 조회
	UserDTO getUserByNo(int userNo);
	
	UserDTO getUserById(String userId);
	
	int getCompleteCount(int userNo);
	
	int getTotalReviewStarCount(int userNo);
	
	void increaseRequesterCompletedCount(int userNo);
	
	void increaseHelperCompletedCount(int userNo);
	
	void setUpdateMannerScore(int userNo, int mannerScore);
	
	void setNewUser(UserDTO newUser);
	
	void setEditUser(UserDTO editUser);
	
	void setDeleteUser(int userNo);
	
}
