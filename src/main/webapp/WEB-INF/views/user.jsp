<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 상세 조회</title>
</head>
<body>
	
	<img src="<c:url value='/upload/user/${user.profileImgName}'/>" style="width: 20%"/><br>
	${user.userId}<br>
	${user.userGender}<br>
	${user.userBirth}<br>
	${user.userAge}<br>
	${user.userAddrGu}<br>
	${user.userAddrDong}<br>
	${user.userSkill}<br>
	${user.mannerScore}<br>
	${user.requesterCompletedCount}<br>
	${user.helperCompletedCount}<br>
	${user.userCreatedAt}<br>
	
	<c:url value="/users/${user.userNo}/edit" var="getEditUser"/>
	<a href="${getEditUser}">내 정보 수정</a>
	
	<c:url value="/users/${user.userNo}" var="submitDeleteUser"/>
	<form:form action="${submitDeleteUser}" method="DELETE">
		<button>회원 탈퇴</button>
	</form:form>
	
</body>
</html>