package com.townHelper.service;

import java.io.File;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.townHelper.domain.UserDTO;
import com.townHelper.domain.UserProfileSummaryDTO;
import com.townHelper.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public List<UserProfileSummaryDTO> getAllUsersSummary() {
		List<UserProfileSummaryDTO> userList = userRepository.getAllUsersSummary();
		return userList;
	}

	@Override
	public UserProfileSummaryDTO getUserSummaryByNo(int userNo) {
		UserProfileSummaryDTO user = userRepository.getUserSummaryByNo(userNo);
		int userAge = LocalDate.now().getYear() - user.getUserBirth().getYear();
		user.setUserAge(userAge);
		return user;
	}

	@Override
	public UserDTO getUserByNo(int userNo) {
		UserDTO user = userRepository.getUserByNo(userNo);
		return user;
	}

	@Override
	public void uploadFile(UserDTO user) {
		MultipartFile file = user.getProfileImgFile();
		String savedName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();

		if (file != null && !file.isEmpty()) {
			File saveFile = new File("C:\\townHelper_upload\\user", savedName);

			try {
				file.transferTo(saveFile);
				user.setProfileImgName(savedName);
				user.setProfileImgPath("/upload/user/");
				System.out.println("파일 업로드 성공: " + saveFile.getPath());
			} catch (Exception e) {
				throw new RuntimeException("파일 업로드 실패", e);
			}
		}
	}

	@Override
	public void setNewUser(UserDTO newUser) {
		uploadFile(newUser);
		userRepository.setNewUser(newUser);
	}

	@Override
	public void setEditUser(UserDTO editUser) {
		
		UserDTO originUser = userRepository.getUserByNo(editUser.getUserNo());
		
		if (editUser.getUserPw() == null && editUser.getUserPw().isEmpty()); {
			editUser.setUserPw(originUser.getUserPw());			
		}
			
		if (editUser.getProfileImgFile() != null && !editUser.getProfileImgFile().isEmpty()) {
			uploadFile(editUser);			
		} else {
			editUser.setProfileImgName(originUser.getProfileImgName());
			editUser.setProfileImgPath(originUser.getProfileImgPath());
		}
		
		userRepository.setEditUser(editUser);
	}

	@Override
	public void setDeleteUser(int userNo) {
		userRepository.setDeleteUser(userNo);
		System.out.println(userNo + "번 사용자 DB 삭제됨.");
	}

}
